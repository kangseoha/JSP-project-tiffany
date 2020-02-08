package com.seoho.tiffany.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {
	
	
	public static void href(HttpServletResponse response, String msg, String uri) throws IOException {
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('" + msg + "');");
		out.print("location.href = '" + uri + "' ");
		out.print("</script>");
		out.flush();
	}

	
	public static void back(HttpServletResponse response, String msg) throws IOException {
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('" + msg + "');");
		out.print("history.back();");
		out.print("</script>");
		out.flush();
	}

	
	// 오버로딩
	public static void back(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("history.back();");
		out.print("</script>");
		out.flush();
	}
}
