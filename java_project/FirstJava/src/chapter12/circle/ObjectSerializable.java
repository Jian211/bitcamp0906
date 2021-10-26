package chapter12.circle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializable {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
		// 저장된 파일을 이용해서 인스턴스를 생성  >  복원
		// 복원시에는 저장 순서에 맞게 복원해야한다.
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"));
		
		// 복원 : 인스턴스 생성하고 반환
		Circle c1 = (Circle) in.readObject(); 
		Circle c2 = (Circle) in.readObject();
		String str = (String) in.readObject();
		in.close();
		
		c1.showCircleInfo();
		c2.showCircleInfo();
		System.out.println(str);
		
		
	}
}
