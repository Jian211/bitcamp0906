package chapter02;

/*
	 ȸ���̸��� �����ϴ� ����
	 ȸ�� ��ȭ��ȣ�� �����ϴ� ����
	 ȸ�� �ֹε�Ϲ�ȣ�� �����ϴ� ����
	  
 */
public class Person {
	private String memberName;		// ȸ���� �̸�
	private String phoneNumber;		// ��ȭ��ȣ
	//private String personalNumber;	// �ֹε�Ϲ�ȣ
	private long personalNumber;	// �ֹε�Ϲ�ȣ
	
	//setter / getter
	
	//setter�� ���� �޾Ƽ� ������ ����. ��, �Ű������� �´� Ÿ���� �����͸� �޾ƾ���.
	public void setMember(String name) {
		memberName = name;
	}
	
	//getter �ν��Ͻ� ���� ��ȯ
	public String getMember() {
		return memberName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(long personalNumber) {
		this.personalNumber = personalNumber;
	}

	public void printData() {
		System.out.println("name :"+memberName);
		System.out.println("Phone Number :"+ phoneNumber);
		System.out.println("Personal Number :"+ personalNumber);
		
		
	}
}
