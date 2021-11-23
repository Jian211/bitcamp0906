package free;

/*
	1이 될 때까지
	
 
 */

public class free02 {
	public static void main(String[] args) {
		
		System.out.println(test(25,5));
		
	}

	private static int test(int i, int j) {
		int cnt = 0;
		int sd = i;
		int k = j;
		
		while(sd > 1) {
			if(i > j) {
				sd /= k;
			} else {
				sd--;
			}
			cnt++;
		}
		return cnt;
	}
}
