package chapter11;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest1 {
	public static void main(String[] args) {
		TreeSet<Integer> sTree = new TreeSet<Integer>();
		
		sTree.add(1);
		sTree.add(5);
		sTree.add(10);
		sTree.add(21);
		sTree.add(10);
		sTree.add(4);

		System.out.println("요소의 개수 : "+ sTree.size());

		Iterator<Integer> itr = sTree.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}
}
