package com.seoho.tiffany.action.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoho.tiffany.action.Action;
import com.seoho.tiffany.dao.CommentDao;
import com.seoho.tiffany.util.Script;

public class NoticeCommentWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if
		(
				request.getParameter("userno") == null || 
				request.getParameter("noticeno") == null ||
				request.getParameter("content") == null ||
				request.getParameter("userno").equals("") ||
				request.getParameter("noticeno").equals("") ||
				request.getParameter("content").equals("")
		) {
			Script.back(response, "잘못된 접근입니다.");
			return;
		}

		System.out.println(request.getParameter("userno"));
		System.out.println(request.getParameter("noticeno"));
		System.out.println(request.getParameter("content"));
		
		
		int userno = Integer.parseInt(request.getParameter("userno"));
		int noticeno = Integer.parseInt(request.getParameter("noticeno"));
		
		String content = request.getParameter("content");
		
//		User user = (User) request.getSession().getAttribute("user");
		
		CommentDao commentDao = CommentDao.getInstance();
		int result = commentDao.save(userno,noticeno,content);
		
		if(result == 1) {
			RequestDispatcher dis = request.getRequestDispatcher("/notice?cmd=detail&noticeno="+noticeno);
			dis.forward(request, response);
		}else {
			Script.back(response, "글 입력시 오류가 발생하였습니다.");
		}

	}

}
