package com.bitcamp.mvc.domain;

public class RegRequest {
	private String userId;
	private String userPw;
	private String userName;

	
	
	@Override
	public String toString() {
		return "RegRequest [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public RegRequest() {};
	
	public RegRequest(String userId, String userPw, String userName) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
	}
	
	
	
}
