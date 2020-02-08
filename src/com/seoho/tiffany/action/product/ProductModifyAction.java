package com.seoho.tiffany.action.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoho.tiffany.action.Action;
import com.seoho.tiffany.dao.ProductDao;
import com.seoho.tiffany.model.Product;
import com.seoho.tiffany.util.Script;

public class ProductModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if
		(
				request.getParameter("productno") == null ||
				request.getParameter("productno").equals("")
		) 
		{
			Script.back(response, "잘못된 접근입니다.");
			return;
		}
		
		System.out.println(request.getParameter("productno"));
		
		int productno = Integer.parseInt(request.getParameter("productno"));
		
		
//		System.out.println(request.getSession().getAttribute("userno"));
//		System.out.println(request.getSession().getAttribute("username"));
//		System.out.println(request.getSession().getAttribute("admin"));
//		System.out.println(request.getSession().getAttribute("email"));
//		System.out.println(request.getSession().getAttribute("address"));
//		System.out.println(request.getSession().getAttribute("tel"));
//			
//		User principal = (User) request.getSession().getAttribute("admin");
//		// 권한 검증!!
//		if(principal.getAdmin()!=1) {
//			Script.back(response, "권한이 없습니다.");
//			return;
//		}
		
		
		
		// 2. DAO 연결해서 Select 해서 Board 객체 받기
		ProductDao productDao = ProductDao.getInstance();
		Product product = productDao.findByproduct(productno);
		
		// 3. request에 Board 객체 넣기
		if(product != null) {
			request.setAttribute("product", product);
		}else {
			Script.back(response, "해당 게시글이 없습니다.");
			return;
		}
		
		// 4. update.jsp 로 이동하기
		RequestDispatcher dis = request.getRequestDispatcher("/product/productModify.jsp");
		dis.forward(request, response);

	}

}
