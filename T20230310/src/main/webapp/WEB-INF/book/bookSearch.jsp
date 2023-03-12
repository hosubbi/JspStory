<%@page import="co.yedam.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Clean Blog - Start Bootstrap Theme</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="resources/css/styles.css" rel="stylesheet" />
</head>

<body>
	<!-- Navigation-->
	<jsp:include page="../includes/top.jsp"></jsp:include>

	<!-- Page Header-->
	<jsp:include page="../includes/header.jsp"></jsp:include>

	<!-- Main Content-->
	<div class="container px-4 px-lg-5">
		<div class="row gx-4 gx-lg-5 justify-content-center">
			<div class="col-md-12 col-lg-10 col-xl-8">
			
				<table class="table">
					<thead>
						<tr>
							<th>도서코드</th>
							<th>책제목</th>
							<th>저자</th>
							<th>출판사</th>
							<th>도서평</th>
							<th>판매가</th>
						</tr>
					</thead>
					<%
						BookVO book = (BookVO) request.getAttribute("vo");
					%>
					<tbody>
							<tr>
								<td><%=book.getBookCode() %></td>
								<td><%=book.getBookTitle() %></td>
								<td><%=book.getBookAuthor() %></td>
								<td><%=book.getBookPress() %></td>
								<td><%=book.getBookDesc() %></td>
								<td><%=book.getBookPrice() %></td>
							</tr>
					</tbody>
					
					<a href="bookInfo.do">도서 조회 화면으로 돌아가기</a>
				</table>
			</div>
		</div>
	</div>

	<!-- Footer-->
	<jsp:include page="../includes/footer.jsp"></jsp:include>

	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="resources/js/scripts.js"></script>
</body>

</html>