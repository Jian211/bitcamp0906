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
	
	
	//  게시판 등록
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

//	// 
//	public int selectById(String id,Connection conn) throws SQLException {
//		int memberidx = -1;
//		
//		String sql = "select * from member where userid=?;";
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				memberidx = rs.getInt(1);	// memberidx 값 받아오기
//			}
//		} finally {
//			JdbcUtil.close(pstmt);
//		}
//
//		return memberidx;
//	}
	
	//  게시판의 총 갯수를 구하는 메소드
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

	//	선택한 행의 갯수만큼 게시판의 데이터를 GET
	public List<GuestBook> selectList(Connection conn, int index, int COUNT_PER_PAGE) throws SQLException {
		List<GuestBook> list = new ArrayList<GuestBook>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select guestbook.idx, "
						 + " guestbook.subject,"
						 + " guestbook.content,"
						 + " guestbook.regdate, "
						 + " member.username," 
						 + " member.photo from guestBook join member on guestBook.memberidx = member.idx"
						 + " order by guestbook.idx desc"
				+ " limit ?,?;";
		
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
						rs.getString("username"),
						rs.getString("photo")
						));
			}
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return list;
	}

	// idx값 기준으로 게시판을 삭제 -> throw로 분기
	public int deleteGuestBookByIdx(Connection conn,int guestBookIdx, int memberIdx) throws SQLException {
		int result = 0;
		
		String sql ="delete from guestbook where idx=? and memberidx = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, guestBookIdx);
			pstmt.setInt(2, memberIdx);
			result = pstmt.executeUpdate();
			
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return result;
	}


	// 수정된 게시글 데이터를 DB에 삽입
	public int editByGuestBook(Connection conn, GuestBook guestBook) throws SQLException {
		int result = 0; 
		String sql = "UPDATE guestbook SET subject = ?, content = ? WHERE idx = ? and memberidx = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, guestBook.getSubject());
			pstmt.setString(2, guestBook.getContent());
			pstmt.setInt(3, guestBook.getIdx());
			pstmt.setInt(4, guestBook.getMemberidx());
			
			result = pstmt.executeUpdate();
			
		} finally {
			JdbcUtil.close(pstmt);
		}
		System.out.println(result);
		
		return result;
	}

	// 유저가 선택한 게시판 하나의 정보를 전달
	public GuestBook selectBygGuestBookIdx(Connection conn, int guestBookIdx) throws SQLException {
		GuestBook guestBook = null;
		
		String sql = "SELECT g.idx, g.subject, g.content, g.regdate, m.username, g.memberidx, m.photo \r\n" + 
				"FROM guestbook g \r\n" + 
				"join member m \r\n" + 
				"on g.memberidx = m.idx \r\n" + 
				"where g.idx = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, guestBookIdx);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				guestBook = new GuestBook(
						rs.getInt(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6),
						rs.getString(7));
			}
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			
		}
		
		
		return guestBook;
	};
	
	
	
	
}
