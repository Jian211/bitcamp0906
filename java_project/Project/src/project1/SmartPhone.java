package project1;

import java.util.Scanner;

public class SmartPhone {
	// Contact 클래스의 인스턴스 10개를 저장할 수 있는 배열을 정의
	Contact [] arr = new Contact[10];
	
	
	// 배열에 인스턴스를 저장
	// + 비어있는 인덱스에 저장  > 인덱스 추출 메소드 생성
	void add(Contact c) {
		int index = getEmptyIndex();
		if(index == -1) {
			System.out.println("저장공간이 부족합니다.");
		} else {
			arr[index] = c;
		}
	}

	// 비어있는 인덱스 추출
	int getEmptyIndex() {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == null) {	
				return i;
			}
		}
		return -1;
	}
	
	// 배열에 인스턴스 수정
	void edit(int index, Contact c) {
		arr[index] = c;
	}
	
	// 배열에 인스턴스 삭제
	void remove(int index) {
		arr[index] = null;
	}
	
	// 저장된 데이터 출력
	void printAll() {
		for (int i = 0; i < arr.length; i++) {
			arr[i].print();
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Smartphone 클래스의 인스턴스 생성
		SmartPhone smartPhone = new SmartPhone();
		
		// 사용자로부터 입력을 받아, Contact 인스턴스를 생성해서
		// SmartPhone 클래스의 인스턴스가 가지고 있는 배열에 추가
		Contact user = new Contact();
		
		System.out.print("\nName > ");
		user.setName(scanner.nextLine());
		
		System.out.print("\naddress > ");
		user.setAdress(scanner.nextLine());
		
		System.out.print("\nBirth Day > ");
		user.setBirthDay(scanner.nextInt());
		
		System.out.print("\nEmail > ");
		user.setEmail(scanner.nextLine());
		
		System.out.print("\nGroup > ");
		user.setGroup(scanner.nextInt());
		
		System.out.print("\nPhone number > ");
		user.setPhoneNumber(scanner.nextLine());
		
		smartPhone.add(user);
		
		// 10번 반복하기
		for (int i = 0; i < 10; i++) {
			smartPhone.add(new Contact());
		}
		
		// 배열의 모든 요소를 출력
		smartPhone.printAll();
		
		// 배욜의 모든 요소를 검색
		// ??
		
		// 배열의 요소를 삭제
		System.out.println("삭제하실 번호를 입력해주세요.");
		int index = scanner.nextInt() - 1;
		smartPhone.remove(index);
		
		// 배열의 요소를 수정
		System.out.println("수정하실 번호를 입력해주세요.");
		index = scanner.nextInt() - 1;
		
		Contact c2 = new Contact();
		
		System.out.print("\nName > ");
		c2.setName(scanner.nextLine());
		
		System.out.print("\naddress > ");
		c2.setAdress(scanner.nextLine());
		
		System.out.print("\nBirth Day > ");
		c2.setBirthDay(scanner.nextInt());
		
		System.out.print("\nEmail > ");
		c2.setEmail(scanner.nextLine());
		
		System.out.print("\nGroup > ");
		c2.setGroup(scanner.nextInt());
		
		System.out.print("\nPhone number > ");
		c2.setPhoneNumber(scanner.nextLine());
		smartPhone.edit(index, c2);
	}
	
}
