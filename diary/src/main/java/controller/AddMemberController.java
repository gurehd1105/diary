package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dao.MemberDao;
import vo.Member;

@WebServlet("/member/addMember")
public class AddMemberController extends HttpServlet {
	// 회원가입 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController 실행");
		
		
		
		// session 유효성 검사
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null) {
			// 로그인이 되어 있는 상태
			// 리다이렉트 할 컨트롤러 url
			response.sendRedirect(request.getContextPath()+"/member/memberHome");
			return;
		}
		
		// view forward
		request.getRequestDispatcher("/WEB-INF/view/member/addMember.jsp").forward(request, response);
	}

	// 회원가입 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// session 유효성 검사
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null) {
			response.sendRedirect(request.getContextPath()+"/member/memberHome");
			return;
		}
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		Member paramMember = new Member();
		paramMember.setMemberId(memberId);
		paramMember.setMemberPw(memberPw);
		// 매개값 디버깅
		System.out.println(paramMember.toString());
		
		MemberDao memberDao = new MemberDao();
		int row = memberDao.insertMember(paramMember);
		
		response.sendRedirect(request.getContextPath()+"/member/loginMember");
	}

}
