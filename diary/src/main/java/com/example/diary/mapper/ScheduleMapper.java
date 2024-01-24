package com.example.diary.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.diary.vo.Schedule;
@Mapper
public interface ScheduleMapper {
	
	//날짜 검색
	 
	List<Schedule> selectScheduleListByDate(Map<String, Integer> map);
	
	Integer selectScheduleDateMaxYear();
	Integer selectScheduleDateMinYear();

	
	//스케줄 글자 검색
	List<Schedule> selectScheduleListByWord(String word);	
	int scheduleListByWordCount(); 
		
    // 달력 출력
    List<Map<String,Object>> selectScheduleListByMonth(Map<String, Object> paramMap);
   
    // 스케줄 상세보기 리스트  
    List<Schedule> selectScheduleListByDay(Map<String, Object> paramMap);
   

    
   
   
}