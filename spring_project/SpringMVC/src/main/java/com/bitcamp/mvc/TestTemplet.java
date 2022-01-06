package com.bitcamp.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/test")
public class TestTemplet {

	//@RequestMapping("/test")
	//@RequestMapping( value = "/test")
	//@RequestMapping( value = {"/test"})
	//@RequestMapping( value = {"/test","/abs"})
	
	@GetMapping
	public String getPage1(
			//@RequestAttribute("a") String a
			) {
		//System.out.println(a);
		return "test";
	}
	
	@PostMapping
	public ModelAndView view( ModelAndView msv ) {
		msv.addObject("msg", "저장방법1");
		return msv;
	}
	
	
//	public String testPost(	
//			
//			@RequestParam("name") String name,
//			int age,
//			HttpServletRequest req,
//			@ModelAttribute("userInfo") Test test
//			
//			) {
//		
//		System.out.println(name);
//		System.out.println(age);
//		System.out.println(req.getParameter("gender"));
//		System.out.println(test);
//
//		return "test2";
//	}
	
	
}
