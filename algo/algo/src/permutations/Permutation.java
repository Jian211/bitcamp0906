package permutations;

/*
	순열이란
	서로 다른 n개  중 r개를 골라 순서를 고려해 나열한 경우의 수.
	
	만약 n = {"A","B","C"}  총 3개
	r = 2개를 골라 나열
	
	nPr = n(n-r+1)  공식!
*/


public class Permutation {
	public static void main(String[] args) {
		// 순열 만들어보기

		char [] carr = {'A','B','C','D','E'};

		test(carr,3);
	}
	
	
	public static void test (char [] n, int r) {
		
		for (int i = 0; i < n.length; i++) {
			char a = n[i];
			for (int j = 1; j < n.length - 1; j++) {
				System.out.println(a + n[j]);
			}
			
		}

	}
}
