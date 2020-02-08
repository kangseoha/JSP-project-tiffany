package com.seoho.tiffany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.seoho.tiffany.db.DBUtil;
import com.seoho.tiffany.model.Notice;
import com.seoho.tiffany.model.User;
import com.seoho.tiffany.viewmodel.NoticeVM;


public class NoticeDao {
	public NoticeDao() {}
	private static NoticeDao instance = new NoticeDao();
	public static NoticeDao getInstance() {
		return instance;
	}
	
	public int save(int userno, String title, String content) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt= null;
		try {
			final String SQL = "INSERT INTO notice(userno, title, content, noticeCreateTime) VALUES(?, ?, ?, now())";
			pstmt = conn.prepareStatement(SQL);

			pstmt.setInt(1, userno);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			int result = pstmt.executeUpdate();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return -1;
	}
	
	public int modify(int noticeno, String title, String content) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt= null;
		try {
			final String SQL = "UPDATE notice SET title = ?, content = ? WHERE noticeno = ?";
			pstmt = conn.prepareStatement(SQL);
		
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, noticeno);
		
			int result = pstmt.executeUpdate();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return -1;
	}
	
	public int delete(int noticeno) {
		// 1. Stream 연결
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt= null;
		try {
			// 2. 쿼리 전송 클래스 (규약에 맞게)
			final String SQL = "DELETE FROM notice WHERE noticeno = ?";
			pstmt = conn.prepareStatement(SQL);
			// 3. SQL문 완성하기
			pstmt.setInt(1, noticeno);
			// 4. SQL문 전송
			// pstmt.executeQuery();
			int result = pstmt.executeUpdate();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return -1;
	}
// 노티스의 리스트 뿌림 
	public List<NoticeVM> NoticeListAll(int pageno) {
		// 0. 컬렉션 만들기
		List<NoticeVM> noticeListVM = new ArrayList<>();		
		// 1. Stream 연결
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT *");
			sb.append(" FROM notice n inner join user u");
			sb.append(" on n.userno = u.userno");
			sb.append(" order by noticeno desc");
			sb.append(" limit ?,10");
			

			final String SQL = sb.toString();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, (pageno-1)*10);
			// 3. SQL문 완성하기
			// 4. SQL문 전송
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int noticeno=rs.getInt("noticeno");
				int userno =rs.getInt("userno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp noticeCreateTime = rs.getTimestamp("noticecreatetime");
				int admin = rs.getInt("admin");
				String userid=rs.getString("userid");
				String username=rs.getString("username");
				String email = rs.getString("email");
				String address = rs.getString("address");
				int tel = rs.getInt("tel");
				
				// Board Builder
				Notice notice = Notice.builder()
						.noticeno(noticeno)
						.userno(userno)
						.title(title)
						.content(content)
						.noticeCreateTime(noticeCreateTime)
						.pageno(pageno)
						.build();
						
				// User Builder
				User user = User.builder()
						.userno(userno)
						.admin(admin)
						.userid(userid)
						.username(username)
						.email(email)
						.address(address)
						.tel(tel)
						.build();
				
				noticeListVM.add(NoticeVM.builder()
						.notice(notice).user(user).build());
				
				
			}
			
			return noticeListVM;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	public NoticeVM findByNoticeno(int noticeno) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT *");
			sb.append(" FROM notice n inner join user u");
			sb.append(" on n.userno = u.userno");
			sb.append(" where n.noticeno = ?");  // 세미콜론은 절대 금지, 끝에 띄어쓰기

			final String SQL = sb.toString();
			pstmt = conn.prepareStatement(SQL);
			// 3. SQL문 완성하기
			pstmt.setInt(1, noticeno);
			// 4. SQL문 전송
			rs = pstmt.executeQuery();
			
			NoticeVM noticelist = null;
			if(rs.next()) {
				int userno =rs.getInt("userno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int admin = rs.getInt("admin");
				String userid=rs.getString("userid");
				String username=rs.getString("username");
				Timestamp noticeCreateTime = rs.getTimestamp("noticecreatetime");
				String email = rs.getString("email");
				String address = rs.getString("address");
				
				int tel = rs.getInt("tel");
				
				// Board Builder
				Notice notice = Notice.builder()
						.noticeno(noticeno)
						.userno(userno)
						.title(title)
						.content(content)
						.noticeCreateTime(noticeCreateTime)
						.build();
						
				// User Builder
				User user = User.builder()
						.userno(userno)
						.admin(admin)
						.userid(userid)
						.username(username)
						.email(email)
						.address(address)
						.tel(tel)
						.build();
				
				
				noticelist=NoticeVM.builder()
						.notice(notice).user(user).build();
			}
			
			return noticelist;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	
	public int lastpage() {	
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			final String SQL = "select count(*) from notice";
			pstmt = conn.prepareStatement(SQL);	
			rs = pstmt.executeQuery();
			if (rs.next()) {
			return rs.getInt(1);// 첫번째 컬럼을 나타냄, count(*) 별칭또한 인식하지못함.

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	

	
}
