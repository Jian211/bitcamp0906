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
import member.domain.EditRequest;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberEditService {

	private MemberEditService() {};
	private static MemberEditService service = new MemberEditService();
	public static MemberEditService getInstance () { return service; };
	
	
	// idx 값으로 Member 객체를 반환하는 메소드
	public Member getMember(int idx) {
		Member member = null;
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			member = MemberDao.getInstance().selectByIdx(conn, idx);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

		
		return member;
	}
	
	public int editMember(HttpServletRequest req, HttpServletResponse res) {
		int result = 0;
		// 1. multipart 여부 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);

		if(isMultipart) {
			
			String idx = null;
			String pw = null;
			String username = null;
			String oldfile = null; 
			String fileName = null;
			File newFile = null;
			boolean newFileChk = false;
			String saveDir = req.getSession().getServletContext().getRealPath("/uploadfile");
			
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
						
						if(paramName.equals("pw")) {
							pw = getFieldValue(item);
						} else if(paramName.equals("oldfile")){
							oldfile = getFieldValue(item);
						} else if(paramName.equals("username")) {
							username = getFieldValue(item);
						} else if(paramName.equals("idx")) {
							idx = getFieldValue(item);
						}
						
					} else {
						// file
						if(item.getFieldName().equals("photo") && item.getSize() > 0) {
							
							// 새로운 파일 이름은 중복이 되지 않는 숫자로 생성
							String newFileName = String.valueOf(System.nanoTime());
						
							// file 저장을 위한 file 객체 생성
							newFile = new File(saveDir, newFileName);
							
							// 파일 저장
							item.write(newFile);
							System.out.println("파일 저장완료");
							
							fileName = newFileName;
							newFileChk = true;
							
						}
					}
				}
				
				if(fileName == null) {
					fileName = oldfile;
				}
				
				// Dao 호출
				conn = ConnectionProvider.getConnection();
				
				result = MemberDao.getInstance().updateMember(conn, new EditRequest(Integer.parseInt(idx), pw, username, fileName));
				
				if(newFileChk && oldfile != null && oldfile.equals("starwars.png")) {
					// oldfile 삭제
					File oldFile = new File(saveDir,oldfile);
					if(oldFile.exists()) {
						oldFile.delete();
					}
				}

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

	private String getFieldValue(FileItem item) throws UnsupportedEncodingException {
		return item.getString("utf-8").isEmpty() ? null : item.getString("utf-8");
	}
	
	
}
