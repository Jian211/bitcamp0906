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

public class DeptEditCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		String viewPage = null;

		Connection conn = null;
		
		if(req.getMethod().equals("GET")) {

			// deptno 받기
			String deptno = req.getParameter("deptno");
			// Dao에게 수정 값과 deptno 값 넘겨주기 > dept객체가 필요하다. > request에 저장
			Dept dept = null;
			
			try {
				conn = ConnectionProvider.getConnection();
				dept = DeptDao.getInstance().selectByDeptno(conn,deptno);
			
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn);
			}
			
			req.setAttribute("dept", dept);
			
			viewPage = "/WEB-INF/views/dept/editform.jsp";
			
		} else if(req.getMethod().equals("POST")) {
//			try {
//				req.setCharacterEncoding("utf-8");
//				
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
			
			// 수정하고자 하는 데이터를 받는다. 
			String deptno = req.getParameter("deptno");
			String dname  = req.getParameter("dname");
			String loc    = req.getParameter("loc");
			int dcnt = 0;
			
			// Dao 수정 처리
			try {
				conn = ConnectionProvider.getConnection();
				
				Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
				dcnt = DeptDao.getInstance().editDept(conn,dept);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn);
			}
			
			String msg = dcnt > 0 ? "수정되었습니다." : "잘못된 요청입니다.";
			req.setAttribute("result", msg);
			
			viewPage = "/WEB-INF/views/dept/edit.jsp";
		}
		
		
		
		return viewPage;
	}

}
