package com.bitcamp.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/login")
public class LoginController {
	
	
	@GetMapping
	public String getLoginForm(
			@RequestHeader(value="referer", required = false) String url,
			HttpServletRequest req,
			Model model
			) {
		model.addAttribute("url", url == null 
				? "http://localhost:8080"+ req.getContextPath()
				: url);
		return "member/loginForm";
	}
	
	
	@PostMapping
	public String login(
			String userId,
			String userPw,
			String url,
			String userName
			) {
		
		System.out.println("ID" + userId);
		System.out.println("PW" + userPw);
		System.out.println("url" + url);
		System.out.println("userName" + userName);
		
		//return "redirect:"+url; // URL을 받아서 상대경로 
		//return "redirect:/cookie/make";	// 서버 루트 기준 + 절대경로
		return "redirect:reg";	// 현재 경로 기준으로 상대 경로 설정
	}
	
	
}
