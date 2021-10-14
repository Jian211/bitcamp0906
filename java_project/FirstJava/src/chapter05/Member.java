package chapter05;

import java.util.Calendar;

public class Member {
	String name;
	int birthYear;
	int age;
	
	Member(){};
	
	Member(String name, int year) {
		this.name = name;
		birthYear = year;
		age = ageCal();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	void printAll() {
		System.out.println(name);
		System.out.println(birthYear);
		System.out.println(age);
	}
	
	int ageCal() {
		return Calendar.getInstance().get(Calendar.YEAR) - birthYear - 1;
	}
	
	public static void main(String[] args) {
		Member member1 = new Member();
		Member member2 = new Member("손흥민",2000);
		
		member1.printAll();
		member2.printAll();
		
	}
}
