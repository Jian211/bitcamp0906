package greedy;

public class gry03 {
/* 
#   ���ϱ� Ȥ�� ���ϱ� 
#   �� �ڸ��� ���� ( 0 ~ 9 )�θ� �̷���� ���ڿ� S�� �־����� ��,
#   ���ʺ��� ���������� �ϳ��� ��� ���ڸ� Ȯ���ϸ� ���� ���̿�
#   'x' or '+' �����ڸ� �־� ��������� ������� �� �ִ� ���� ū ���� ���ϴ�
#   ���α׷��� �ۼ��Ͻÿ�
#   ��, + ���� x�� ���� ����ϴ� �Ϲ����� ��İ��� �޸�, ��� ������ ���ʿ���
#   ���� ������� �̷�����ٰ� �����սô�.

#   ���� ��� 02984��� ���ڿ��� ���� �� �ִ� ���� ū����((((0+2)*9)*8)*4) �Դϴ�
 
 */
	public static void main(String[] args) {
		String a = "02984";
		String b = "567";
		
		System.out.println(test(a));
		System.out.println(test(b));
	}

	private static int test(String a) {
		int result = a.charAt(0) - 48;

		for (int i = 1; i < a.length(); i++) {
			if(result <= 1 || a.charAt(i) - 48 <= 1) {
				result += a.charAt(i) - 48;
			} else {
				result *= a.charAt(i) - 48;
			}
		}
		return result;
	}
}
/*
	private static int test(String a) {
		int num = a.charAt(0) - 48;
		a = a.substring(1);

		return test01(a, num);
	}

	private static int test01 (String a, int num) {
		int nextNum = num;

		if(num < 2) {
			nextNum = (a.charAt(0) - 48) + num;
		} else {
			nextNum = (a.charAt(0) - 48) * num;
		}
		a = a.substring(1);

		if(a.length() == 0) {
			return nextNum;
		}
		
		return test01(a, nextNum);
	
	}
 */