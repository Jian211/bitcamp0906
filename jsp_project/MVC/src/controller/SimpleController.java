package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 1. 사용자 요청 받기  사용자의 요청은 get or post
		doProcess(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 1. 사용자 요청 받기 get or post
		doProcess(req, res);
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 파라미터 값에 따라서 서버 전송
		String type = req.getParameter("type");
		
		Object result = null;
		String viewPage = "/WEB-INF/views/simpleView.jsp";
		
		if(type == null) {
			result = "아무 값이 없습니다.";
			viewPage = "/index.jsp";
		} else if(type.equals("sam")) {
			result = "삼겹살!";
			viewPage = "/WEB-INF/views/login.jsp";
		}
		
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, res);
	}
	
//	private void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		// 2. 사용자의 요청을 분석 : 파라미터 값을 이용해서 분석 
//		String type = req.getParameter("type");
//		
//		
//		// 3. 사용자 요청에 맞는 데이터 처리 : 요청에 따른 분기 
//		//	결과 데이터를 생성 
//		
//		// 응답 결과 객체
//		Object result = null;		// View 페이지에서 toString()으로 출력
//		
//		// View page 경로
//		String viewPage = "/WEB-INF/views/simpleView.jsp";
//		
//		if(type == null || type.equals("greeting")) {
//			result = "안녕하세요.";	// object <- String   : 다형성
//			viewPage = "WEB-INF/views/greeting.jsp";
//		
//		} else if(type.equals("date")) {
//			result = new Date();	// object <- Date	  : 다형성
//			viewPage = "WEB-INF/views/date.jsp";
//			
//		} else {
//			result = "Invalid Request";	// Invalid : 잘못된
//		}
//		
//		// 4.	결과를 request 객체 속성에 저장 := View 페이지에 결과 데이터를 공유(전달)
//		req.setAttribute("result", result);
//		
//		// 5.	View page를 지정(선택) > 포워딩 
//		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage); // jsp경로입력
//		dispatcher.forward(req, res);
//		
//		
//	}
	
}
