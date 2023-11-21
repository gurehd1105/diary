package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import vo.Member;

public class MemberDao {
	// 로그인
	public Member loginMember(Member paramMember) {
		Member resultMember = new Member();
		
		//커넥션 풀
		DataSource ds = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// Tomcat context.xml 설정을 로드
			Context context = new InitialContext(); 
			// context.xml에서 커넥션풀 객체 로드
			ds = (DataSource)context.lookup("java:comp/env/jdbc/diary");
			conn = ds.getConnection();

			//conn 디버깅
			System.out.println(conn+" <--conn");			
			System.out.println(paramMember.getMemberId() + "<-- loginid");
			System.out.println(paramMember.getMemberPw() + "<-- loginpw");

			
			String sql = "SELECT member_no memberNo, member_id memberId, member_pw memberPw FROM member WHERE member_id=? and member_pw = PASSWORD(?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, paramMember.getMemberId());
			stmt.setString(2, paramMember.getMemberPw());
			System.out.println(stmt + "<--stmt");			
			rs = stmt.executeQuery();
			if(rs.next()) {
				resultMember = new Member();
				resultMember.setMemberNo(rs.getInt("memberNo"));
				resultMember.setMemberId(rs.getString("memberId"));			
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) {
				rs.close();	
				}
				if (stmt != null) {
				stmt.close();	
				}
				if (conn != null) {
				conn.close();	
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultMember; // 로그인 실패시 null, 성공시 memberNo속성 + memberId속성 
	}




	// 회원가입
	public int insertMember(Member paramMember) {
		int row = 0;
		// 커넥션풀
		DataSource ds = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// Tomcat context.xml 설정을 로드
			Context context = new InitialContext(); 
			// context.xml에서 커넥션풀 객체 로드
		    ds = (DataSource)context.lookup("java:comp/env/jdbc/diary");
			conn = ds.getConnection();
			// conn 디버깅
			System.out.println(conn + "<--conn");
			String sql = "INSERT INTO member(member_id, member_pw, createdate) VALUES(?, PASSWORD(?), NOW())";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, paramMember.getMemberId());
			stmt.setString(2, paramMember.getMemberPw());
			row = stmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
				stmt.close();	
				}	
				if(conn != null) {
				conn.close();	
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
		return row;
	}

	
	//비밀번호 수정
	
	public int modifyMemberPw (int memberNo, String memberPw, String memberPw2) {
		int row = 0;
		//커넥션풀
		DataSource ds = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/diary");
			conn = ds.getConnection();
			//conn 디버깅
			System.out.println(conn+" <--conn");
			System.out.println(memberNo +"<--memberNo");
			System.out.println(memberPw +"<--memberPw");
			System.out.println(memberPw2 +"<--memberPw2");

			
			
			String sql = "UPDATE member SET member_pw = PASSWORD(?) WHERE member_no =? AND member_pw= PASSWORD(?)";
			stmt = conn.prepareStatement(sql);						
			stmt.setString(1, memberPw);
			stmt.setString(2, memberPw2);
			stmt.setInt(3, memberNo);
			
			row = stmt.executeUpdate();
			System.out.println(stmt + "<--stmt");	
			
			if(row==1) {
				System.out.println("업데이트 성공");
			} else {
				System.out.println("업데이트 실패");
				return row;
			}
		
		} catch (Exception e) {	
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
		return row;
			
	}
	
	
	// 회원탈퇴
	public int removeMember(int memberNo, String memberPw) {
		int row = 0;
		//커넥션풀		
		DataSource ds = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/diary");
			conn = ds.getConnection();
			//conn 디버깅
			System.out.println(conn+" <--conn");
			System.out.println(memberNo + "<--memberNo");
			System.out.println(memberPw + "<--memberPw");
	
			String sql = "DELETE FROM member WHERE member_no = ? AND member_pw = PASSWORD(?) ";
			stmt = conn.prepareStatement(sql);		
			stmt.setString(1, memberPw);
			stmt.setInt(2, memberNo);
			
			row = stmt.executeUpdate();
			System.out.println(stmt + "<--stmt");
			
			
			if(row==1) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
				return row;
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
		return row;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
