package greedy;

public class gry03 {
/* 
#   곱하기 혹은 더하기 
#   각 자리가 숫자 ( 0 ~ 9 )로만 이루어진 문자열 S가 주어졌을 때,
#   왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하며 숫자 사이에
#   'x' or '+' 연산자를 넣어 결과적으로 만들어질 수 있는 가장 큰 수를 구하는
#   프로그램을 작성하시오
#   단, + 보다 x를 먼저 계산하는 일반적인 방식과는 달리, 모든 연산은 왼쪽에서
#   부터 순서대로 이루어진다고 가정합시다.

#   예를 들어 02984라는 문자열로 만들 수 있는 가장 큰수는((((0+2)*9)*8)*4) 입니다
 
 */
	private static int test(String a) {
		// 0과 1은 곱하면 손해 값이 0이거나 혹은 1이면 무조껀 더하기 
		int result = 0;
		int i = 1;
		int fir = a.charAt(i - 1) - 48;
		
		while( i < a.length()) {
			int sec = a.charAt(i) - 48;
			
			if(sec > 1) {		// 이러면 0과 1은 아니다.  그러면 곱해도 된다는 뜻
				fir = fir * sec;
			} else {
				fir = fir + sec;
			}
			i++;
			result += fir;
		}
		return result;
	}

	public static void main(String[] args) {
		String a = "02984";
		String b = "12984";
		System.out.println(test(a));
		System.out.println(test(b));
	}
}