package com.example.diary.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.example.diary.vo.Comment;

@Mapper
public interface CommentMapper {
	
	//코멘트 목록 페이징
	 List<Comment> selectCommentList(Map<String, Object> paramMap);
	//페이징 위한 전체 수량
	  int commentCount(); 
	  
	  
	
}
