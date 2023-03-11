package co.yedam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.service.BookService;
import co.yedam.service.BookServiceMybatis;
import co.yedam.vo.BookVO;

public class BoodAddControl implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String code = request.getParameter("code");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		String desc = request.getParameter("desc");
		int price = 0;
		if(request.getParameter("price") == null) {
			price = 0;
		}else {
			price = Integer.parseInt(request.getParameter("price"));
		}
		
		BookVO vo = new BookVO();
		vo.setBookCode(code);
		vo.setBookTitle(title);
		vo.setBookAuthor(author);
		vo.setBookPress(press);
		vo.setBookDesc(desc);
		vo.setBookPrice(price);
		
		
		BookService service = new BookServiceMybatis();
		if (service.addBook(vo)) {
			// 정상 처리.
			response.sendRedirect("bookList.do");
		} else {
			
			try {
				request.getRequestDispatcher("WEB-INF/book/bookAddForm.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
	}
}
