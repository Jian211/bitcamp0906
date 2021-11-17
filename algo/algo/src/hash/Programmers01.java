package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

제한사항
	마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
	completion의 길이는 participant의 길이보다 1 작습니다.
	참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
	참가자 중에는 동명이인이 있을 수 있습니다.

예제 #1 	"leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #2	"vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #3	"mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.
*/

class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		for(String name : participant) {
			hm.put(name, hm.getOrDefault(name, 0) + 1);
		}
		
		for(String name : completion) {
			hm.put(name, hm.get(name) -1);
		}
		
		for(String key : hm.keySet()) {
			if(hm.get(key) != 0) {
				answer = key ;
				break;
			}
		}
		
		return answer;
	}
}


public class Programmers01 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		
		// 도전자
		String [] participant = {"leo","kiki","eden"};						  // leo
		//String [] participant = {"marina","josipa","nikola","vinko","filipa"};  // vinko
		//String [] participant = {"mislav","stanko","mislav","ana"};				  // mislav
		
		// 완주자
		String [] completion = {"eden","kiki"};
		//String [] completion = {"josipa","filipa","marina","nikola"};
		//String [] completion = {"stanko","ana","mislav"};
		
		System.out.println(sol.solution(participant,completion));
	}

}



// 테스트는 통과지만 효율성문제에서 죄다 틀림

/*  
class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashSet<String> hs = new HashSet<String>();
		for(String i : completion) {
			hs.add(i);
		}

		// 완료자 하나씩 대입
		Iterator<String> itr =  hs.iterator();
		while(itr.hasNext()) {
			String comp = itr.next();
			for (int i = 0; i < participant.length; i++) {
				if(comp.equals(participant[i])) {
					participant[i] = null;
					break;
				}
			}
		}
		for(String i : participant) {
			if(i != null) {
				answer = i;
			}
		}
		
		return answer;
	}
}
---------------------------------------------------------------------------------
		String answer = "";
		HashMap<String, Integer> hmList = new HashMap<String, Integer>();

		for (int i = 0; i < completion.length; i++) {
			hmList.put(completion[i], 0);
		}

		for (int i = 0; i < participant.length; i++) {
			if(hmList.containsKey(participant[i])) {
				hmList.put(participant[i], hmList.get(participant[i])+1);
				if(hmList.get(participant[i]) > 1) {
					answer = participant[i];
				}
			} else {
				hmList.put(participant[i], 0);
				answer = participant[i];
			}
		}
		
		
		return answer;


*/