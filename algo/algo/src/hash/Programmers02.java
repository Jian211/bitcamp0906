package hash;

import java.util.HashMap;

/*

	��ȭ��ȣ�ο� ���� ��ȭ��ȣ ��, �� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 �ִ��� Ȯ���Ϸ� �մϴ�.
	��ȭ��ȣ�� ������ ���� ���, ������ ��ȭ��ȣ�� �������� ��ȭ��ȣ�� ���λ��Դϴ�.
	
	������ : 119
	���ؿ� : 97 674 223
	������ : 11 9552 4421
	��ȭ��ȣ�ο� ���� ��ȭ��ȣ�� ���� �迭 phone_book �� solution �Լ��� �Ű������� �־��� ��,
	� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 ������ false�� �׷��� ������ true�� return �ϵ��� solution �Լ��� �ۼ����ּ���.

	- ���� ���� -
	phone_book�� ���̴� 1 �̻� 1,000,000 �����Դϴ�.
	�� ��ȭ��ȣ�� ���̴� 1 �̻� 20 �����Դϴ�.
	���� ��ȭ��ȣ�� �ߺ��ؼ� ������� �ʽ��ϴ�.

	

*/
class Solution1 {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		for(String s : )
		
		return answer;
	}
}
public class Programmers02 {
	public static void main(String[] args) {
		Solution1 so = new Solution1();

		String [] phone_book = {"119", "97674223", "11 95524421"};  // false 		� ��ȣ�� ���ξ �ִٸ� false
		//String [] phone_book = {"123","456","789"};				   // true;
		//String [] phone_book = {"12","123","1235","567","88"};     // false;
		so.solution(phone_book);
		//System.out.println(so.solution(phone_book));
	}

}

/*
	
		HashSet<String> hs = new HashSet<String>();
		for(String name : phone_book) {
			hs.add(name.replace(" ", ""));
		}
		System.out.println(hs.toString());
			
		// ���� ª���� �ְ�
		Arrays.sort(phone_book);
		for(String i : phone_book) {
			System.out.println(i);
		}
		
		int len = phone_book[0].length();
		String fir = phone_book[1].substring(0, len);
		String sec = phone_book[0];
		if(fir.equals(sec)) {
			answer = false;
		}


*/