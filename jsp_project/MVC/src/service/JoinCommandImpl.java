package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Join;
import javafx.scene.DepthTest;

public class JoinCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		String viewPage = "";
		
		
		String uId = req.getParameter("uId");		
		String uPw = req.getParameter("uPw");		
		String uName = req.getParameter("uName");		
		String uDate  = req.getParameter("uDate");		
		
		Join join = new Join(uId, uPw, uName, Integer.parseInt(uDate));
		
		int result = DeptDao
		
		return viewPage;
	}

}
