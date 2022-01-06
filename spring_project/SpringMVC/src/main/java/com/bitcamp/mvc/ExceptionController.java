package com.bitcamp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

	private HelloService service;
	
	@RequestMapping("/error/null")
	public String getPage() {
		
		service.getGreeting();
		
		return "index";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPorinterException(NullPointerException e) {
		
		return "error/null.jsp";
	}
	
	
}
