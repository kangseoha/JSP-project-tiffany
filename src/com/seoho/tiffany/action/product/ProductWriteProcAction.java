package com.seoho.tiffany.action.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.seoho.tiffany.action.Action;
import com.seoho.tiffany.dao.ProductDao;
import com.seoho.tiffany.util.Script;

public class ProductWriteProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String savePath="upload"; // 저장하고싶은 파일, 
		ServletContext context = request.getSession().getServletContext();//프로젝트 절대경로
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println(uploadFilePath);
		
		
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, 1024 * 1024 * 2, "UTF-8",
				new DefaultFileRenamePolicy());
		
		
		
		String type = multi.getParameter("type");
		String productname = multi.getParameter("productname");
		String madeof = multi.getParameter("madeof");
		String content = multi.getParameter("content");
		String detail = multi.getParameter("detail");
		String images = multi.getOriginalFileName("images");
		
		
		ProductDao productDao = ProductDao.getInstance();
		int result = productDao.save(type, productname, madeof, content, detail, images);

		if (result == 1) {
			RequestDispatcher dis = request.getRequestDispatcher("/product?cmd=list&type="+type);
			dis.forward(request, response);
		} else {
			Script.back(response, "글 입력시 오류가 발생하였습니다.");
		}
	}
}
