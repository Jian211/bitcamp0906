package chapter10;

public class ExceptionTest03 {

	public static void main(String[] args) {
		int [] arr = new int[3];
		Object o = new String("ABC");
		int size = -10;
		String str = null;
		String number = "one";
	
		
		
		try {
			// 배열의 인덱스를 잘못 처리한경우
			System.out.println(arr[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("예외 발생!!!");
			System.out.println(e.getMessage());
		}
	
		try {
			Integer i = (Integer)o;
		} catch (ClassCastException e) {
			System.out.println("예외 발생!!!");
			System.out.println(e.getMessage());
		}

		try {
			int [] arr1 = new int[size];
		} catch (NegativeArraySizeException e) {
			System.out.println("예외 발생!!!");
			System.out.println(e.getMessage()); // null 즉, 메세지가 따로 정해져 있지않다.
		}
		
		try {
			System.out.println(str.toUpperCase());
		} catch (Exception e) {
			System.out.println("예외 발생!!!");
			System.out.println(e.getMessage());
		}
		
		try {
			// String -> int
			int temp = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			System.out.println("예외 발생!!!");
			System.out.println(e.getMessage());
		}
		

		
		System.out.println("프로그램을 종료합니다.");
	}
}
