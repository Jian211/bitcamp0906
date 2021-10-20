package project05;

/*
	SmartPhone 클래스에 있는 배열의 타입이 추상클래스로 되어도 문제가 없는 것을 확인 
*/
import java.util.Scanner;


public class SmartPhone {
	public static final Scanner sc = new Scanner(System.in);
	// 배열을 다형성의 특징을 이용하여, 하위 클래스의 인스턴스를 저장하는 형태로 작성
	private Contact [] arr;
	private int cnt;
	
	// Contact 클래스의 인스턴스 10개를 저장할 수 있는 배열을 정의
	public SmartPhone() {
		this(10);
	}
	
	public SmartPhone(int size) {
		arr = new Contact[size];
		cnt = 0;
	}
	
	// 배열에 인스턴스를 저장
	// + 비어있는 인덱스에 저장  > 인덱스 추출 메소드 생성
	public void insertDataInfo(Contact c) {
		arr[cnt++] = c;
	}
	
	public void insertData() {
		if(cnt >= 9) {
			System.out.println("저장공간이 부족합니다.");
		} else {
			System.out.println("거래처회사를 생성하시려면 1번, 회사의 데이터를 생성하시려면 2번을 입력하세요.");
			int userChoice = Integer.parseInt(sc.nextLine());

			System.out.println("이름을 입력해주세요.");
			String name = sc.nextLine();
			
			if(blackChk(name)) {
				System.out.println("공백없이 입력해주시기 바랍니다.");
				return;
			}
			
			System.out.println("이메일을 입력해주세요.");
			String email = sc.nextLine();
			
			System.out.println("핸드폰 번호를 입력해주세요.");
			String phoneNumber = sc.nextLine();
			
			if(phoneNumberChk(phoneNumber)) {
				System.out.println("존재하는 번호입니다.");
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
				
				insertDataInfo(new CustomerContact(name, phoneNumber, email, adress, birthDay, group, company, item, rank));
			} else {
				System.out.println("회사를 입력해주세요.");
				String company = sc.nextLine();

				System.out.println("부서를 입력해주세요.");
				String department = sc.nextLine();
				
				System.out.println("직급을 입력해주세요.");
				String rank = sc.nextLine();
				
				insertDataInfo(new CompanyContact(name, phoneNumber, email, adress, birthDay, group, company, department, rank));
			}
			
		}
	}
	
	public void editData() {
		if(arr[0] == null) {
			System.out.println("저장된 데이터가 없습니다.\n새로운데이터를 추가해주세요.");
			return;
		} 
		
		System.out.println("수정하시려는 이름을 입력해주세요.");
			
		String name = sc.nextLine();
		if(blackChk(name)) {
			System.out.println("공백없이 입력해주시기 바랍니다.");
			return;
		}
		
		int index = searchIndex(name);
		
		if(index == -1) {
			System.out.println("아이디의 정보가 없습니다.");
		} else {

			if(arr[index] instanceof CustomerContact) {
				CustomerContact temp = (CustomerContact)arr[index];
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

				System.out.println("거래 품목을 입력해주세요.");
				temp.setItem(sc.nextLine());

				System.out.println("직급을 입력해주세요.");
				temp.setRank(sc.nextLine());
			} else {
				CompanyContact temp = (CompanyContact)arr[index];
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
				
				insertDataInfo(temp);
			}
		}
		
	}
	
	//매개변수(name)로 배열 안에 있는 name들 중 같은 것을 찾아 인덱스 반환
	private int searchIndex(String name) {
		int index = -1;
		for (int i = 0; i < cnt; i++) {
			if(arr[i].getName().equals(name)){
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	public void removeData() {
		if(arr[0] == null) {
			System.out.println("저장된 데이터가 없습니다.");
		} else {
			System.out.println("삭제하시려는 이름을 입력해주세요.");
			String name = sc.nextLine();
			
			int index = searchIndex(name);
			
			if(index == -1) {
				System.out.println("아이디의 정보가 없습니다.");
			} else {
				for (int i = index; i < cnt; i++) {
					arr[i] = arr[i+1];
				}
				System.out.println("삭제되었습니다.");
			}
		}
	}
	
	public void showData() {
		if(arr[0] == null) {
			System.out.println("저장된 데이터가 없습니다.");
		} else {
			System.out.println("=========================");
			for (int i = 0; i < cnt; i++) {
				arr[i].print();
				System.out.println("----------------------");
			}
			System.out.println("=========================");
		}
	}

	public void searchData() {
		if(arr[0] == null) {
			System.out.println("저장된 데이터가 없습니다.");
		} else {
			System.out.println("검색하시려는 이름을 입력해주세요.");
			String name = sc.nextLine();
			
			int index = searchIndex(name);
			
			if(index == -1) {
				System.out.println("해당 데이터는 존재하지않습니다.");
			} else {
				arr[index].print();
			}
		}
	}

	public boolean blackChk(String bar) {
		// 32 = 아스키 코드로 공백을 나타냄;
		for (int i = 0; i < bar.length(); i++) {
			if(bar.charAt(i) == 32) {
				return true;  // 공백 O
			}
		}
		return false;
	}
	
	public boolean phoneNumberChk(String number) {
		for (int i = 0; i < cnt; i++) {
			if(arr[i].getPhoneNumber().equals(number)){
				return true;
			}
		}
		return false;
	}
	
}
