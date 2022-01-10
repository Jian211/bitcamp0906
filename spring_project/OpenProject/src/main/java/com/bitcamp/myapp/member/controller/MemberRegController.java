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
		return "member/regForm";
	}
	
	@PostMapping
	public void memberReg(MemberRegRequest regRequest, Model model, HttpServletRequest request ) throws Exception {
		model.addAttribute("result", regService.insertMember(regRequest, request));
		
		
	}

}