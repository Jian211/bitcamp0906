package com.bitcamp.myapp.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberIdCheckController {

	@RequestMapping("/member/checkid")
	@ResponseBody
	public String checkId(	@RequestParam("userid") String userid ) {
		
		
		
		return "Y";
	}
	
}
