package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		
		// 요청일 때 처리 
		// 로그인 체크 하고, 
		// -> 비 로그인 상태이면 로그인 폼 페이지로 이동
		// -> 로그인 상태이면 정상적으로 요청을 처리
		
		// 로그인 상태 체크
		// : HttpSession 객체의 속성에 loginInfo 이름의 속성이 존재하는지 체크 
		
		// 1. 세션에 있는 유저 정보 확인
		//	 1-1. 세션 받아오기
		HttpSession session = ((HttpServletRequest)req).getSession(); // 이거 싱기하네 
		
		// 2. 받아온 세션 값 확인	
		if(session != null && session.getAttribute("loginInfo") != null) {
			// 2-1. 로그인 상태! -> 정상처리 
			chain.doFilter(req, res);
		} else {
			// 2-2. 비 로그인 상태 
			String uri = ((HttpServletRequest)req).getContextPath() + "/member/login.do";
			((HttpServletResponse)res).sendRedirect(uri);
		}
		
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
