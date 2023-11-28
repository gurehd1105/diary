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
			<td>번호</td>
			<td>제목</td>	
			<td>내용</td>	
			<td>작성일</td>				
		</tr>
		<tr>
			<td>${notice.noticeNo}</td>
			<td>${notice.noticTitle}</td>	
			<td>${notice.noticeContent}</td>	
			<td>${notice.Createdate}</td>				
		</tr>
	</table>	
	
</body>
</html>