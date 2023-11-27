package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDao;
import vo.Notice;

/**
 * Servlet implementation class NoticeOneController
 */
@WebServlet("/notice/noticeOne")
public class NoticeOneController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		System.out.println(noticeNo + "<-- noticeNo");
		
		NoticeDao noticeDao = new NoticeDao();
		Notice notice = noticeDao.noticeOne(noticeNo);
		
		
		request.setAttribute("notice", notice);
		

		request.getRequestDispatcher("/WEB-INF/view/notice/noticeOne.jsp").forward(request, response);
	}


	
}
