package com.seoho.tiffany.action.user;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seoho.tiffany.action.Action;
import com.seoho.tiffany.dao.UserDao;
import com.seoho.tiffany.model.User;
import com.seoho.tiffany.util.Script;

public class UserLoginProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		System.out.println("userid : "+userid);
		System.out.println("password : "+password);
		
		String rememberMe = 
				Optional.ofNullable(request.getParameter("rememberMe")).orElse("off");
		
		
		
		// 2-(1)번
		UserDao userDao = UserDao.getInstance();
		// 2-(2)번
		User user = userDao.login(userid, password);
		
		
		
		if(rememberMe.equals("on")) {
			Cookie cookie = new Cookie("useridCookie", userid);
			cookie.setMaxAge(60*60*24*7); //일주일 보관
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("useridCookie", "");
			cookie.setMaxAge(0); //일주일 보관
			response.addCookie(cookie);
		}
		
		
		// 2-(3)번
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			RequestDispatcher dis = request.getRequestDispatcher("/");
			dis.forward(request, response);
		}else {
			Script.back(response, "아이디와 비밀번호를 확인해주세요.");
		}
		
	}
}







