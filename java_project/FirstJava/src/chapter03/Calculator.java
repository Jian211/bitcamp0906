package chapter03;
/*
 	클래스를 정의
 
 */

import java.util.Scanner;

public class Calculator {
	// final 변수 앞 또는 클래스 앞에 사용된다.
	// java에서 상수 : 변수에 최초 초기화된 값을 바꾸지 못한다.
	final float PI = 3.1415f;
	final String USER_NAME;
	
	// 생성자: 초기화 메소드
	Calculator(String name) {
		USER_NAME = name;
	}
	
	
	//1. 정수 두 개를 매개변수의 인자로 전달받아 더하기연산 후 출력하는 메소드
	public void plus(int num1, int num2) {
		long result = (long)num1 + num2;
		System.out.printf("%d + %d = %d\n", num1, num2, result);
	}
	
	//2. 정수 두 개를 매개변수의 인자로 전달받아 빼기 연산 후 출력하는 메소드
	public void minus(int num1, int num2) {
		long result = (long)num1 - num2;
		System.out.printf("%d - %d = %d\n", num1, num2,result);
	}
	
	//3. 정수 두 개를 매개변수의 인자로 전달받아 곱하기 연산 후 출력하는 메소드
	public void multi(double num1, int num2) {
		long result = (long)num1 * num2;
		System.out.printf("%d * %d = %2f\n", num1, num2,result);
		
	}

	//4. 정수 두 개를 매개변수의 인자로 전달받아 나누기 연산 후 출력하는 메소드
	public void devide(int num1, int num2) {
		float result = (float)num1 * num2;
		System.out.printf("%d / %d = %d\n", num1, num2,result);
		
	}
	
	//5. 실수 반지름 하나를 매개변수의 인자로 전달 받아 원의 둘레를 구해 반환하는 메소드
	float circum(float r) {
		return 2 * PI * r;
	}
	
	// 6. 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 넓이를 구해 반환하는 메소드
	float cirArea(float r) {
		return PI * r * r ;
	}
	
	// 7. main() 메소드를 정의하고 각각의 메소드를 호출해서 결과를 콘솔에 출력
	public static void main(String[] args) {
		Calculator cal = new Calculator("손흥민");

		// 상수를 출력
		System.out.println("PI : "+cal.PI);
		System.out.println("User Name : "+cal.USER_NAME);

		cal.plus(10, 20);

		Scanner scanner = new Scanner(System.in);
		System.out.println("덧샘을 시작합니다.\n숫자 1을 입력해주세요.");
		int num1 = Integer.parseInt(scanner.nextLine());
		System.out.println("숫자 2을 입력해주세요.");
		int num2 = Integer.parseInt(scanner.nextLine());

		cal.plus(num1, num2);
		System.out.println("=====================");
		System.out.println("원의 둘레와 넓이를 구합니다.\n 반지름을 입력해주세요.");
		float r = Float.parseFloat(scanner.nextLine());
		
		System.out.println("전달받은 반지름 : "+r);
		System.out.println("원의 둘레 : "+ cal.circum(r));
		System.out.println("원의 넓이 : "+ cal.cirArea(r));
	}

	//8. 콘솔에서 사용자에게 데이터를 받아 메소드를 호출할 때 , 사용자에게 받은
	//	 데이터를 메소드의 매개변수 인자로 활용.

}
