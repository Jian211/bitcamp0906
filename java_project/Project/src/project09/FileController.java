package project09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class FileController {
	private File contactFile;
	private Calendar cal;			
	private String fileName = "contact";
	private String route = "C:\\Users\\Jian\\Documents\\bitcamp0906\\java_project\\Project";	// 저장 라우트 설정

	public FileController(){
		contactFile = new File(route,fileName);	// 파일 경로  및 폴더 이름.
		cal = Calendar.getInstance();
	}
	
	// 저장된 파일 불러오기.
	public ArrayList<Contact> importData() {
		ArrayList<Contact> temp = new ArrayList<Contact>();
		ObjectInputStream in = null;

		try {
			FileInputStream fis = new FileInputStream(fileName+"\\"+getLastSavedFile());
			in = new ObjectInputStream(fis);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		while(true) {
			try {
				temp.add((Contact)in.readObject());
			} catch (Exception e) {
				break; // 더이상 파일이 없다는 것
			}
		}
		
		return temp;
	}
	
	public String getDateinfo() {				// 파일 이름 저장 형식
		// 파일 이름 형식  년월일시분초contactData 
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.valueOf(cal.get(Calendar.MONTH)+1);
		String date = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		String hour = String.valueOf(cal.get(Calendar.HOUR));
		String min = String.valueOf(cal.get(Calendar.MINUTE));
		String second = String.valueOf(cal.get(Calendar.SECOND));
		return year+"_"+month+"_"+date+"_"+hour+"_"+min+"_"+second; 
	}
	
	public void exportData(ArrayList<Contact> arr)  {		// 현재 리스트에 있는 데이터 저장하기 ( 직렬화  )
		String fileNameForm = fileName+"\\"+ getDateinfo()+"contact.ser";	// 형식된 파일명 저장하기.

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileNameForm));
			
			for( Contact c : arr ) {	
				out.writeObject(c);
			}

			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("[export 완료]");
	}

	public String getLastSavedFile() {		// contact 폴더에서 최근파일(마지막 파일)가지고오기
		String [] arr = contactFile.list();
		return arr[arr.length-1];
	}
	
	public boolean existsFolder() {   	// contact 폴더 존재여부
		boolean result = false;
		if(contactFile.exists()) {	 	
			result = true;
		}
		return result;
	}

	public void makeFolder() {			// contact 폴더 생성
		contactFile.mkdir();
		System.out.println("[내가보기]  파일경로 : "+contactFile);
		System.out.println("[내가보기]  "+"폴더 생성이 완료되었습니다.");
	}
	
}
