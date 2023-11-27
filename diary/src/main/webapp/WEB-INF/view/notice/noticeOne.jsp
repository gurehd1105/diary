<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>상세보기</h1>
	
		<table border="1">
		<tr>
        	<th>번호</th>
        	<th>멤버</th>
        	<th>제목</th>
        	<th>내용</th>
        	<th>작성일</th>
        	<th>수정일</th>
        </tr>
        <tr>
        	<td>${notice.noticeNo}</td>
        	<td>${notice.memberId}</td>
        	<td>${notice.noticeTitle}</td>
        	<td>${notice.noticeContent}</td>
        	<td>${notice.createdate}</td>
        	<td>${notice.updatedate}</td>
        </tr>
	
		</table>
	
</body>
</html>