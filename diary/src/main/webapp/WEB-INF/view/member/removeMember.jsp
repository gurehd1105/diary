<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원탈퇴</h1>
	<form id="updatePw" method="post" action="<%=request.getContextPath()%>/member/removeMember">
	<table border="1">
	<tr>
		<td>비밀번호입력</td>
		<td><input type="password" id="memberPw" name="memberPw"></td>
	</tr>
	</table>
	<button id="rvBtn">탈퇴</button>
	</form>
</body>
</html>