package greedy;
/*
	1�� �� ������ : ���� ����
	- ��� �� N�� �� �� ���� ������ �� ���� �� �ϳ��� �ݺ������� �����Ͽ� �����Ϸ����Ѵ�.
	  ��, �ι�° ������ N�� K�� ������ ������ ���� ������ �� �ִ�.
	  	1. N���� 1�� ����.
	  	2. N���� K�� ������.
	  	
	- N�� K�� �־����� N�� 1�� �� �� ���� 1�� Ȥ�� 2���� ������ �����ؾ��ϴ� �ּ� Ƚ���� ���ϴ� ���α׷�

 */

public class gry02 {

	public static void main(String[] args) {
		System.out.println(test(28,3));

	
	}

	private static int test(int n, int k ) {
		int result = 0;
		
		while(true) {
			int target = (n / k) * k;  					// �� ��������
			result +=  n - target;						//
			System.out.println("result >" +  result);
			n = target;
			System.out.println("n >" +  n);
			
			// N�� K���� ���� ��( ���̻� ���� �� ���� �� ) �ݺ��� Ż��
			if(n < k) break;
			
			// K�� ������ 
			result += 1;
			n /= k;
		}
		// ���������� ���� ���� ���Ͽ� 1�� ����
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