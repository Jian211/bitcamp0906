package recursion;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2447

public class Back2447 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int userChoice = sc.nextInt();
		sc.close();

		int l = 1;

		for (int i = 0; i < userChoice; i++) {
			l *= 3;
		}
		
		String [][] arr = new String[l][l];
		
		printMark(l ,arr);
		
		System.out.println(arr.length);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
	}

	private static void printMark(int l, String [][] arr) {
		int x = 0;
		int y = 0;
		printMark(l, x, y , arr);
	}

	private static void printMark(int l, int x, int y , String [][] arr) {
		// 종료조건
		if(x >= l) {
			System.out.println("왓어?");
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < l; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			return;
		}
		
		int min = l/3;
		int max = l-min;
		
		System.out.printf("min : %d  max : %d   x : %d   y : %d  \n",min,max,x,y);
		while( y < l/3 ) {
			if(!(min <= x && x < max) && (min <= y && y < max)) {
				arr[x][y] = " * ";
				x++;
			}
			y++;
			x = x - l + 1;
			
			System.out.printf("x : %d   y : %d \n ",x,y);
		}

		printMark(l, x, y, arr);
		
		
	}
}
	