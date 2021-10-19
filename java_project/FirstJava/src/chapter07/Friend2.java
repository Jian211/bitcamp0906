package chapter07;


public class Friend2 {
	// 개인 정보 관리 프로그램
	// 정보를 저장하는 변수
	String name;
	String phoneNumber;
	String address;
	
	// 저장데이터의 초기화
	public Friend2(String name,String phoneNumber,String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	// 데이타 출력메소드 : 상속을 하면 오버라이딩해서 하이 클래스의 멤버도 출력.
	public void showData() {
		System.out.println("이름 : "+ name);
		System.out.println("핸드폰 : "+phoneNumber);
		System.out.println("주소 : "+ address);
	}
	
	// Override 목적
	public void showBasicInfo() {}
}
