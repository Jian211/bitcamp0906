package chapter12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StringWriter {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedWriter out = new BufferedWriter(new FileWriter("String.txt",true));
		
		out.write("안녕하세요!!!!");
		out.newLine();
		out.write("날이 추워요!!!");
		out.newLine();
		out.write("으하하하하ㅏ!!!");
		out.newLine();
		out.write("날짜 = 2021-10-26");
		out.newLine();
		
		out.close();
		
	}
}
