package mm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

import mm.dao.MemberDao;
import mm.service.ChangePasswordService;
import mm.service.MemberRegService;

@Configuration
//@Import(JavaConfigSub.class)
@ImportResource("classpath:appCtxSub.xml")
public class JavaConfigMain {

	// MemberDao
	@Bean(name="dao")	// name이 없을 때는 메서드 이름이 이름이된다.
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	
	@Bean 		// 속성 값이 없으니 name은 메소드의 이름
	public MemberRegService regService() {
		return new MemberRegService(memberDao());
	}
 	
	
	
}
