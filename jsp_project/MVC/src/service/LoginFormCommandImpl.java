package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		
		// 결과데이터가 없음
		// request 속성에 저장 X
		
		return "/WEB-INF/views/member/loginForm.jsp";
	}

}
