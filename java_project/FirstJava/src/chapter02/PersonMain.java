package chapter02;

public class PersonMain {
	public static void main(String[] args) {
		Person person = new Person();
		
		person.setMember("Áö¸í±Ù");
		person.setPhoneNumber("010-5014-3407");
		person.setPersonalNumber(9999999999999L);
		
		System.out.println(person.getMember());
		System.out.println(person.getPhoneNumber());
		System.out.println(person.getPersonalNumber());
		
		person.printData();
	}
}
