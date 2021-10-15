package chapter06;
/*
  1.국어, 영어, 수학 점수 10개씩을 저장하는
     배열을 정의하고 점수를 모두 출력하고, 
     평균 점수를 출력하는 프로그램을 작성해봅시다.
     
     각 점수는 랜덤한 값을 생성해서 입력합시다.
 */
public class ScoryAarray {
	public static void main(String[] args) {
		int [][] subject = new int[10][3];
		
		for (int i = 0; i < subject.length; i++) {
			for (int j = 0; j < subject[i].length; j++) {
				subject[i][j] = (int)(Math.random()*50)+50;
			}
		}
		// 모두출력
		System.out.println("국어\t영어\t수학\t평균");
		for (int i = 0; i < subject.length; i++) {
			int avg = 0;
			for (int j = 0; j < subject[i].length; j++) {
				avg += subject[i][j];
				System.out.printf("[%d] \t",subject[i][j]);
			}
			System.out.print(avg/subject[i].length);
			System.out.println();
		}
	}
}
