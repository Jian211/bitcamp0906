package project07.HashMapVer;
/*
 	Contact클래스가 ShowData인터페이스를 상속하면서 추상 메소드를 보유하는 관계로 생성
 	Contact클래스는 추상 메소드를 가지고 있어 추상클래스가 되는 형태로 정의
 	
 */

public abstract class Contact implements ShowData{
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