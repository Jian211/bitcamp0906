package chapter10;

import java.util.Scanner;

public class ExceptionTest01 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("피제수를 입력해주세요.");		// 나누어지는 수
		int num1 = sc.nextInt();
		
		System.out.println("제수를 입력해주세요.");		// 나누는 수
		int num2 = sc.nextInt();
		
		// 피제수가 0이면 오류발생 !!!
		if(num2 == 0) {			// 정상적인 종료가 될 수 있도록 코드 작성.
			System.out.println("0으로 나눌 수 없습니다.");
		} else {
			System.out.println(num1/num2);
		}
		
		
		
		
	}
}
