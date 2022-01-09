package com.bitcamp.myapp.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.myapp.dao.MemberDao;
import com.bitcamp.myapp.jdbc.ConnectionProvider;
import com.bitcamp.myapp.jdbc.JdbcUtil;
import com.bitcamp.myapp.member.domain.LoginInfo;
import com.bitcamp.myapp.member.domain.Member;

@Service
public class MemberMyPageService {

	@Autowired
	private MemberDao dao;

	public Member getMember(HttpSession session) throws SQLException {

		int memberIdx = ((LoginInfo) session.getAttribute("loginInfo")).getIdx();
		Member member = null;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			member = dao.selectByIdx(conn, memberIdx);

		} finally {
			JdbcUtil.close(conn);
		}

		return member;

	}
}