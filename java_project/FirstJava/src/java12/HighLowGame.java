package java12;


import javax.swing.JOptionPane;

public class HighLowGame {
	
	
	public static void main(String[] args) {
		Count c = new Count();	
		c.start();
		
		int randomNum = (int)(Math.random()*99)+1;
		boolean correct = false;
		String user;
		
		while(!correct) {
			user = JOptionPane.showInputDialog("1~100사이의 숫자를 입력해주세요.");
			int userNum = Integer.parseInt(user);
			if(userNum == randomNum) {
				correct = true;
				System.out.println("정답입니다.");
				System.exit(0);
			} else {
				if(userNum > randomNum) {
					System.out.println(userNum+"보다 작은 수를 입력해주세요");
				}else {
					System.out.println(userNum+"보다 큰 수를 입력해주세요");
				}
			}
		}
		
	}
}
