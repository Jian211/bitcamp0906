package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import member.service.MemberRegService;

public class MemberRegCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		
		String view = "";
		
		if(req.getMethod().equals("GET")) {
			
			view = "/WEB-INF/views/member/regForm.jsp";
		} else if(req.getMethod().equals("POST")) {
			
			req.setAttribute("result", MemberRegService.getInstance().insertMember(req, res));
			
			view = "/WEB-INF/views/member/reg.jsp";
		}
		
		return view;
	}

}
