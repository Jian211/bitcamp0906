package member.service;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;
import member.dao.MemberDao;
import member.domain.Member;
import member.exception.MemberNotFoundException;

public class MemberDeleteService {

	private MemberDeleteService () {};
	private static MemberDeleteService service = new MemberDeleteService();
	public static MemberDeleteService getInstance () { return service; };

	
	
	// 사용자에게 idx값을 받아 삭제 결과여부를 반환
	public int deleteMember(HttpServletRequest req, HttpServletResponse res) throws SQLException, MemberNotFoundException {
		int result = 0;
		
		// idx 객체 받기
		String idx = req.getParameter("idx");
		
		Member member = null;
		Connection conn = null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			
			member = MemberDao.getInstance().selectByIdx(conn, Integer.parseInt(idx));
			
			// 회원 정보가 존재하지 않으면 예외 발생 
			if(member == null) {
				throw new MemberNotFoundException(idx);
			}
		
			// 회원정보에 문제가 없다면
			result = MemberDao.getInstance().deleteMemberByIdx(conn,Integer.parseInt(idx));
			
			// 회원의 프로필 사진을 삭제
			// 시스템경로
			String uploadURI = "/uploadfile";
			String saveDir = req.getSession().getServletContext().getRealPath(uploadURI);
			
			// File 객체 생성 : 파일 객체가 있어야 해당위치에 파일이 있는지
			if(member != null && !member.getPhoto().equals("starwars.png")) {
				File deleteFile = new File(saveDir,member.getPhoto());
				//저장 공간에 파일이 존재 하는지 확인 
				
				if(deleteFile.exists()) {
					deleteFile.delete();
				}
			
			}
			
			
			
		} finally {
			JdbcUtil.close(conn);
		}
		
		
		return result; 
	}



}
