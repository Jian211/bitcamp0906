package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
															// 싱글톤
	private EmpDao () { };									// 1. 생성자를 private으로
	
	static private EmpDao empDao = new EmpDao();			// 2. 공용변수이지만 private
	
	static public EmpDao getInstance() { return empDao;	}	// 3. 내부에서 만든 생성자(변수)를 외부에서 사용가능하도록 메소드.
	
	
	// 새로운 사원 정보를 입력
	public void insertEmp(Connection conn, Emp emp) {
		String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;			
		int resultEmp = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);  	//	2. DB 연결
			
			pstmt.setInt(1, emp.getEmpno());		//	3-1. 삽입할 값을 나열
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMrg());
			pstmt.setString(5, emp.getHireDate());
			pstmt.setInt(6, emp.getSal());
			pstmt.setInt(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());
		
			resultEmp = pstmt.executeUpdate();		//	3-2. DB에 값 삽입	
			
			if(resultEmp > 0) {
				System.out.println("새로운 사원이 등록되었습니다.");
			} else {
				System.out.println("새로운 사원을 등록 실패하였습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			EmpUtil.close(pstmt);					//	4. 연결 종료
		}
	}

	
	// EMP 테이블의 모든 데이터를 출력하는 프로그램을 작성
	public List<Emp> selectAllEmp(Connection conn) {
		String sql = "select * from emp";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Emp> list = new ArrayList<>();					//	테이블에서 행하나씩 담을 리스트 생성
		
		try {
			pstmt = conn.prepareStatement(sql);	//	2. DB연결
			rs = pstmt.executeQuery();						//	3-1. select실행준비
			
			while(rs.next()) {								//	3-2. 각 행들을 리스트에 담음
				list.add(new Emp(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			EmpUtil.close(rs); 								//	4. 각각 DB연결 종료
			EmpUtil.close(pstmt); 
		}
		return list;
	}
	
	
	// EMP테이블에서 SCOTT사원의 급여 정보를 1000으로 바꾸는 프로그램을 작성(수정)
	public int editEmp(Connection conn, int sal, String ename) {
		int resultEdit = 0;
		String sql = "update emp set sal = ? where ename = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sal);
			pstmt.setString(2, ename);
			
			resultEdit = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			EmpUtil.close(pstmt);
		}

		return resultEdit;
	}
	
	
	// EMP테이블에서 SCOTT이름으로 검색한 결과를 출력하는 프로그램을 작성해보자.
	public Emp selectOneEmp(Connection conn, String ename) {
		String sql = "select * from emp where ename = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Emp emp = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				emp = new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			EmpUtil.close(rs);
			EmpUtil.close(pstmt);
		}
		return emp;
	}


	public int deleteEmp(Connection conn, String ename) {
		String sql = "delete from emp where ename = ?";
		PreparedStatement pstmt = null;
		int resultDelete = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename);
			
			resultDelete = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultDelete;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 모든 사원 정보를 출력하되 부서정보를 함게 출력하는 프로그램을 작성해보자.
}
