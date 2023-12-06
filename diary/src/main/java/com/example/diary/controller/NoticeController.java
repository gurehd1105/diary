package com.example.diary.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.diary.mapper.NoticeMapper;
import com.example.diary.service.CommentService;
import com.example.diary.service.NoticeService;
import com.example.diary.vo.Member;
import com.example.diary.vo.Notice;

import jakarta.servlet.http.HttpSession;

@Controller
public class NoticeController {
	
	@Autowired 
	private NoticeService noticeService;
	private CommentService commentService;
	
	
	//공지 삭제
    @GetMapping(value="/removeNotice")
	public String removeNotice(Model model , Notice notice) {
	   model.addAttribute(notice);
	   System.out.println(notice);
	   return "notice/removeNotice";
	      
	   }
	@PostMapping(value="/removeNotice")
	public String deleteNotice(Notice notice) {
		
		noticeService.deleteNotice(notice);	
		return "redirect:/noticeList";
	}
	

	
	//공지 수정
	@GetMapping(value="/modifyNotice")
	public String updateNotice(HttpSession session , Model model , Notice notice) {
		 Member loginMember = (Member)session.getAttribute("loginMember");   
	     Notice paramNotice = noticeService.selectNoticeOne(notice);
	     model.addAttribute("paramNotice" , paramNotice);
	     System.out.println(paramNotice + "<- paramNotice!");
	    
		return "notice/modifyNotice";	
	}
	

	@PostMapping(value="/modifyNotice")
	public String updateNotice(HttpSession session, Notice notice ) {
		Member loginMember = (Member)session.getAttribute("loginMember");   
	    System.out.println(notice);
	    notice.setMemberId(loginMember.getMemberId());
	    noticeService.updateNotice(notice);
		return "redirect:/noticeList";
		
	}
	
	// 공지사항 리스트
	@GetMapping(value = "/noticeList")
	public String noticeList(Model model, 
					@RequestParam(defaultValue = "1") int currentPage) {// currentPage 가 get으로 넘어오거나 안오면 1
		
		//mapper
		int rowPerPage = 5;		
		int beginRow = (currentPage - 1) * rowPerPage ;
		
		Map<String, Object> noticeMap = new HashMap<>();
		noticeMap.put("beginRow", beginRow);
		noticeMap.put("rowPerPage", rowPerPage);
		
		int totalRow = noticeService.noticeCount();
	    int lastPage = (totalRow / rowPerPage);
	    if((totalRow % rowPerPage) != 0) {
	       lastPage= lastPage +1;
	    }

		
		List<Notice>list = noticeService.selectNoticeList(noticeMap);
		
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);

		
		return "notice/noticeList";
	}
	
	
	
	
	
	@GetMapping(value = "/noticeOne")
	public String noticeOne(Notice notice, Model model) {
		
		Notice noticeOne = noticeService.selectNoticeOne(notice);
		model.addAttribute("noticeOne", noticeOne);
		

		
		return "notice/noticeOne";
	}
	


	@GetMapping(value = "/addNotice")
	public String addNotice() {
		
		return "notice/addNotice";	// forward		
	}
	
	
	
	
	
	
	@PostMapping(value="/addNotice")
	public String addNotice(Notice notice) {
		// mapper 호출
		int row = noticeService.insertNotice(notice);
		
		return "redirect:/noticeList"; //response senRedirect 
	}

}
