package chapter02;

/*
 	String Ÿ���� �̸��� ������ �� �ִ� ���� name�� ����
 	int Ÿ���� ���̸� ������ �� �ִ� ���� age�� ����
 	double Ÿ���� Ű�� ���� �� �� �ִ� ���� height�� ����
 	boolean Ÿ���� JAVA å�� ���� ���θ� ������ �� �ִ� ���� hasBook�� ����
 	�̸��� ����,Ű, å�� ���� ���θ� ����غ��ô�.
  
 */

public class Member {
	// �ν��Ͻ� ������ �ڵ� �ʱ�ȭ 
	private String name; 		// ������� �̸�
	private int age;			// ������� ����
	private double height;		// ������� Ű
	//private boolean hasBook;	// �ڹ� å ��������
	
	void printData() {
		System.out.println("�̸�: "+name);
		System.out.println("����: "+age);
		System.out.println(" Ű: "+height);
		//System.out.println("å����: "+hasBook);
	}
	
	public static void main(String[] args) {
		// Member Ŭ������ �ν��Ͻ��� ���� > �̸�, ����, Ű ,å ��
		Member member = new Member();
		
		// �ν��Ͻ��� ������ �����ؼ� ����غ���
		member.printData();
		
		// �ν��Ͻ� ������ ���� ����
		member.name = "�����";
		member.age = 29;
		member.height = 175.0;
		//member.hasBook = false;
		
		System.out.println("\n�ν��Ͻ� ������ ���� ����\n");
		
		member.printData();
	}
}
