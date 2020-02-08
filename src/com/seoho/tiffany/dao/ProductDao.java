package com.seoho.tiffany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.seoho.tiffany.db.DBUtil;
import com.seoho.tiffany.model.Product;

public class ProductDao {
	public ProductDao() {}
	private static ProductDao instance = new ProductDao();
	public static ProductDao getInstance() {
		return instance;
	}

	// 제품 저장
	public int save(String type, String productname, String madeof,String content, String detail, String images) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			final String SQL = "INSERT INTO product(type,productname, madeof, content, detail,images) VALUES(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, type);
			pstmt.setString(2, productname);
			pstmt.setString(3, madeof);
			pstmt.setString(4, content);
			pstmt.setString(5, detail);
			pstmt.setString(6, images);
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

	// 제품 시 업데이트
	public int modify(int productno,String type, String productname, String madeof,String content, String detail, String images) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			final String SQL = "UPDATE product SET type=?, productname=?,madeof=?,content=?,detail=?,images =? WHERE productno = ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, type);
			pstmt.setString(2, productname);
			pstmt.setString(3, madeof);
			pstmt.setString(4, content);
			pstmt.setString(5, detail);
			pstmt.setString(6, images);
			pstmt.setInt(7, productno);

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

	// 제품 리스트시 제품리스트를 모두 담을 리스트객체
	public List<Product> findAllProduct(String type) {
		List<Product> products = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			final String SQL = "SELECT * FROM product WHERE type = ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, type);

			rs = pstmt.executeQuery();

			Product product = null;
			while(rs.next()) {

				int productno = rs.getInt("productno");
				type = rs.getString("type");
				String productname = rs.getString("productname");
				String madeof = rs.getString("madeof");
				String content = rs.getString("content");
				String detail = rs.getString("detail");
				String images = rs.getString("images");
				
				

				product = Product.builder().productno(productno).type(type).productname(productname).madeof(madeof).content(content).detail(detail).images(images).build();
				products.add(product);
			}
			

			return products;
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

	// 디테일 시 정보를 담을 제품 객체
	public Product findByproduct(int productno) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			final String SQL = "SELECT * FROM product WHERE productno = ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, productno);

			rs = pstmt.executeQuery();
			Product product = null;

			if (rs.next()) {

				productno = rs.getInt("productno");
				String type = rs.getString("type");
				String productname = rs.getString("productname");
				String madeof = rs.getString("madeof");
				String content = rs.getString("content");
				String detail = rs.getString("detail");
				String images = rs.getString("images");

				// User Builder
				product = Product.builder().productno(productno).type(type).productname(productname).madeof(madeof).content(content).detail(detail).images(images).build();
				
			}

			return product;
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

	// 제품 삭제 
	public int delete(int productno) {
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt= null;
		try {
		
			final String SQL = "DELETE FROM product WHERE productno = ?";
			pstmt = conn.prepareStatement(SQL);
		
			pstmt.setInt(1, productno);
			
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
