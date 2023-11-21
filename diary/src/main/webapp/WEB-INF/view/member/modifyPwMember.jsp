<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>비밀번호 수정</h1>
	<form id="updatePw" method="post" action="<%=request.getContextPath()%>/member/modifyPwMember">
	<table border="1">
	<tr>
		<td>변경전</td>
		<td><input type="password" id="memberPw" name="memberPw"></td>
	</tr>
	<tr>
		<td>변경후</td>
		<td><input type="password" id="memberPw2" name="memberPw2"></td>
	</tr>
	</table>
	<button id="modBtn">수정</button>
	</form>
</body>
	

</html>