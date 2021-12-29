package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import guestbook.dao.ReplyDao;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class ReplyDeleteService {
	private ReplyDeleteService () {};
	private static ReplyDeleteService service = new ReplyDeleteService();
	public static ReplyDeleteService getInstance () {return service; };


	public int deleteReply(HttpServletRequest req) {
		int result = 0;
		
		int idx = Integer.parseInt(req.getParameter("idx"));
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			result = ReplyDao.getInstance().deleteByIdx(conn,idx);
			
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			JdbcUtil.close(conn);
		}
		
		return result;
	}

}
