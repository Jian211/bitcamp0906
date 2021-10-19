package java07;

public class Person {
	// 이름을 저장하는 변수와 주민등록번호를 저장하는 변수 정의
	String name;
	int MyNumber; // 앞에 6자리만
	
	// 생성자 정의
	Person(String name, int muNumber){
		this.MyNumber = muNumber;
		this.name = name;
	}
	
	
	// 인사하는 메소드를 정의 
	public void print() {
		System.out.println("안녕하세요.");
		System.out.println("저는 "+name+" 입니다.");
	}
}
