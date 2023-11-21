<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js">
</script>

</head>
<body>
	<h1>비밀번호 수정</h1>
	<form id="updatePw" method="post" action="<%=request.getContextPath()%>/member/modifyPwMember">
	<table border="1">
	<tr>
		<td>현재 비밀번호</td>
		<td><input type="password" id="memberPw" name="memberPw"></td>
	</tr>
	<tr>
		<td>변경후 비밀번호</td>
		<td><input type="password" id="memberPw2" name="memberPw2"></td>
	</tr>
	</table>
	<button id="modBtn">수정</button>
	</form>ㄴ
</body>
	<script type="text/javascript">
	$('#modBtn').click(function()){
		if($('memberPw').val().length<1){
			alert('현재 비밀번호를 입력하세요');
		} else if ($('memberPw2').val().length<1){
			alert('새로운 비밀번호를 입력하세요');
		} else if ($('memberPw').val() ==$('memberPw2').val()) {
			alert('비밀번호가 동일합니다. 다른 번호로 변경하세요');
		} else{
			$('#modBtn').submit();
		}
	});
});
</script>

</html>