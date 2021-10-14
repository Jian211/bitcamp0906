package chapter06;

public class MaxAndMin {
	int miniValue(int[] arr) { 
		int temp = 0;
		for (int i = 1; i < arr.length; i++) {
			if(temp == 0) {
				temp = arr[0];
			}
			if(temp > arr[i]) {
				temp = arr[i];
			}
		}
		return temp;
	} // 최소값 반환

	int maxValue(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			if(temp < arr[i]) {
				temp = arr[i];
			}
		}
		return temp;
	} // 최대값
	
	public int random() {
		return (int)(Math.random()*15+1);
	}
	
	public void print(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("[%d]",arr[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MaxAndMin a = new MaxAndMin();
		int range = a.random();
		
		int [] arr = new int[range];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = a.random();
		}
		//현재 배열출력
		a.print(arr);
	
		int min = a.miniValue(arr);
		int max = a.maxValue(arr);
		System.out.println("min : "+ min);
		System.out.println("max : "+ max);
		
	}
}
