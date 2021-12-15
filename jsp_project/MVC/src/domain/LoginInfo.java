package domain;

public class LoginInfo {

	private String uid;
	private String name;
	private String nic;
	private String email;
	
	// 생성자로 초기화
	public LoginInfo(String uid, String name, String nic, String email) {
		this.uid = uid;
		this.name = name;
		this.nic = nic;
		this.email = email;
	}

	public String getUid() {
		return uid;
	}

	public String getName() {
		return name;
	}

	public String getNic() {
		return nic;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "loginInfo [uid=" + uid + ", name=" + name + ", nic=" + nic + ", email=" + email + "]";
	}
	
	
	
	
	
	// 읽기 전용이 되야한다. 이유는 사용자의 정보가 변하면 안되기 때문, getter만 존재!!
	
}
