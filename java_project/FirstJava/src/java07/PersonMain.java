package java07;

public class PersonMain {

	public static void main(String[] args) {
		//메인메소드만들것
		Person p1 = new Male("철갑이",930101);
		Person p2 = new Female("손순이",980101);
		
		p1.print();
		p2.print();
	}
}
