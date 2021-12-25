package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;

public class GuestBookDeleteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		
		System.out.println("딜릿트");
		
		/*
		 *  삭제 service , dao 
		 *  수정 만들기
		 *  댓글만들기 
		 *  클린코드 및 html & css좀 꾸미기 끗
		 *  
		 */
		

		
		return "/WEB-INF/views/guestbook/delete.jsp";
	}

}
