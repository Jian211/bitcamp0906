package com.bitcamp.myapp.member.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.myapp.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.myapp.member.dao.MybatisMemberDao;
import com.bitcamp.myapp.member.domain.LoginInfo;
import com.bitcamp.myapp.member.domain.Member;

@Service
public class MemberMyPageService {

	//@Autowired
	//private JdbcTemplateMemberDao dao;
	
//	@Autowired
//	private MybatisMemberDao dao;
	
	public Member getMember(HttpSession session) throws SQLException {
		int memberIdx = ((LoginInfo) session.getAttribute("loginInfo")).getIdx();
//		dao.selectByIdx(memberIdx);
		return new Member(); // 객ㅊ체지우기
	}
}