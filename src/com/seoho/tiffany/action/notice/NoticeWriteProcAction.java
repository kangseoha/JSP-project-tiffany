package com.seoho.tiffany.action.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoho.tiffany.action.Action;
import com.seoho.tiffany.dao.NoticeDao;
import com.seoho.tiffany.model.User;
import com.seoho.tiffany.util.Script;

public class NoticeWriteProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		if
		(
				request.getParameter("title") == null || 
				request.getParameter("content") == null ||
				request.getParameter("title").equals("") ||
				request.getParameter("content").equals("")
		) {
			Script.back(response, "잘못된 접근입니다.");
			return;
		}

		System.out.println(request.getParameter("title"));
		System.out.println(request.getParameter("content"));

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		User user = (User) request.getSession().getAttribute("user");
		
		NoticeDao noticeDao = NoticeDao.getInstance();
		int result = noticeDao.save(user.getUserno(),title, content);
		
		if(result == 1) {
			RequestDispatcher dis = request.getRequestDispatcher("/notice?cmd=list&pageno=1");
			dis.forward(request, response);
		}else {
			Script.back(response, "글 입력시 오류가 발생하였습니다.");
		}
	}
}
