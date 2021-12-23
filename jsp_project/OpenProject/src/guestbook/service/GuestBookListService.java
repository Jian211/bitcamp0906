package guestbook.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.GuestBookDao;
import guestbook.domain.GuestBook;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;
import member.domain.LoginInfo;

public class GuestBookListService {

	private GuestBookListService () {};
	private static GuestBookListService service = new GuestBookListService();
	public static GuestBookListService getInstance() { return service; }
	
	
	public int insertGuestBookWrite(HttpServletRequest req, HttpServletResponse res) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();

			int idx = selectById(((LoginInfo) req.getSession().getAttribute("loginInfo")).getUserId(),conn);
			String subject = req.getParameter("subject");
			String content = req.getParameter("content");

			
			result = GuestBookDao.getInstance().insertGuestBook(conn, new GuestBook(idx, subject, content));
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		return result;
		
	};
	
	public int selectById(String id,Connection conn) throws SQLException {
		int idx = -1;
		
		String sql = "select * from project.member where userid=?;";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				idx = rs.getInt(1);	// idx 값 받아오기
			}
		} finally {
			JdbcUtil.close(pstmt);
		}

		return idx;
	}

	
	
	
	
}
