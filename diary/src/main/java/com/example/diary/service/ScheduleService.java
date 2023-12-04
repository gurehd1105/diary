package com.example.diary.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.diary.mapper.ScheduleMapper;
import com.example.diary.vo.Schedule;


@Service
@Transactional
public class ScheduleService {
   @Autowired private ScheduleMapper scheduleMapper;
   
   // 달력 출력
   public List<Map<String, Object>> getScheduleListByMonth(Map<String, Object> paramMap) {      
      List<Map<String,Object>> scheduleList = new ArrayList<>();
      
      scheduleList = scheduleMapper.selectScheduleListByMonth(paramMap);
      return scheduleList;
   
      
   // 스케줄 상세보기
      public  Schedule selectScheduleListByDay(Schedule paramSchedule) {
   	   		return null;
      }
      
      
     
      
      
      
   }
}