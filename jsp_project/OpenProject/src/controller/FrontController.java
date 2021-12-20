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

import member.command.BadCommandimpl;
import member.command.Command;

public class FrontController extends HttpServlet{

	private Map<String,Command> commans = new HashMap<String, Command>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿이 생성 될 때 한번 실행합니다. -> 초기화 처리합니다.");
		
		// Web.xml -> init-param 설정된 경로 가져오기. /WEB-INF/command.properties
		String configFile = config.getInitParameter("configPath");
		
		// 시스템 경로 파일의 실제경로
		String configPath = config.getServletContext().getRealPath(configFile);
		
		Properties prop = new Properties();
		FileInputStream fis = null;	// 프로그램 기준으로 외부의 파일을 갖고온다.
		try {
			fis = new FileInputStream(configPath);
			
			prop.load(fis);	// 파일 -> 객체 Properties
			fis.close();    // stream클래스는 close메소드를 실행 해줘야한다.
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		Iterator<Object> itr = prop.keySet().iterator();			// 키 값 셋팅
		while(itr.hasNext()) {
			String command = (String)itr.next();
			String commandClassName = prop.getProperty(command);	// Value 얻기
			System.out.println(commandClassName);
			
			try {
				// Command interface를 상속한 클래스를 담는다. < 
				Command commandObj = (Command)Class.forName(commandClassName).newInstance();
				// commandObj 이거에 궁금함이 생겼다.
				System.out.println("commandObj : "+commandObj);
				
				// commands Map에 <요청, 객체> 저장
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
		
		System.out.println("commandURI : "+commandURI);
		Command command = commans.get(commandURI);			
		if(command == null) {
			command = new BadCommandimpl();
		}

		String viewPage = command.getPage(req, res);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, res);
	}
	
}
