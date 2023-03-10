package co.yedam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class BookAddForm implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/book/bookAddForm.jsp");
		try {
			rd.forward(request, response); // 요청 재지정.
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	

}
