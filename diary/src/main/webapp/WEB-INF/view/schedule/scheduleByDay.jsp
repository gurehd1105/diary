<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>스케줄 상세보기</h1>
		<table border="1">
			<tr>
				<td>일자</td>
				<td>메모</td>
			</tr>
		   <c:forEach var="m" items="${list}">	
			   <tr>			
				   <td>${m.scheduleDate}</td>
				   <td>${m.scheduleMemo}</td>		
			   </tr>				
		   </c:forEach>		    	
		</table>
</body>
</html>