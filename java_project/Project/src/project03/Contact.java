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

public class Contact {
	private	String name;
	private String phoneNumber;
	private String email;
	private String adress;
	private int birthDay;
	private String group;
	
	Contact(){}
	
	// 생성자를 통하여 기본 정보를 저장
	Contact(String name, String phoneNumber, String email, String adress, int birthDay, String group){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.adress = adress;
		this.birthDay = birthDay;
		this.group = group;
	}
	
	// 기본 정보를 출력
	public void print() {
		System.out.println("이름 : "+ name);
		System.out.println("생일 : "+ birthDay);
		System.out.println("메일 : "+ email);
		System.out.println("주소 : "+ adress);
		System.out.println("번호 : "+ phoneNumber);
		System.out.println("그룹 : "+ group);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	


}