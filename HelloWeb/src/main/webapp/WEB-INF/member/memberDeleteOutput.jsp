<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%@ include file="../includes/sidebar.jsp" %>
	<%@ include file="../includes/top.jsp" %>
	
	<h3>회원정보삭제결과(memberDeleteOutput.jsp)</h3>
	<%
		Object obj = request.getAttribute("message"); // Object
		String result = (String) obj;
		String idd = (String) request.getAttribute("id");
	%>
	<p>처리결과: <%=result %></p>
	<p><%=idd %> 님의 정보가 삭제되었습니다!</p>
	
	<p>회원목록으로 이동</p>
	<a href="memberList.do">회원목록페이지</a>
	
	<%@ include file="../includes/footer.jsp" %>