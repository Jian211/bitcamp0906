package java12;

public class Count extends Thread{

	
	@Override
	public void run() {
		for (int i = 20; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
