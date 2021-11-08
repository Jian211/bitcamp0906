package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Jdbc_testPreparedStatementSelete {

	public static void main(String[] args) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs	= null;
		
		// Dept 저장을 위한 List<Dept>
		List<Dept> list = new ArrayList<>();
		
		
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user	= "scott";
		String pw 	= "tiger";

		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			
			// 2. 연결 	: connection 
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("DB connection ok!!");
		

			// 3. 작업 (CRUD) DML,select  statement 객체생성
			//	SQL을 등록해서 생성하기 때문에 Sql을 먼저 작성해야한다. 
			String sql = "select * from dept where deptno = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 70);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Dept(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 클래스를 찾을 수 없습니다.");
			
		} catch (SQLException e) {
			System.out.println("데이터베이스에 연결할 수 없습니다.");
			e.printStackTrace();

		} finally {

			// 4. close
			try {
				if(rs != null)		rs.close();
				if(pstmt != null) 	pstmt.close();
				if(conn != null) 	conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("부서 리스트");
		System.out.println("------------------------------------");
		System.out.println("부서번호\t부서이름\t위치");
		System.out.println("------------------------------------");
		for(Dept dept : list) {
			System.out.println(dept.toString());
		}
		
	}
}
