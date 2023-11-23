package controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import vo.*;


/**
 * Servlet implementation class ScheduleByDayController
 */
@WebServlet("/schedule/scheduleByDay")
public class ScheduleByDayController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	/*
		// session 유효성 검사
			HttpSession session = request.getSession();
			if(session.getAttribute("loginMember") == null) {
				// 로그인이 되어 있지 않은 상태
				// 리다이렉트할 컨트롤러 url
				response.sendRedirect(request.getContextPath()+"/member/loginMember"); 
				return;
			}
	*/		
		int targetY = Integer.parseInt(request.getParameter("targetY"));
		int targetM = Integer.parseInt(request.getParameter("targetM"));
		int targetD = Integer.parseInt(request.getParameter("targetD"));
		
		
		ScheduleDao scheduleDao = new ScheduleDao();
		
		Schedule schedule = new Schedule();
		List<Schedule>list = scheduleDao.selectScheduleByDay("goodee", targetY, targetM+1, targetD)	;	
		request.setAttribute("list", list);

		
			request.getRequestDispatcher("/WEB-INF/view/schedule/scheduleByDay.jsp").forward(request, response);					
	 }

	
}


