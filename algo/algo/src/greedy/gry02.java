package greedy;
/*
	1이 될 때까지 : 문제 설명
	- 어떠한 수 N이 될 때 까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고한다.
	  단, 두번째 연산은 N이 K로 나누어 떨어질 때만 선택할 수 있다.
	  	1. N에서 1을 뺀다.
	  	2. N에서 K로 나눈다.
	  	
	- N과 K가 주어질때 N이 1이 될 때 까지 1번 혹은 2번의 과정을 수행해야하는 최소 횟수를 구하는 프로그램

 */

public class gry02 {

	public static void main(String[] args) {
		System.out.println(test(28,3));

	
	}

	private static int test(int n, int k ) {
		int result = 0;
		
		while(true) {
			int target = (n / k) * k;  					// 이 행위부터
			result +=  n - target;						//
			System.out.println("result >" +  result);
			n = target;
			System.out.println("n >" +  n);
			
			// N이 K보다 작을 때( 더이상 나눌 수 없을 때 ) 반복문 탈출
			if(n < k) break;
			
			// K로 나누기 
			result += 1;
			n /= k;
		}
		// 마지막으로 남은 수에 대하여 1씩 빼기
		result += (n - 1);
		
		return result;
	}
}

//	private static int test(int i, int j) {
//		int cnt = 0;
//		int sd = i;
//		int k = j;
//		
//		while(sd > 1) {
//			if(i > j) {
//				sd /= k;
//			} else {
//				sd--;
//			}
//			cnt++;
//		}
//		return cnt;
//	}