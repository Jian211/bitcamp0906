package project09;


// 2-1-1. 거래처의 정보를 저장하는 하위 클래스를 정의.
public class CompanyContact extends Contact {
	// 2-2. 회사이름, 부서이름, 직급 변수추가
	private String company;
	private String department;
	private String rank;
	
	public CompanyContact() {	};
	
	public CompanyContact(String name,String phoneNumber,String email,
			String adress,int birthDay,String group, String company, String department, String rank) {
		super(name, phoneNumber, email, adress, birthDay, group);
		this.company = company;
		this.department = department;
		this.rank = rank;
	}

	// 2-1-2. 정보를 출력하는 메소드를 오버라이딩하여 추가된 정보를 출력.
	@Override
	public void print() {
		super.print();
		System.out.println("회사 : "+ company);
		System.out.println("부서 : "+ department);
		System.out.println("직급 : "+ rank);
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public void showData() {
		// TODO Auto-generated method stub
		
	}
}
