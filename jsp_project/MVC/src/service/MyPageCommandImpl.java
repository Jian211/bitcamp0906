package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyPageCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		
		// 사용자 페이지 My Page는 로그인 상태에서만 데이터 처리를 해준다!!!
		// 세션 체크  : session 속성에 loginInfo가 존재 하는지 확인
		
		boolean loginChk = req.getSession().getAttribute("loginInfo") != 
				null ? true : false;
		
		if(loginChk) {
			// 결과 데이터를 생성
			String msg ="마이페이지에는 사용자 정보를 출력합니다.";
			
			// request 속성에 데이터 저장
			req.setAttribute("msg", msg);
		
		} 
		
		req.setAttribute("loginChk", loginChk); 
		
		return "/WEB-INF/views/member/mypage.jsp";
	}
}
