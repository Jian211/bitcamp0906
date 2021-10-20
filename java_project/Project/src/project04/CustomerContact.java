package project04;
/*

*/

// 2-2-1.	회사, 거래처의 정보를 저장하는 하위클래스를 정의.
public class CustomerContact extends Contact{
	// 2-2-2.	거래처 회사이름, 거래품목, 직급 변수추가.
	private String company;
	private String item;
	private String rank;
	
	public CustomerContact() {}
	
	public CustomerContact(String name,String phoneNumber,String email,String adress,
			int birthDay,String group, String company,String item,String rank) {
		super(name, phoneNumber, email, adress, birthDay, group);
		this.company = company;
		this.item = item;
		this.rank = rank;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("거래처 회사 : "+ company);
		System.out.println("거래 품목 : "+ item);
		System.out.println("직급 : "+ rank);
	}
	
	// 2-2-3.	정보를 출력하는 메소드 오버라이딩 해서 추가된 정보를 출력.
	
	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
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
