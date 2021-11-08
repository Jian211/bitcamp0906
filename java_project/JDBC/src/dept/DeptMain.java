package dept;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DeptMain {

	
	public static void main(String[] args) {
	
		DeptDao deptDao = DeptDao.getInstance();	// 싱글톤 패턴
		Connection conn = null;
		List<Dept> list = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			// 트렌젝션 일의 단위
			conn.setAutoCommit(false); // 트렌젝션을 컨트롤하겠다.
			
			// 부서 리스트를 확인
			list = deptDao.selectAllList(conn);
			
			System.out.println(" 부서 리스트 ");
			System.out.println("------------------------------");
			for(Dept dept : list) {
				System.out.println(dept);
			}
			
			// 부서번호로 검색
			Dept dept = deptDao.selectByDeptno(conn, 10);
			System.out.println("10번 부서: "+ dept);
			
			// 부서 정보를 입력
			Dept newDept = new Dept(50, "DEV", "SEOUL");
			int insertCnt = deptDao.insertDept(conn, newDept);
			if(insertCnt > 0) {
				System.out.println("등록이 되었습니다.");
			} else {
				System.out.println("등록이 되지 않았습니다.");
			}
			System.out.println("입력결과 "+ deptDao.selectByDeptno(conn, 50));
			
			conn.commit();
			
			// 수정
			Dept editDept = new Dept(60, "Design", "PUSAN");
			int editCnt = deptDao.editDept(conn, editDept);
			
			if(editCnt > 0) {
				System.out.println("정보가 수정되었습니다.");
			} else {
				System.out.println("수정 실패, 조건에 맞는 데이터가 존재하지 않습니다.");
			}
			System.out.println("수정결과 : "+ deptDao.selectByDeptno(conn, 60));
			
			
			// delete deptno기준으로 삭제
			int deleteCnt = deptDao.deleteDept(conn, 60);
			if(deleteCnt > 0) {
				System.out.println("삭제완료");
			} else {
				System.out.println("삭제 실패");
			}
			System.out.println("삭제결과 : "+ deptDao.selectByDeptno(conn, 60));
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		//	부서 리스트를 확인하고 싶다. 
		
	}
}
