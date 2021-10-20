package chapter10;

public class ExceptionTest05 {
	public static void main(String[] args) {
		
		try {
			// 1. 예외 객체 생성
			Exception e = new Exception("고의로 발생시킨 예외") ;
	
			// 2. 예외 발생
			throw e;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();// 예외 처리를 하지 않았을 때 발생되는 메시지 출력
		}
	
		
		System.out.println("프로그램이 종료됩니다.");
	}
}
