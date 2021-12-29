package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.GuestBookDao;
import guestbook.domain.GuestBook;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class GuestBookListViewService {
	private GuestBookListViewService() {};
	private static GuestBookListViewService service = new GuestBookListViewService();
	public static GuestBookListViewService getInstance() { return service; }

	
	public GuestBook getGuestBookInfo(HttpServletRequest req, HttpServletResponse res) {
		GuestBook guestBook = null;
		Connection conn = null;
		
		int guestBookIdx = Integer.parseInt(req.getParameter("guestBookIdx"));
		System.out.println(guestBookIdx);
		
		try {
			conn = ConnectionProvider.getConnection();
			guestBook = GuestBookDao.getInstance().selectBygGuestBookIdx(conn,guestBookIdx);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		return guestBook;
	};
	
	
	
	
}
