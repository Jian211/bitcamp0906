package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.ReplyDeleteService;

public class GuestBookReplyDeleteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {

		if(req.getMethod().equals("POST")) {
			req.setAttribute("result", ReplyDeleteService.getInstance().deleteReply(req));
		}
		
		
		// 새ㅔ롭게 만든 delete.jsp 파일의 역할이 write.jsp와 동일하다.
		return "/WEB-INF/views/guestbook/reply/delete.jsp";
	}

}
