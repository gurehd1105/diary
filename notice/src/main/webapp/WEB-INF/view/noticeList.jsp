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
	<h1>Notice List</h1>
	
	<a href="${pageContext.request.contextPath}/addNotice">공지사항 추가</a>
		<table border="1">
		
			<tr>
				<td>번호</td>
				<td>제목</td>				
			</tr>
			<c:forEach var="n" items="${list}">
			<tr>
				<td>${n.noticeNo}</td>
				<td><a href="${pageContext.request.contextPath}/noticeOne?=${noticeNO}">${n.noticeTitle}</a></td>
			</tr>
			</c:forEach>
		</table>
		<c:if test="${currentPage > 1}">
			<a href="${pageContext.request.contextPath}/noticeList?currentPage=${currentPage - 1}">이전</a>
		</c:if>
			<a href="${pageContext.request.contextPath}/noticeList?currentPage=${currentPage + 1}">다음</a>
	
</body>
</html>