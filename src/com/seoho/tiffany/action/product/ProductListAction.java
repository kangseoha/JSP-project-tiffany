package com.seoho.tiffany.action.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoho.tiffany.action.Action;
import com.seoho.tiffany.dao.ProductDao;
import com.seoho.tiffany.model.Product;

public class ProductListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		ProductDao productDao = ProductDao.getInstance();
					
		List<Product> productList = productDao.findAllProduct(type);
		request.setAttribute("productList", productList);	
		Cookie cookie = new Cookie("type",type);
		cookie.setMaxAge(60*60*24*7); //일주일 보관
		response.addCookie(cookie);
			
		
		RequestDispatcher dis = request.getRequestDispatcher("/product/productList.jsp");
		
		dis.forward(request, response);
	}
}
