package recursion;

//https://www.acmicpc.net/problem/2447

import java.util.Scanner;

public class back2447 {

	//int [][] arr = new int[n][n];
	
	// n ±¸ÇÏ±â 
	static public int makeN(int k) {
		if(k == 0) {
			return 0;
		}
		return 3 * makeN(k--);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		sc.close();
		
		System.out.println(makeN(k));
	}
}
