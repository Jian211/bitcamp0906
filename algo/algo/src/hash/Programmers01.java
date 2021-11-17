package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
������ ������ �������� �����濡 �����Ͽ����ϴ�. �� �� ���� ������ �����ϰ�� ��� ������ �������� �����Ͽ����ϴ�.

�����濡 ������ �������� �̸��� ��� �迭 participant�� ������ �������� �̸��� ��� �迭 completion�� �־��� ��,
�������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
	������ ��⿡ ������ ������ ���� 1�� �̻� 100,000�� �����Դϴ�.
	completion�� ���̴� participant�� ���̺��� 1 �۽��ϴ�.
	�������� �̸��� 1�� �̻� 20�� ������ ���ĺ� �ҹ��ڷ� �̷���� �ֽ��ϴ�.
	������ �߿��� ���������� ���� �� �ֽ��ϴ�.

���� #1 	"leo"�� ������ ��ܿ��� ������, ������ ��ܿ��� ���� ������ �������� ���߽��ϴ�.

���� #2	"vinko"�� ������ ��ܿ��� ������, ������ ��ܿ��� ���� ������ �������� ���߽��ϴ�.

���� #3	"mislav"�� ������ ��ܿ��� �� ���� ������, ������ ��ܿ��� �� ��ۿ� ���� ������ �Ѹ��� �������� ���߽��ϴ�.
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
		
		// ������
		String [] participant = {"leo","kiki","eden"};						  // leo
		//String [] participant = {"marina","josipa","nikola","vinko","filipa"};  // vinko
		//String [] participant = {"mislav","stanko","mislav","ana"};				  // mislav
		
		// ������
		String [] completion = {"eden","kiki"};
		//String [] completion = {"josipa","filipa","marina","nikola"};
		//String [] completion = {"stanko","ana","mislav"};
		
		System.out.println(sol.solution(participant,completion));
	}

}



// �׽�Ʈ�� ������� ȿ������������ �˴� Ʋ��

/*  
class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashSet<String> hs = new HashSet<String>();
		for(String i : completion) {
			hs.add(i);
		}

		// �Ϸ��� �ϳ��� ����
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