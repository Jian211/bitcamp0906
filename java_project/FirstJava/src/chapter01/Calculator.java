package chapter01;

public class Calculator {
	/*
	  	1. ���� �� ���� �Ű������� ���ڷ� ���޹޾� ���ϱ� �޼ҵ带 �߰��սô�.
	  	2. ���� �� ���� �Ű������� ���ڷ� ���޹޾� ���� �޼ҵ带 �߰��սô�.
	  	3. ���� �� ���� �Ű������� ���ڷ� ���޹޾� ���ϱ� �޼ҵ带 �߰��սô�.
	  	4. ���� �� ���� �Ű������� ���ڷ� ���޹޾� ������ �޼ҵ带 �߰��սô�.
	  
	 */

	int add(int num1, int num2) {
		return num1+num2;
	}

	int minus(int num1, int num2) {
		return num1-num2;
	}
	
	long multi(long num1, int num2) {
		return num1*num2;
	}
	
	int devide(int num1, int num2) {
		return num1/num2;
	}
	
	float devide(float num1, float num2) {
		return num1/num2;
	}

	public static void main(String[] args) {
		// Ŭ������ ���ǵ��� �޼ҵ��� ��� 
		// Ŭ������ �̿��ؼ� �ν��Ͻ�(��ü)�� ����.
		// Ŭ������ ���(����,�޼���)���� �޸𸮿� �ε�ȴ�!
		// ��ü ����: new Ŭ�����̸�() => ������(��ü�� �޸� �ּҰ�)
		// ������ ȣ�� > �ʱ�ȭ
		// �������� : ��ü�� �ּҰ��� �����ϴ� �����̴�.
		// Ŭ���� �̸� �����̸� 
		Calculator cal = new Calculator();
		System.out.println("���ϱ� �޼ҵ� ȣ��");
		System.out.println("1 + 2 = "+ cal.add(1, 2));
		System.out.println("���� �޼ҵ� ȣ��");
		System.out.println("1 - 2 = "+ cal.minus(1, 2));
		System.out.println("���ϱ� �޼ҵ� ȣ��");
		System.out.println("1000000 * 1000000 = "+ cal.multi(1000000, 1000000));
		System.out.println("���������� �޼ҵ� ȣ��");
		System.out.println("10 / 3 = "+ cal.devide(10, 3));
		System.out.println("�Ǽ������� �޼ҵ� ȣ��");
		System.out.println("10.0 * 3.0 = "+ cal.devide(10.0f, 3.0f));
		// ������ �⺻Ÿ���� int
		// �Ǽ��� �⺻Ÿ���� double
	}
}
