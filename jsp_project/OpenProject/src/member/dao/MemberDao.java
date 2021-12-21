package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.util.JdbcUtil;
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
				member = new Member(
						rs.getInt("idx"),
						rs.getString("userid"),
						rs.getString("password"),
						rs.getString("username"),
						rs.getString("regdate"),
						rs.getString("photo"));
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
				member = new Member(
						rs.getInt("idx"),
						rs.getString("userid"),
						rs.getString("password"),
						rs.getString("username"),
						rs.getString("regdate"),
						rs.getString("photo"));
			}
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		
		return member;
		
	}
	
	
	
	
	
	
	
}
