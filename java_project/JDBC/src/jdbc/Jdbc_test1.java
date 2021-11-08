package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_test1 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt	= null;
		ResultSet rs	= null;
		
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user	= "scott";
		String pw 	= "tiger";

		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			
			// 2. 연결 	: connection 
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("DB connection ok!!");
		

			// 3. 작업 (CRUD) DML,select 
		
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 클래스를 찾을 수 없습니다.");
			
		} catch (SQLException e) {
			System.out.println("데이터베이스에 연결할 수 없습니다.");
			e.printStackTrace();

		} finally {

			// 4. close
			//rs.close();
			//stmt.close();
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
}
