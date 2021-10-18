package project01;

public class Contact {

	private	String name;
	private String phoneNumber;
	private String email;
	private String adress;
	private int birthDay;
	private int group;
	

	Contact(){}
	
	Contact(String name, String phoneNumber, String email, String adress, int birthDay, int group){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.adress = adress;
		this.birthDay = birthDay;
		this.group = group;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}
	
	 void print(){
		System.out.println(name);
		System.out.println(birthDay);
		System.out.println(email);
		System.out.println(adress);
		System.out.println(phoneNumber);
		System.out.println(group);
	}

}