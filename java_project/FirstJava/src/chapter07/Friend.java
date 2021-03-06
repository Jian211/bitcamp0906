package chapter07;

// 추상클래스로 만들기 : 추상클래스가되려면 추상 메소드가 있어야한다
public abstract class Friend {
	// 개인 정보 관리 프로그램
	// 정보를 저장하는 변수
	String name;
	String phoneNumber;
	String address;
	
	// 저장데이터의 초기화
	public Friend() {
		
	}
	
	public Friend(String name,String phoneNumber,String address) {
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
	//public void showBasicInfo() {}
	// 추상 메소드 : 처리 블록이 없다!, 미완성된 메소드, 상속을 통해 완성시켜야하는 메소드
	public abstract void showBasicInfo();
}
