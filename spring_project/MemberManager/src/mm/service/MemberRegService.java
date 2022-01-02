package mm.service;

import mm.dao.Dao;
import mm.domain.Member;
import mm.domain.RegRequest;
import mm.exception.DuplicateMemberException;

public class MemberRegService {
	
//	MemberDao dao = new MemberDao();	//	이것이 의존상태
	
	private Dao dao;	
	
	// Dao type의 객체를 주입 받는 방법 : 생성자, Setter Method

	// 1. 생성자
	public MemberRegService(Dao dao) {
		this.dao = dao;
	}
	
	// 2. Setter Method
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	
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
