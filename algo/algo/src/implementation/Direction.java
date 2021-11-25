package implementation;

/*
	���డ A�� N * N ũ���� ���簢�� ���� ���� �� �ֽ��ϴ�. 
	�� ������ 1 * 1 ũ���� ���簢������ �������� �ֽ��ϴ�.
	���� ���� �� ��ǥ�� (1,1)�̸�, ���� ������ �Ʒ� ��ǥ�� (N, N)�� �ش��մϴ�.
	
	���డ A�� �� �� �� �� �������� �̵��� �� ������, ���� ��ǥ�� �׻� (1, 1) �Դϴ�. 
	�츮 �տ��� ���డ A�� �̵��� ��ȹ�� ���� ��ȹ���� ���� �ֽ��ϴ�.
	
	��ȹ������ �ϳ��� �ٿ� ���⸦ �������� �Ͽ� L, R, U, D �� �ϳ��� ���ڰ� �ݺ������� ���� �ֽ��ϴ�.
	�� ������ �ǹ̴� ������ �����ϴ�.
	
	L : �������� ��ĭ �̵�
	R : ���������� �� ĭ �̵�
	U : ���� �� ĭ �̵�
	D : �Ʒ��� �� ĭ �̵�
 	
 	�̶� ���డ A�� N * N ũ���� ���簢�� ������ ����� �������� ���õ˴ϴ�. 
 	���� ��� (1, 1)�� ��ġ���� 	L Ȥ�� U�� ������ ���õ˴ϴ�.
 	������ N = 5�� ������ ��ȹ���Դϴ�.

 	�Է� ���� 5 	R R R U D D 
 	��� ���� 3,4
 
 */

public class Direction {

	public static void main(String[] args) {
		String[] arr = {"R","R","R","U","D","D"};		

		int n = 5;	//	���� ũ��
		int x = 1;	// 	������ġ 
		int y = 1;	// 	������ġ

		int [] dx = {0, 0, -1, 1};				// ���Ʒ� 
		int [] dy = {-1, 1, 0, 0};				// �޿� 	
		String moveTypes[] = {"L","R","U","D"};	

		// �̵��ϸ鼭 �ϳ��� Ȯ�� �ϱ�
		for (int i = 0; i < arr.length; i++) {
			String move = arr[i];
			
			int nx = -1;	// �̵��� ��ǥ ���� ���� ��ü
			int ny = -1;
			
			for (int j = 0; j < 4; j++) {
				if(move.equals(moveTypes[j])) {
					nx = x + dx[j];
					ny = y + dy[j];
				}
			}
			
			// ������ ����� ��� ����
			if(nx < 1 || ny < 1 || nx > n || ny > n ) continue;
				
			x = nx;
			y = ny;
		}
		
		System.out.println(x);
		System.out.println(y);
	}
}

/*

private static void map(int mapSize, String[] arr) {
int [][] map = new int[mapSize][mapSize];

int x = 1;
int y = 1;

int i = 0;
while(i < arr.length) {
	String c = arr[i];
	
	if(c.equals("L")) x = x - 1 > 0  ? x - 1 : x;
	
	if(c.equals("R")) x = x + 1 > 0  ? x + 1 : x;
	
	if(c.equals("U")) y = y - 1 > 0  ? y - 1 : y;

	if(c.equals("D")) y = y + 1 > 0  ? y + 1 : y;
	
	i++;
}

System.out.println("x : "+ x);
System.out.println("y : "+ y);
}

*/