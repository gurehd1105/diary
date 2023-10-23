<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%>
<%
	int boardNo = Integer.parseInt(request.getParameter("boardNo"));
	String boardPw = request.getParameter("boardPw");
	
	Class.forName("org.mariadb.jdbc.Driver");
	String url = "jdbc:mariadb://localhost:3306/gdj72";
	String dbuser = "root";
	String dbpw = "java1234";
	
	Connection conn = DriverManager.getConnection(url, dbuser, dbpw);
	String sql = "DELETE FROM Board WHERE board_no=? AND board_pw = ?";
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1, boardNo);
	stmt.setString(2, boardPw);
	
	int row = stmt.executeUpdate();
	
	stmt.close();
	conn.close();
	
	if(row == 1) {
		response.sendRedirect(request.getContextPath()+"/boardList.jsp");		
		System.out.println("삭제성공");
	}	else {
		response.sendRedirect(request.getContextPath()+"/deleteBoardForm.jsp?boardNo="+boardNo);
		System.out.println("삭제실패");
	}
	
%>





