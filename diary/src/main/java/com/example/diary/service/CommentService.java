package com.example.diary.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.diary.mapper.CommentMapper;
import com.example.diary.mapper.NoticeMapper;
import com.example.diary.vo.Comment;

@Service
@Transactional
public class CommentService {
	@Autowired
	  private CommentMapper commentMapper;
	
	// 코멘트 리스트
	 public List<Comment> SelectCommentList(Map<String, Object>commentMap) {
		 List<Comment> commentList = commentMapper.selectCommentList(commentMap);		 
		 return commentList;
			 
	 }
	 	// 코멘트 페이지수
		 public int commentCount() {
		      int row = commentMapper.commentCount();
		      return row;
		   }
	
	
	
}
