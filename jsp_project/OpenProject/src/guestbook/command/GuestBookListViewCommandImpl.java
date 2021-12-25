package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.domain.GuestBook;

public class GuestBookListViewCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		String viewPage = "";
		
		if(req.getMethod().equals("GET")) {
			req.setAttribute("guestBook", new GuestBook(req.getParameter("listView")));
			
			// 댓글 정보도 받아와야한다.
			
			
			viewPage = "/WEB-INF/views/guestbook/guestbookListView.jsp";
		} else if(req.getMethod().equals("POST")){
			
			
		}
		
		
		
		return viewPage;
	}

}
