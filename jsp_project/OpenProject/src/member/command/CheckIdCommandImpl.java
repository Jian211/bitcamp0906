package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import member.service.CheckIdService;

public class CheckIdCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		
		// Y || N
		req.setAttribute("result", 
				CheckIdService.getInstance().getMemberCount(req) == 1 ? "N" : "Y");
		
		return "/WEB-INF/views/member/checkid.jsp";
	}

}
