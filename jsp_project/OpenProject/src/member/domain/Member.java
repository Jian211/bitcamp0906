package member.domain;

import java.sql.Timestamp;

/*
 	작업자     : 지명근
 	날짜 	  : 2021. 12.21 photo 추가 
 	작업 내용 : 사진 파일의 경로를 저장하는 변수 추가
 
 */
public class Member {
	
	private int idx;
	private String userId;
	private String pw;
	private String userName;
//	private Timestamp regDate; // Java.sql.TimeStamp -> Java.util.Date
	private String regDate; 
	private String photo;
	
	
	public Member(int idx, String userId, String pw, String userName, String regDate, String photo) {
		this.idx = idx;
		this.userId = userId;
		this.pw = pw;
		this.userName = userName;
		this.regDate = regDate;
		this.photo = photo;
	}

	public LoginInfo getLoginInfo() {
		return new LoginInfo(this.idx, this.userId, this.userName, this.photo);
	}
	
	
	public Member() {	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		return "Member [idx=" + idx + ", userId=" + userId + ", pw=" + pw + ", userName=" + userName + ", regDate="
				+ regDate + ", photo=" + photo + "]";
	}
	
	
	
	

}
