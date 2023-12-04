package com.example.diary.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.diary.vo.Schedule;
@Mapper
public interface ScheduleMapper {
	
   // 달력 출력
   List<Map<String,Object>> selectScheduleListByMonth(Map<String, Object> paramMap);
   
   
   
   // 스케줄 상세보기출력
   Schedule selectScheduleListByDay(Schedule schedule);
   
   
}