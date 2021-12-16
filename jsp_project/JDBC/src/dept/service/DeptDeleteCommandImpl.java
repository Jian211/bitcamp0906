package dept.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDao;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class DeptDeleteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest req, HttpServletResponse res) {
		// 삭제 할 deptno
		String deptno = req.getParameter("deptno");
		
		Connection conn = null;
		int cnt = 0;
		try {
			conn = ConnectionProvider.getConnection();
			
			// dao에게 deptno전달
			cnt = DeptDao.getInstance().deleteDept(conn, Integer.parseInt(deptno));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		// 결과 msg를 req에 저장
		String msg = cnt > 0 ? "삭제되었습니다." : "잘못된 요청입니다.";
		req.setAttribute("result", msg);
		
		return "/WEB-INF/views/dept/delete.jsp";
	}

}
