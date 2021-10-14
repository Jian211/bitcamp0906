package chapter05;

import java.util.Calendar;

public class Member {
	// private : 클래스 내부의 맴버들만 접근가능.
	private String name;
	private String phoneNumber;
	private String major;
	private int grade;
	private String email;
	private String birthday;
	private String address;
	
	Member(){};
	
	Member(String name, String phoneNumber, String major, int grade, String email, String birthday, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.major = major;
		this.grade = grade;
		this.email = email;
		this.birthday = birthday;
		this.address = address;
	}
	
	Member(String name, String phoneNumber, String major, int grade, String email) {
		//this(name, phoneNumber, major, grade, email, null, null);
		this(name, phoneNumber, major, grade, email, "생일정보 없음", "주소 정보 없음");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void showData() {
		System.out.println("이름 : "+ this.name);
		System.out.println("전화번호 : "+ this.phoneNumber);
		System.out.println("전공 : "+ this.major);
		System.out.println("학년 : " + this.grade);
		System.out.println("이메일 : " + this.email);
		System.out.println("생일 : "+ this.birthday);
		System.out.println("주소 : "+ this.address);

	/*if(this.birthday == null) {
			System.out.println("생일 : 정보 없음");
		}else {
			System.out.println("생일 : "+ this.birthday);
		}
		
		if(this.address == null) {
			System.out.println("주소 : 정보 없음");
		} else {
			System.out.println("주소 : "+ this.address);
		}*/
	}
}
