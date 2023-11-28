package com.example.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.notice.mapper.NoticeMapper;
import com.example.notice.vo.Notice;

@Controller
public class NoticeController {
	
	@Autowired private NoticeMapper noticeMapper;
	
	@GetMapping(value="/noticeList")
	public String noticeList(Model model, 
					@RequestParam(defaultValue = "1") int currentPage) {// currentPage 가 get으로 넘어오거나 안오면 1
		
		//mapper
		int rowPerPage = 5;		
		int beginRow = (currentPage - 1) * rowPerPage ;
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		
		List<Notice>list = this.noticeMapper.selectNoticeList(paramMap);
		
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);

		
		return "noticeList";
	}
	
	@GetMapping(value = "/noticeOne")
	public String noticeOne(Notice notice, Model model) {
		
		Notice noticeOne = this.noticeMapper.selectNoticeOne(notice);
		model.addAttribute("model", model);
		
		
		return "noticeOne";
	}
	
	
	
	
	
	
	@GetMapping(value = "/addNotice")
	public String addNotice() {
		
		return "addNotice";			    // forward
	}
	
	@PostMapping(value="/addNotice")
	public String addNotice(Notice notice) {
		// mapper 호출
		int row = this.noticeMapper.insertNotice(notice);
		
		return "redirect:/noticeList"; //response senRedirect 
	}
}
