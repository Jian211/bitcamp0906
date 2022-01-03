package mm.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import mm.dao.Dao;
import mm.domain.Member;
import mm.domain.RegRequest;
import mm.exception.DuplicateMemberException;

@Component("regService2")
public class MemberRegService2 {
	
//	@Autowired			// new MemberDao();
//	@Qualifier("md")
	@Resource(name = "guestDao")
	private Dao dao;	
	
	public MemberRegService2() {};
	
	public void regMember(RegRequest regRequest) throws DuplicateMemberException {
		
		// 이메일 중복 체크 
		Member member = dao.selectByEmail(regRequest.getEmail());
		if(member != null) {
			throw new DuplicateMemberException("이미 존재하는 이메일 입니다.");
		}
		
		dao.insert(regRequest.toMember());
		System.out.println("등록되었습니다.");
	}
	
}
