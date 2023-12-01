package com.example.diary.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.diary.service.CalendarService;
import com.example.diary.service.ScheduleService;
import com.example.diary.vo.Member;
import com.example.diary.vo.Schedule;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired CalendarService calendarService;
	@Autowired ScheduleService scheduleService;
	
	@GetMapping("/home")
	public String home(HttpSession session, Model model,
						@RequestParam(required = false) Integer targetYear,
						@RequestParam(required = false) Integer targetMonth
						) {
		Member loginMember = (Member) session.getAttribute("loginMember");
		// 로그인 후에만
		
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/login";
		}
		
	
		Map<String, Object> calendarMap = calendarService.getCalendar(targetYear, targetMonth);
		model.addAttribute("calendarMap", calendarMap);
		
//		List<Schedule> list = scheduleService.getScheduleListByMonth(null, 0);
//		model.addAttribute("list", list);
		
		return "home";
	}
}

