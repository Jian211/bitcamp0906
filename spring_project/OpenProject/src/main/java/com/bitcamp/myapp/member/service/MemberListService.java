package com.bitcamp.myapp.member.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.myapp.dao.JdbcTemplateMemberDao;
import com.bitcamp.myapp.member.domain.ListPageView;
import com.bitcamp.myapp.member.domain.Member;

@Service
public class MemberListService {
	
	@Autowired
	private JdbcTemplateMemberDao dao;
	
	// 페이지 당 표현할 회원의 수
	private final int COUNT_PER_PAGE = 3;
	
	public ListPageView getPageView(int pageNum) throws SQLException {
		int totalCount = dao.selectTotalCount();
		int index = (pageNum-1)*COUNT_PER_PAGE;
		List<Member> list = dao.selectList(index, COUNT_PER_PAGE);
		return new ListPageView(totalCount, pageNum, COUNT_PER_PAGE, list);
	}
	
}