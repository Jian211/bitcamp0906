package mm.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import mm.domain.Member;

@Component("dao")	// 이름이 정해지지 않으면 class 이름이 들어간다 (소문자)
@Qualifier("md")
public class MemberDao implements Dao {

	// ID 
	private static int nextId = 0;	
	
	// 회원 정보를 저장하는 컬렉션
	private Map<String,Member> map = new HashMap<String, Member>();
	
	
	@Override
	public void insert(Member member) {
		member.setId(nextId++);
		map.put(member.getEmail(), member);
	}

	@Override
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}

	@Override
	public Member selectByEmail(String email) {
		return map.get(email);
	}

	@Override
	public Collection<Member> selectAll() {
		return map.values();
	}

}
