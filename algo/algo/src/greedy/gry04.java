package greedy;

import java.util.Arrays;

/* 모험가 길드 : 문제 설명
 	한 마을에 모험가가 N명 있습니다.
 	모함가 길드에서는 N명의 모험가를 대상으로 '공포도'를 측정했는데,
 	'공포도'가 높은 모험가는 쉽게 공포를 느껴 위험 상황에서 대처할 능력이 떨어집니다.
 	
 	모험가 길드장인 동빈이는 모험가 그룹을 안전하게 구성하고자
 	공포도가 X인 모험가는 반드시 X명 이상으로 구성한 모함가 그룹에 참여해야
 	여행을 떠날 수 있도록 규정했습니다. 

 	동빈이는 최대 몇 개의 모험가 그룹을 만들 수 있는지 궁금합니다. 
 	N명의 모험가에 대한 정보가 주어졌을 떄,
 	
 	여행을 떠날 수 있는 그룹 수의 최댓값을 구하는 프로그램을 작성하세요.
 
 	예를들어 N = 5, 각 모험가의 공포도는 다음과 같다
 	
 				2, 3, 1, 2, 2
 	
 	이 경우 그룹 1에 공포도가 1, 2, 3인 모험가를 한 명 씩 넣고, 그룹 2에
 	공포도가 2인 남은 두 명을 넣게되면 총 2개의 그룹을 만들 수 있다.
 	
 	또한 몇 명의 모험가는 마을에 그대로 남아 있어도 되기 때문에,
 	모든 모험가를 특정한 그룹에 넣을 필요는 없다.
 
 */


public class gry04 {

	private static void getGroupsNum(int[] people) {
		int result = 0;
		Arrays.sort(people);			// step 1.	정렬을 한다. { 1, 2, 2, 2, 3 }
		
		int i = 0;
		while(i < people.length) {	
			int koWaGaRuHiTo = people[i];
			
			if( i + koWaGaRuHiTo <= people.length ) {
				i += koWaGaRuHiTo;
				result++;
			} else {
				break;
			}
		}
		
		System.out.println(result);
	}
	
	
	public static void main(String[] args) {

		int [] people = {2, 3, 1, 3, 2};
		
		getGroupsNum(people);
	}

}
