package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import guestbook.domain.GuestBook;
import jdbc.util.JdbcUtil;

public class GuestBookDao {

	private GuestBookDao () {};
	private static GuestBookDao dao = new GuestBookDao();
	public static GuestBookDao getInstance() { return dao; }
	
	
	public int insertGuestBook(Connection conn, GuestBook guestBook) throws SQLException {
		int result = 0;
		
		String sql = "INSERT INTO guestbook(subject,content,memberidx) VALUES (?,?,?);";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, guestBook.getSubject());
			pstmt.setString(2, guestBook.getContent());
			pstmt.setInt(3, guestBook.getIdx());
			
			result = pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return result;
	};
	
	
	
	
	
}
