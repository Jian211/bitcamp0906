package com.bitcamp.mvc.domain;

public class Test {
	
	private String name;
	private int age;
	private String gender;
	
	public Test() {};
	
	public Test(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Test [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
	
	
}
