package chapter01;

public class Calculator {
	/*
	  	1. 숫자 두 개를 매개변수의 인자로 전달받아 더하기 메소드를 추가합시다.
	  	2. 숫자 두 개를 매개변수의 인자로 전달받아 빼기 메소드를 추가합시다.
	  	3. 숫자 두 개를 매개변수의 인자로 전달받아 곱하기 메소드를 추가합시다.
	  	4. 숫자 두 개를 매개변수의 인자로 전달받아 나누기 메소드를 추가합시다.
	  
	 */

	int add(int num1, int num2) {
		return num1+num2;
	}

	int minus(int num1, int num2) {
		return num1-num2;
	}
	
	long multi(long num1, int num2) {
		return num1*num2;
	}
	
	int devide(int num1, int num2) {
		return num1/num2;
	}
	
	float devide(float num1, float num2) {
		return num1/num2;
	}

	public static void main(String[] args) {
		// 클래스의 정의도니 메소드의 사용 
		// 클래스를 이용해서 인스턴스(객체)를 생성.
		// 클래스의 멤버(변수,메서드)들이 메모리에 로드된다!
		// 객체 생성: new 클래스이름() => 참조값(객체의 메모리 주소값)
		// 생성자 호출 > 초기화
		// 참조변수 : 객체의 주소값을 저장하는 변수이다.
		// 클래스 이름 변수이름 
		Calculator cal = new Calculator();
		System.out.println("더하기 메소드 호출");
		System.out.println("1 + 2 = "+ cal.add(1, 2));
		System.out.println("빼기 메소드 호출");
		System.out.println("1 - 2 = "+ cal.minus(1, 2));
		System.out.println("곱하기 메소드 호출");
		System.out.println("1000000 * 1000000 = "+ cal.multi(1000000, 1000000));
		System.out.println("정수나누기 메소드 호출");
		System.out.println("10 / 3 = "+ cal.devide(10, 3));
		System.out.println("실수나누기 메소드 호출");
		System.out.println("10.0 * 3.0 = "+ cal.devide(10.0f, 3.0f));
		// 정수의 기본타입은 int
		// 실수의 기본타입은 double
	}
}
