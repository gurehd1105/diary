<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>공지사항 입력</h1>
		<form  method="post" action="${pageContext.request.contextPath}/notice/addNotice">
			<table border="1">
			
			<tr>
				<th>제목</th>
				<td><input type="text" name="noticeTitle"></td>								
			</tr>			
			<tr>
				<th>내용</th>
				<td><input type="text" name="noticeContent"></td>
			</tr>				
			</table>
			<button id="addBtn" name="addBtn">공지사항 추가</button>
		</form>

</body>
</html>