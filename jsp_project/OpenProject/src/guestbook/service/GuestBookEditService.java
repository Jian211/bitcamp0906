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
	

	public void editGuestBook(GuestBook guestBook) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		
		try {
			GuestBookDao.getInstance().editByGuestBook(conn,guestBook);

		} finally {
			JdbcUtil.close(conn);
		}
		
	};
	
	
	
}
