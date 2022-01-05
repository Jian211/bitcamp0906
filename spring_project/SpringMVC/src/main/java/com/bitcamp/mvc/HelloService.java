package com.bitcamp.mvc;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	public String getGreeting() {
		String str = "안녕하세요.";
		
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		if(hour >= 6 && hour <= 10) {
			str = "오하요~";
		} else if(hour >= 12 && hour <= 15) {
			str = "콘니치와~";
		} else if(hour >= 18 && hour <= 22) {
			str = "콤방와~";
		}
		
		return str;
	}
	
}
