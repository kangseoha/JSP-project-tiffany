package com.seoho.tiffany.action.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoho.tiffany.action.Action;
import com.seoho.tiffany.dao.CommentDao;
import com.seoho.tiffany.dao.NoticeDao;
import com.seoho.tiffany.util.Script;
import com.seoho.tiffany.viewmodel.NoticeVM;

public class NoticeDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("noticeno") == null || request.getParameter("noticeno").equals("")) {
			Script.back(response, "잘못된 접근입니다.");
			return;
		}

		int noticeno = Integer.parseInt(request.getParameter("noticeno"));

		NoticeDao noticeDao = NoticeDao.getInstance();
		NoticeVM noticeListVM = noticeDao.findByNoticeno(noticeno);
		
		
		CommentDao commentdao = CommentDao.getInstance();
		noticeListVM.setComment(commentdao.findByNoticeno(noticeno));

		request.setAttribute("NoticeListVM", noticeListVM);
		RequestDispatcher dis = request.getRequestDispatcher("/notice/noticeDetail.jsp");
		dis.forward(request, response);

	}
}
