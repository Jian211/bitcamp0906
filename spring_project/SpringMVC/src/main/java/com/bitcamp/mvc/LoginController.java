package com.bitcamp.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member/login")
public class LoginController {
	
	
	@GetMapping
	public String getLoginForm(
//			@RequestHeader(value="referer", required = false) String url,
			@RequestParam(value="url", required = false) String url1,
			HttpServletRequest req,
			Model model
			) {
		model.addAttribute("url", url1 == null 
				? "http://localhost:8080"+ req.getContextPath()
				: url1);
		return "member/loginForm";
	}
	
	
	@PostMapping
	public String login(
			String userId,
			String userPw,
			String rurl,
			String userName,
			HttpSession session
			) {
		
		session.setAttribute("loginInfo", userId);
		
		System.out.println("ID" + userId);
		System.out.println("PW" + userPw);
		System.out.println("url" + rurl);
		System.out.println("userName" + userName);
		
		//return "redirect:"+url; // URL을 받아서 상대경로 
		//return "redirect:/cookie/make";	// 서버 루트 기준 + 절대경로
		return "redirect:"+rurl;	// 현재 경로 기준으로 상대 경로 설정
	}
	
	
}
