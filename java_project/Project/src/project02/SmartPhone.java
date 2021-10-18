package project02;

import java.util.Scanner;

public class SmartPhone {
	public static final Scanner sc = new Scanner(System.in);
	private Contact [] arr;
	private int cnt;
	// Contact 클래스의 인스턴스 10개를 저장할 수 있는 배열을 정의
	public SmartPhone() {
		arr = new Contact[10];
		cnt = 0;
	}
	
	// 배열에 인스턴스를 저장
	// + 비어있는 인덱스에 저장  > 인덱스 추출 메소드 생성
	public void insertData(Contact c) {
		arr[cnt++] = c;
	}
	
	public void insertData() {
		if(cnt >= 9) {
			System.out.println("저장공간이 부족합니다.");
		} else {
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
			int group = Integer.parseInt(sc.nextLine());
			
			insertData(new Contact(name, phoneNumber, email, adress, birthDay, group));
		}
	}
	
	public void editData() {
		if(arr[0] == null) {
			System.out.println("저장된 데이터가 없습니다.\n새로운데이터를 추가해주세요.");
		} else {
			System.out.println("수정하시려는 이름을 입력해주세요.");
			String name = sc.nextLine();
			
			int index = searchIndex(name);
			
			if(index == -1) {
				System.out.println("아이디의 정보가 없습니다.");
			} else {
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
				
				System.out.println("그룹을 입력해주세요.");
				arr[index].setGroup(Integer.parseInt(sc.nextLine()));
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
