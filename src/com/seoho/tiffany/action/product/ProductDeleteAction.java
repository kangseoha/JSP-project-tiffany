package com.seoho.tiffany.action.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoho.tiffany.action.Action;
import com.seoho.tiffany.dao.ProductDao;
import com.seoho.tiffany.model.User;
import com.seoho.tiffany.util.Script;

public class ProductDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productno=Integer.parseInt(request.getParameter("productno"));
		String type = request.getParameter("type");

		User user = (User) request.getSession().getAttribute("user");
		
		
		if(1 != user.getAdmin()) {
			Script.back(response, "삭제할 권한이 없습니다.");
			return;
		}
		
		ProductDao productDao = ProductDao.getInstance();
		
		int result = productDao.delete(productno);
		
		if(result == 1) {
			RequestDispatcher dis = request.getRequestDispatcher("/product?cmd=list&type="+type);
			dis.forward(request, response);
		}else {
			Script.back(response, "해당 게시글을 삭제할 수 없습니다.");
		}
	}

}