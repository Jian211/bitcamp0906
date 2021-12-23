package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import guestbook.dao.GuestBookDao;
import guestbook.domain.GuestBook;
import guestbook.domain.GuestBookListView;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class GuestBookListSerivce {

	private GuestBookListSerivce () {};
	private static GuestBookListSerivce service = new GuestBookListSerivce();
	public static GuestBookListSerivce getInstance() { return service; }

	
	public GuestBookListView getList(int pageNum) {
		GuestBookListView listView = null;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			
			int totalCount = GuestBookDao.getInstance().selectTotalCount(conn);	 
			final int COUNT_PER_PAGE = 3;					// 페이지 당 표현할 갯수
			int currentPage = pageNum;						// 현재 페이지 번호
			int index = (currentPage-1)*COUNT_PER_PAGE;		// 항목 가져오기  : limit index 
			List<GuestBook> list = GuestBookDao.getInstance().selectList(conn, index, COUNT_PER_PAGE);		// 전체 게시글 수 구하기

			listView = new GuestBookListView(totalCount, COUNT_PER_PAGE, currentPage, list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		
		return listView;
	}
	

	
	
	
}
