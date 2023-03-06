package co.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.MemberService;
import co.dev.service.MemberServiceImpl;
import co.dev.vo.MemberVO;

public class MemberDeleteControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		
		MemberVO vo = new MemberVO();
		
		vo.setId(id);
		System.out.println("입력: " + vo);
		
		MemberService service = new MemberServiceImpl();
		boolean result = service.removeMember(id);
		
		if(result) {
			req.setAttribute("message", "삭제성공");
		} else {
			req.setAttribute("message", "삭제실패");
		}
		// 요청재지정. ReqestDispatcher
		RequestDispatcher rd = //
				req.getRequestDispatcher("WEB-INF/member/memberDeleteOutput.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
