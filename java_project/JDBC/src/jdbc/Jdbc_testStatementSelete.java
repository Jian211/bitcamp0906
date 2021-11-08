package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Jdbc_testStatementSelete {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt	= null;
		ResultSet rs	= null;
		
		// Dept 저장을 위한 List<Dept>
		List<Dept> list = new ArrayList<>();
		
		
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user	= "scott";
		String pw 	= "tiger";

		try {
			// 1. 드라이버 로드 : 프로그램에서 한번만 실행해주면 되는 부분 
			Class.forName("oracle.jdbc.driver.OracleDriver");

			
			// 2. 연결 	: connection 
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("DB connection ok!!");
		

			// 3. 작업 (CRUD) DML,select  statement 객체생성
			stmt = conn.createStatement();
			
			// sql : selete
			String sql = "select * from dept order by deptno";
			rs = stmt.executeQuery(sql);
			
			// 반복을 통해 행단위 데이터 검색
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString(2);
				String loc = rs.getString("loc");
				//System.out.print(deptno+"\t"+ dname+"\t"+ loc+"\n");
		
				list.add(new Dept(deptno,dname,loc));
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
				if(stmt != null) 	stmt.close();
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
