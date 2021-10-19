package project03;
/*
1. Contact 클래스는 기본정보를 저장하고 기본 정보를 출력하는 
      메소드를 정의합니다.
	> 생성자를 통해 기본 정보들을 초기화 합니다.

2. 그룹에 해당하는 정보들을 추가적으로 정의하는 새로운 클래스들을 정의합니다.
      회사, 거래처의 정보를 저장하는 하위 클래스를 정의합니다.
    > CompanyContact 회사, 거래처의 정보를 저장하는 하위 클래스를 정의.
    	- 회사이름, 부서이름, 직급  변수추가
    	- 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 출력
    > CustomerContact 회사, 거래처의 정보를 저장하는 하위 클래스를 정의.
    	- 거래처 회사이름, 거래품목, 직급 변수 추가
    	- 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 출력
    	
3. SmartPhone 클래스의 배열을 다형성의 특징을 이용하여,
      상위 타입의 배열을 생서 후, 하위 클래스의 인스턴스를 저장하는 형태로 작성.

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
}
