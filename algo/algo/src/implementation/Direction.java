package implementation;

/*
	여행가 A는 N * N 크기의 정사각형 공간 위에 서 있습니다. 
	이 공간은 1 * 1 크기의 정사각형으로 나누어져 있습니다.
	가장 왼쪽 위 좌표는 (1,1)이며, 가장 오른쪽 아래 좌표는 (N, N)에 해당합니다.
	
	여행가 A는 상 하 좌 우 방향으로 이동할 수 있으며, 시작 좌표는 항상 (1, 1) 입니다. 
	우리 앞에는 여행가 A가 이동할 계획이 적힌 계획서가 놓여 있습니다.
	
	계획서에는 하나의 줄에 띄어쓰기를 기준으로 하여 L, R, U, D 중 하나의 문자가 반복적으로 적혀 있습니다.
	각 문자의 의미는 다음과 같습니다.
	
	L : 왼쪽으로 한칸 이동
	R : 오른쪽으로 한 칸 이동
	U : 위로 한 칸 이동
	D : 아래로 한 칸 이동
 	
 	이때 여행가 A가 N * N 크기의 정사각형 공간을 벗어나는 움직임은 무시됩니다. 
 	예를 들어 (1, 1)의 위치에서 	L 혹은 U를 만나면 무시됩니다.
 	다음은 N = 5인 지도와 계획서입니다.

 	입력 예시 5 	R R R U D D 
 	출력 예시 3,4
 
 */

public class Direction {

	public static void main(String[] args) {
		String[] arr = {"R","R","R","U","D","D"};		

		int n = 5;	//	맵의 크기
		int x = 1;	// 	최초위치 
		int y = 1;	// 	최초위치

		int [] dx = {0, 0, -1, 1};				// 위아래 
		int [] dy = {-1, 1, 0, 0};				// 왼우 	
		String moveTypes[] = {"L","R","U","D"};	

		// 이동하면서 하나씩 확인 하기
		for (int i = 0; i < arr.length; i++) {
			String move = arr[i];
			
			int nx = -1;	// 이동할 좌표 정보 담을 객체
			int ny = -1;
			
			for (int j = 0; j < 4; j++) {
				if(move.equals(moveTypes[j])) {
					nx = x + dx[j];
					ny = y + dy[j];
				}
			}
			
			// 공간을 벗어나는 경우 무시
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