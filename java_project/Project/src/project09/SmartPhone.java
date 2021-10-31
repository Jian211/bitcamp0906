package project09;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SmartPhone {
	public static final Scanner sc = new Scanner(System.in);
	private ArrayList<Contact> arr;
	private FileController fileController;
	
	private String regexName = "[a-zA-Z가-힣]+";										// 유저 이름  규칙정의
	private String regexPhoneNumber = "[0-9]{2,3}[ -]*[0-9]{3,4}[ -]*[0-9]{4}";		// 유저 핸드폰번호  규칙정의
	
	
	public SmartPhone() throws Exception, IOException{
		fileController = new FileController();
		//arr = fileController.importData(); 
	}
	
	// [ file load & save ]  project 8 + 9   /////////////////////////////////
	
	public void handleImportData() {
		arr = fileController.importData();
	}
	
	public void handleExportData(){  		// save date in "Contact" file
		fileController.exportData(arr);
	}
	
	////////////////////////////////////////////////////////////////////////
	
	
	
	// 배열에 요소를 추가하는 메소드 : 참조값을 전달 받아 배열에 추가하는 기능
	public void insertData(Contact c) {
		arr.add(c);
	}
	
	// 사용자로 부터 데이터를 받아 Contact 객체를 생성하고 배열에 참조값을 저장하는 기능
	public void insertDataInfo() {
		System.out.println("거래처회사를 생성하시려면 1번, 회사의 데이터를 생성하시려면 2번을 입력하세요.");
		int userChoice = Integer.parseInt(sc.nextLine());

		System.out.println("이름을 입력해주세요.");
		String name = nameChk(sc.nextLine());
		
		System.out.println("이메일을 입력해주세요.");
		String email = sc.nextLine();
		
		System.out.println("핸드폰 번호를 입력해주세요.\nex 01012345678");
		String phoneNumber = phoneFormChk(sc.nextLine()); // 번호예외처리
		
		if(phoneNumberChk(phoneNumber)) { // 번호중복예외처리
			System.out.println("중복된 번호가 입력되었습니다. 처음부터 다시입력해주세요.");
			return;
		}
		
		System.out.println("생일을 입력해주세요.");
		int birthDay = Integer.parseInt(sc.nextLine());
		
		System.out.println("주소를 입력해주세요.");
		String adress = sc.nextLine();
		
		System.out.println("그룹을 입력해주세요.");
		String group = sc.nextLine();
		
		if(userChoice == 1) {
			System.out.println("회사를 입력해주세요.");
			String company = sc.nextLine();

			System.out.println("거래 품목을 입력해주세요.");
			String item = sc.nextLine();
			
			System.out.println("직급을 입력해주세요.");
			String rank = sc.nextLine();
			
			insertData(new CustomerContact(name, phoneNumber, email, adress, birthDay, group, company, item, rank));
		} else {
			System.out.println("회사를 입력해주세요.");
			String company = sc.nextLine();

			System.out.println("부서를 입력해주세요.");
			String department = sc.nextLine();
			
			System.out.println("직급을 입력해주세요.");
			String rank = sc.nextLine();
			
			insertData(new CompanyContact(name, phoneNumber, email, adress, birthDay, group, company, department, rank));
		}
			
	}
	
	//이름으로 검색 > 데이터 수정 : 수정할 데이터를 받아서 처리
	public void editDataInfo() {
		if(arr.size() == 0) {
			System.out.println("저장된 데이터가 없습니다.\n새로운데이터를 추가해주세요.");
			return;
		} 
		
		System.out.println("수정하시려는 이름을 입력해주세요.");
		
		String name = nameChk(sc.nextLine());
		int index = searchIndex(name);
		if(index < 0 ) {
			System.out.println("찾으시는 "+name+"의 정보가 존재하지 않습니다.");
		} else {
			System.out.println("데이터 수정을 위해 각각의 요소를 입력해주세요.");
			
			if(arr.get(index) instanceof CustomerContact) {
				CustomerContact temp = (CustomerContact)arr.get(index);
				System.out.println("이름을 입력해주세요.");
				temp.setName(nameChk(sc.nextLine()));
				
				System.out.println("이메일을 입력해주세요.");
				temp.setEmail(sc.nextLine());
				
				System.out.println("핸드폰 번호를 입력해주세요.\nex : 000-0000-0000");
				String phoneNumber = phoneFormChk(sc.nextLine()); // 번호예외처리
				if(phoneNumberChk(phoneNumber)) { 				  // 번호중복예외처리
					return;
				}
				temp.setPhoneNumber(phoneNumber);
				
				System.out.println("생일을 입력해주세요.");
				temp.setBirthDay(Integer.parseInt(sc.nextLine()));
				
				System.out.println("주소를 입력해주세요.");
				temp.setAdress(sc.nextLine());
				
				System.out.println("그룹을 입력해주세요.");
				temp.setGroup(sc.nextLine());
				
				System.out.println("회사를 입력해주세요.");
				temp.setCompany(sc.nextLine());

				System.out.println("거래 품목을 입력해주세요.");
				temp.setItem(sc.nextLine());

				System.out.println("직급을 입력해주세요.");
				temp.setRank(sc.nextLine());
				
				insertData(temp);
				
			} else {
				CompanyContact temp = (CompanyContact)arr.get(index);
				System.out.println("이름을 입력해주세요.");
				temp.setName(sc.nextLine());
				
				System.out.println("이메일을 입력해주세요.");
				temp.setEmail(sc.nextLine());
				
				System.out.println("핸드폰 번호를 입력해주세요.");
				temp.setPhoneNumber(sc.nextLine());
				
				System.out.println("생일을 입력해주세요.");
				temp.setBirthDay(Integer.parseInt(sc.nextLine()));
				
				System.out.println("주소를 입력해주세요.");
				temp.setAdress(sc.nextLine());
				
				System.out.println("그룹을 입력해주세요.");
				temp.setGroup(sc.nextLine());
				
				System.out.println("회사를 입력해주세요.");
				temp.setCompany(sc.nextLine());

				System.out.println("부서를 입력해주세요.");
				temp.setDepartment(sc.nextLine());

				System.out.println("직급을 입력해주세요.");
				temp.setRank(sc.nextLine());
				
				insertData(temp);
			}
		}
		
	}
	
	//매개변수(name)로 배열 안에 있는 name들 중 같은 것을 찾아 인덱스 반환
	private int searchIndex(String name) {
		int index = -1;
		
		for(Contact c : arr) {
			if(c.getName().equals(name)) {
				index = arr.indexOf(c);
				break;
			}
		}
		return index;
	}
	
	public void removeDataInfo() {
		if(arr.size() == 0 ) {
			System.out.println("저장된 데이터가 없습니다.");
		} else {
			System.out.println("데이터를 삭제를 시작하겠습니다. ");
			System.out.println("삭제하시려는 이름을 입력해주세요.");

			String name = sc.nextLine();
			
			int index = searchIndex(name);
			
			if(index < 0) {
				System.out.println("삭제하려고하는 "+name + "의 정보가 없습니다.");
			} else {
				arr.remove(index);
				System.out.println(name +"이 삭제되었습니다.");
			}
		}
	}
	
	public void showData() {
		if(arr.size() == 0) {
			System.out.println("저장된 데이터가 없습니다.");
		} else {
			for(Contact c : arr) {
				System.out.println("=========================");
				c.print();
				System.out.println("=========================");
			}
		}
	}

	public void searchDataInfo() {
		if(arr.size() == 0) {
			System.out.println("저장된 데이터가 없습니다.");
		} else {
			System.out.println("검색하시려는 이름을 입력해주세요.");
			String name = sc.nextLine();
			
			int index = searchIndex(name);
			
			if(index < 0) {
				System.out.println("해당 데이터는 존재하지않습니다.");
			} else {
				arr.get(index).print();
			}
		}
	}
	
	private String phoneFormChk(String phoneNumber) {
		boolean chk = phoneNumber.matches(regexPhoneNumber);
		while(!chk) {
			try {
				throw new Exception("숫자만 다시 입력해주세요.");
			} catch (Exception e) {
				e.getMessage();
			} finally {
				phoneNumber = sc.nextLine();
				chk = phoneNumber.matches(regexPhoneNumber);
			}
		}
		return phoneNumber;
	}
	
	private String nameChk(String name) {
		boolean chk = name.matches(regexName); // 한영체크
		chk = !blankChk(name); // 공백체크

		while(!chk) {
			try {
				throw new Exception("공백없이 한글,영어만 다시 입력해주세요.");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				name = sc.nextLine();
				chk = name.matches(regexName);
				chk = !blankChk(name); 
			}
		}
		return name;
	}

	public boolean blankChk(String bar) {
		// 32 = 아스키 코드로 공백을 나타냄
		for (int i = 0; i < bar.length(); i++) {
			if(bar.charAt(i) == 32) {
				return true;
			}
		}
		return false;
	}
	
	public boolean phoneNumberChk(String number) {
		boolean result = false;
		for(Contact cn : arr) {
			if(cn.getPhoneNumber().equals(number)) {
				System.out.println("이미 존재하는 번호입니다.");
				result = true;
			}
		}
		return result;
	}
	
	
	
}
