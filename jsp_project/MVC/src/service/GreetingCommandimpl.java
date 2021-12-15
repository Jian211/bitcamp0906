package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetingCommandimpl implements Command{
	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("그리팅!!!");
		// 사용자 요청 처리
		// JDBC, 데이터 분석, 다른 서버의 API처리 
		String str = "Halo";
		
		// 결과 데이터를 request 속성에 저장
		req.setAttribute("result", str);
		
		// view page 경로를 반환
		String viewPage = "/WEB-INF/views/greeting.jsp";
		
		return viewPage;	
	}

}
