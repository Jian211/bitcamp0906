package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_testStatementDML {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt	= null;
		
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
			stmt = conn.createStatement();

			//	SQL : insert
			String sql = "insert into dept(deptno, dname, loc) values (60, 'test','SEOUL')";
			int cnt = stmt.executeUpdate(sql);
			
			if(cnt > 0) {
				System.out.println("입력되었습니다.");
			} else {
				System.out.println("입력 실패!");
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
				if(stmt != null) 	stmt.close();
				if(conn != null) 	conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
