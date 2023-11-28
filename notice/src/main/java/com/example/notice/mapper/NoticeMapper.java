package com.example.notice.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.notice.vo.Notice;

@Mapper
public interface NoticeMapper {
	//목록(페이징)
		List<Notice> selectNoticeList(Map<String, Object>paramMap);
		
		//상세보기
		Notice selectNoticeOne(Notice notice);
		
		//입력
		int insertNotice(Notice notice);
	
	
	
}
