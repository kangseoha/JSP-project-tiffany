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
import com.seoho.tiffany.viewmodel.NoticeVM;

public class NoticeModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if
		(
				request.getParameter("noticeno") == null ||
				request.getParameter("userno") == null ||
				request.getParameter("noticeno").equals("") ||
				request.getParameter("userno").equals("")
		) 
		{
			Script.back(response, "잘못된 접근입니다.");
			return;
		}
		
		
		int noticeno = Integer.parseInt(request.getParameter("noticeno"));
		int userno = Integer.parseInt(request.getParameter("userno"));
		// principal 접근 주체
		User principal = (User) request.getSession().getAttribute("user");
		
		
	
		// 권한 검증!!
		if(!(userno !=1 || principal.getAdmin()!=1)) {
			Script.back(response, "권한이 없습니다.");
			return;
		}
		
		// 2. DAO 연결해서 Select 해서 Board 객체 받기
		NoticeDao noticeDao = NoticeDao.getInstance();
		NoticeVM noticeVM = noticeDao.findByNoticeno(noticeno);
		
		// 3. request에 Board 객체 넣기
		if(noticeVM != null) {
			request.setAttribute("noticeVM", noticeVM);
		}else {
			Script.back(response, "해당 게시글이 없습니다.");
			return;
		}
		
		// 4. update.jsp 로 이동하기
		RequestDispatcher dis = request.getRequestDispatcher("/notice/noticeModify.jsp");
		dis.forward(request, response);

	}

}
