package hash;

import java.util.HashMap;

/*

	전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
	전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
	
	구조대 : 119
	박준영 : 97 674 223
	지영석 : 11 9552 4421
	전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
	어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

	- 제한 사항 -
	phone_book의 길이는 1 이상 1,000,000 이하입니다.
	각 전화번호의 길이는 1 이상 20 이하입니다.
	같은 전화번호가 중복해서 들어있지 않습니다.

	

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

		String [] phone_book = {"119", "97674223", "11 95524421"};  // false 		어떤 번호가 접두어에 있다면 false
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
			
		// 가장 짧은거 넣고
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