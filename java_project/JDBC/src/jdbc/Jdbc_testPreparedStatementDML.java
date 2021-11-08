package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_testPreparedStatementDML {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt	= null;
		

		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			
			// 2. 연결 	: connection 
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user	= "scott";
			String pw 	= "tiger";
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("DB connection ok!!");
		

			// 3. 작업 (CRUD) DML,select  statement 객체생성
			String sql = "insert into dept values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 70);
			pstmt.setString(2, "DEV");
			pstmt.setString(3, "INCHEON");
			
			// DML 실행
			int resultCnt = pstmt.executeUpdate();
			
			if(resultCnt > 0) {
				System.out.println("등록이 되었습니다.");
			} else {
				System.out.println("등록되지 않았습니다.");
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
				if(pstmt != null) 	pstmt.close();
				if(conn != null) 	conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
