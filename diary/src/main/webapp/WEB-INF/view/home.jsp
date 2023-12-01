<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HOME</h1>
	<div>로그인 성공!!! ${loginMember.memberId}님 환영합니다</div>
	<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
	<a href="${pageContext.request.contextPath}/modifyPw">비밀번호 수정</a>	
	<a href="${pageContext.request.contextPath}/noticeList">공지사항</a>	
	<a href="${pageContext.request.contextPath}/removeMember">회원탈퇴</a>	
	
	<div>
		${calendarMap.targetYear}년
		${calendarMap.targetMonth + 1}월	
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/home?targetMonth=${calendarMap.targetMonth-1}&targetYear=${calendarMap.targetYear}">이전달</a>
		<a href="${pageContext.request.contextPath}/home?targetMonth=${calendarMap.targetMonth+1}&targetYear=${calendarMap.targetYear}">다음달</a>
	</div>
	<table border="1">
		<tr>
			<c:forEach var="i" begin="1" end="${calendarMap.totalTd}">
				<c:set var="d" value="${i-calendarMap.beginBlank}"></c:set>
				<td>
					<c:if test="${d < 1 || d >calendarMap.lastDate}">
					&nbsp; 
					</c:if> 				
					<c:if test="${!(d < 1 || d >calendarMap.lastDate)}">
						<a href="${pageContext.request.contextPath}/schedule/scheduleOne?targetY=${targetY}&targetM=${targetM-1}&targetD=${d}">${d}</a>
					</c:if>
					<!--  한 행에 7열씩 출력하도록 행(<tr></tr>)추가-->
					<c:if test="${i < calendarMap.totalTd && i % 7 == 0}">
						<tr></tr>					
					</c:if>
					
				</td>			
			</c:forEach>
		</tr>
	
	</table>
	
	
	
	
	
</body>
</html>