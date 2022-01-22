package com.bitcamp.myapp.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.myapp.member.dao.MemberDao;

@Service
public class MemberCheckIdService {

	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	
//	public int checkId(String userid) {
//		dao = template.getMapper(MemberDao.class);
//		return dao;
//	}

}
