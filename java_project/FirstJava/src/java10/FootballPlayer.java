package java10;

import java.io.Serializable;

// 축구 클래스 생성
public class FootballPlayer implements Comparable<FootballPlayer>, Serializable{
	String name;
	int number;
	String team;
	int age;

	public FootballPlayer(String name, int number, String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return String.valueOf(name)+" "
				+ Integer.valueOf(number)+" "
				+ String.valueOf(team)+" "
				+ Integer.valueOf(age) ;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		FootballPlayer fb = (FootballPlayer) obj;
		if(this.name.equals(fb.name) 
				&& this.age == fb.age 
				&& this.team.equals(fb.team)) 
		{
			result = true;
		}
		return result;
	}

	@Override
	public int hashCode() {
		return this.age % 10;
	}

	@Override
	public int compareTo(FootballPlayer o) {
		// 팀 이름순으로 정렬
		
		int result = this.team.compareTo(o.team); // 음수 ,양수, 0
		
		if(result == 0) {
			result = this.name.compareTo(o.name);
			if(result == 0) {
				result = this.number - o.number;
			}
		}

		return result;
	}
	
	
	
	
}



	