package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;
import member.dao.MemberDao;

public class CheckIdService {

	private CheckIdService() {};
	private static CheckIdService service = new CheckIdService() {};
	public static CheckIdService getInstance() { return service; };
	
	
	// 해당 아이디로 select => count 갯수를 반환 
	public int getMemberCount(HttpServletRequest req) {
		int result = 0 ;
		
		String userId = req.getParameter("userid");
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
//			result = MemberDao.getInstance().selectById(conn, userId) == null ? 0 : 1;
			result = MemberDao.getInstance().selectByIdCount(conn,userId);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		return result;
	}
	
}
