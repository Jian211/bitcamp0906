package com.bitcamp.myapp.member.dao;

import java.util.List;

import com.bitcamp.myapp.member.domain.LoginParams;
import com.bitcamp.myapp.member.domain.Member;
import com.bitcamp.myapp.member.domain.MemberRegRequest;
import com.bitcamp.myapp.member.domain.SearchParams;

public interface MemberDao {
	
	//public Member selectByIdPw(LoginParams params);
	public Member selectByIdPw(String uid, String pw);
	
	public int selectTotalCount();
	
	//public List<Member> selectList(SearchParams params);
	public List<Member> selectList(int count, int index);
	
	public int insertMember(MemberRegRequest regRequest);

}
