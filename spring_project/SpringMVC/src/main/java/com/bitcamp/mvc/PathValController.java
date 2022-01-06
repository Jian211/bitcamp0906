package com.bitcamp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/name")
public class PathValController {

	
	@GetMapping("/{path}/{no}")
	public String getPage(
			@PathVariable("path") String pathName,
			@PathVariable("no") String no,
			Model model
			) {
		
		System.out.println(pathName);
		String [] members = new String[] {"손흥민","이강인","황희찬"};
		
		model.addAttribute("result", members[Integer.parseInt(no)]);
		
		return "path/view";
		
	}
	
}
