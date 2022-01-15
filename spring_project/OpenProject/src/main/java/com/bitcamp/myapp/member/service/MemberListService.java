package com.bitcamp.myapp.member.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.myapp.member.dao.MemberDao;
import com.bitcamp.myapp.member.domain.ListPageView;
import com.bitcamp.myapp.member.domain.Member;
import com.bitcamp.myapp.member.domain.SearchParams;

@Service
public class MemberListService {
	
	//@Autowired
	//private JdbcTemplateMemberDao dao;
	//private MybatisMemberDao dao;
	
	private MemberDao dao;

//	@Autowired
//	private SqlSessionTemplate sst;
	
	// 페이지 당 표현할 회원의 수
	private final int COUNT_PER_PAGE = 5;
	
	public ListPageView getPageView(int pageNum) throws SQLException {
		int totalCount = dao.selectTotalCount();
		int index = (pageNum-1)*COUNT_PER_PAGE;
		SearchParams params = new SearchParams(index, COUNT_PER_PAGE, null, null);
		//List<Member> list = dao.selectList(params);
		//dao = sst.getMapper(MemberDao.class);
		List<Member> list = dao.selectList(COUNT_PER_PAGE, index);
		return new ListPageView(totalCount, pageNum, COUNT_PER_PAGE, list);
	}
	
}