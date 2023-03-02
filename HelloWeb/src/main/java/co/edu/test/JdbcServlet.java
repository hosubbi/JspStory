package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.jdbc.EmpDAO;

@WebServlet("/getUserInfo")
public class JdbcServlet extends HttpServlet{

		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			EmpDAO dao = new EmpDAO();
			int empNo = Integer.parseInt(req.getParameter("empId"));
			Map<String, Object> result = dao.getEmpInfo(empNo);
			
			Set<String> set = result.keySet(); // 키부분만 set
			for(String key : set) {
				System.out.println("key : " + key + "val : " + result.get(key));
			}
			
			// 페이지 출력. 사번/이름(이름 + 성씨)/급여/부서
			PrintWriter out = resp.getWriter();
			
//			String empId = req.getParameter(result.get());
			
			
			// 페이지 작성.
			// {키:값}, {키:값}, {키:값}, {키:값} => result.get("키") 값을 반환.
			out.print("<a href = 'temp.html'>조회-등록으로 이동</a>");
			
			System.out.println(result.get("사번"));
			System.out.println(result.get("이름"));
			System.out.println(result.get("급여"));
			System.out.println(result.get("부서번호"));
		}
}
