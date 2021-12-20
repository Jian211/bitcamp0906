package member.domain;

import java.sql.Timestamp;

public class Member {
	
	private int idx;
	private String userid;
	private String pw;
	private String username;
//	private Timestamp regDate; // Java.sql.TimeStamp -> Java.util.Date
	private String regDate; // DB -> 2021.12.20 12:21

	
	public Member(int idx, String userid, String pw, String username, String regDate) {
	super();
	this.idx = idx;
	this.userid = userid;
	this.pw = pw;
	this.username = username;
	this.regDate = regDate;
		
	}


	public Member() {
	}


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
	
	
	

}
