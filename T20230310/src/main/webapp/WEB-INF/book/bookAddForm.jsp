<%@page import="co.yedam.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Clean Blog - Start Bootstrap Theme</title>
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet"
        type="text/css" />
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
            <form action="bookAdd.do" method="post" enctype="multipart/form-data">
                <table class="table">
                    <tbody>
                        <tr>
                            <td>도서코드</td>
                            <td><input type="text" name="code"></td>
                        </tr>
                        <tr>
                            <td>도서명</td>
                            <td><input type="text" name="title"></td>
                        </tr>
                        <tr>
                            <td>저자</td>
                            <td><input type="text" name="author"></td>
                        </tr>
                        <tr>
                            <td>출판사</td>
                            <td><input type="text" name="press"></td>
                        </tr>
                        <tr>
                            <td>도서평</td>
                            <td><input type="text" name="desc"></textarea></td>
                        </tr>
                        <tr>
                            <td>판매가</td>
                            <td><input type="number" name="price"></td>
                        </tr>
                        <tr>
                            <td align="center" colspan="2">
                                <input class="btn btn-primary" type="submit" value="등록">
                                <input class="btn btn-warning" type="reset" value="초기화"></td>
                        </tr>
                    </tbody>
                </table>
                </form>
            </div>
        </div>
    </div>
<script>
  document.querySelector('form').addEventListener('submit', function (e) {
    e.preventDefault(); // 기본 기능 차단.
    <%BookVO vo = new BookVO();%>
    let code = document.querySelector('input[name="code"]').value;
    let title = document.querySelector('input[name="title"]').value;
    let author = document.querySelector('input[name="author"]').value;
    let press = document.querySelector('input[name="press"]').value;
    let desc = document.querySelector('input[name="desc"]').value;
    let price = document.querySelector('input[name="price"]').value;

    let isOk = true;
    if (code == '' || code == 'null'){
      isOk = false;
    }
    if (title == '' || title == 'null'){
      isOk = false;
    }
    if (author == '' || author == 'null'){
      isOk = false;
    }
    if (press == '' || press == 'null'){
        isOk = false;
      }
    
    
    if (!isOk){
      alert('입력항목을 확인하세요!!');
      return false;
    }
    

    // 이벤트의 콜백함수에서 this는 이벤트가 발생하는 대상 element.
    console.log(this);
    this.submit();

  })
</script>
    <!-- Footer-->
    <jsp:include page="../includes/footer.jsp"></jsp:include>

    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="resources/js/scripts.js"></script>
</body>

</html>