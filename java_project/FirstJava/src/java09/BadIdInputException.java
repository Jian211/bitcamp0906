package java09;

public class BadIdInputException extends Exception {
	
	public BadIdInputException() {
		
	}
	
	public void message(String id) {
		System.out.println(id+"는 숫자 또는 영어로만 나열되지 않았습니다.");
	}
	public void message() {
		System.out.println("숫자를 입력해주세요!");
	}
}
