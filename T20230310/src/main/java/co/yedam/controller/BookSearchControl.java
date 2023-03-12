package co.yedam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.service.BookService;
import co.yedam.service.BookServiceMybatis;
import co.yedam.vo.BookVO;

public class BookSearchControl implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookCode = request.getParameter("bookCode");
		
		BookService service = new BookServiceMybatis();
		BookVO result = service.getBookInfo(bookCode);
		
		request.setAttribute("vo", result);
		
		System.out.println(result);
		String targetPage = "";
		if(result == null) {
			targetPage = "WEB-INF/book/bookInfo.jsp";
		}else {
			targetPage = "WEB-INF/book/bookSearch.jsp";
		}
		try {		
			request.getRequestDispatcher(targetPage).forward(request, response);	
		} catch (ServletException | IOException e) {
			e.printStackTrace();	
		} 
		
	}

}
