package com.seoho.tiffany.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoho.tiffany.action.Action;
import com.seoho.tiffany.dao.UserDao;
import com.seoho.tiffany.util.Script;

public class UserJoinProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				// 1번
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		int tel = Integer.parseInt(request.getParameter("tel"));
		
		

		System.out.println("userid : "+userid);
		System.out.println("username : "+username);
		System.out.println("username : "+username);
		System.out.println("password : "+password);
		System.out.println("email : "+email);
		System.out.println("address : "+address);
		System.out.println("tel : "+tel);
		
		// 2-(1)번
		UserDao userDao = UserDao.getInstance();
		
		// 2-(2)번
		int result = userDao.save(userid, username, password, email, address,tel);
		
		// 2-(3)번
		if(result == 1) {
			RequestDispatcher dis = request.getRequestDispatcher("/");
			dis.forward(request, response);
		}else {
			Script.back(response, "회원가입 실패");
		}
	}
}
