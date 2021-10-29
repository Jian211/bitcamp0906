package project09;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ExportData implements Runnable {

	String fileNameForm = fileName+"\\"+ getDateinfo()+"contact.ser";	// 형식된 파일명 저장하기.
	FileOutputStream fos = new FileOutputStream(fileNameForm);
	ObjectOutputStream out = new ObjectOutputStream(fos);				// 파일 저장하기위한 생성자.
	
	
	public void run() {
		// 저장 파일을 받아서  > 현제ㅐ의 리스트를 저장
		
		public void exportData() throws IOException {	// 현재 리스트에 있는 데이터 저장하기 ( 직렬화  )
			//synchronized (this) {			// 동기화 했지만 잘 모르겠다.. *#$*@(%@*$(!*#$)!@*)$
				
				for( Contact c : arr ) {	// 현재의 리스트 받아오기 
					out.writeObject(c);		// 폴더에 저장.
				}
				out.close();
			//}
			System.out.println("[export 완료]");
		}
		
	}
	
}
