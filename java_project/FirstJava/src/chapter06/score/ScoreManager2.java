package chapter06.score;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;;

public class ScoreManager2 {
	public static final Scanner sc = new Scanner(System.in);
	private List<Student> score;
	
	public ScoreManager2(int size) {
		score = new ArrayList<>(size);
	}

	public ScoreManager2() {
		this(10);
	}
	
	// Show all data in arr
	public void showAllData() {
		System.out.println("학생 점수 리스트 ");
		System.out.println("----------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("----------------------------");
	
		for(Student stu : score) {
			System.out.println(stu);
		}
	}
	
	// add Data
	// list에 요소 추가
	public void insertScore(Student s) {
		//score[numOfStudent++] = s;
		score.add(s);
	}
	
	// search data with name
	public void searchData() {
		System.out.println("검색 하고자하는 학생의 이름을 입력해주세요.");
		String name = sc.nextLine();
		
		int index = searchIndex(name);

		// -1 or num
		if(index > -1) {
			System.out.println(score.get(index));
		} else {
			System.out.println("존재하지 않습니다.");
		}
		
	}
	
	// remove data with name
	public void removeData(){
		System.out.println("삭제 하고자하는 학생의 이름을 입력해주세요.");
		String name = sc.nextLine();
		
		int index = searchIndex(name);
		
		if(index > -1) {
			score.remove(index);
			System.out.println("데이터가 삭제되었습니다.");
		} else {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		}
	}
	
	// search index in array with name
	private int searchIndex(String name) {
		int index = -1;
		for (int i = 0; i < score.size(); i++) {
			if(score.get(i).getName().equals(name)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	// save Student info in array
	public void insertStudent() {
		System.out.println("학생 성적 데이터를 입력합니다.");

		System.out.print("이름>> ");
		String name = sc.nextLine();
		
		System.out.println("국어점수>> ");
		int scoreKor = Integer.parseInt(sc.nextLine());
		
		System.out.println("영어점수>> ");
		int scoreEng = Integer.parseInt(sc.nextLine());
		
		System.out.println("수학점수>> ");
		int scoreMath = Integer.parseInt(sc.nextLine());
	
		// Student 객체 생성  > 배열에 저장
		insertScore(new Student(name, scoreKor, scoreEng, scoreMath));
	}
}
