package chapter04;

public class Contact {

	private	String name;
	private String phoneNumber;
	private String email;
	private String adress;
	private String birthDay;
	private int group;
	

	Contact(){}
	
	Contact(String name, String phoneNumber, String email, String adress, String birthDay, int group){
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

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public static void main(String[] args) {
		Contact ctt = new Contact();

		ctt.phoneNumber = "010-0000-0000";
		printAll(ctt);
		
		ctt.phoneNumber = "323-2132-1234";
		printAll(ctt);
		
		
	}
	
	static void printAll(Contact ctt){
		System.out.println(ctt.name);
		System.out.println(ctt.birthDay);
		System.out.println(ctt.email);
		System.out.println(ctt.adress);
		System.out.println(ctt.phoneNumber);
		System.out.println(ctt.group);
	}
}
