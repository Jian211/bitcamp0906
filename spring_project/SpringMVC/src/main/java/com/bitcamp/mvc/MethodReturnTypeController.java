package com.bitcamp.mvc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MethodReturnTypeController {

//	@RequestMapping("/return/test1")
//	public Model test1(Model model) {
//		model.addAttribute("msg1","Model 객체 반환 ");
//		return model;	//   view의 경로는 "return/test1"이 된다.
//	}
	// 위 코드와 같은 결과 도출 void를 활용하면 코드가 한결 깔끔해 진다. 
	@RequestMapping("/return/test1")
	public void test1(Model model) {
		model.addAttribute("msg1","Model 객체 반환 ");
		//return model;	//   view의 경로는 "return/test1"이 된다.
	}

	
	@RequestMapping("/return/test2")
	public ModelMap test2(ModelMap map ) { //ModelMap map = new ModelMap(); 파라미터로 받으면 생략이 가능
		map.addAttribute("msg2", "ModelMap을 통한 데이터 공유");
	
		return map;	//   view의 경로는 "return/test2"이 된다.
	}

	@RequestMapping("/return/test3")
	public Map<String, Object> test3(Map<String, Object> map) {	//Map<String, Object> map = new HashMap<String, Object>(); 파라미터로 받으면 생략이 가능
		map.put("msg3", "Map 객체를 이용한 데이터 공유");
		
		return map;	//   view의 경로는 "return/test2"이 된다.
	}
	
	
	
}
