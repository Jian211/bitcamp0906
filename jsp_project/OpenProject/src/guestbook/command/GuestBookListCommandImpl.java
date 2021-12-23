package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.domain.GuestBookListView;
import guestbook.service.GuestBookListSerivce;

public class GuestBookListCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		
		String pageNumber = req.getParameter("pNum");
		int pageNum = 1;
		
		if(pageNumber != null && pageNumber.length() > 0) {
			try {
				pageNum = Integer.parseInt(pageNumber);
				
			} catch (NumberFormatException e){
				e.printStackTrace();
			}
		}
		
		GuestBookListView listView = GuestBookListSerivce.getInstance().getList(pageNum);
		
//		if(listView.getList() == null) {
//			listView = null;
//		}
		
		req.setAttribute("listView", listView);
		
		return "/WEB-INF/views/guestbook/guestbookList.jsp";
	}

}
