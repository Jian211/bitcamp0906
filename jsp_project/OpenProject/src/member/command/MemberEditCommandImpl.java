package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import member.service.MemberEditService;

public class MemberEditCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		String view = null;
		
		if(req.getMethod().equals("GET")) {
			
			String idx = req.getParameter("idx");
			
			req.setAttribute("member", MemberEditService.getInstance().getMember(Integer.parseInt(idx)));
			
			view = "/WEB-INF/views/member/manager/editform.jsp";
		
		} else if(req.getMethod().equals("POST")) {
			
			
		}
		
		return view;
	}

}
