package com.bitcamp.myapp.member.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bitcamp.myapp.member.domain.Member;

@Service
public class MailSenderService {
	
	@Autowired
	private JavaMailSender sender;
	
	public int send(String subject, String content, String email) {
		return 0;
	}

	public int send(String email, String userName) {
		
		int resultCnt = 1;
		
		MimeMessage mimeMessage = sender.createMimeMessage();
	
		try {
			// Mail subject
			mimeMessage.setSubject("[안내]" + userName + " 회원가입을 축하합니다.", "UTF-8");
			
			// Mail content
			String html = "<h1> 회원가입을 축하합니다. </h1>";
			html += "<a href=\"http://www.naver.com\">네이버</a><br>";
			html += "<a href=\"http://localhost:8080/myapp\">오픈프로젝트 가기</a><br>";
			mimeMessage.setText(html, "UTF-8", "html");	
			
			// from : 보내는 사람 설정, 구글 정책은 setFrom이 적용되지 않는다. 
			mimeMessage.setFrom(new InternetAddress("myunggeun2@naver.com"));
			
			// To : 받는 사람의 이메일 설정
			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email, userName+"님","utf-8"));
			
			// send mail
			sender.send(mimeMessage);
		
		} catch (MessagingException | UnsupportedEncodingException e) {
			resultCnt = 0;
			e.printStackTrace();
		}

		return resultCnt;
	}
	
	public int send(String [] emails) {
		
		return 0;
	}
	
	public int send(Member member) {
		
		return 0;
	}
	
	
	
}
