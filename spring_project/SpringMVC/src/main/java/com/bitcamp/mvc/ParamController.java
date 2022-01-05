package com.bitcamp.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.mvc.domain.LoginRequest;

@Controller
public class ParamController {

	@RequestMapping("/param")
	public String getForm( Model model ) {
		model.addAttribute("title","회원 로그인 폼");
		return "form/loginForm";
	}
	
	
	// 사용자 요청 받기 1 : HttpServletRequest 이용
	@RequestMapping(value = "/getParam1", method = RequestMethod.POST)
	public String getParam1(HttpServletRequest req, Model model) {
		// 데이터 받는 방식을 request를 사용했다.
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		model.addAttribute("userId", userId);
		model.addAttribute("userPw", userPw);
		
		return "form/loginInfo";
	}
	

	// 사용자 요청 받기 2 : @RequestParam 이용
	@RequestMapping(value = "/getParam2",method = RequestMethod.POST)
	public String getParam2(
			@RequestParam(name = "userId", defaultValue = "test") String userId,
			@RequestParam(name = "userPw", required = true) String userPw,
			@RequestParam(name = "page", defaultValue = "1") int pageNumber,
			Model model
			) {
		
		model.addAttribute("userId", userId);
		model.addAttribute("userPw", userPw);
		
		return  "form/loginInfo";
	}
 	
	@RequestMapping(value = "/getParam3" , method = RequestMethod.POST)
	public String getParam3(
			@ModelAttribute("loginParam") LoginRequest request			
			) {
		System.out.println(request);
		
		return "form/loginInfo";
		
	}
	
	
	
	
}
