package com.example.diary.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.diary.mapper.ScheduleMapper;
import com.example.diary.vo.Notice;
import com.example.diary.vo.Schedule;


@Service
@Transactional
public class ScheduleService {
   @Autowired private ScheduleMapper scheduleMapper;
   
   
   
   public Map<String, Object> getScheduleListByDate(String year, String month, String day) {
		
	   // 월범위
		Integer minYear = scheduleMapper.selectScheduleDateMinYear();
		Integer maxYear = scheduleMapper.selectScheduleDateMaxYear();
		
		Map<String, Integer> maxMinMap = new HashMap<>();
		maxMinMap.put("minYear", minYear);
		maxMinMap.put("maxYear", maxYear);
		
		// 스케줄 리스트
		Map<String, Integer> paramMap = new HashMap<>();
		if(year.equals("")) {
			paramMap.put("year", null);
		} else {
			paramMap.put("year", Integer.parseInt(year));
		}
		
		// if..else
		if(month.equals("")) {
			paramMap.put("month", null);
		} else {
			paramMap.put("month", Integer.parseInt(month));
		}
		
		// if..else
		if(day.equals("")) {
			paramMap.put("day", null);
		} else {
			paramMap.put("day", Integer.parseInt(day));
		}
		
		List<Schedule> list = scheduleMapper.selectScheduleListByDate(paramMap);
		
		// 반환 맵
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("maxMinMap", maxMinMap); // 년도 최소, 최대값
		resultMap.put("list", list); // 조건결과 리스트
		return resultMap;
	}


   	/*
   		// 스케줄 글자 검색
   		public List<Schedule> getScheduleListByWord(String word){
   			List<Schedule> list = null;
	
   			list = scheduleMapper.selectScheduleListByWord(word);
	  
   			return list;
   			
   		}
   */
   
   // 달력 출력
   public List<Map<String, Object>> getScheduleListByMonth(Map<String, Object> paramMap) {      
      List<Map<String,Object>> scheduleList = new ArrayList<>();
      
      scheduleList = scheduleMapper.selectScheduleListByMonth(paramMap);
      return scheduleList;
    }
      
   // 스케줄 상세보기
   public List<Schedule> getScheduleListByDay(Map<String, Object> paramMap) {
	   List<Schedule> resultSchedule = new ArrayList<>();
	   resultSchedule = scheduleMapper.selectScheduleListByDay(paramMap);
	   return resultSchedule;
	   
	   
	   
   }
     
  
}