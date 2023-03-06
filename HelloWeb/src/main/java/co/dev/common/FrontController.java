package co.dev.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.controller.MainControl;
import co.dev.controller.MemberDeleteControl;
import co.dev.controller.MemberDeleteFormControl;
import co.dev.controller.MemberInsertControl;
import co.dev.controller.MemberInsertFormControl;
import co.dev.controller.MemberListControl;
import co.dev.controller.MemberSearchControl;
import co.dev.controller.MemberSearchFormControl;
import co.dev.controller.MemberUpdateControl;
import co.dev.controller.MemberUpdateFormControl;

public class FrontController extends HttpServlet{
	// url 패턴과 실행 컨트롤러 등록.
	// url - controller : map 등록.
	Map<String, Control> map = new HashMap<>();
	String enc;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		enc = config.getInitParameter("encoding"); // UTF-8
		
		map.put("/main.do", new MainControl());
		map.put("/login.do", new LoginControl());
		//회원목록.
		map.put("/memberList.do", new MemberListControl());
		
		// 회원 등록 화면
		map.put("/memberInsertForm.do", new MemberInsertFormControl());
		
		// 회원등록 처리
		map.put("/memberInsert.do", new MemberInsertControl());
		
		// 회원 조회 화면
		map.put("/memberSearchForm.do", new MemberSearchFormControl());
		
		// 회원 조회
		map.put("/memberSearch.do", new MemberSearchControl());
		
		// 회원 수정 화면
		map.put("/memberUpdateForm.do", new MemberUpdateFormControl());
		
		// 회원 수정
		map.put("/memberUpdate.do", new MemberUpdateControl());
		
		// 회원 삭제 폼
		map.put("/memberDeleteForm.do", new MemberDeleteFormControl());
		
		// 회원 삭제
		map.put("/memberDelete.do", new MemberDeleteControl());
		
//		map.put("/empList.do", new EmpListContriol()); // 결과 페이지 : member/empList.jsp
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(enc); // 인코딩 : UTF-8
		
		
		// url - control 매칭. 
		String uri = req.getRequestURI(); // http://localhost:8080/HelloWeb/main.do
		String context = req.getContextPath(); // /HelloWeb
		String path = uri.substring(context.length()); // 
		
		System.out.println(path);
		
		Control sub = map.get(path);
		sub.execute(req, resp);
	}
	
}
