package chapter04;
/*
  1. 독감예방 접조이 가능한지 여부를 확인하는 메소드를 정의
  	- 매개변수로 태어난 해(년도)를 전달받습니다.
  	- 15세 미만의 경우와 65세 이상의 경우"무료예방접종이 가능합니다." 메시지가 콘솔에 출력
  	- 위에서 정의한 조건의 범위가 아닌 나머지의 경우 무료접종대상이 아닙니다라고 출력
  
  2. 건강검진 대상 여부를 판별하고 어떤 검진이 가능한지 확인하는 메소드를 정의합니다.
  	- 매개변수로 태어난 해(년도)를 전달받습니다.
  	- 대한민국 성인(20세)의 경우 무료로 2년마다 건강검진을 받을 수 있습니다.
  	- 짝수 해에 태어난 사람은 올해가 짝수년이라면 검사대상이 됩니다.
  	- 40이상의 경우는 암 검사도 무료로 검사를 할 수 있습니다.
 */
import java.util.Calendar;

public class Member {
	String name;
	int birthYear;
	int age;
	
	Member(){};
	Member(String name, int year) {
		name = name;
		birthYear = year;
		age = ageCal();
	}

	void vaccination() {
		
		int age = ageCal();
		
		boolean checkAge1 = age < 15 || age >= 65;
		boolean checkAge2 = !(age < 15 || age >= 65);
		if(checkAge1) {
			System.out.println("무료예방접종이 가능합니다.");
		} else {
			System.out.println("무료접종대상이 아닙니다.");
		}
	}
	
	int ageCal() {
		return Calendar.getInstance().get(Calendar.YEAR) - birthYear - 1;
	}
	
	void checkup() {
		int age = ageCal();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		boolean checkUp = birthYear%2 == year%2;
		
		if(age >= 20 && checkUp) {
			System.out.println("무료로 2년마다 건강검진을 받을 수  있습 니다.");
		}
		if(year%2 == 0 && year%2 == 0) {
			System.out.println("건강검진 대상입니다.");
		}
		if(age >= 40) {
			System.out.println("암 검사도 무료로 가능합니다.");
		}
	}
	
	public static void main(String[] args) {
		Member member = new Member("손흥민",2000);
		
		
		//member.vaccination(2000);
		//member.checkup(2000);
	}
}
