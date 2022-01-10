package com.bitcamp.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bitcamp.myapp.member.domain.Member;
import com.bitcamp.myapp.member.domain.MemberRegRequest;

@Repository
public class JdbcTemplateMemberDao {
	
	@Autowired
	private JdbcTemplate template;
	
	
	//로그인 처리를 위한 select 아래 매소드는 깔끔하게 쓴 코드
	public Member selectByIdPw(String uid, String pw) {
		String sql = "select * from member where userid=? and password=?";
		List<Member> members = template.query(sql, new MemberRowMapper(), uid, pw);
		return members.isEmpty() ?  null : members.get(0);
	};
	
	
	// 전체 회원의 수를 구하는 메소드
	public int selectTotalCount() {
		return template.queryForObject("select count(*) from member", Integer.class);
	}
	
	
	// 리스트 페이지에 출력할 회원 정보 List<Member>
	public List<Member> selectList(int index, int count){
		String sql = "select * from member order by regdate desc limit ?,?";
		return template.query(sql, new MemberRowMapper(), index, count);
	}

	
	// 회원 가입을 위한 insert
	public int insertMember(MemberRegRequest request) {
		String sql = "insert into member(userid,password,username,photo) values(?,?,?,?)";
		return template.update(sql, request.getUserid(), request.getPw(),request.getUsername(),request.getPhoto());
	}
	
	public int insert(MemberRegRequest request) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		int resultCnt = template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				String sql="insert into member(userid,password,username,photo) values(?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"idx"} );
				pstmt.setString(1, request.getUserid());
				pstmt.setString(2, request.getPw());
				pstmt.setString(3, request.getUsername());
				pstmt.setString(4, request.getFileName());
				return pstmt;
			}
			
		}, keyHolder);

		Number keyValue = keyHolder.getKey();
		request.setIdx(keyValue.intValue());

		return resultCnt;
		
	}
	
	
	
	// MyPage를 위한 Member 객체를 구하는 Select
	public Member selectByIdx(int idx) {
		String sql = "select * from member where idx = ?";
		List<Member> members = template.query(sql, new MemberRowMapper(), idx);
		return members.isEmpty() ? null : members.get(0);
	}
}
