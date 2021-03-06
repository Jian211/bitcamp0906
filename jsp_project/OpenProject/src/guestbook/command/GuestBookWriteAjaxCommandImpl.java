package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestBookWriteService;

public class GuestBookWriteAjaxCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {

		if(req.getMethod().equals("POST")) {
			req.setAttribute("result", GuestBookWriteService.getInstance().insertGuestBook(req, res));
		}
		
		return "/WEB-INF/views/guestbook/result.jsp";
	}

}
