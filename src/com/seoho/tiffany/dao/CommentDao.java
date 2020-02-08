package com.seoho.tiffany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.seoho.tiffany.db.DBUtil;
import com.seoho.tiffany.model.Comment;


public class CommentDao {
	public CommentDao() {}
	private static CommentDao instance = new CommentDao();
	public static CommentDao getInstance() {
		return instance;
	}
	

	public List<Comment> findByNoticeno(int noticeno) {
		List<Comment> commentlist = new ArrayList<>();	
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("select c.commentno, c.userno, c.noticeno, c.content,c.commentCreateTime, u.username");
			sb.append(" from comment c inner join user u");
			sb.append(" on c.userno = u.userno");
			sb.append(" where noticeno=? ");
			
			
			final String SQL = sb.toString();
			pstmt = conn.prepareStatement(SQL);
			// 3. SQL문 완성하기
			pstmt.setInt(1, noticeno);
			// 4. SQL문 전송
			rs = pstmt.executeQuery();
			
		
			while(rs.next()) {
				int commentno = rs.getInt("commentno");
				int userno = rs.getInt("userno");
				String content = rs.getString("content");
				Timestamp commentCreateTime = rs.getTimestamp("commentCreateTime");
				String username = rs.getString("username");
				
				Comment comment = Comment.builder().
						commentno(commentno)
						.userno(userno)
						.content(content)
						.commentCreateTime(commentCreateTime)
						.username(username)
						.build();
				
				commentlist.add(comment);
			}
			
			return commentlist;
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
	
	
	public int delete(int commentno) {
		// 1. Stream 연결
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt= null;
		try {
			// 2. 쿼리 전송 클래스 (규약에 맞게)
			final String SQL = "delete from comment where commentno=?";
			pstmt = conn.prepareStatement(SQL);
			// 3. SQL문 완성하기
			pstmt.setInt(1, commentno);
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
	
	
	
	public int save(int userno, int noticeno, String commentContent) {
		// 1. Stream 연결
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt= null;
		try {
			// 2. 쿼리 전송 클래스 (규약에 맞게)
			final String SQL = "INSERT INTO comment(userno, noticeno, content, commentCreateTime) VALUES(?,?,?, now());";
			pstmt = conn.prepareStatement(SQL);
			// 3. SQL문 완성하기
			pstmt.setInt(1, userno);
			pstmt.setInt(2, noticeno);
			pstmt.setString(3, commentContent);
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
	
	
	
	

	
	
}
