package com.bitcamp.mvc;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeaderCheckController {

	
	@RequestMapping(value = "/header/check")
	public void check(
			ModelMap map,
			Model model,
			Map<String, Object> hmap,	// 경우에 따라서 Map도 가능
			@RequestHeader("referer") String referer
			) {

		System.out.println("referer : "+referer);

		// > ModelMap
		map.put("url",referer);
	
		// > Model
		model.addAttribute("url1", referer);
		
		// > Map
		hmap.put("url3", referer);
		
		
	}
	
}
