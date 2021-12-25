package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.domain.GuestBookListView;
import guestbook.service.GuestBookListSerivce;

public class GuestBookListCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		
		
		// 유저가 클릭한 페이지 확인 
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

		req.setAttribute("listView", listView);
		
		return "/WEB-INF/views/guestbook/guestbookList.jsp";
	}

}
