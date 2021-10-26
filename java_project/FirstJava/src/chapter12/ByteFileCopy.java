package chapter12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy {

	public static void main(String[] args) {

		try {
			// 프로그램에서 파일 복사
			// 프로그램이 파일 원본을 읽고  > 새로운 파일을 생성 (쓰기)
			// 원본 파일의 데이터를 읽기 위한 스트림 클래스 생성 : InputStream, FileInputStream
			
			InputStream in = new FileInputStream("LineInst.exe");	// 경로의 파일 읽기
			OutputStream out = new FileOutputStream("copy4.exe");	// 파일 경로에 쓰기
		
			// 필터 스트림  : 필터스트림을 사용하기 위해서는 기본 스트림이 필요하다.
			BufferedInputStream   bin = new BufferedInputStream(in,1024*2);	 // 2KB
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			int copyByte = 0; // 복사한 Byte size 계산
			int bData = -1;	  // Stream으로 부터 읽어온 byte단위의 data.
			
			while(true) {
				bData = bin.read(); // read data
				if(bData == -1) {
					break;
				}
				
				bout.write(bData);	// write Data
				copyByte++;
			}
			
			bin.close();
			bout.close();
			
			System.out.println("복사된 size는 "+ copyByte+"입니다.");
		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
}
