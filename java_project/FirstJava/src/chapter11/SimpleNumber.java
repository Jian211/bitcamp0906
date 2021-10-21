package chapter11;

public class SimpleNumber {

	int num;
	
	public SimpleNumber(int num) {
		this.num = num;
	}

	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;

		SimpleNumber sn = (SimpleNumber) obj;
		if(sn.num == this.num) {
			result = true;
		}
		
		return result;
	}



	@Override
	public int hashCode() {
		return this.num % 10;  // 3으로 나누는 이유
	}



	@Override
	public String toString() {
		return String.valueOf(num);
	}
	
}
