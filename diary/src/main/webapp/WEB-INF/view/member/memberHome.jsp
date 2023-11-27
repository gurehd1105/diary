<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js">
</script>
</head>
<body>
	
	
	<h1>안녕하세요!! ${loginMember.memberId}님</h1>
	<div>
 		<a href="${pageContext.request.contextPath}/member/logoutMember">로그아웃</a>
 		<!--로그아웃 프로세스: ---LogoutMemberController.doGet()-- [session invalidate]--/member/loginMember -->	
 		
 		<a href="${pageContext.request.contextPath}/member/modifyMemberPw">비밀번호수정</a>
 		<!--비밀번호 수정폼: ---ModifyMemberController.doGet()--modifyMemberPw.jsp -->
 		<!--비밀번호 수정액션: ModifyMemberController.doPost()--[session invalidate]--/member/loginMember  -->
 		
 		<a href="${pageContext.request.contextPath}/member/removeMember">회원탈퇴</a>
 		<!--비밀번호 탈퇴폼: RemoveMemberController.doGet()--removeMember.jsp -->
 		<!--비밀번호 탈퇴액션: RemoveMemberController.doPost()--[session invalidate]--/member/loginMember  -->			
 	</div>
 	<!-- 공지사항 -->
 	
 	<h1>공지사항 리스트</h1>	
 	<div>
 
 	 <a href="${pageContext.request.contextPath}/notice/insertNotice">공지사항 추가</a>
 		<table border="1">
 			
 			<tr>
 				<td>번호</td>
 				<td>제목</td>
 				<td>작성일</td>
 				<td>수정</td>
 				<td>삭제</td>
 			</tr>			
 			<c:forEach var="n" items="${noticeList}">
 				<tr>
 					<td>${n.noticeNo}</td>
 					<td>
 						<a href="${pageContext.request.contextPath}/notice/noticeOne?noticeNo=${n.noticeNo}">${n.noticeTitle}</a>						
 					</td>
 					<td>${n.createdate}</td>				
 					<td>
 						<a href="${pageContext.request.contextPath}/notice/updateNotice?noticeNo=${n.noticeNo}">수정</a>
 					</td>
 					<td>
 						<a href="${pageContext.request.contextPath}/notice/deleteNotice?noticeNo=${n.noticeNo}">삭제</a>
 					</td>
 				</tr> 		
 			</c:forEach>
 		</table>	
 	</div>
 	<br>
	
	<!-- 달력 -->
	<div>
		<h1>${targetY}년 ${targetM+1}월</h1>
		
		<div>
			<a href="${pageContext.request.contextPath}/member/memberHome?targetY=${targetY}&targetM=${targetM-1}">이전달</a>
			
			<!-- 만약 href속성값 매개값이 많으면 c:url jstl을 사용하면 가독성 높일 수 있다 -->
			<c:url var = "nextUrl" value="/member/memberHome">
				<c:param name="targetY" value="${targetY}"></c:param>
				<c:param name="targetM" value="${targetM+1}"></c:param>	
			</c:url>
			<a href="${nextUrl}">다음달</a>
		</div>
		
		<table border="1">
			<tr>
				<c:forEach var="i" begin="1" end="${totalTd}" step="1">
					<c:set var="d" value="${i - beginBlank}"></c:set>
					<td>
						<c:if test="${d < 1 || d > lastD}">
							&nbsp;
						</c:if>
						<c:if test="${!(d < 1 || d > lastD)}">
							<a href="${pageContext.request.contextPath}/schedule/scheduleByDay?targetY=${targetY}&targetM=${targetM-1}&targetD=${d}">
								${d}
							</a>
							<div>
								<c:forEach var="m" items="${list}">
									<c:if test="${m.scheduleDay == d}">
										<div>${m.cnt} 개의 일정</div>
										<div>${m.memo}</div>
									</c:if>
								</c:forEach>
							</div>
						</c:if>
						
						<c:if test="${i<totalTd && i%7==0}">
							</tr><tr>
						</c:if>
					</td>
				</c:forEach>
			</tr>
		</table>
	</div>
</body>
</html>
