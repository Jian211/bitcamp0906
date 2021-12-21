package member.domain;

import java.sql.Timestamp;

/*
 	작업자     : 지명근
 	날짜 	  : 2021. 12.21 photo 추가 
 	작업 내용 : 사진 파일의 경로를 저장하는 변수 추가
 
 */
public class Member {
	
	private int idx;
	private String userid;
	private String pw;
	private String username;
//	private Timestamp regDate; // Java.sql.TimeStamp -> Java.util.Date
	private String regDate; 
	private String photo;
	
	
	public Member(int idx, String userid, String pw, String username, String regDate, String photo) {
		this.idx = idx;
		this.userid = userid;
		this.pw = pw;
		this.username = username;
		this.regDate = regDate;
		this.setPhoto(photo);
	}

	public LoginInfo getLoginInfo() {
		return new LoginInfo(this.userid, this.username, this.photo);
	}
	
	
	public Member() {	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	
	@Override
	public String toString() {
		return "Member [idx=" + idx + ", userid=" + userid + ", pw=" + pw + ", username=" + username + ", regDate="
				+ regDate + ", photo=" + photo + "]";
	}
	
	
	
	

}
