package com.seoho.tiffany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import com.seoho.tiffany.db.DBUtil;
import com.seoho.tiffany.model.User;

public class UserDao {
	
	private UserDao() {
	}

	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}
	
	//회원가입 시 저장
	public int save(String userid, String username, String password, String email, String address, int tel) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			final String SQL = "INSERT INTO user(userid,username, password, email, address,tel,createTime) VALUES(?,?,?,?,?,?,now())";
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, userid);
			pstmt.setString(2, username);
			pstmt.setString(3, password);
			pstmt.setString(4, email);
			pstmt.setString(5, address);
			pstmt.setInt(6, tel);
			int result = pstmt.executeUpdate();

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	//회원수정 시 업데이트
	public int modify(String password, String email, String address, int tel, String userid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt= null;
		try {
			final String SQL = "UPDATE user SET password=?, email=?,address=?,tel=? WHERE userid = ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, password);
			pstmt.setString(2, email);
			pstmt.setString(3, address);
			pstmt.setInt(4, tel);
			pstmt.setString(5, userid);
			
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
	
	//로그인 시
	public User login(String userid,String password) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			final String SQL = "SELECT * FROM user WHERE userid = ? and password = ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
		
			
			rs = pstmt.executeQuery();

			User user = null;
			if (rs.next()) {
				int userno = rs.getInt("userno");
				int admin = rs.getInt("admin");
				userid = rs.getString("userid");
				String username=rs.getString("username");
				String email = rs.getString("email");
				String address = rs.getString("address");
				int tel = rs.getInt("tel");
				Timestamp createTime = rs.getTimestamp("createTime");

				// User Builder
				user = User.builder().userno(userno).admin(admin).userid(userid).username(username).email(email).address(address).tel(tel).createTime(createTime)
						.build();
			}
			return user;
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
// 세션연결 시  모든 정보를 담을 용도의 findbyid
	public User findByUserno(int userno) {	
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			final String SQL = "SELECT * FROM user WHERE userno = ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, userno);
		
			rs = pstmt.executeQuery();

			User user = null;
			if (rs.next()) {
				
				int admin = rs.getInt("admin");
				String userid = rs.getString("userid");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String address = rs.getString("address");
				int tel =rs.getInt("tel");
				Timestamp createTime = rs.getTimestamp("createTime");

				// User Builder
				user = User.builder().userno(userno).admin(admin).userid(userid).username(username).email(email).address(address).tel(tel).createTime(createTime)
						.build();
			}

			return user;
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
	
	//id 중복확인을 위한 find by userid
	public int findByUserid(String userid) {	
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			final String SQL = "SELECT count(*) FROM user WHERE userid = ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userid);
		
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
