package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.GuestBookDao;
import guestbook.domain.GuestBook;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class GuestBookEditService {

	private GuestBookEditService() {};
	private static GuestBookEditService service = new GuestBookEditService() {};
	public static GuestBookEditService getInstance() { return service; }
	

	public int editGuestBook(GuestBook guestBook) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			result = GuestBookDao.getInstance().editByGuestBook(conn,guestBook);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		return result;
	};
	
	
	
}
