package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestBookListViewService;

public class GuestBookListViewCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
	
		// 선택한 List index 값 
		int guestBookIdx = Integer.parseInt(req.getParameter("guestBookIdx"));
		req.setAttribute("guestBook", GuestBookListViewService.getInstance().getGuestBook(guestBookIdx));
		
	
		// get list from service
//		System.out.println(req.getParameter("idx")+"idx");
//		req.setAttribute("replyList", ReplyListService.getInstance().getList(req));
		
		return "/WEB-INF/views/guestbook/guestbookListView.jsp";
	}

}
