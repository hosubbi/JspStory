<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update title here</title>
</head>
<body>
	<h3>회원정보수정결과</h3>
	<%
		Object obj = request.getAttribute("message"); // Object
		String result = (String) obj;
		String id = (String) request.getAttribute("id");
	%>
	<p>처리결과: <%=result %></p>
	<p><%=id %> 님의 정보가 수정되었습니다!</p>
	
	<p>회원목록으로 이동</p>
	<a href="memberList.do">회원목록페이지</a>
</body>
</html>