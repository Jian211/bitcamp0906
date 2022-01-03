package mm.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import mm.dao.MemberDao;

public class MemberManagerSpring3 {

	static ApplicationContext ctx;
	
	public static void main(String[] args) {
		
		ctx = new GenericXmlApplicationContext("classpath:appCtx4.xml");
	
		// 싱글톤과 프로토타입의 차이 
		MemberDao dao1 = ctx.getBean("memberDao", MemberDao.class);	// singleton
		MemberDao dao2 = ctx.getBean("memberDao", MemberDao.class);	// prototype
	
		System.out.println("dao1 = dao2 => "+ (dao1 == dao2));
	
	}
	

}