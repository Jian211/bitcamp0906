package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import guestbook.dao.ReplyDao;
import guestbook.domain.ReplyListItem;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class ReplyListService {

	private ReplyListService () {};
	private static ReplyListService service = new ReplyListService();
	public static ReplyListService getInstance () { return service; };
	
	
	public List<ReplyListItem> getList(HttpServletRequest req){
		
		List<ReplyListItem> list = null;
		Connection conn = null;
		int idx = Integer.parseInt(req.getParameter("idx"));
		
		try {
			conn = ConnectionProvider.getConnection();
			list = ReplyDao.getInstance().selectReplyList(conn, idx);
			
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			JdbcUtil.close(conn);
		}
		
		return list;
		
	}
	
	
}
