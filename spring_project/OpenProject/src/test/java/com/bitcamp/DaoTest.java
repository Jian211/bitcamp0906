package com.bitcamp;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitcamp.myapp.member.dao.MemberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@Configuration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DaoTest {

	
	private MemberDao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void 회원의전체수구하는테스트() {
		
		dao = template.getMapper(MemberDao.class);
		
		int cnt = dao.selectTotalCount(new HashMap<String, String>());
		
		assertEquals("전체 회원수 확인 : 6", 6 ,cnt);
		
		// 전체회
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchType","uid");
		map.put("keyword","cool");
		
		cnt = dao.selectTotalCount(map);
		assertEquals("아이디가  cool문자열을 포함하는 회원의 수", 3 ,cnt);
		
		
		fail("Not yet implemented");
	}

}
