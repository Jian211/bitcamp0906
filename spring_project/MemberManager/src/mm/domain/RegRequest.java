package mm.domain;

import java.util.Date;

public class RegRequest {
	private String email;
	private String pw;
	private String confirmPw;
	private String name;

	// 비밀 번호 일치 여부
	public boolean isPwRePwEquals() {
		return pw.equals(confirmPw);
	}
	
	// RegRequest -> Member 
	public Member toMember() {
		return new Member(0, email, pw, name, new Date());
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getConfirmPw() {
		return confirmPw;
	}

	public void setConfirmPw(String confirmPw) {
		this.confirmPw = confirmPw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RegRequest(String email, String pw, String confirmPw, String name) {
		this.email = email;
		this.pw = pw;
		this.confirmPw = confirmPw;
		this.name = name;
	}
	
	
	
	
}
