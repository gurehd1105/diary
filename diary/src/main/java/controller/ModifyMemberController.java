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

@WebServlet("/member/modifyPwMember")
public class ModifyMemberController extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session 유효성 검사
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null) {
			// 로그인이 되어 있는 상태
			// 리다이렉트 할 컨트롤러 url
			response.sendRedirect(request.getContextPath()+ "/member/memberHome");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/member/modifyPwMember.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// session 유효성 검사
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null) {
			// 로그인이 되어 있는 상태
			// 리다이렉트 할 컨트롤러 url
			response.sendRedirect(request.getContextPath()+ "/member/memberHome");
			return;
		}
		
		Member member = (Member)session.getAttribute("loginMember");	
		
		int memberNo = member.getMemberNo();		
		String MemberPw = request.getParameter("memberPw");
		String MemberPw2 = request.getParameter("memberPw2");
		
		MemberDao memberDao = new MemberDao();
		
		try {
			
			int row = memberDao.modifyMemberPw(memberNo, MemberPw, MemberPw2);
			System.out.println(row);
			session.invalidate();
			response.sendRedirect(request.getContextPath()+"/member/loginMember");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
