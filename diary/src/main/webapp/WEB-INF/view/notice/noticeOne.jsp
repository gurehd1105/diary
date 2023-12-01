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

	<h1>상세정보</h1>
	<table border="1">
		<tr>
			<th>번호</th>			
			<td>${noticeOne.noticeNo}</td>
		</tr>
		<tr>	
			<th>제목</th>				
			<td>${noticeOne.noticeTitle}</td>
		</tr>
		<tr>	
			<th>내용</th>			
			<td>${noticeOne.noticeContent}</td>	
		</tr>
		<tr>	
			<th>작성일</th>	
			<td>${noticeOne.createdate}</td>						
		</tr>		
	</table>
	<br>
	<br>
	<br>
	<br>
	<h1>코멘트</h1>
	<table border="1">
		<tr>
			<td>내용</td>	
			<td>작성일</td>		
		</tr>
	</table>
	


</body>
</html>