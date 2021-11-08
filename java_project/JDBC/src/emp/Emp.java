package emp;

public class Emp {

	private int 	empno;
	private String	ename;
	private String	job;
	private int		mrg;
	private String	hireDate;
	private int 	sal;
	private int		comm;
	private int 	deptno;
	

	@Override
	public String toString() {
		return empno+"\t"+ename+"\t"+job+"\t" +mrg+"\t" +hireDate+"\t" +sal+"\t" +comm+"\t" +deptno;
	}

	public Emp(int empno, String ename, String job, int mrg, String hireDate, int sal, int comm, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mrg = mrg;
		this.hireDate = hireDate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMrg() {
		return mrg;
	}

	public void setMrg(int mrg) {
		this.mrg = mrg;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	
	
}
