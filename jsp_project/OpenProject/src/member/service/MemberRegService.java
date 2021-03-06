package member.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;
import member.dao.MemberDao;
import member.domain.RegRequest;

public class MemberRegService {

	// Service 클래스도 메소드만 있는 클래스다! -> 싱클톤처리
	private MemberRegService() {}
	private static MemberRegService regService = new MemberRegService();
	public static MemberRegService getInstance () {
		return regService;
	}
	
	// 사용자가 전달한 요청 데이터를 받아서 Dao insert 메소드로 전달 
	// 입력 결과 데이터 반환 하는 메소드, 사용자 요청 처리, 응답 처리 
	
	public int insertMember(HttpServletRequest req, HttpServletResponse res) {
		int result = 0;

		// 1. multipart 여부 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);

		if(isMultipart) {
			
			// 파라미터를 받기, 파일 업로드, 저장 파일 이름을 생성
			// RegRequest 객체 생성 
			String userId = null;
			String pw = null;
			String userName = null;
			String fileName = null; // 파일이 있으면 업로드 없으면 Null
			File newFile = null;
			Connection conn = null;
			
			// 데이터 받기, 파일 업로드
			// 2. 파일 저장을 위한 Factory 객체 생성
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// 3. 요청을 구분( form 안에 있는 input 들을 분리 )
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			try {
				List<FileItem> items = upload.parseRequest(req);
				
				Iterator<FileItem> itr = items.iterator();
				
				while(itr.hasNext()) {
					FileItem item = itr.next();
					
					// 일반 파라미터와 file을 구분해서 처리
					if(item.isFormField()) {
						// 일반 파라미터
						// 파라미터 이름에 맞는 데이터를 받고 변수에 저장 
						String paramName = item.getFieldName();
						
						if(paramName.equals("userid")) {
							userId = item.getString("utf-8");
						} else if(paramName.equals("pw")){
							pw = item.getString("utf-8");
						} else if(paramName.equals("username")) {
							userName = item.getString("utf-8");
						}
						
					} else {
						// file
						if(item.getFieldName().equals("photo") && item.getSize() > 0) {
							// 웹 저장경로 
							// 시스템 경로 
							String saveDir = req.getSession().getServletContext().getRealPath("/uploadfile");
							// 새로운 파일 이름은 중복이 되지 않는 숫자로 생성
							String newFileName = String.valueOf(System.nanoTime());
						
							// file 저장을 위한 file 객체 생성
							newFile = new File(saveDir, newFileName);
							
							// 파일 저장
							item.write(newFile);
							System.out.println("파일 저장완료");
							
							fileName = newFileName;
							
						}
					}
				}
				
				if(fileName == null) {
					fileName = "startwars.png";
				}
				
				// Dao 호출
				conn = ConnectionProvider.getConnection();
				
				RegRequest regRequest = new RegRequest(userId, pw, userName, fileName);
				
				result = MemberDao.getInstance().insertMember(conn, regRequest);
				
			} catch (FileUploadException e1) {
				e1.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
				// 저장된 파일이 있다면 파일을 삭제
				if(newFile != null && newFile.exists()) {
					newFile.delete();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn);
			}
		}
		
		return result; 
	}
	
}
