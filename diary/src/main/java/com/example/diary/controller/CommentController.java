package com.example.diary.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.diary.service.CommentService;
import com.example.diary.vo.Comment;



@Controller
public class CommentController {
		
	@Autowired
	private CommentService commentService;
	
	// 코멘트 리스트
	
	@GetMapping(value ="/commentList")
	public String commentList(Model model, 
				@RequestParam(defaultValue = "1") int currentPage) {
		
	
	int rowPerPage = 5;
	int beginRow = (currentPage - 1) * rowPerPage ;
	
	Map<String, Object> commentMap = new HashMap<>();
	commentMap.put("beginRow", beginRow);
	commentMap.put("rowPerPage", rowPerPage);
	
	int totalRow = commentService.commentCount();
    int lastPage = (totalRow / rowPerPage);
    if((totalRow % rowPerPage) != 0) {
       lastPage= lastPage +1;
    }
    
    List<Comment>list = commentService.SelectCommentList(commentMap);
	
    model.addAttribute("list", list);
    
    return "commentList";
	
		
}
}