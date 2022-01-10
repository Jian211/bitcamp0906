package com.bitcamp;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 스프링 실행을 위한 설정
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DBConnectionTest {
	
	@Autowired
	private DataSource dataSource;

	private Connection conn;
	
	@Autowired
	private JdbcTemplate template;
	
	@Before
	public void setUp() throws Exception {
		conn = dataSource.getConnection();
	}

	@After
	public void tearDown() throws Exception {
		conn.close();
	}

	@Test
	public void test() {
		
		// dataSource Null 확인
		assertNotNull("dataSource",dataSource);
		
		// connection null 확인
		assertNotNull("Connection", conn);
		
		// Template null 확인
		assertNotNull("JdbcTemplate", template);
	}

}
