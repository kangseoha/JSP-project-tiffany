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

public class NoticeDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int noticeno = Integer.parseInt(request.getParameter("noticeno"));
		int userno = Integer.parseInt(request.getParameter("userno"));
		User user = (User) request.getSession().getAttribute("user");

		if (userno == user.getUserno() | user.getAdmin() == 1) {
			NoticeDao noticeDao = NoticeDao.getInstance();

			int result = noticeDao.delete(noticeno);
			if (result == 1) {
				RequestDispatcher dis = request.getRequestDispatcher("/notice?cmd=list&pageno=1");
				dis.forward(request, response);
			} else {
				Script.back(response, "해당 게시글을 삭제할 수 없습니다.");

			}

		} else {
			Script.back(response, "삭제할 권한이 없습니다.");
			return;
		}

	}

}