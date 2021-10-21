package chapter11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		
		// 다음주소의 링크를 연결해서 데이터를 저장한다.
		LinkedList<Integer> list = new LinkedList<>();

		List<Integer> list2 = new ArrayList<>();

		// 데이터(instance) 저장 : add(E e)
		list.add(new Integer(1));	
		list.add(2);	// Auto Boxing이 되었다.
		list.add(13);
		list.add(1);
		list.add(5);
		
		// list의 요소의 갯수
		System.out.println("list size ?  "+list.size());

		// for 이용 일괄 참조
		System.out.println("for ------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// for each
		System.out.println("for each--------------------------------");
		for(Integer i : list) {
			System.out.println(i);
		}
		
		System.out.println("Iterator--------------------------------");
		// 이게 왜 사용되어야 하는지 궁금하네. 어디에 활용될까나. 이따 찾아보기 *
		Iterator<Integer> itr = list.iterator();
		
		while(itr.hasNext()) {
			Integer i = itr.next();
			System.out.println(i);
		}

		// 요소 삭제
		list.remove(2);
		
		

		
	}
}
