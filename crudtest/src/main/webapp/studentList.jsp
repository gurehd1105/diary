<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "vo.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Class.forName("org.mariadb.jdbc.Driver");
	System.out.println("드라이브 로딩 성공");
	String url = "jdbc:mariadb://localhost:3306/gdj72";
	String dbuser = "root";
	String dbpw = "java1234"; 

	Connection conn = DriverManager.getConnection(url, dbuser, dbpw);
	System.out.println("DB접속 성공");
	
	
	String sql = "SELECT s.student_no studentNo,s.student_name studentName,s.student_birth studentBirth,s.createdate sCreatedate,s.updatedate sUpdatedate,s.team_no teamNo,t.team_name teamName,t.team_count teamCount,t.team_begin teamBegin,t.team_end teamEnd,t.createdate tCreatedate,t.updatedate tUpdatedate FROM student s INNER JOIN team t ON s.team_no = t.team_no WHERE s.student_no";
    PreparedStatement stmt = conn.prepareStatement(sql);   
    ResultSet rs = stmt.executeQuery();
	
	 ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		   while(rs.next()) {
			  HashMap <String, Object> m = new HashMap<String, Object>();
		      m.put("studentNo", rs.getInt("studentNo"));
		      m.put("studentName", rs.getString("studentName"));
		      m.put("studentBirth", rs.getString("studentBirth"));
		      m.put("sCreatedate", rs.getString("sCreatedate"));
		      m.put("sUpdatedate", rs.getString("sUpdatedate"));
		      m.put("teamNo", rs.getInt("teamNo"));
		      m.put("teamName", rs.getString("teamName"));
		      m.put("teamCount", rs.getInt("teamCount"));
		      m.put("teamBegin", rs.getString("teamBegin"));
		      m.put("teamEnd", rs.getString("teamEnd"));
			  m.put("tCreatedate", rs.getString("tCreatedate"));
			  m.put("tUpdatedate", rs.getString("tUpdatedate"));
	      list.add(m);
	   }
	   rs.close();
	   stmt.close();
	   conn.close();
%>
	<ul>
		<li><a href="<%=request.getContextPath()%>/home.jsp">홈으로</a></li>
		<li><a href="<%=request.getContextPath()%>/empList.jsp">직원관리</a></li>
		<li><a href="<%=request.getContextPath()%>/teamList.jsp">팀관리</a></li>
		<li><a href="<%=request.getContextPath()%>/studentList.jsp">학생관리</a></li>
		<li><a href="<%=request.getContextPath()%>/boardList.jsp">게시판관리</a></li>
	</ul>
	<h1>학생</h1>
	<div>
		<a href="<%=request.getContextPath()%>/addStudentForm.jsp">학생추가</a>
	</div>
	<table border="1">
	  <tr>
	  	<th>studentNo</th>
	  	<th>studentName</th>
	  	<th>studentBirth</th>
	  	<th>sCreatedate</th>
	  	<th>sUpdatedate</th>
	  	<th>teamNo</th>
	  	<th>teamName</th>
	  	<th>teamCount</th>
	  	<th>teamBegin</th>
	  	<th>teamEnd</th>
	  	<th>tCreatedate</th>
	  	<th>updatedate</th>
	  	
	  	
	  	
	  <%
	  	for(HashMap<String, Object> m : list){
	  %>		
	  	  <tr>
	  	  	<td>
	  	  	   <td><%=m.get("studentNo")%></td>
	  	  	   <td><%=m.get("studentName")%></td>
	  	  	   <td><%=m.get("screatedate")%></td>
	  	  	   <td><%=m.get("sUpdatedate")%></td>
	  	  	   <td><%=m.get("teamNo")%></td>
	  	  	   <td><%=m.get("teamName")%></td>
	  	  	   <td><%=m.get("teamCount")%></td>
	  	  	   <td><%=m.get("teamBegin")%></td>
	  	  	   <td><%=m.get("teamEnd")%></td>
	  	  	   <td><%=m.get("tCreatedate")%></td>
	  	  	   <td><%=m.get("tupdatedate")%></td>  	  	   
		 </tr> 
	  <%
	  	}
	  %>	

	</table>
</body>
</html>