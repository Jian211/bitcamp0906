package chapter05;

public class MemberMain {
	public static void main(String[] args) {
		// 회원의 정보를 저장하는 프로그램
		// 데이터를 저장할 수 있는 구조(클래스) 만들었다.
		Member m1 = new Member("황희찬","010-5819-6254","축구",5,"Wolverhampton","2000.1.1.","런던");
		m1.showData();

		Member m2 = new Member("이강인", "023-1234-4567", "야구", 3, "laoflsdo@aladoawd");
		m2.showData();
	}
}
