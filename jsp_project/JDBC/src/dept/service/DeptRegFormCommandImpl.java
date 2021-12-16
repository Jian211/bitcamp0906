package dept.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeptRegFormCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		// 부서 정보를 입력하는 폼 화면
		
		String viewPage = "/WEB-INF/views/dept/regform.jsp";
		return viewPage;
	}

}
