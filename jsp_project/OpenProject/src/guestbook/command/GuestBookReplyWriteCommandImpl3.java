package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestBookReplyWriteService;

public class GuestBookReplyWriteCommandImpl3 implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {

		if(req.getMethod().equals("POST")) {
			
			req.setAttribute("replyList", GuestBookReplyWriteService.getInstance().writeReply3(req, res));
		}
		
		return "/WEB-INF/views/guestbook/reply/write3.jsp";
	}

}
