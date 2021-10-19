package chapter09;

import java.util.ArrayList;
import java.util.List;

public class WrapperTest {

	public static void main(String[] args) {

		Integer iValue1 = new Integer(11);
		Integer iValue2 = 11; 	// Auto Boxing : 기본형 데이터를 인스턴스로 만드는 것
		
		System.out.println("참조 변수의 비교"+(iValue1 == iValue2));
		System.out.println("값 비교"+iValue1.equals(iValue2));
	
		int num1 = iValue1; // Auto UnBoxing : 값을 꺼내는 행위
		int num2 = Integer.parseInt("11");
		System.out.println(Integer.valueOf("12"));

		
		// Collection 클래스들은 객체를 저장하는 목적으로 만들었다.
		List<Integer> list = new ArrayList<Integer>();
		list.add(11); 	// new Integer(11)를 자동으로 해주는것 Auto Boxing 
		
		String a = "aaa";
		
	}
}