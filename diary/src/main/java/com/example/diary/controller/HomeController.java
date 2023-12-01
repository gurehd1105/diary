package com.example.diary.controller;

import org.springframework.stereotype.Controller;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	public String home(HttpSession session) {
		// 로그인 후에만 
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/home";
		}		
		return "home";
	}
}
