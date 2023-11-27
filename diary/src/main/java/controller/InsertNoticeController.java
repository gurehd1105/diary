package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NoticeDao;
import vo.Notice;

/**
 * Servlet implementation class InsertNoticeController
 */
@WebServlet("/notice/insertNotice")
public class InsertNoticeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// session 유효성 검사
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null) {
			// 로그인이 되어 있는 상태
			// 리다이렉트 할 컨트롤러 url
			response.sendRedirect(request.getContextPath()+"/member/loginMember");
			return;
	
		// view forward
		
	}
		request.getRequestDispatcher("/WEB-INF/view/notice/insertNotice.jsp").forward(request, response);
	}		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// session 유효성 검사
			HttpSession session = request.getSession();
			if(session.getAttribute("loginMember") == null) {
				
				response.sendRedirect(request.getContextPath()+"/member/loginMember"); 
				return;
			}
		String memberId = request.getParameter("memberId");
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
		
		Notice notice = new Notice();	
		notice.setMemberId(memberId);
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		//디버깅
		System.out.println(notice.toString());
		
		NoticeDao noticeDao = new NoticeDao();
		int row = noticeDao.insertNotice(notice);
		

		if(row==1) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
	
		}
		
		response.sendRedirect(request.getContextPath()+"/member/memberHome");
	
	}

}
