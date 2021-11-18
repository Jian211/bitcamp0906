package free;

public class Enitec_CodingTest {

	public static char[] keys = {'A', 'B', 'C', 'D', 'E'}; // �������� �Ǵ� ���ڹ迭
	
	public static void main(String args[]) {
	
		String example1 = getChangeString("A3D3D2B1C3A4");
		String example2 = getChangeString("D3A2B1C4");
		String example3 = getChangeString("A0B1C2D2E1");
		
		System.out.println(example1); // DBACAE �� ��µ˴ϴ�.
		System.out.println(example2); // BCCB �� ��µ˴ϴ�.
		System.out.println(example3); // ACEAA �� ��µ˴ϴ�.
	}

	
	public static String getChangeString(String target) {
		String result = "";
		
		for(int i = 1 ; i < target.length() ; i += 2 ) {
			int index =	chkChar(target.charAt(i-1)) + (target.charAt(i) - 48);		// �����ε��� + ���� = �ε��� 
			result += keys[index%5];
		}
		
		return result;
	}

	public static int chkChar(char c) {
		for (int i = 0; i < keys.length; i++) {
			if(keys[i] == c) {
				return i;
			}
		}
		return -1;
	}
	
}
