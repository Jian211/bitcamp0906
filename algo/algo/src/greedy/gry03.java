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
	private static int test(String a) {
		// 0�� 1�� ���ϸ� ���� ���� 0�̰ų� Ȥ�� 1�̸� ������ ���ϱ� 
		int result = 0;
		int i = 1;
		int fir = a.charAt(i - 1) - 48;
		
		while( i < a.length()) {
			int sec = a.charAt(i) - 48;
			
			if(sec > 1) {		// �̷��� 0�� 1�� �ƴϴ�.  �׷��� ���ص� �ȴٴ� ��
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