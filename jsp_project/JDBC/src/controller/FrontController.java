package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.service.BadCommandImpl;
import dept.service.Command;

public class FrontController extends HttpServlet{

	private Map<String,Command> commans = new HashMap<String, Command>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿이 생성 될 때 한번 실행합니다. -> 초기화 처리합니다.");

		String configFile = config.getInitParameter("configPath");
		
		// 시스템 경로 파일의 실제경로
		String configPath = config.getServletContext().getRealPath(configFile);
		
		Properties prop = new Properties();
		FileInputStream fis = null;						// 프로그램 기준으로 외부의 파일을 갖고온다.
		
		try {
			fis = new FileInputStream(configPath);
			
			prop.load(fis);								// 파일 -> 객체 Properties
			fis.close();   								// stream클래스는 close메소드를 실행 해줘야한다.
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		Iterator<Object> itr = prop.keySet().iterator();			// 키 값 셋팅
		while(itr.hasNext()) {
			String command = (String)itr.next();
			String commandClassName = prop.getProperty(command);	// Value 얻기
			
			try {
				Command commandObj = (Command)Class.forName(commandClassName).newInstance();
				
				commans.put(command, commandObj);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("초기화된 요청 : "+ commans.size());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String commandURI = req.getRequestURI();
		
		if(commandURI.startsWith(req.getContextPath())) {
			commandURI = commandURI.substring(req.getContextPath().length());
		}
		
		Command command = commans.get(commandURI);	
		// command = dept.service.DeptListCommandImpl 이게 들어갈텐데
		// dept.service.DeptListCommandImpl 값이 자동으로  DeptListCommandImpl 클래스를 실행시키는건가?
		
		
		if(command == null) {
			command = new BadCommandImpl();
		}

		String viewPage = command.getPage(req, res);	// 이게 실행 시켜주는거였다. 아 이해 되따
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, res);
	}
	
}
