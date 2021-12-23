package member.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import member.domain.Member;
import member.service.LoginService;

public class LoginCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		String view = null;
		
		if(req.getMethod().equals("GET")) {
			
			view = "/WEB-INF/views/member/loginform.jsp";
			
		} else if(req.getMethod().equals("POST")) {

			
			boolean loginChk = false;
			String msg = "아이디 또는 비밀번호를 확인해주세요.";
			
			try {
				Member member = LoginService.getInstance().login(req, res);

				if(member != null) {
					// 로그인 처리 : 
					req.getSession().setAttribute("loginInfo", member.getLoginInfo());
					msg = "로그인 되었습니다.";
					loginChk = true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				msg = "처리도중에  예외가 발생! 다시 시도해주세요.";
			}
			
			req.setAttribute("loginChk", loginChk);
			req.setAttribute("msg", msg);
			
			
			view = "/WEB-INF/views/member/login.jsp";
		}
		
		
		return view;
	}

}
