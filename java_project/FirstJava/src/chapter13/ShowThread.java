package chapter13;

public class ShowThread extends Thread{

	String threadName;
	
	ShowThread(String name){
		this.threadName = name;
	}
	
	@Override
	public void run() {
		// 새로운 스래드의 실행 메소드 : 메인 스레드에서 직접 호출하지 않는다.
		for (int i = 0; i < 100; i++) {
		
			// 스레드 제어 메소드 :  sleep(ms) > 매개변수 1/1000 단위
			// 매개변수로 전달된 시간 만큼 블록상태가 된다.
			// 조건이 만족하면 (시간이 지나면) 실행 가능상태로 전환
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	
	}
	
	
}
