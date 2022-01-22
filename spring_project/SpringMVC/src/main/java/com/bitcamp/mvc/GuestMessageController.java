package com.bitcamp.mvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.mvc.domain.GuestMessage;
import com.bitcamp.mvc.domain.OrderItem;

//@Controller
@RestController
public class GuestMessageController {

	
	@RequestMapping("/guest/list.json")
	//@ResponseBody  => RestController를 추가하면 생략가능
	public List<GuestMessage> getMessageList(){
		
		List<GuestMessage> list = new ArrayList<GuestMessage>();
		list.add(new GuestMessage(1,"테스트 메시지",new Date()));
		list.add(new GuestMessage(2,"인사합니다",new Date()));
		list.add(new GuestMessage(3,"다음에 만나요",new Date()));
		
		return list;
	}
	
	@RequestMapping("/simple")
	public String getString() {
		return "/mc/form";
	}

	
	@RequestMapping("/orderitem")
	public OrderItem getOrderItem() {
		return new OrderItem("product-10", 10000, "파손주의");
	}

	@RequestMapping("/orderitems")
	public List<OrderItem> getOrderItems() {
		List<OrderItem> list = new ArrayList<OrderItem>();
		list.add(new OrderItem("product-10", 10000, "파손주의"));
		list.add(new OrderItem("product-11", 20000, "파손주의"));
		list.add(new OrderItem("product-12", 30000, "파손주의"));
		
		return list;
	}
	
	@RequestMapping("/orderitems2")
	public Map<String,OrderItem> getOrderItems2() {
		Map<String,OrderItem> list = new HashMap<String, OrderItem>();
		
		list.put("product-10", new OrderItem("product-10", 10000, "파손주의"));
		list.put("product-20", new OrderItem("product-20", 10, "파손주의"));
		
		return list;
	}
	
	@PostMapping("/orderitem")
	@ResponseBody
	public OrderItem  getOrderItem( @RequestBody OrderItem item ) {
		
		System.out.println(item);
		
		return item;
	}
	
	
	
	
}
