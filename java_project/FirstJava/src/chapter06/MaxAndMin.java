package chapter06;

public class MaxAndMin {
	static int miniValue(int[] arr) { 
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(temp > arr[i]) {
				temp = arr[i];
			}
		}
		return temp;
	} // 최소값 반환

	static int maxValue(int[] arr) {
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(temp < arr[i]) {
				temp = arr[i];
			}
		}
		return temp;
	} // 최대값
	
	static public int random() {
		return (int)(Math.random()*1000+1);
	}
	
	static public void print(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("[%d]",arr[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int [] arr = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random();
		}
		
		//현재 배열출력
		print(arr);
	
		int min = miniValue(arr);
		int max = maxValue(arr);
		System.out.println("min : "+ min);
		System.out.println("max : "+ max);
		
	}
}
