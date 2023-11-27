package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import vo.*;
import dao.*;


public class NoticeDao {
	//member_level > 0
	
	public int insertNotice(Notice notice) {
		int row = 0;		
		//커넥션 풀
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
			String sql = "INSERT INTO notice(member_id, notice_title, notice_content) VALUES(?, ?, ?)";
			stmt = conn.prepareStatement(sql);			
			stmt.setString(1,notice.getMemberId());
			stmt.setString(2,notice.getNoticeTitle());
			stmt.setString(3,notice.getNoticeContent());
		
			row = stmt.executeUpdate();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return row ;
	}

	//member_level > 0 and pw일치
	public int deleteNotice(Notice notice) {
		return 0;

	}
	
	//member_level > 0 and pw일치
	public int updateNotice(Notice notice) {
		
		return 0;

	}
		
	
	public Notice noticeOne(int noticeNo) {
		//커넥션 풀
				DataSource ds = null;
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;
				Notice n = null;
						
				try {
					Context context = new InitialContext();
					ds = (DataSource) context.lookup("java:comp/env/jdbc/diary");
					conn = ds.getConnection();
					System.out.println(conn + "<--conn");
					String sql = "SELECT notice_no noticeNo, member_id memberId, notice_title noticeTitle, notice_content noticeContent, createdate, updatedate FROM notice WHERE notice_no = ?";
							
					stmt = conn.prepareStatement(sql);
					stmt.setInt(1, noticeNo);	
				
					rs = stmt.executeQuery();
					if(rs.next()) {
						n = new Notice();
						n.setNoticeNo(rs.getInt("noticeNo"));
						n.setMemberId(rs.getString("memberId"));
						n.setNoticeTitle(rs.getString("noticeTitle"));
						n.setNoticeContent(rs.getString("noticeContent"));
						n.setCreatedate(rs.getString("createdate"));
						n.setUpdatedate(rs.getString("Updatedate"));
			
					}
	
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if (rs != null) {
			                rs.close();
			            }
						if (conn != null) {
			                conn.close();
			            }
						if (stmt != null) {
			                stmt.close();
			            }
			           
					} catch (SQLException e) {
				
						e.printStackTrace();
					}
				}
				return n;
					
	}
	
	
	
	public List<Notice> selectNoticeList(){
		List<Notice> list = new ArrayList<>();

		//커넥션 풀
		DataSource ds = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
				
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/diary");
			conn = ds.getConnection();

			String sql = """
					SELECT 
				        notice_no noticeNo, 
				        notice_title noticeTitle,
				        notice_content noticeContent,
				        createdate				      			        
				    FROM notice					
				""";
			stmt = conn.prepareStatement(sql);
			    
			rs = stmt.executeQuery();
			while(rs.next()) {
				Notice n = new Notice();
				n.setNoticeNo(rs.getInt("noticeNo"));
				n.setNoticeTitle(rs.getString("noticeTitle"));
				n.setNoticeContent(rs.getString("noticeContent"));
				n.setCreatedate(rs.getString("createdate"));
				list.add(n);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) {
	                rs.close();
	            }
				if (conn != null) {
	                conn.close();
	            }
				if (stmt != null) {
	                stmt.close();
	            }
	           
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		}
		return list;	
	}

	
	
}
