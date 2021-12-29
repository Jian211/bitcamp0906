package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.domain.GuestBook;
import guestbook.service.GuestBookListViewService;
import guestbook.service.ReplyListService;

public class GuestBookListViewCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
	
		System.out.println(req.getMethod());
		
		GuestBook guestBook = GuestBookListViewService.getInstance().getGuestBookInfo(req,res);
		System.out.println(guestBook);
		req.setAttribute("guestBook", guestBook);
		
	
		// get list from service
//		System.out.println(req.getParameter("idx")+"idx");
//		req.setAttribute("replyList", ReplyListService.getInstance().getList(req));
		
		return "/WEB-INF/views/guestbook/guestbookListView.jsp";
	}

}
