package permutations;

/*
	�����̶�
	���� �ٸ� n��  �� r���� ��� ������ ����� ������ ����� ��.
	
	���� n = {"A","B","C"}  �� 3��
	r = 2���� ��� ����
	
	nPr = n(n-r+1)  ����!
*/


public class Permutation {
	public static void main(String[] args) {
		// ���� ������

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
