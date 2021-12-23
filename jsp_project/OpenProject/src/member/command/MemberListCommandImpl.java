package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import member.service.MemberListService;

public class MemberListCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {

		String pageNumber = req.getParameter("p");
		int pageNum = 1;
		
		if(pageNumber != null && pageNumber.length() > 0) {
			try {
				pageNum = Integer.parseInt(pageNumber);
				
			} catch (NumberFormatException e){
				e.printStackTrace();
			}
		}
		
		req.setAttribute("listView", MemberListService.getInstance().getPage(pageNum));
		
		return "/WEB-INF/views/member/manager/list.jsp";
	}

}
