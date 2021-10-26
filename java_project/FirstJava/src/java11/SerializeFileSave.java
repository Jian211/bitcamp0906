package java11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializeFileSave {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		// 출력
		FileOutputStream fos = new FileOutputStream("footballPlayer.ser");
		ObjectOutputStream out = new ObjectOutputStream(fos);

		out.writeObject(new FootballPlayer("손흥민", 7, "토트넘", 28));
		out.writeObject(new FootballPlayer("황희찬",26,"울버햄튼",24));
		out.writeObject(new FootballPlayer("이강인",7,"마르요카",14));
		out.close();
		
		// 쓰기
		FileInputStream fis = new FileInputStream("footballPlayer.ser");
		ObjectInputStream in = new ObjectInputStream(fis);

		ArrayList<FootballPlayer> fbp = new ArrayList<>();
		
		// 저장 
		while(true) {
			try {
				fbp.add((FootballPlayer)in.readObject());
			} catch (Exception e) {
				break;
			}
		}
		
		// 출력
		for( FootballPlayer f : fbp ) {
			System.out.println(f.toString());
		}
		
		
	}
}
