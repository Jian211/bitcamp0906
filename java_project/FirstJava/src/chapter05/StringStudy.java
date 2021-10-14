package chapter05;

public class StringStudy {
	
	public static void main(String[] args) {
		// 문제 역순으로 출력하라
		String str = "ABCDEFGHIJKLMN";
		String result = ""; 
		StringBuilder str12 = new StringBuilder("ABCDEFGHIJKLMN");
		
		for (int i = str.length()-1; i >= 0; i--) {
			result += str.charAt(i);
		}
		
		str12 = str12.reverse();
		
		System.out.println(result);
		System.out.println(str12);
		
		
		// 중간에 삽입된 -를 뺀 String 인스턴스를 생성하라
		String str1 = "999999-9999999";
		StringBuilder str11 = new StringBuilder(str1);
		//str1 = str1.replace("-", "");
		//String result1 = str1.substring(0,6) + str1.substring(8);
		int index = str11.indexOf("-");
		str11.deleteCharAt(index);
		
		
		//-----------------------------------
		
		//스트링빌더와 버퍼는 문자 생성과 편집을 가능하게 해준다.
		StringBuilder strBuf = new StringBuilder("AB");
		
		strBuf.append(25); // AB25
		
		
		
	}
}
