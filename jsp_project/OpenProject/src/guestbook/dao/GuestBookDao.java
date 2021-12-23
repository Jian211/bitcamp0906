package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
			pstmt.setInt(3, guestBook.getMemberidx());
			
			result = pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return result;
	}

	public int selectTotalCount(Connection conn) throws SQLException {
		int totalCount = 0;
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from guestbook";
		
		try { 
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				totalCount = rs.getInt(1);	
			}
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
		return totalCount;
	}

	public List<GuestBook> selectList(Connection conn, int index, int COUNT_PER_PAGE) throws SQLException {
		List<GuestBook> list = new ArrayList<GuestBook>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from project.guestbook limit ?,?;";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			pstmt.setInt(2, COUNT_PER_PAGE);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {

				list.add(new GuestBook(
						rs.getInt("idx"),
						rs.getString("subject"),
						rs.getString("content"),
						rs.getString("regdate"),
						rs.getInt("memberidx"),
						selectByMemberidx(conn,rs.getInt("memberidx"))	// 이렇게 해도되는지 질문
						));
						
			}
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return list;
	};
	
	public String selectByMemberidx(Connection conn,int memberidx) throws SQLException {
		String username = null;
		
		String sql = "select username from member where idx= ?;";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberidx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				username = rs.getString(1);
			}
			
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return username;
	}
	
	
	
}
