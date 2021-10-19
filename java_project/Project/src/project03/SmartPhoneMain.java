package project03;

public class SmartPhoneMain {

	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone();
		
		while(true) {
			showMenu();
			
			int menuNum = Integer.parseInt(SmartPhone.sc.nextLine());
			
			switch (menuNum) {
			case 1:
				System.out.println("데이터를 생성하겠습니다.");
				sp.insertData();
				break;
			case 2:
				System.out.println("데이터를 수정하겠습니다.");
				sp.editData();
				break;
			case 3:
				System.out.println("데이터를 삭제하겠습니다.");
				sp.removeData();
				break;
			case 4:
				System.out.println("모든 데이터를 출력하겠습니다.");
				sp.showData();
				break;
			case 5:
				System.out.println("종료하겠습니다.");
				return;
			default:
				break;
			}
			
		}
	}

	private static void showMenu() {
		System.out.println("-----------------");
		System.out.println("1. 데이터 생성");
		System.out.println("2. 데이터 수정");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 모든데이터 출력");
		System.out.println("5. 종료");
		System.out.println("번호를 입력해주세요. >");
		System.out.println("-----------------");
	}
}
