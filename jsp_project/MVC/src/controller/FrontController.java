package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{

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
	
	// 이것은  URI처리
	private void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 요청 > 분석 > 처리 > 저장 > 포워딩
		
		String commandURI = req.getRequestURI();
		
		commandURI = commandURI.startsWith(req.getContextPath()) ? 
				commandURI.substring(req.getContextPath().length()) : "";
		
			
		String viewPage = "";
		Object result   = "";
		
		if(commandURI.equals("/login.do")) {
			viewPage = "/WEB-INF/views/login.jsp";
			result = "이것은 URI를 통한 처리";
		} else {
			viewPage = "/index.jsp";
			result = "없는 페이지 입니다.";
		}

		
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, res);
		
	}
	
//	private void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		
//		// 2. 사용자의 요청을 분석 : URI를 이용한 사용자 요청 분석
//		String commandURI = req.getRequestURI();
//		
//		
//		if(commandURI.startsWith(req.getContextPath())) {  // req.getContextPath() => /mvc
//			commandURI = commandURI.substring(req.getContextPath().length()); 
//		}
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
//		if(commandURI == null || commandURI.equals("/greeting.do")) {
//			result = "안녕하세요.";	// object <- String   : 다형성
//			viewPage = "WEB-INF/views/greeting.jsp";
//		
//		} else if(commandURI.equals("/date.do")) {
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
