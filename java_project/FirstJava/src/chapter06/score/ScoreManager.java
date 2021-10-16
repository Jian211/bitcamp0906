package chapter06.score;

import java.util.Scanner;

import chapter06.score.Student;;

public class ScoreManager {
	public static final Scanner sc = new Scanner(System.in);
	
	private Student [] score;
	private int numOfStudent;
	
	public ScoreManager(int size) {
		score = new Student[size];
		numOfStudent = 0;
	}

	public ScoreManager() {
		this(10);
	}
	
	// Show all data in arr
	public void showAllData() {
		System.out.println("학생 점수 리스트 ");
		System.out.println("----------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("----------------------------");
	
		for(int i=0 ; i < numOfStudent; i++) {
			System.out.println(score[i]);
		}
	}
	
	// add Data
	public void insertScore(Student s) {
		score[numOfStudent++] = s;
	}
	
	// search data with name
	public void searchData() {
		System.out.println("검색 하고자하는 학생의 이름을 입력해주세요.");
		String name = sc.nextLine();
		
		int index = searchIndex(name);

		// -1 or num
		if(index > -1) {
			System.out.println(score[index]);
			
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
			// 시프트라는 말은 > 참조 값을 지운다! = 정보삭제
			for (int i = index; i < numOfStudent - 1; i++) {
				score[i] = score[i+1];
			}
			numOfStudent--;
			System.out.println("데이터가 삭제되었습니다.");
		} else {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		}
	}
	
	// search index in array with name
	private int searchIndex(String name) {
		int index = -1;
		for (int i = 0; i < numOfStudent; i++) {
			if(score[i].getName().equals(name)) {
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
