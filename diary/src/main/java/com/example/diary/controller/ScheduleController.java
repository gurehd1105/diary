package com.example.diary.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.diary.service.ScheduleService;
import com.example.diary.vo.Member;
import com.example.diary.vo.Schedule;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ScheduleController {
	@Autowired	private ScheduleService scheduleService;
	
	@GetMapping("/scheduleListByDate")
	public String scheduleListByDate(Model model,
									 @RequestParam(defaultValue = "") String year, 
									 @RequestParam(defaultValue = "") String month,
									 @RequestParam(defaultValue = "") String day) {
		
		Map<String, Object> resultMap = scheduleService.getScheduleListByDate(year, month, day);
	
		model.addAttribute("list", resultMap.get("list"));
		model.addAttribute("maxMinYear", resultMap.get("maxMinMap"));
		model.addAttribute("paramYear", year);
		model.addAttribute("paramMonth", month);
		model.addAttribute("paramDay", day);

		scheduleService.getScheduleListByDate(year, month, day);
		
		return "schedule/scheduleListByDate";
		
	}
	// 스케줄 상세보기	
	@GetMapping("/scheduleByDay")
	public String scheduleByDay(Schedule schedule, Model model, 
								 Integer targetYear, 
								 Integer targetMonth, 
								 Integer targetDay,	
								 HttpSession session) {
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null) {
			//로그인 실패
			return "redirect:/login";
		}
		
		System.out.println(targetDay + "<-- targetDay");

		Map<String, Object> paramMap = new HashMap<>();	
		
		paramMap.put("targetYear", targetYear);
		paramMap.put("targetMonth", targetMonth);
		paramMap.put("targetDay", targetDay);
		paramMap.put("memberId", loginMember.getMemberId());
		System.out.println(paramMap + "<-- paramMap");
		
		List<Schedule> list = scheduleService.getScheduleListByDay(paramMap);
		model.addAttribute("targetYear", targetYear);
		model.addAttribute("targetMonth", targetMonth);
		model.addAttribute("targetDay", targetDay);
		
		model.addAttribute("list", list);
		
		System.out.println(targetDay);
		System.out.println(list);
		
		return "schedule/scheduleByDay";

	}
		

	/*
	 *스케줄 검색
	@GetMapping("/scheduleListByWord")
	public String scheduleListByWord(Model model, 
									@RequestParam(name="word", defaultValue = "")String word) {
	
		List<Schedule> list = scheduleService.getScheduleListByWord(word);		
		model.addAttribute("list", list);
		
		return "schedule/scheduleListByWord";
		
	}
	*/
}

