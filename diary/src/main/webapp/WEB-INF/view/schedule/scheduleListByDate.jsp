<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>         
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>no</th>
			<th>memo</th>
			
		</tr>	
		<c:forEach var="s" items="${list}">
			<tr>
				<td>${s.scheduleNo}</td>
				<td>${s.scheduleMemo}</td>			
			</tr>	
		</c:forEach>
		
	</table>
		<form action="./scheduleListByDate" method="get">
		<select name="year">
			<option>년</option>
			<c:forEach var="year" begin="${maxMinYear.minYear}" end="${maxMinYear.maxYear}" step="1">
				<c:if test="${year == paramYear}">
					<option selected>${year}</option>
				</c:if>
				<c:if test="${year != paramYear}">
					<option>${year}</option>
				</c:if>	
			</c:forEach>
		</select>
		<select name="month">
			<option>월</option>
			<c:forEach var="month" begin="1" end="12" step="1">
				<c:if test="${month == paramMonth}">
					<option selected>${month}</option>
				</c:if>
				<c:if test="${month != paramMonth}">
					<option>${month}</option>
				</c:if>
			</c:forEach>
		</select>
		<select name="day">
			<option>일</option>
			<c:forEach var="day" begin="1" end="31" step="1">
				<c:if test="${day == paramDay}">
					<option selected>${day}</option>
				</c:if>
				<c:if test="${day != paramDay}">
					<option>${day}</option>
				</c:if>
			</c:forEach>
		</select>
		<button type="submit">검색</button>
	</form>
</body>
</html>
