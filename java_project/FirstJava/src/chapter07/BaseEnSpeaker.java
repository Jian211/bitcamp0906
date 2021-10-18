package chapter07;

public class BaseEnSpeaker extends Speaker{
	private int baseRate;
	
	public void setBaseRate(int base) {
		baseRate = base;
	}
	
	// 오버 라이딩은
	// 상위 클래스의 메소드의 선언부를 일치시키고 처리부를 변경
	// @Override : 상위 클래스의 메소드를 오바라이딩 한다. 
	//			      오버라이딩의 규칙에 맞게 정의하는지 체크 

	@Override  
	public void showCurrentState() {	// 상위 클래스의 메소드와 선언부를 동일시킴
		super.showCurrentState();
		System.out.println("베이스 크기"+ baseRate);
	}
	
	public static void main(String[] args) {
		
		BaseEnSpeaker aes = new BaseEnSpeaker();
		
		aes.showCurrentState();
		
		System.out.println("=================");
		Speaker speaker = new Speaker();
		speaker.showCurrentState();
	
		System.out.println("=================");
		
		// 다형성
		// 상위 타입의참조변수  = 하위 타입의 인스턴스
		// 참조변수의 타입에 정의된 멤버만 사용이 가능
		Speaker sp = new BaseEnSpeaker();
		sp.showCurrentState();
		
	
	}
}
