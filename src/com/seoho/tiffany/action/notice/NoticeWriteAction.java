package com.seoho.tiffany.action.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoho.tiffany.action.Action;

public class NoticeWriteAction implements Action {

	@Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("/notice/noticeWrite.jsp");
		dis.forward(request, response);
	}
}