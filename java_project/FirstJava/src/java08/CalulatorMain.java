package java08;

public class CalulatorMain extends CalulatorImpl{
	
	@Override
	public long add(long n1, long n2) {
		// TODO Auto-generated method stub
		return super.add(n1, n2);
	}

	@Override
	public long substract(long n1, long n2) {
		// TODO Auto-generated method stub
		return super.substract(n1, n2);
	}

	@Override
	public long multiply(long n1, long n2) {
		// TODO Auto-generated method stub
		return super.multiply(n1, n2);
	}

	@Override
	public double divide(double n1, double n2) {
		// TODO Auto-generated method stub
		return super.divide(n1, n2);
	}

	
	public static void main(String[] args) {
		//CalulatorImpl capImpl = new CalulatorImpl(2,3);  인스턴스 생성불가
		Calulator cal = new CalulatorMain();
		CalulatorImpl cal2 = new CalulatorMain();
		CalulatorMain cal3 = new CalulatorMain();
		int n1 = 123;
		int n2 = 62;
		
		System.out.println(cal.add(n1, n2));
		System.out.println(cal2.add(n1, n2));
		System.out.println(cal3.add(n1, n2));
		
		
	}
}
