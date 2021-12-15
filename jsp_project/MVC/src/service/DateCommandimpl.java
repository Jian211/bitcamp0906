package service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateCommandimpl implements Command{

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("데잇ㅆㅆ!!!");

		// 사용자 요청 처리
		// JDBC, 데이터 분석, 다른 서버의 API처리 
		Date now = new Date();
		
		// 결과 데이터를 request 속성에 저장
		req.setAttribute("result", now);
		
		// view page 경로를 반환
		String viewPage = "/WEB-INF/views/date.jsp";
		
		return viewPage;	
	}

}
