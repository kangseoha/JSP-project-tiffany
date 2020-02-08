package com.seoho.tiffany.action.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.seoho.tiffany.action.Action;
import com.seoho.tiffany.dao.UserDao;
import com.seoho.tiffany.dto.UserJoinDto;

public class UseridCheckAction implements Action {
	private final static String TAG = "UseridCheckAction : ";
	@Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
		BufferedReader br = request.getReader();
		String responsedata = br.readLine();
		System.out.println(TAG+responsedata);
	
		Gson gson=new Gson();
		//toJson() == ﻿JSON.Stringify ; fromJson() = ﻿JSON.parse;
		UserJoinDto userJoinDto=gson.fromJson(responsedata, UserJoinDto.class);
		
		System.out.println(TAG+userJoinDto.getUserid());
		
		UserDao userDao = UserDao.getInstance();
		int result = userDao.findByUserid(userJoinDto.getUserid());
		
		if(result == 1) { // 중복되었음.
			PrintWriter out = response.getWriter();
			out.print("fail");
			out.flush();
		}else { // 중복되지않음
			PrintWriter out = response.getWriter();
			out.print("ok");
			out.flush();
		}
				
				
 
	}

}
