package com.bitcamp.myapp.member.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bitcamp.myapp.member.dao.MemberDao;
import com.bitcamp.myapp.member.domain.Member;
import com.bitcamp.myapp.member.domain.Member2;
import com.bitcamp.myapp.member.domain.MemberLoginRequest;
import com.bitcamp.myapp.member.exception.LoginInvalidException;

@Service
public class MemberLoginService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	public String login(MemberLoginRequest loginRequest, HttpSession session, HttpServletResponse response)	throws Exception {

		String viewName = null;
		//Member member = sqlSessionTemplate.getMapper(MemberDao.class).selectByIdPw(loginRequest.getLoginParam());
		
		Member member = sqlSessionTemplate.getMapper(MemberDao.class).selectById(loginRequest.getUserid());

		if (member == null) {
			throw new LoginInvalidException("아이디 또는 비밀번호가 틀립니다.");
		} else if(!encoder.matches(loginRequest.getPassword(), member.getPassword())) {
			// 사용자가 입력한 비밀번호와 member객체의 비밀번호를 확인
			throw new LoginInvalidException("아이디 또는 비밀번호가 틀립니다.");
		}

		session.setAttribute("loginInfo", member.getLoginInfo());	// 세선에 유저 정보 저장

		// 아이디 저장 -> 쿠키 저장
		if (loginRequest.getSaveid() != null && loginRequest.getSaveid().equals("on")) {
			Cookie c = new Cookie("saveId", loginRequest.getUserid());
			response.addCookie(c);
		}
		if (loginRequest.getUrl().length() > 0) {
			viewName = "redirect:" + loginRequest.getUrl();
		} else {
			viewName = "redirect:/";
		}

		return viewName;
	}

}