package java11.console;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class FileMake {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		// 폴더 생성
		File newFile = new File("D:\\","hello"); // 경로 , 폴더이름

		if(!newFile.exists()) {		// 경로에 동일한 폴더이름이 없다면
			System.out.println("존재하지 않습니다.");
			System.out.println("파일을 생성하겠습니다.");
			newFile.mkdir();		// 파일 생성하기
		}
		
		/////////////////////////////////////////////////////////// -- 폴더 생성 완료
		// > 메모장 생성하기 
		
		String folderDir = "D:\\hello\\";	// 저장위치 변수로 생성
		
		System.out.println("메모의 제목을 입력해주세요.");
		String title = sc.nextLine();
		String time = String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
		BufferedWriter out = new BufferedWriter(new FileWriter(folderDir +title + time+".txt"));
		
		System.out.println("메모의 내용을 입력해주세요.");
		out.write(sc.nextLine());
		out.close();
	
		BufferedReader in = new BufferedReader(new FileReader(folderDir+title + time+".txt"));
		
		String str;
		while(true) {
			str = in.readLine();
			if(str == null) {
				break;
			}
			System.out.println(str);
		}
		
		in.close();
	}
}
