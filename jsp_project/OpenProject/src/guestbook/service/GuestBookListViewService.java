package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;


import guestbook.dao.GuestBookDao;
import guestbook.domain.GuestBook;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class GuestBookListViewService {
	private GuestBookListViewService() {};
	private static GuestBookListViewService service = new GuestBookListViewService();
	public static GuestBookListViewService getInstance() { return service; }
	

	public GuestBook getGuestBook(int guestBookIdx) {
		GuestBook guestBook = null;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			guestBook = GuestBookDao.getInstance().selectBygGuestBookIdx(conn, guestBookIdx);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		
		return guestBook;
	};
	
	
	
	
}
