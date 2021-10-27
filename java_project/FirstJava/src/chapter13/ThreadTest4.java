package chapter13;

import javax.swing.JOptionPane;

public class ThreadTest4 {
	static boolean inputCheck = false;

	public static void main(String[] args) {
		
		CountDownThread c1 = new CountDownThread();
		c1.start();
		
		
		String input = JOptionPane.showInputDialog("아무데이터나 입력하세요.");
		System.out.println("입력하신데이터는 "+ input +"입닏.");
	
		inputCheck = true;
	}
}
