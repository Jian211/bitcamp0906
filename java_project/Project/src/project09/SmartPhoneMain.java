package project09;

public class SmartPhoneMain {

	public static void main(String[] args) throws Exception {
		SmartPhone sp = new SmartPhone();
		Thread tr = new Thread(sp);
		tr.start();	// 자동으로 run()을 실행
		
		boolean coin = true;
		
		if(!sp.existsFolder()) { 	// 폴더가 존재하는지 체크 
			sp.makeFolder();		// 없으면 생성
		}
		// 파일 셋팅하는 쓰레드 처리
		
		
		
		while(coin) {
			try {
				tr.join();
				showMenu();
				
				int menuNum = Integer.parseInt(SmartPhone.sc.nextLine());
				
				switch (menuNum) {
				
				case 1:
					System.out.println("연락처 입력.");
					sp.insertDataInfo();
					break;
				case 2: // 연락처 검색
					System.out.println("연락처 검색.");
					sp.searchDataInfo();
					break;
				case 3: // 연락처 수정
					System.out.println("연락처 수정.");
					sp.editDataInfo();
					break;
				case 4:
					System.out.println("연락처 삭제.");
					sp.removeDataInfo();
					break;
				case 5:
					System.out.println("연락처 전체 리스트 보기.");
					sp.showData();
					break;
				case 6:
					// 쓰레드 (동기화처리를 해야하는데 )
					System.out.println("파일 저장.");
					sp.exportData();
					break;
				case 7:
					System.out.println("파일 불러오기.");
					sp.importData();
					break;
				case 8:
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
		System.out.println("4. 연락처 삭제");
		System.out.println("5. 연락처 전체 리스트 보기");
		System.out.println("6. 파일 저장");
		System.out.println("7. 파일 불러오기");
		System.out.println("8. 종료");
		System.out.println(">>> 메뉴를 선택하세요");
	}
}
