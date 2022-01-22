package com.bitcamp.myapp.member.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bitcamp.myapp.member.dao.MemberDao;
import com.bitcamp.myapp.member.domain.MemberRegRequest;

@Service
public class MemberRegService {
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private MailSenderService senderService;
	
	public String insertMember(MemberRegRequest regRequest, HttpServletRequest request)
			throws Exception {
		int resultCnt = 0;
		String url = "";

		// 기본 이미지 설정
		regRequest.setFileName("starwars.png");
		
		// DB 관련 예외 발생 시 삭제 처리를 위한 File 객체 변수 선언
		File newFile = null;

		// 파일이 있다면 -> 파일 저장
		if (!regRequest.getPhoto().isEmpty() && regRequest.getPhoto().getSize() > 0) {
			// 시스템의 경로
			String savePath = request.getSession().getServletContext().getRealPath(CommonsData.SAVE_URI);
			String[] files = regRequest.getPhoto().getOriginalFilename().split("\\.");
			String exet = files[files.length - 1];
			String newFileName = System.nanoTime() + "." + exet;
			newFile = new File(savePath, newFileName);
			regRequest.getPhoto().transferTo(newFile);
			regRequest.setFileName(newFileName);
		}
		
		// 비밀번호 암호화
		regRequest.setPw(encoder.encode(regRequest.getPw()));	
		
		try {
			resultCnt = template.getMapper(MemberDao.class).insertMember(regRequest);
			
			// 가입 메일 전송
			if(senderService.send(regRequest.getUserid(), regRequest.getUsername()) > 0) {
				System.out.println("메일 발송 완료");
			} else {
				System.out.println("메일 발송 실패!");
			}
			
		} catch (Exception e) {
			// 파일이 저장된 후 DB관련 예외가 발생했을 때 : 저장했던 파일을 삭제 
			if(newFile != null && newFile.exists()) {
				newFile.delete();
			}
			e.printStackTrace();
			throw e;
		}
		
		if(resultCnt == 0) {
			url = "member/reg";
		}
		return url;

	}

}