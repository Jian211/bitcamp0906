package com.bitcamp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JoinController {
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView view = new ModelAndView();
		
		view.addObject("msg", "오셔서 감사합니다.");
		view.setViewName("form/join");
		
		return view;
	}
	
}
