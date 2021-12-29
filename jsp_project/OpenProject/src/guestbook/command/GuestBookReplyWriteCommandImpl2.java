package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestBookReplyWriteService;

public class GuestBookReplyWriteCommandImpl2 implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {

		if(req.getMethod().equals("POST")) {
			
			req.setAttribute("replyList", GuestBookReplyWriteService.getInstance().writeReply2(req, res));
		}
		
		return "/WEB-INF/views/guestbook/reply/write.jsp";
	}

}
