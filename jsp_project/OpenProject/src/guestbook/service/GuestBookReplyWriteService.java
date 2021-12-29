package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import guestbook.dao.ReplyDao;
import guestbook.domain.ReplyListItem;
import guestbook.domain.ReplyRequest;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class GuestBookReplyWriteService {
	private GuestBookReplyWriteService() {};
	private static GuestBookReplyWriteService service = new GuestBookReplyWriteService();
	public static GuestBookReplyWriteService getInstance () { return service; };
	
	
	public int writeReply(HttpServletRequest req, HttpServletResponse res) {
		int result = 0;
		
		String memberIdx = req.getParameter("memberIdx");
		String guestbookIdx = req.getParameter("guestbookIdx");
		String message = req.getParameter("message");
		
		ReplyRequest replyRequest = new ReplyRequest(Integer.parseInt(memberIdx), Integer.parseInt(guestbookIdx), message);
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
		
			result = ReplyDao.getInstance().insertReply(conn, replyRequest);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JdbcUtil.close(conn);
		}
		
		return result;
	}


	public List<ReplyListItem> writeReply2(HttpServletRequest req, HttpServletResponse res) {
		
		// 데이터 입력
		writeReply(req,res);
		
		int guestBookIdx = Integer.parseInt(req.getParameter("guestbookIdx"));
		
		Connection conn = null;
		List<ReplyListItem> list = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			list = ReplyDao.getInstance().selectReplyList(conn, guestBookIdx);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		return list;
	}


	public String writeReply3(HttpServletRequest req, HttpServletResponse res) {
		// JSON 형식의 데이터를 반환
		// JSON -> 문자열
		
		// 데이터 입력
		writeReply(req,res);
		
		int guestBookIdx = Integer.parseInt(req.getParameter("guestbookIdx"));
		
		Connection conn = null;
		List<ReplyListItem> list = null;
		String jsonStr = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			list = ReplyDao.getInstance().selectReplyList(conn, guestBookIdx);

			//List<ReplyListItem> list -> JSON
			Gson gson = new Gson();
			
			jsonStr = gson.toJson(list);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		
		return jsonStr;
	}
	
	
}
