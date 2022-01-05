package com.bitcamp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/form")
public class FormController {
	
	//@RequestMapping(value = "/form", method = RequestMethod.GET) 클래스위에 리퀘스트 맵핑 적어놨을시 생략가능
	@RequestMapping(method = RequestMethod.GET)
	public String getForm() {
		return "form/form";  // /WEB-INF/views/form/form.jsp
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView getParam(
			@RequestParam("userId") String userId,
			@RequestParam("userPw") String userPw
			) {
		//getParam("test123","123"); 이것과 같다 위에 어너테이션이
			

		ModelAndView view = new ModelAndView();
		view.setViewName("form/data");	//  "/WEB-INF/views/form/data.jsp"
		view.addObject("userId", userId);
		view.addObject("userPw", userPw);
		
		return view;
	}
	
	
}
