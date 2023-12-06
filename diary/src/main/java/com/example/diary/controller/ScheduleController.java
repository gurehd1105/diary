package com.example.diary.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.diary.service.ScheduleService;
import com.example.diary.vo.Schedule;


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
	public String scheduleByDay(Schedule schedule, Model model) {
		
		Schedule scheduleOne = scheduleService.selectScheduleByDay(schedule);
		model.addAttribute("scheduleOne", scheduleOne);
		
		return "schedule/scheduleByDay";

	}
		
	
	
	
	
	
	
	/*
	@GetMapping("/scheduleListByWord")
	public String scheduleListByWord(Model model, 
									@RequestParam(name="word", defaultValue = "")String word) {
	
		List<Schedule> list = scheduleService.getScheduleListByWord(word);		
		model.addAttribute("list", list);
		
		return "schedule/scheduleListByWord";
		
	}
	*/
}

