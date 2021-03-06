package com.seoho.tiffany.db;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {
	public static Connection getConnection() {
		try {

			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");
			Connection conn = ds.getConnection();
			System.out.println("DB Success");
			return conn;
		} catch (Exception e) {
			System.out.println("DB Fail");
			e.printStackTrace();
		}
		return null;
	}
}
