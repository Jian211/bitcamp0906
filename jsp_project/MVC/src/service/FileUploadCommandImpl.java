package service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		String view = null;
		System.out.println("req.getMethod() : "+req.getMethod());
		
		if(req.getMethod().equals("GET")) {
			
			view = "/WEB-INF/views/upload/uploadform.jsp";
			
		} else if(req.getMethod().equals("POST")) {

			String title	= null;
			String fileName = null;
			long   fileSize = 0;
			String contentType = null;
			String userName = null;
			
			// 1. multipart 여부 확인
			boolean isMultipart = ServletFileUpload.isMultipartContent(req);
			
			if(isMultipart) {
				
				// 2. File을 저장을 위한 Factory객체 생성
				DiskFileItemFactory factory = new DiskFileItemFactory();
				
				// 3. 요청을 구분( form 안에 있는 input들을 분리 )
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				try {
					List<FileItem> items = upload.parseRequest(req);
					
					Iterator<FileItem> itr = items.iterator();
					
					while (itr.hasNext()) {

						FileItem item = itr.next();

						// 파일과 일반 폼 필드 를 구분해서 데이터 처리
						if(item.isFormField()) {
							// text, password, checkbox, radio, hidden, select, textarea ...
							// type=file 을 제외한 타입
							
							// 파라미터 이름 : input 의 name 속성값
							String paramName = item.getFieldName();
							
							if(paramName.equals("title")) {
								try {
									title = item.getString("utf-8");
								} catch (UnsupportedEncodingException e) {
									e.printStackTrace();
								}
							} else if(paramName.equals("username")) {
								
								try {
									userName = item.getString("utf-8");
								} catch (UnsupportedEncodingException e) {
									e.printStackTrace();
								}
								
							} 
							
						} else {
							// file 처리
							
							
							// 웹경로
							String uploadURI = "/uploadFile";
							
							// 시스템 경로
							String saveDir = req.getSession().getServletContext().getRealPath(uploadURI);

							// 파라미터 이름
							String paramName = item.getFieldName();
							System.out.println("파라미터 이름 : " + paramName);
							
							if(paramName.equals("userfile")) {
								
								// 파일 이름 
								fileName = item.getName();
								System.out.println("파일 이름 : " + fileName);
								
								// contentType
								contentType = item.getContentType();
								System.out.println("컨텐트타입 : " + contentType);
								
								// 파일 사이즈
								fileSize = item.getSize();
								System.out.println("파일 사이즈 : " + fileSize);
								
								// 파일 저장
								File saveFile = new File(saveDir,fileName);
								
								if(saveFile.exists()) {
									saveFile = new File(saveDir, fileName.split(".")[0]+System.nanoTime()+"."+fileName.split("\\.")[1]);
								}
							
								try {
									item.write(saveFile);
								} catch (Exception e) {
									e.printStackTrace();
								}
								
							}
							
						}

					}
					
					
				} catch (FileUploadException e) {
					
					e.printStackTrace();
				}
				
			}
			
			req.setAttribute("title", title);
			req.setAttribute("fileName", fileName);
			req.setAttribute("contentType", contentType);
			req.setAttribute("fileSize", fileSize);
			req.setAttribute("username", userName);
			
			
			view = "/WEB-INF/views/upload/upload.jsp";
		}
		
		return view;
	}

}
