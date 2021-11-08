package emp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpMain {
	
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		List<Emp> list = new ArrayList<>();
		EmpDao empDao = EmpDao.getInstance();
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);					// false은, 동기화를 개발자가 직접 컨트롤
			
			// add New EMP 
			empDao.insertEmp(conn,new Emp(7778,"SON","Soccer",7839,"92/12/21",8000,2500,20));
			System.out.println();
			
			
			// EMP TABLE Print ALL
			list = empDao.selectAllEmp(conn);					
			list.forEach( e -> System.out.println(e.toString()));
			System.out.println();
			

			// SCOTT사원의 정보 출력
			Emp emp = empDao.selectOneEmp(conn, "SCOTT");		
			System.out.println(emp.toString());
			System.out.println();
			
			
			// SCOTT사원의 SAL을 1000으로 변경
			int resultEdit = empDao.editEmp(conn, 1000, "SCOTT");
			if(resultEdit > 0) System.out.println("SCOTT 사원의 SAL이 변경되었습니다.");
			else System.out.println("SCOTT사원의 정보가 변경되지 않았습니다.");
			System.out.println();
			
			
			// 이적으로인하여 SON사원 삭제
			int resultDelete = empDao.deleteEmp(conn,"SON");
			if(resultDelete > 0) System.out.println("SON 선수가 삭제되었습니다.");
			else System.out.println("SON 선수가 삭제되지 않았습니다.");
			System.out.println();
			
			
			// 모든 사원정보를 출력하되 부서정보를 함께 출력하는 프로그램을 작성
			// 이부분이 어렵다.
			
			conn.commit();		// DB에 저장  - DCL
			
			
		} catch (SQLException e) {
			System.out.println("Connection fail!");
			conn.rollback();
			e.printStackTrace();
		} 
		
		
		
		
		
		
		
	}
}
