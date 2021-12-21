package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.domain.LoginInfo;
import member.domain.Member;

public class MyPageService {

	private MyPageService() {}
	private static MyPageService service = new MyPageService();
	public static MyPageService getInstance() {
		return service;
	}
	
	public Member myPageInfo(HttpServletRequest req) {
		LoginInfo loginInfo = (LoginInfo)req.getSession().getAttribute("loginInfo");
		
		Connection conn = null;
		Member member = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			member = MemberDao.getInstance().selectById(conn,loginInfo.getUserId());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}
}
