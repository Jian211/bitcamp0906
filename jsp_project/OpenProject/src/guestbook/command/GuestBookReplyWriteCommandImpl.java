package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestBookReplyWriteService;

public class GuestBookReplyWriteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {

		if(req.getMethod().equals("POST")) {
			
			req.setAttribute("result", GuestBookReplyWriteService.getInstance().writeReply(req, res));
		}
		
		return "/WEB-INF/views/guestbook/reply/write.jsp";
	}

}
