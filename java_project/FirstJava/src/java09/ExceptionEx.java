package java09;
/*
	1.콘솔에서 사용자 아이디를 입력 받아 정상적인 영문자와 숫자로만 
	이루어진 값을 입력했는지 확인하는 프로그램을 만들어봅시다.
		①사용자 예외 클래스를 정의해서 예외를 발생 시켜 봅시다.	
		②예외 클래스 이름은 BadIdInputException이라고 정의합시다.

	2.Scanner 클래스로 태어난 년도를 입력 받을 때 int 타입으로 받도록 합시다. 
	이때 nextInt() 메소드를 사용하게 되는데 이때 발생하는 예외처리를 하도록 합시다.
 */

import java.util.Scanner;

public class ExceptionEx {

	public static boolean check(String id) {
		String reg = "^[a-zA-Z0-9]*$";
		return id.matches(reg);
	}
	
	public static void main(String[] args) {
		System.out.println("첫번쨰------------------------");
		Scanner sc = new Scanner(System.in);
		String userId = null;
		
		try {
			System.out.println("영문자와 숫자로만 이루어진 아이디를 입력해주세요.");
			System.out.print("> ");
			userId = sc.nextLine();
			if(!check(userId)) {
				throw new BadIdInputException();
			}
			
			System.out.println("아이디가 등록되었습니다.");
		} catch (BadIdInputException bie) {
			System.out.println("오류가 발생!!");
			bie.message(userId);
		}
		
		System.out.println("두번쨰------------------------");
		System.out.println("태어난 연도를 입력해주세요.");
		
		int year = 0;
		try {
			year = sc.nextInt();
			System.out.println(year+"를 입력해주셨습니다.");
		} catch (Exception e) {
			System.out.println("에러발생!!!");
			BadIdInputException err = new BadIdInputException();
			err.message();
		}
		
		System.out.println("프로그램을 종료합니다.");
	}
}
