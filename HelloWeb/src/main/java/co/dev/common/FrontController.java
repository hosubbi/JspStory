package co.dev.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	// url 패턴과 실행 컨트롤러 등록.
	// url - controller : map 등록.
	Map<String, Control> map = new HashMap<>();
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainControl());
		map.put("/login.do", new LoginControl());
		//회원목록.
		map.put("/memberList.do", new MemberListControl());
		
		//map.put("/empList.do", new EmpListContriol()); // 결과 페이지 : member/empList.jsp
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// url - control 매칭. 
		String uri = req.getRequestURI(); // http://localhost:8080/HelloWeb/main.do
		String context = req.getContextPath(); // /HelloWeb
		String path = uri.substring(context.length()); // 
		
		System.out.println(path);
		
		Control sub = map.get(path);
		sub.execute(req, resp);
	}
	
}
