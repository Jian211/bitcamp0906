package chapter06;

public class Student {
	// 학생이름, 국어점수, 영어점수, 수학점수를 저장하는 변수를 정의 + 변수는 캡슐화
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	// 총점을 구하는 메소드
	public int total() {
		return kor+eng+math;
	}
	
	// 평균을 구하는 메소드
	public float avg() {
		return (float)total()/3;
	}
	// getter, setter 메소드 정의
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	// 추가한 메소드들
	static int randomValue() {
		return (int)(Math.random()*60)+41;
	}
	static void print(Student[] arr) {
		System.out.println("이름\t국어\t영여\t수학\t총점\t평균");
		for(Student s : arr) {
			System.out.printf("[%s]\t[%d]\t[%d]\t[%d]\t[%d]\t[%.1f]",
					s.getName(),
					s.getKor(),
					s.getEng(),
					s.getMath(),
					s.total(),
					s.avg());
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// Student타입을 10개 담을 수 있는 배열을 선언.
		Student [] stdArr = new Student[10];
		
		// 인스턴스에 랜덤 값을 저장.
		for (int i = 0; i < stdArr.length; i++) {
			Student temp = new Student();
			temp.setName(""+(i+1));
			temp.setKor(randomValue());
			temp.setEng(randomValue());
			temp.setMath(randomValue());
			stdArr[i] = temp;
		}
		
		print(stdArr);
		
		
	}
	
}
