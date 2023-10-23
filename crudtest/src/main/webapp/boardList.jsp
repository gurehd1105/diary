<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>		
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "vo.Board" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	int currentPage = 1;
	if(request.getParameter("currentPage") != null){
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	int rowPerPage = 10;
	
	// 사용자 정보
	Class.forName("org.mariadb.jdbc.Driver");
	System.out.println("드라이브 로딩 성공");
	String url = "jdbc:mariadb://localhost:3306/gdj72";
	String dbuser = "root";
	String dbpw = "java1234";
	
	Connection conn = DriverManager.getConnection(url, dbuser,dbpw);
	System.out.println("DB접속 성공");
	
	String sql1 ="SELECT count(*) FROM board ";
   	PreparedStatement stmt1 = conn.prepareStatement(sql1);
 	ResultSet rs1 = stmt1.executeQuery();
 	int totalRow = 105;
 	if(rs1.next()){
 		totalRow = rs1.getInt("COUNT(*)");
 	} 															
 	int lastPage = totalRow / rowPerPage;
 	if(totalRow % rowPerPage != 0){
 		lastPage = lastPage + 1;
 	}
 	System.out.println(lastPage + "<-- lastPage");
	
	 
	// SELEct ~ As ~: 컬럼에 별칭주기
	 				
	 	//한 페이지에 10개
	 String sql2 = "SELECT board_no boardNo, board_title boardTitle, createdate FROM board ORDER BY createdate LIMIT ?,?";	
	 PreparedStatement stmt2 = conn.prepareStatement(sql2);
	 int beginRow =(currentPage-1)*rowPerPage;
	 stmt2.setInt(1, beginRow);
	 stmt2.setInt(2, rowPerPage);
	 ResultSet rs2 = stmt2.executeQuery();
	
	ArrayList<Board> list = new ArrayList<Board>();
	while(rs2.next()){
		Board b = new Board();	// 결과행의 수만큼 Board객체 필요
		b.boardNo = rs2.getInt("boardNo");
		b.boardTitle = rs2.getString("boardTitle");	
		b.createdate = rs2.getString("createdate");
		list.add(b);
	}
	// 모델 레이어
	//---------------------------------------	
	rs2.close();
	stmt2.close();
	conn.close();

%> 
	<!-- 뷰 레이어 -->

	<ul>
		<li><a href="<%=request.getContextPath()%>/home.jsp">홈으로</a></li>
		<li><a href="<%=request.getContextPath()%>/empList.jsp">직원관리</a></li>
		<li><a href="<%=request.getContextPath()%>/teamList.jsp">팀관리</a></li>
		<li><a href="<%=request.getContextPath()%>/studentList.jsp">학생관리</a></li>
		<li><a href="<%=request.getContextPath()%>/boardList.jsp">게시판관리</a></li>
	</ul>
	
	<h1>게시판</h1>
	<div>
		<a href="<%=request.getContextPath()%>/addBoardForm.jsp">게시판추가</a>
	</div>
	<table border="1">
	 	<tr>
	 	  <th>board_No</th>
		  <th>board_Title</th>
		  <th>createdate</th>
		</tr> 
	 <% 
		for(Board b: list){
	 %>
	 	<tr>
	 		<td>
	 			<%=b.boardNo %>
		 	<td>
		 		<a href="<%=request.getContextPath()%>/boardOne.jsp?boardNo=<%=b.boardNo%>">
		 			<%=b.boardTitle %>
		 		</a>
		 	</td>
		 	<td>
		 		<%=b.createdate %>	
		 	</td>	
	 	</tr>	
	 <% 			
		}
	 %>
	</table>
	<div>
		<a href="<%=request.getContextPath()%>/boardList.jsp?currentPage=1">
			처음
		</a>
		<%
		if(currentPage>1){
		%>
		<a href="<%=request.getContextPath()%>/boardList.jsp?currentPage=<%=currentPage-1%>">
			이전
		</a>
		<% 		
			}
		%>
		<%
		if(currentPage<lastPage){
		%>
		<a href="<%=request.getContextPath()%>/boardList.jsp?currentPage=<%=currentPage+1%>">
			다음
		</a>
		<a href="<%=request.getContextPath()%>/boardList.jsp?currentPage=<%=lastPage%>">
			마지막
		</a>
		<%	
		}
		%>
	</div>
</body>
</html>

    
