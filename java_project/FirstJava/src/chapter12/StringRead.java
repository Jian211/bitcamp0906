package chapter12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class StringRead {
	
	public static void main(String[] args) throws IOException {
		
		Reader reader = new FileReader("String.txt");
		BufferedReader in = new BufferedReader(reader);

		// 한라인의 문자열을 받을 변수
		String str;
		
		while(true) {
			str = in.readLine();

			if(str == null) {
				break;
			}
			System.out.println(str);
		}
		
		
	}
}
