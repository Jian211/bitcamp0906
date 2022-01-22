package com.bitcamp.myapp.member.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.myapp.member.domain.MemberRegRequest;
import com.bitcamp.myapp.member.service.MemberRegService;

@Controller
@RequestMapping("/member/reg")
public class MemberRegController {
	
	@Autowired
	private MemberRegService regService;
	
	@GetMapping
	public String getRegForm() {
		return "member/regform";
	}
	
	@PostMapping
	public String memberReg(MemberRegRequest regRequest, HttpServletRequest request ) throws Exception {
		return "redirect:/" + regService.insertMember(regRequest, request);
	}

}