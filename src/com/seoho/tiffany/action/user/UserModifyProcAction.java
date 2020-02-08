package com.seoho.tiffany.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seoho.tiffany.action.Action;
import com.seoho.tiffany.dao.UserDao;
import com.seoho.tiffany.model.User;
import com.seoho.tiffany.util.Script;

public class UserModifyProcAction implements Action {

	@Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("password") == null ||
				request.getParameter("email") == null ||
				request.getParameter("address") == null ||
				request.getParameter("password").equals("") ||
				request.getParameter("email").equals("") ||
				request.getParameter("address").equals("")) {
			Script.back(response, "잘못된 접근입니다.");
			return;
		}
		
		User user = (User) request.getSession().getAttribute("user");
		
		int userno = user.getUserno();
		String userid = user.getUserid();
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		int tel = Integer.parseInt(request.getParameter("tel"));
		
		
		// Dao 연결해서 회원정보 수정!!
		UserDao userDao = UserDao.getInstance();
		int result = userDao.modify(password,email,address,tel,userid);
		
		if(result == 1) {
			// 세션 업데이트
			User principal = userDao.findByUserno(userno);
			HttpSession session = request.getSession();
			session.setAttribute("user", principal);
			
			Script.href(response, "회원정보를 수정하였습니다.", "/user?cmd=modify");
		} else {
			Script.back(response, "회원정보를 확인하여주세요.");
		}
	}
}




