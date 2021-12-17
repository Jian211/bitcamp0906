package dept.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.JoinDao;
import dept.domain.User;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class JoinCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		System.out.println(req.getMethod());
		String viewPage ="";
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		if(req.getMethod().equals("GET")){
			
			viewPage = "/WEB-INF/views/join/joinForm.jsp";
			
		}else if(req.getMethod().equals("POST")) {
			String uId = req.getParameter("uId");		
			String uPw = req.getParameter("uPw");		
			String uName = req.getParameter("uName");		
			SimpleDateFormat fm1 = new SimpleDateFormat("yyyyMMdd");
			
			int uDate = Integer.parseInt(fm1.format(new Date()));
			User user = new User(uId, uPw, uName, uDate);	
			
			Connection conn = null;
			
			int result = 0;
			try {
				conn = ConnectionProvider.getConnection();
				result = JoinDao.getInstance().setUser(conn, user);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn);
			}
			
			String msg = result > 0 ? 
					"회원가입에 성공하셨습니다." :
						"이미 등록된 회원이십니다." ;
			
			req.setAttribute("result", msg);
			viewPage = "/WEB-INF/views/join/join.jsp";
		}
		
		return viewPage;
	}

}
