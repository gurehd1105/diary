package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.Member;

@WebServlet("/member/removeMember")
public class RemoveMemberController extends HttpServlet {

	// remove폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember")== null) {  //로그인이 되어 있지 않다면 로그인폼으로 이동
			response.sendRedirect(request.getContextPath()+"/member/loginMember");
			return;
		}
		// view forward
		request.getRequestDispatcher("/WEB-INF/view/member/removeMember.jsp").forward(request, response);

	}

	// remove 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember")== null) {
			response.sendRedirect(request.getContextPath()+"/member/loginMember");
			return;
		}
	Member loginMember = (Member)session.getAttribute("loginMember");
	int memberNo = loginMember.getMemberNo();
	String memberPw = request.getParameter("memberPw");
	
	MemberDao memberdao = new MemberDao();
	int row = memberdao.removeMember(memberNo, memberPw);
	System.out.println(row);
	
	if(row != 1) {
		response.sendRedirect(request.getContextPath()+"/member/memberHome");
		return;
	}	session.invalidate();
		response.sendRedirect(request.getContextPath()+"/member/loginMember");
			
	}

}
