<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.*" %> 
<%
	Member member = new Member();
	member = (Member)session.getAttribute("loginMember");

	

%> 
  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>환영합니다.<%=member.getMemberId()%></h1>
 	<div>
 		<a href="<%=request.getContextPath()%>/member/logoutMember">로그아웃</a>
 		<!--로그아웃 프로세스: ---LogoutMemberController.doGet()-- [session invalidate]--/member/loginMember -->	
 		
 		<a href="<%=request.getContextPath()%>/member/modifyPwMember">비밀번호수정</a>
 		<!--비밀번호 수정폼: ---ModifyMemberController.doGet()--modifyMemberPw.jsp -->
 		<!--비밀번호 수정액션: ModifyMemberController.doPost()--[session invalidate]--/member/loginMember  -->
 		
 		<a href="<%=request.getContextPath()%>/member/removeMember">회원탈퇴</a>
 		<!--비밀번호 탈퇴폼: RemoveMemberController.doGet()--removeMember.jsp -->
 		<!--비밀번호 탈퇴액션: RemoveMemberController.doPost()--[session invalidate]--/member/loginMember  -->		
 	</div>
 
</body>
</html>