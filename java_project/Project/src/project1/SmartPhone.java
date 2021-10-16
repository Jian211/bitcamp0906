package project1;

import java.util.Scanner;

public class SmartPhone {
	public static final Scanner sc = new Scanner(System.in);
	
	// Contact 클래스의 인스턴스 10개를 저장할 수 있는 배열을 정의
	Contact [] arr = new Contact[10];
	
	
	// 배열에 인스턴스를 저장
	// + 비어있는 인덱스에 저장  > 인덱스 추출 메소드 생성
	void insertData() {
		if(arr[9] != null) {
			System.out.println("저장공간이 부족합니다.");
		} else {
			Contact temp = new Contact();
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
			
			if(getEmptyIndex() == -1) {
				arr[0] = temp;
			} else {
				arr[getEmptyIndex()-1] = temp;
			}
		}
	}
	private void insertDate(int index) {

		System.out.println("이름을 입력해주세요.");
		arr[index].setName(sc.nextLine());

		System.out.println("이메일을 입력해주세요.");
		arr[index].setEmail(sc.nextLine());

		System.out.println("핸드폰 번호를 입력해주세요.");
		arr[index].setPhoneNumber(sc.nextLine());

		System.out.println("생일을 입력해주세요.");
		arr[index].setBirthDay(Integer.parseInt(sc.nextLine()));

		System.out.println("주소를 입력해주세요.");
		arr[index].setAdress(sc.nextLine());
	}
	
	public void editData() {
		if(checkNull()) {
			System.out.println("저장된 데이터가 없습니다.\n새로운데이터를 추가해주세요.");
		} else {
			System.out.println("수정하시려는 이름을 입력해주세요.");
			String name = sc.nextLine();
			
			int index = searchIndex(name);
			
			if(index == -1) {
				System.out.println("아이디의 정보가 없습니다.");
			} else {
				insertDate(index);
			}
		}
		
	}
	
	//매개변수(name)로 배열 안에 있는 name들 중 같은 것을 찾아 인덱스 반환
	private int searchIndex(String name) {
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].getName().equals(name)){
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	private int getEmptyIndex() {
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] != null) {	
				index = i;
			}
		}
		return index;
	}
	//배열 비었는지 확인
	private boolean checkNull() {
		if(arr[0] == null) {
			return true;
		}
		return false;
	}
	
	public void removeData() {
		if(checkNull()) {
			System.out.println("저장된 데이터가 없습니다.");
		} else {
			System.out.println("삭제하시려는 이름을 입력해주세요.");
			String name = sc.nextLine();
			
			int index = searchIndex(name);
			
			if(index == -1) {
				System.out.println("아이디의 정보가 없습니다.");
			} else {
				int lenght = getEmptyIndex() -1;  // 값이 있는 배열의 길이
				for (int i = index; i < lenght-1; i++) {
					arr[i] = arr[i+1];
				}
				System.out.println("삭제되었습니다.");
			}
		}
		
	}
	
	public void showData() {
		if(checkNull()) {
			System.out.println("저장된 데이터가 없습니다.");
		} else {
			for (int i = 0; i < getEmptyIndex(); i++) {
				arr[i].print();
			}
		}
	}
	
}
