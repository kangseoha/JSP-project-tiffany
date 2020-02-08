package com.seoho.tiffany.action.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoho.tiffany.action.Action;
import com.seoho.tiffany.dao.NoticeDao;
import com.seoho.tiffany.viewmodel.NoticeVM;

//http://localhost:8000/notice?cmd=list&pageno=변수
public class NoticeListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pageno = Integer.parseInt(request.getParameter("pageno"));
		
				
		NoticeDao noticeDao = NoticeDao.getInstance();
	
		System.out.println(pageno);
		List<NoticeVM> noticeListVM = noticeDao.NoticeListAll(pageno);
		double lastpage = Math.ceil(noticeDao.lastpage()/10.0);
		
		
		request.setAttribute("noticeListVM", noticeListVM);	
		request.setAttribute("lastpage", lastpage);

		
		RequestDispatcher dis = request.getRequestDispatcher("/notice/noticeList.jsp");
		
		dis.forward(request, response);
	
	
	}

}
