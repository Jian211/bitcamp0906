package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import guestbook.domain.ReplyListItem;
import guestbook.domain.ReplyRequest;
import jdbc.util.JdbcUtil;

public class ReplyDao {

	private ReplyDao () {};
	private static ReplyDao dao = new ReplyDao() {};
	public static ReplyDao getInstance () { return dao; };
	
	
	public int insertReply(Connection conn, ReplyRequest replyRequest) throws SQLException {

		int result = 0;
		
		String sql = "insert into reply (content, memberidx, guestbookidx) value (?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, replyRequest.getMessage());
			pstmt.setInt(2, replyRequest.getMemberIdx());
			pstmt.setInt(3,replyRequest.getGuestbookIdx());
			
			result = pstmt.executeUpdate();
			
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		
		return result;
	}
	
	public List<ReplyListItem> selectReplyList (Connection conn, int guestBookIdx) throws SQLException{
		List<ReplyListItem> list = new ArrayList<ReplyListItem>();
		
		String sql =  "select r.idx, r.content, r.regdate, r.memberidx, r.guestbookidx, m.username, m.photo from member m join reply r on m.idx=r.memberidx where r.guestbookidx=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, guestBookIdx);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReplyListItem item = new ReplyListItem(
						rs.getInt(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(5), 
						rs.getInt(4),
						rs.getString(6),
						rs.getString(7)
						);
				
				list.add(item);
			}
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return list;
	}

	public int deleteByIdx(Connection conn, int replyIdx) throws SQLException {
		int result = 0;
		
		String sql ="delete from reply where idx = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, replyIdx);
			
			result = pstmt.executeUpdate();
			
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return result;
	}
	
	
}
