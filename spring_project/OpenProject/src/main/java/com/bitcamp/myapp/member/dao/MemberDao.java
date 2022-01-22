package com.bitcamp.myapp.member.dao;

import java.util.List;

import com.bitcamp.myapp.member.domain.LoginParams;
import com.bitcamp.myapp.member.domain.Member;
import com.bitcamp.myapp.member.domain.Member2;
import com.bitcamp.myapp.member.domain.MemberRegRequest;

public interface MemberDao {
	
	public Member selectByIdPw(LoginParams params);
	
	public Member selectById(String userid);
	
	public int selectTotalCount();
	
	public List<Member> selectList(int count, int index);
	
	public int insertMember(MemberRegRequest regRequest);
	

}
