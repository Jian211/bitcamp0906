package chapter11;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

public class TreeMapTest1 {
	public static void main(String[] args) {
		
		TreeMap<Integer, String> map = new TreeMap<>();
		
		//데이터를 저장
		map.put(1, "권창훈");
		map.put(5, "차범근");
		map.put(4, "이동경");
		map.put(3, "이호");
		map.put(2, "이동준");

		NavigableSet<Integer> navi = map.navigableKeySet();
		
		Iterator<Integer> itr = navi.iterator();
		while(itr.hasNext()) {
			System.out.println(map.get(itr.next()));
		}

		itr = navi.descendingIterator();
	
		while(itr.hasNext()) {
			System.out.println(map.get(itr.next()));
		}
	}
}
