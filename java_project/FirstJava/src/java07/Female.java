package java07;

import java.util.Calendar;

public class Female extends Person{
	//추가적인 변수
	final String GENDER = "여성";
	
	Female(String name, int myNumber){
		super(name, myNumber);
	}
	
	@Override
	public void print() {
		int age = (Calendar.getInstance().get(Calendar.YEAR)%100 + 100 - MyNumber/10000 );
		System.out.println("안녕하세요. 저는 "+name
				+"("+GENDER+")"
				+"입니다. "
				+ age
				+ "살 입니다.");
	}
}
