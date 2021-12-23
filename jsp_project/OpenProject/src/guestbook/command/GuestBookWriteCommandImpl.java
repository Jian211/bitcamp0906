package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestBookWriteService;

public class GuestBookWriteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {

		String viewPage = "";
		
		
		if(req.getMethod().equals("GET")) {
			viewPage = "/WEB-INF/views/guestbook/guestbookform.jsp";
			
		} else if(req.getMethod().equals("POST")) {
			String msg = "";
			
			int result = GuestBookWriteService.getInstance().insertGuestBook(req,res);

			
			if(result > 0) {
				msg = "글이 등록 되었습니다.";
				viewPage = "/WEB-INF/views/guestbook/guestbook.jsp";
 			} else {
 				msg = "글 등록이 실패 되었습니다.";
 				viewPage = "/WEB-INF/views/guestbook/guestbookform.jsp";
 			}
			
			req.setAttribute("msg", msg);
		}
		
		
		return viewPage;
	}

}
