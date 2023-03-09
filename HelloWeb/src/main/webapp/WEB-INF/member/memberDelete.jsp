<%@page import="co.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
 <jsp:include page="../includes/sidebar.jsp"></jsp:include>
 <jsp:include page="../includes/top.jsp"></jsp:include>
	<h3>회원삭제조회(memberUpdate.jsp)</h3>
	<%
		MemberVO member = (MemberVO) request.getAttribute("vo");
		String message = (String) request.getAttribute("message");
		//if(message != null){
	%>
	<c:if test="${massage != null }">	
		<p>${massage }</p>
	</c:if>
	<%
		//}
	%>
	<form action="memberSearch.do">
		<input type="hidden" name="job" value="delete">
		찾을ID: <input type="text" name="id">
		<input type="submit" value="찾기">
	</form>
	
	<p></p>
	<%
	if (member != null){ // 조회된 정보가 있으면 화면 결과 표시.
	%>
	<h3>회원삭제정보</h3>
	<form action="memberDelete.do">
		ID: <input type="text" name="id" value="<%=member.getId() %>" readonly><br>
		<input type="submit" value="삭제">
	</form>
	<%
	}
	%>
	<jsp:include page="../includes/footer.jsp"></jsp:include>