package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.GuestBookDao;
import jdbc.ConnectionProvider;

public class GuestBookDeleteServie {
	
	private GuestBookDeleteServie () {};
	private static GuestBookDeleteServie service = new GuestBookDeleteServie() {};
	public static GuestBookDeleteServie getInstance () { return service ;}

	
	// 게시판 idx값으로 삭제 실행 후 결과를 전달하는 메소드
	public void deleteGuestBook(int idx) throws SQLException {
		GuestBookDao.getInstance().deleteGuestBookByIdx(
				ConnectionProvider.getConnection(),idx);
		
	};
	
	
	
	
}