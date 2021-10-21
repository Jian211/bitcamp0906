package project06;

public class SmartPhoneMain {

	public static void main(String[] args) throws Exception{
		SmartPhone sp = new SmartPhone();
		boolean coin = true;
		while(coin) {
			try {
				showMenu();
				
				int menuNum = Integer.parseInt(SmartPhone.sc.nextLine());
				
				switch (menuNum) {
				case 1:
					System.out.println("연락처 입력.");
					sp.insertData();
					break;
				case 2: // 연락처 검색
					System.out.println("연락처 검색.");
					sp.searchData();
					break;
				case 3: // 연락처 수정
					System.out.println("연락처 수정.");
					sp.editData();
					break;
				case 4:
					System.out.println("연락처 삭제.");
					sp.removeData();
					break;
				case 5:
					System.out.println("연락처 전체 리스트 보기.");
					sp.showData();
					break;
				case 6:
					System.out.println("종료.");
					return;
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				coin = true;
			}
		}
	}
	
	private static void showMenu() {
		System.out.println("==================");
		System.out.println("1. 연락처 입력");
		System.out.println("2. 연락처 검색");
		System.out.println("3. 연락처 수정");
		System.out.println("4. 데이터 삭제");
		System.out.println("5. 모든데이터 출력");
		System.out.println("6. 종료");
		System.out.println("==================");
	}
}
