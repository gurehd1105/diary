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
    <h1>공지사항 추가</h1>
    <form id="insertNotice" method="post" action="${pageContext.request.contextPath}/notice/insertNotice">
        <table border="1">
        <tr>
          <td>
            <label for="memberId">Member ID:</label>      
            <input type="text" id="memberId" name="memberId" value="${loginMember.memberId}" readonly>
          </td>
		</tr>
		<tr>
          <td>
            <label for="noticeTitle">Title:</label>
            <input type="text" id="noticeTitle" name="noticeTitle" required>
          </td>
		</tr>
		<tr>
          <td>
            <label for="noticeContent">Content:</label>
            <textarea id="noticeContent" name="noticeContent" required></textarea>
          </td>
       	</tr>
       </table>
       <br>
       <button id="insertBtn" name="insertBtn">공지사항 추가</button>
    </form>
</body>
</html>