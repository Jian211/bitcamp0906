package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import member.service.MemberRegService;

public class MemberRegCommandImpl2 implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		
		String view = "";
		
		if(req.getMethod().equals("POST")) {
			
			req.setAttribute("result", MemberRegService.getInstance().insertMember(req, res));
			
			view = "/WEB-INF/views/member/reg2.jsp";
		}
		
		return view;
	}

}
