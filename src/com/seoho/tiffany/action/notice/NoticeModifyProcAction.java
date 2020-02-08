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

public class NoticeModifyProcAction implements Action {

	@Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		if
		(
				request.getParameter("noticeno") == null ||
				request.getParameter("userno") == null || 
				request.getParameter("title") == null || 
				request.getParameter("content") == null ||
				request.getParameter("noticeno").equals("") ||
				request.getParameter("userno").equals("") ||
				request.getParameter("title").equals("") ||
				request.getParameter("content").equals("")
		) {
			Script.back(response, "잘못된 접근입니다.");
			return;
		}
		
		int noticeno = Integer.parseInt(request.getParameter("noticeno"));
		int userno = Integer.parseInt(request.getParameter("userno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		User principal = (User) request.getSession().getAttribute("user");
		
		
		System.out.println(noticeno);
		System.out.println(userno);
		System.out.println(title);
		System.out.println(content);
		System.out.println(principal.getUserno());
		
		// 권한 검증!!
		if(userno !=principal.getUserno()) {
			Script.back(response, "권한이 없습니다.");
			return;
		}
		

		NoticeDao noticeDao = NoticeDao.getInstance();
		int result = noticeDao.modify(noticeno, title, content);
		
		if(result == 1) {
			RequestDispatcher dis = 
			request.getRequestDispatcher("/notice?cmd=list&pageno=1");
			dis.forward(request, response);
		} else {
			Script.back(response, "게시글 수정시 오류가 발생하였습니다.");
		}
	}
}



