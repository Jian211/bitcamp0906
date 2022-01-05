package com.bitcamp.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.mvc.domain.SearchType;

@Controller
public class SearchController {

	
	@RequestMapping("/search/search1")
	public void getForm1() {
		
	}
	
	@RequestMapping("/search/search2")
	public void getForm2() {
		
	}
	
	@RequestMapping("/search/search3")
	public void getForm3() {
		
	}
	
	// 검색 타입
	@ModelAttribute("searchType")	// : 메소드가 반환하는 객체를 view에 전달, 전달범위 체크할 것
	public List<SearchType> getSearchType(){
		
		List<SearchType> list = new ArrayList<>(); 
		list.add(new SearchType(1,"아이디"));
		list.add(new SearchType(2,"이름"));
		list.add(new SearchType(3,"이름+아이디"));
		
		return list;
	}
	
	// 인기검색어
	@ModelAttribute("keywords")
	public String[] getKeyword() {
		return new String[] {"cool","hot","son"};
	}
	
}
