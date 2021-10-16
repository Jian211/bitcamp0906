package chapter06.score;

public class ScoreMain1 {

	public static void main(String[] args) {
		ScoreManager manager = new ScoreManager();
		
		// 1. save data
		manager.insertScore(new Student("손흥민",68,99,80));
		manager.insertScore(new Student("이강인",86,87,63));
		manager.insertScore(new Student("황희찬",70,86,97));

		// 2. print all data
		manager.showAllData();
		
		// 3. search data
		//manager.searchData("손흥민");
		//manager.searchData("케인");
		//manager.searchData("황소");
		
		// 4. delete data
		//manager.removeData("손흥민");
		//manager.removeData("황희찬");
		
		// 5.  show all data
		manager.showAllData();
		
	}

}
