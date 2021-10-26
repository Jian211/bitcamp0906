package java11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FootballMain {

	public static void main(String[] args) {
		System.out.println("1. ===============================");
		// 1. 축구선수 인스턴스를 저장할 수 있는 List<E> 컬렉션 인스턴스를 생성
		List<FootballPlayer> fbplayerList = new ArrayList<FootballPlayer>();

		// 저장하고 출력하는 프로그램 만들기
		fbplayerList.add(new FootballPlayer("손흥민",7,"토트넘",28));		
		fbplayerList.add(new FootballPlayer("황희찬",26,"울버햄튼",24));		
		fbplayerList.add(new FootballPlayer("황희찬",26,"울버햄튼",24));		
		fbplayerList.add(new FootballPlayer("이강인",14,"마르요카",21));		
		
		for(FootballPlayer fbp : fbplayerList) {
			System.out.println("-----------------------");
			System.out.println(fbp.toString());
			System.out.println("-----------------------");
		}
		
		System.out.println("2. ===============================");
		
		// 2. 축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면 같은 선수라 판단하고 입력이 되지 않도록
		// set<E> 컬렉션을 이용해서 축구선수 인스턴스를 저장하고 출력하는 프로그램을 만들어봅시다.
		
		Set<FootballPlayer> set = new HashSet<FootballPlayer>();
		
		// 데이터 저장
		// 중복 체크 : hashCode() -> 같다면 -> equals()
		
		set.add(new FootballPlayer("손흥민",7,"토트넘",28));		
		set.add(new FootballPlayer("황희찬",26,"울버햄튼",24));		
		set.add(new FootballPlayer("황희찬",26,"울버햄튼",24));		
		set.add(new FootballPlayer("이강인",7,"마르요카",14));		
		
		System.out.println("set.size() "+set.size());
		
		Iterator<FootballPlayer> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println("---------------");
			System.out.println(itr.next());
			System.out.println("---------------");
		}
		
		System.out.println("3. ===============================");
	
		//3. TreeSet<E>를 이용해서 팀 이름순으로 정렬하고,
		// 	  같은 팀의 선수들은 이름 순으로 정렬하고,
		//   같은 이름의 선수는 번호순으로 저장하는 프로그램을 만들어봅시다.
		
		TreeSet<FootballPlayer> tree = new TreeSet<FootballPlayer>();
		
		tree.add(new FootballPlayer("손흥민",7,"토트넘",28));		
		tree.add(new FootballPlayer("황희찬",26,"울버햄튼",24));		
		tree.add(new FootballPlayer("황희찬",26,"울버햄튼",24));		
		tree.add(new FootballPlayer("이강인",7,"마르요카",14));		
		
		System.out.println("tree.size() "+tree.size());
		
		Iterator<FootballPlayer> itr1 = tree.iterator();
		while(itr1.hasNext()) {
			System.out.println("---------------");
			System.out.println(itr1.next());
			System.out.println("---------------");
		}

		System.out.println("4. ===============================");
		// 4. 축구선수의 번호를 Key로 하고 축구선수 인스턴스를 저장하는 Map<k,v> 인스턴스를 이용해서 제작
		
		Map<Integer, FootballPlayer> map = new HashMap<Integer, FootballPlayer>();
		
		map.put(7, new FootballPlayer("손흥민",7,"토트넘",28));
		map.put(26, new FootballPlayer("황희찬",26,"울버햄튼",24));
		map.put(14, new FootballPlayer("이강인",14,"마르요카",14));
		map.put(31, new FootballPlayer("박지성",31,"맨체스터",42));

		System.out.println("map.size() "+map.size());
		
		for(Integer i : map.keySet()) {
			System.out.println(map.get(i));
		}
		
		for(Map.Entry<Integer, FootballPlayer> e : map.entrySet()) {
			System.out.println("("+e.getKey()+","+e.getValue()+")");
		}
		
	}
	
}
