package chapter01;

public class Member {
	
	
	
	
	public static void main(String[] args) {
		// static 바이트 코드가 가상머신에서 실행하는 시점에 
		// 메소드 코드가 메모리에 로드된다.
		System.out.println("지명근");
		sayMyName();
	}

	static void sayMyName() {
		System.out.println("지명근");
	}
}
