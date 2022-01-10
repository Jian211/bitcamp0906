package com.bitcamp.myapp.member.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.myapp.dao.JdbcTemplateMemberDao;
import com.bitcamp.myapp.member.domain.MemberRegRequest;

@Service
public class MemberRegService {

	@Autowired
	private JdbcTemplateMemberDao dao;
	
	public int insertMember(MemberRegRequest regRequest, HttpServletRequest request)
			throws Exception {

		int resultCnt = 0;

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

		try {
			//resultCnt = dao.insertMember(regRequest);
			resultCnt = dao.insert(regRequest);
			
			
		} catch (Exception e) {
			// 파일이 저장된 후 DB관련 예외가 발생했을 때 : 저장했던 파일을 삭제 
			if(newFile != null && newFile.exists()) {
				newFile.delete();
			}
			e.printStackTrace();
			throw e;
		}

		return resultCnt;

	}

}