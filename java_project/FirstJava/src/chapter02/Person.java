package chapter02;

/*
	 회원이름을 저장하는 변수
	 회원 전화번호를 저장하는 변수
	 회원 주민등록번호를 저장하는 변수
	  
 */
public class Person {
	private String memberName;		// 회원의 이름
	private String phoneNumber;		// 전화번호
	//private String personalNumber;	// 주민등록번호
	private long personalNumber;	// 주민등록번호
	
	//setter / getter
	
	//setter는 값을 받아서 변수에 저장. 즉, 매개변수로 맞는 타입의 데이터를 받아야함.
	public void setMember(String name) {
		memberName = name;
	}
	
	//getter 인스턴스 값을 반환
	public String getMember() {
		return memberName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(long personalNumber) {
		this.personalNumber = personalNumber;
	}

	public void printData() {
		System.out.println("name :"+memberName);
		System.out.println("Phone Number :"+ phoneNumber);
		System.out.println("Personal Number :"+ personalNumber);
		
		
	}
}
