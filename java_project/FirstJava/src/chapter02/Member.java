package chapter02;

/*
 	String 타입의 이름을 저장할 수 있는 변수 name을 정의
 	int 타입의 나이를 저장할 수 있는 변수 age를 정의
 	double 타입의 키를 저장 할 수 있는 변수 height를 정의
 	boolean 타입의 JAVA 책의 보유 여부를 저장할 수 있는 변수 hasBook를 정의
 	이름과 나이,키, 책의 보유 여부를 출력해봅시다.
  
 */

public class Member {
	// 인스턴스 변수는 자동 초기화 
	private String name; 		// 사용자의 이름
	private int age;			// 사용자의 나이
	private double height;		// 사용자의 키
	//private boolean hasBook;	// 자바 책 보유여부
	
	void printData() {
		System.out.println("이름: "+name);
		System.out.println("나이: "+age);
		System.out.println(" 키: "+height);
		//System.out.println("책보유: "+hasBook);
	}
	
	public static void main(String[] args) {
		// Member 클래스로 인스턴스를 생성 > 이름, 나이, 키 ,책 ㅂ
		Member member = new Member();
		
		// 인스턴스의 변수를 참조해서 출력해보자
		member.printData();
		
		// 인스턴스 변수의 값을 변경
		member.name = "지명근";
		member.age = 29;
		member.height = 175.0;
		//member.hasBook = false;
		
		System.out.println("\n인스턴스 변수에 값을 변경\n");
		
		member.printData();
	}
}
