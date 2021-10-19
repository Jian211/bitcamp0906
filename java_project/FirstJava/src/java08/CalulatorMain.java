package java08;

public class CalulatorMain extends CalulatorImpl{
	
	public static void main(String[] args) {
		Calulator cal = new CalulatorMain();

		int n1 = 123;
		int n2 = 62;
		
		System.out.println(cal.add(n1, n2));
		System.out.println(cal.divide(n1, n2));
		System.out.println(cal.substract(n1, n2));
		
		
	}
}
