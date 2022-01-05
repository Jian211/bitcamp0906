package com.bitcamp.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.mvc.domain.RegRequest;

@Controller
@RequestMapping("/member/reg")
public class MemberRegController {

	@GetMapping // == @RequestMapping(method = RequestMethod.GET)
	public String getRegForm() {

		return "member/regForm";
	}
		
	@PostMapping // == @RequestMapping(method = RequestMethod.POST)
	public String memberReg(
			HttpServletRequest req,
			@RequestParam("userId") String userId,
			@RequestParam("userPw") String userPw,
			@RequestParam("userName") String userName,
			@ModelAttribute("reg") RegRequest regRequest
			) {
		
		System.out.println("request : " + req.getParameter("userId"));
		System.out.println("request : " + req.getParameter("userPw"));
		System.out.println("request : " + req.getParameter("userName"));
		
		System.out.println("@RequestParam : " + userId);
		System.out.println("@RequestParam : " + userPw);
		System.out.println("@RequestParam : " + userName);
		
		System.out.println(" RegRequest : " + regRequest);

		return "member/reg";
	}
}
