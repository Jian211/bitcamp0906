package exam;

public class ArrayTest {

	
	public static void addOneDArr(int[][] arr, int add) {
		for(int i=0 ; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] += add;
			}
		}
		System.out.println("각 요소에 숫자를 더하기 =======");
		for(int i=0 ; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	
	}
	
	public static void main(String[] args) {
		int [][] arr1 = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{10,11,12}
		};
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j]+"\t");
			}
			System.out.println();
		}
		int[] temp = arr1[arr1.length-1];
		System.out.println("====");
		for (int i = arr1.length-1; i > 0; i--) {
			temp = arr1[i];
			arr1[i] = arr1[i-1];
			arr1[i-1] = temp;
		}

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("=====================");
		int[]arr = {110,240,180,60,150,90,30,200};
		
		int [][] arr3 = {
				{1,2,3},
				{4,5,6,10},
				{8,9},
				{11,12,13},
				{14,15,16,13},
				{17,18,19}
				};
		System.out.println("2차원 배열 출력");
		
		addOneDArr(arr3, 10);
		
	}
	

	
}
