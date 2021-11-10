package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	// static으로 만드는 이유. 자주사용하기 때문에, 실행이 많을수록 계속 선언해야하기 때문
	public static Connection getConnection() throws SQLException {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user	= "scott";
		String pw 	= "tiger";
		return DriverManager.getConnection(jdbcUrl, user, pw);
	}
	
	
}
