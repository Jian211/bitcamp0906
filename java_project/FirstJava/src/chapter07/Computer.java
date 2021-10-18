package chapter07;

public class Computer extends Product {

	
	Computer(int price) {
		super(price);
	}
	
	@Override
	public String toString() {
		// toString() : Object Class가 가지는 메소드
		return "Computer";
	}
}
