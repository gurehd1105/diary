<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
</head>
<body>
    <div class="container">
        <h1>DIARY</h1>
        <div>${loginMember.memberId}님의 일정</div>
        <div>
	        <a href="${contextPath}/logout" class="btn btn-primary">로그아웃</a>
	        <a href="${contextPath}/modifyPw" class="btn btn-secondary">정보수정</a> 
	        <a href="${contextPath}/noticeList" class="btn btn-success">공지사항</a>  
        </div>
        <!-- 회원탈퇴는 마리아DB NO ACTION 변경 오류로 쿼리 등은 만들었으나 보류 -->
        <br><br>
        <div>          
    </div>
        <!-- 캘린더 -->       
		<div class="row">
		    <div class="col">
		        <h2>${calendarMap.targetYear}년 ${calendarMap.targetMonth + 1}월</h2>
		    </div>
		    <div class="col">
		        <form action="${pageContext.request.contextPath}/scheduleListByWord" method="get" id="search" class="d-flex">    
		            <input name="word" class="form-control me-2">        
		            <button type="submit" class="btn btn-info">🔍</button>
		        </form>
		    </div>
		    <div class="col text-end">
		        <a href="${contextPath}/home?targetMonth=${calendarMap.targetMonth-1}&targetYear=${calendarMap.targetYear}" class="btn btn-primary me-2">이전달</a>
		        <a href="${contextPath}/home?targetMonth=${calendarMap.targetMonth+1}&targetYear=${calendarMap.targetYear}" class="btn btn-primary">다음달</a>
		    </div>
			</div>	
        <table class="table table-bordered" style="font-size: 30px;">
            <tr>
                <td style="color: Tomato;">일</td>
                <td>월</td>
                <td>화</td>
                <td>수</td>
                <td>목</td>
                <td>금</td>
                <td style="color: DodgerBlue;">토</td>
            </tr>
            
            <tr>
                <c:forEach var="i" begin="1" end="${calendarMap.totalTd}">
                    <c:set var="d" value="${i-calendarMap.beginBlank}"/>
                    <td>
                        <c:if test="${d < 1 || d> calendarMap.lastDate}">
                            &nbsp;
                        </c:if>
                        
                        <c:if test="${!(d < 1 || d> calendarMap.lastDate)}">
                            <a href="${contextPath}/scheduleByDay?targetYear=${calendarMap.targetYear}&targetMonth=${calendarMap.targetMonth+1}&targetDay=${d}">
                           <span style="font-size: 25px;"> ${d}</span><br><br>
                            </a>
                            <c:forEach var="s" items="${scheduleList}">
                                <c:if test="${d == s.day}">                               
                                    <div style="font-size: 25px;">${s.cnt}개의 일정</div>                                              
                                </c:if>                  
                            </c:forEach>
                        </c:if>

                        <!-- 한 행 당 7열 -->
                        <c:if test="${i<calendarMap.totalTd && i%7==0}">
                            </tr><tr>
                        </c:if>

                    </td>
                </c:forEach>      
            </tr>   
        </table>
    </div>
    <br>
    <br>
    <br>  
</body>
<script>
    // Your JavaScript code here
</script>
</html>