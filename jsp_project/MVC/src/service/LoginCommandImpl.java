package service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.LoginInfo;

public class LoginCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String uid = req.getParameter("uid");
		String upw = req.getParameter("uiw");
		
		boolean loginChk = false;
		
		// Dao => 회원 정보를 select => 회원 데이터 
		
		if(uid.equals(upw)) {
			// 로그인 성공
			loginChk = true;

			// 로그인 정보를 저장 : session
			LoginInfo info = new LoginInfo(uid,"손흥민","Son","son@email.com");
			HttpSession session = req.getSession();
			session.setAttribute("loginInfo", info);
			
			
		} else {
			// 로그인 실패 
		
		
		}
		
		// 속성의 결과를 저장
		// 결과 페이지에 보여지는 값
		req.setAttribute("loginChk", loginChk);
		
 		
		return "/WEB-INF/views/member/login.jsp";
	}

}
