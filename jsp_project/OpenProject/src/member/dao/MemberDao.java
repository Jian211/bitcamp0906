package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.JdbcUtil;
import member.domain.EditRequest;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberDao {
	
	// 싱글톤
	private MemberDao() {}
	private static MemberDao dao = new MemberDao();
	public static MemberDao getInstance() {
		return dao;
	}
	
	// connection ,Member객체를 전달 받아 데이터베이스에 데이터 입력
	public int insertMember(Connection conn, RegRequest request) throws SQLException {
		int resultCnt = 0;
		
		String sql = "INSERT INTO member(userid,password,username,photo)VALUES (?,?,?,?);";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getUserid());
			pstmt.setString(2, request.getPw());
			pstmt.setString(3, request.getUsername());
			pstmt.setString(4, request.getFileName());
			
			resultCnt = pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}

	
	// 로그읜 처리를 위한 select 메소드
	public Member selectByIdPw(Connection conn, String userId, String pw) {
		Member member = null;
		
		String sql = "select * from project.member where userid = ? and password = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = getMember(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		
		return member;
	}


	public Member selectById(Connection conn, String userId) throws SQLException {
		Member member = null;
		
		String sql = "select * from project.member where userid = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = getMember(rs);
			}
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		
		return member;
		
	}

	public List<Member> selectList(Connection conn, int index, int count) throws SQLException {
		List<Member> list = new ArrayList<Member>();
		
		String sql ="select * from member order by regdate desc limit ?,?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			pstmt.setInt(2, count);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(getMember(rs));
			}
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		
		return list;
	}
	
	private Member getMember(ResultSet rs) throws SQLException {
		return new Member(
				rs.getInt("idx"),
				rs.getString("userid"), 
				rs.getString("password"), 
				rs.getString("username"), 
				rs.getString("regdate"), 
				rs.getString("photo"));
	}

	public int selectTotalCount(Connection conn) throws SQLException {
		int totalCount = 0;
		
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "select count(*) from member";
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

	public Member selectByIdx(Connection conn, int idx) throws SQLException {
		Member member = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="select * from member where idx=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				member = getMember(rs);
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return member;
	}

	public int updateMember(Connection conn, EditRequest editRequest) throws SQLException {
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		String sql ="update member set password=?. username=?, photo=? where idx =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, editRequest.getPw());
			pstmt.setString(2, editRequest.getUsername());
			pstmt.setString(2, editRequest.getFileName());
			pstmt.setInt(4, editRequest.getIdx());
			
			resultCnt = pstmt.executeUpdate();
			
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		
		return resultCnt;
	}
	
	
	
	
	
	
	
}
