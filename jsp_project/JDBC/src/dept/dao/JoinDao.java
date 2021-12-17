package dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import dept.domain.Dept;
import dept.domain.User;
import jdbc.util.JdbcUtil;

public class JoinDao {

	private JoinDao(){}
	private static JoinDao dao = new JoinDao();
	public static JoinDao getInstance() {
		return dao;
	}

	public int setUser(Connection conn, User user) {
		System.out.println("디에이오등장");
		int resultCnt = 0; // 결과를 반환한다.
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO customer(uId, uPw ,uName, uDate) VALUES (?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getuId());
			pstmt.setString(2, user.getuPw());
			pstmt.setString(3, user.getuName());
			pstmt.setInt(4, user.getuDate());
			
			resultCnt = pstmt.executeUpdate();	// executeUpdate는 성공여부를 int로 반환
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
				
		return resultCnt;
	}

	
	
}
