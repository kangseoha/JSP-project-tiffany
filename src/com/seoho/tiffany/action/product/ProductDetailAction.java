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

public class ProductDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("productno") == null || request.getParameter("productno").equals("")) {
			Script.back(response, "잘못된 접근입니다.");
			return;
		}

		int productno = Integer.parseInt(request.getParameter("productno"));

		ProductDao productDao = ProductDao.getInstance();
		Product product = productDao.findByproduct(productno);

		if (product != null) {
			request.setAttribute("product", product);
			RequestDispatcher dis = request.getRequestDispatcher("/product/productDetail.jsp");
			dis.forward(request, response);
		} else {
			Script.back(response, "해당 게시글이 삭제되었거나 이동되었습니다.");
		}

	}
}
