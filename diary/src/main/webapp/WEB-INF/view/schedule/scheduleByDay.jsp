<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>         
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${param.targetY}년 ${param.targetM+1}월 ${param.targetD}일 스케줄</h1>
	
	<table border="1">
		<tr>
			<td>일자</td>
			<td>메모</td>
			<td>수정</td>
			<td>삭제</td>			
		</tr>
		<c:forEach var="s" items="${list}">
			<tr>
				<td>${s.scheduleDate}</td>
				<td>${s.scheduleMemo}</td>
				<td>
				<a href="${pageContext.request.contextPath}/schedule/modifyScheduleByDay?scheduleNo=${s.scheduleNo}">수정</a>
				</td>
				<td>
				<a href="?scheduleNo=${s.scheduleNo}">삭제</a>
				</td>
			</tr>
			
			<tr>
				<input type="hidden" name="year" value="${targetY}"> 
				<input type="hidden" name="month" value="${targetM}"> 
				<input type="hidden" name="Day" value="${targetD}"> 			
			</tr>
		</c:forEach>	
	</table>
	<h1>일정 추가</h1>
		<div>
			<form action="">
				<input type="hidden" name="year" value="${targetY}">
				<input type="hidden" name="month" value="${targetM+1}">
				<input type="hidden" name="day" value="${targetD}">
							
				<textarea rows="3" cols="80" name="scheduleMemo"></textarea>
				<button type="button">일정추가</button>
			</form>
		</div>
</body>
</html>