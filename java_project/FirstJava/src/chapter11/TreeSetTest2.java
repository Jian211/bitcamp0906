package chapter11;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest2 {
	public static void main(String[] args) {
		
		TreeSet<Person> tree = new TreeSet<Person>();
		
		tree.add(new Person("손흥민",28));
		tree.add(new Person("황희찬",26));
		tree.add(new Person("이강인",21));
		tree.add(new Person("이강",21));
		
		System.out.println(tree.size());
	
		Iterator<Person> itr = tree.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	
	}
}
