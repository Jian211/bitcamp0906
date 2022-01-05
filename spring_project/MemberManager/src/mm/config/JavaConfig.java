package mm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import mm.dao.MemberDao;
import mm.service.ChangePasswordService;
import mm.service.MemberRegService;

@Configuration  // == xml
public class JavaConfig {

	// MemberDao
	@Bean(name="dao")	// name이 없을 때는 메서드 이름이 이름이된다.
	@Scope(value = "singleton")
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	
	// MemberRegService		 : dao 주입 받아야함
	@Bean 		// 속성 값이 없으니 name은 메소드의 이름
	public MemberRegService regService() {
		return new MemberRegService(memberDao());
	}
	// 주입을 잘못하게되면 오류가 발생하니깐 
	// 간단한 것이 중요한게 아니라 컴파일시 오류를 찾을 수 있어야한다. 
	
	// ChangePasswordService : dao 주입 받아야함
	@Bean
	public ChangePasswordService changePasswordService() {
		ChangePasswordService service = new ChangePasswordService();
		service.setDao(memberDao());
		return service;
	}
 	
	
	
}
