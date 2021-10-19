package java08;

public abstract class CalulatorImpl implements Calulator{
	// 추상클래스 정의
	long n1;
	long n2;
	
	public CalulatorImpl() {
		n1 = 1;
		n2 = 2;
	}

	public CalulatorImpl(long n1, long n2) {
		this.n1 = n1;
		this.n2 = n2;
	}

	@Override
	public long add(long n1, long n2) {
		return n1 + n2;
	}

	@Override
	public long substract(long n1, long n2) {
		return n1 - n2;
	}

	@Override
	public long multiply(long n1, long n2) {
		return n1 * n2;
	}

	@Override
	public double divide(double n1, double n2) {
		return n1 / n2;
	}
	
	
}
