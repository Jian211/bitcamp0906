package guestbook.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.domain.GuestBook;
import guestbook.service.GuestBookEditService;

public class GuestBookEditCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		String viewPage = "";
		
		
		if(req.getMethod().equals("GET")) {
			req.setAttribute("guestBook", new GuestBook(req.getParameter("guestBook")));
			viewPage = "/WEB-INF/views/guestbook/editForm.jsp";
			
		} else if(req.getMethod().equals("POST")) {
			
			// 배열로 받아오기. 
			String [] editedGuestBook = req.getParameterValues("editedGuestBook");
			
			try {
				// 생성자 클래스에 배열을 분해하여  객체에 값을 저장하는 기능이 있음.
				// 수정된 생성자를 전달
				GuestBookEditService.getInstance().editGuestBook(new GuestBook(editedGuestBook));
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.setAttribute("msg", "1");
			viewPage = "/WEB-INF/views/guestbook/edit.jsp";
		}
		
		
		return viewPage;
		
	}

}
