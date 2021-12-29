package guestbook.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestBookDeleteServie;
import member.domain.LoginInfo;

public class GuestBookDeleteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		
		//게시물 idx
		int idx = Integer.parseInt(req.getParameter("idx"));
		
		// 현재 로그인 중인 사용자의 idx
		int memberIdx = ((LoginInfo)req.getSession().getAttribute("loginInfo")).getIdx();
		
		try {
			GuestBookDeleteServie.getInstance().deleteGuestBook(idx, memberIdx);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		
		req.setAttribute("msg", "게시글이 삭제되었습니다.");
		
		return "/WEB-INF/views/guestbook/delete.jsp";
	}

}
