package dept.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDao;
import dept.domain.Dept;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class DeptRegCommandImpl implements Command {
	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		
		String viewPage = null;

		if(req.getMethod().equals("GET")) {
			System.out.println(req.getMethod());		// 전송방식 확인
			viewPage = "/WEB-INF/views/dept/regform.jsp";

			
		} else if(req.getMethod().equals("POST")){
			System.out.println(req.getMethod());		// 전송방식 확인
			
			
			// post 방식에서 한글 처리
			try {
				req.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			// 사용자가 입력한 데이터를 갖고 
			String deptno = req.getParameter("deptno");
			String dname  = req.getParameter("dname");
			String loc 	  = req.getParameter("loc");
			
			// Dept객체를 생성 
			Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
			
			// Dao insert 메소드로 입력처리
			Connection conn = null;
			int regCnt = 0;	// 성공 결과를 확인하기 위한 변수
			
			try {
				conn = ConnectionProvider.getConnection();
				
				// 결과 반환
				regCnt = DeptDao.getInstance().insertDept(conn, dept);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn);
			}
			
			// request 속성에 결과를 반환
			req.setAttribute("result", regCnt);
			req.setAttribute("dept", dept);
			
			viewPage = "/WEB-INF/views/dept/reg.jsp";
		}
		
		
		return viewPage;
		
	}

}
