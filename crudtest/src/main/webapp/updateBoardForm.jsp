<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "vo.Board" %>

<%
	int boardNo = Integer.parseInt(request.getParameter("boardNo"));

	Class.forName("org.mariadb.jdbc.Driver");  // 드라이브 로딩
	System.out.println("드라이브 로딩성공");
	String url = "jdbc:mariadb://localhost:3306/gdj72";  // 마리아 디비 접속
	String dbuser = "root";                              // 이름
	String dbpw = "java1234";
	
	Connection conn = DriverManager.getConnection(url, dbuser, dbpw);
	
	String sql = "SELECT board_no boardNo, board_title boardTitle, board_content boardContent, board_writer boardWriter, createdate, updatedate FROM board WHERE board_no =?";
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1, boardNo);
	ResultSet rs = stmt.executeQuery();
	Board board = null;
	
	if(rs.next()){
		board = new Board();
		board.boardNo = rs.getInt("boardNo");
		board.boardTitle = rs.getString("boardTitle");
		board.boardContent = rs.getString("boardContent");
		board.boardWriter = rs.getString("boardWriter");
		board.createdate= rs.getString("createdate");
		board.updatedate = rs.getString("updatedate");
	}
	


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 수정</h1>
	  <form action="<%=request.getContextPath()%>/updateBoardAction.jsp">
		<table border="1">
		  <tr>
			  	<td>board_no</td>
			  	<td>
			  		<input type="number" name="boardNo" value="<%=board.boardNo%>" readonly="readonly">
			  	</td>
			  </tr>
			   <tr>
			  	<td>board_title</td>
			  	<td>
			  		<input type="text" name="boardTitle" value="<%=board.boardTitle%>">
			  	</td>
			  </tr>	
			   <tr>
			  	<td>board_content</td>
			  	<td>
			  		<textarea rows=8 cols=30 name="boardContent"><%=board.boardContent%>"</textarea>
			  	</td>
			  </tr>
			   <tr>
			  	<td>board_writer</td>
			  	<td>
			  		<input type="text" name="boardWriter" value="<%=board.boardWriter%>">
			  	</td>
			  </tr>	
			   <tr>
			  	<td>board_pw</td>
			  	<td>
			  		<input type="password" name="boardPw">
			  	</td>
			  </tr>
			  <tr>
					<td>createdate</td>
					<td><%=board.createdate%></td>
			  </tr>
			  <tr>
					<td>updatedate</td>
					<td><%=board.updatedate%></td>
			  </tr>	
			  <tr>
					<td 
					colspan="2"><button type="submit">수정</button>
					</td>
			  </tr>
		  		
		</table>
	  </form>
</body>
</html>