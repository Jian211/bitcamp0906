package guestbook.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestBookDeleteServie;

public class GuestBookDeleteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
	
		/*
		 *  수정 만들기
		 *  댓글만들기 
		 *  클린코드 및 html & css좀 꾸미기 끗
		 *  
		 */
		
		int idx = Integer.parseInt(req.getParameter("idx"));
		
		try {
			GuestBookDeleteServie.getInstance().deleteGuestBook(idx);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		
		req.setAttribute("msg", "게시글이 삭제되었습니다.");
		
		return "/WEB-INF/views/guestbook/delete.jsp";
	}

}
