package project03;

/*
1. Contact 클래스는 기본정보를 저장하고 기본 정보를 출력하는 
      메소드를 정의합니다.
	> 생성자를 통해 기본 정보들을 초기화 합니다.

2. 그룹에 해당하는 정보들을 추가적으로 정의하는 새로운 클래스들을 정의합니다.
      회사, 거래처의 정보를 저장하는 하위 클래스를 정의합니다.
    > CompanyContact 회사, 거래처의 정보를 저장하는 하위 클래스를 정의.
    	- 회사이름, 부서이름, 직급  변수추가
    	- 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 출력
    > CustomerContact 회사, 거래처의 정보를 저장하는 하위 클래스를 정의.
    	- 거래처 회사이름, 거래품목, 직급 변수 추가
    	- 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 출력
    	
3. SmartPhone 클래스의 배열을 다형성의 특징을 이용하여,
      상위 타입의 배열을 생서 후, 하위 클래스의 인스턴스를 저장하는 형태로 작성.

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
			
			System.out.println("이메일을 입력해주세요.");
			String email = sc.nextLine();
			
			System.out.println("핸드폰 번호를 입력해주세요.");
			String phoneNumber = sc.nextLine();
			
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
	
}
