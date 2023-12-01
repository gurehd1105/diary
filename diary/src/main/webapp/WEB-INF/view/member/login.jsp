<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<div class="p-5 bg-success text-white text-center">
  		<h1>다이어리</h1>
	</div>

	<div class="container-fluid">
		<br>
		<div>
			<h1>로그인</h1>	
		</div>	
			<form method="post" id="loginAct" action="${pageContext.request.contextPath}/login">
				<table class="mb-3 mt-3">
					<tr>
						<td>아이디</td>
						<td><input type="text" class="form-control" id="memberId" name="memberId" placeholder="아이디를 입력하세요"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" class="form-control" id="memberPw" name="memberPw" placeholder="비밀번호를 입력하세요"></td>
					</tr>						
				</table>
				<br>
				<button class="btn btn-success" type="submit" id="addBtn">로그인</button>
				<a class="btn btn-success" id="loginbtn" href="${pageContext.request.contextPath}/addMember">회원가입</a>
			</form>
	</div>
</body>


<script>
$('.loginBtn').click(function() {
	if($('.memberId').val().length<1){
		alert('ID를 입력하세요');
		return;
	} else if($('.memberPw').val().length<1){
		alert('PW를 입력하세요');
		return;
	} else {
		$('.loginAct').submit();
	}
});
</script>



</html>