package com.project.vo;

public class SessionVo {
	int LoginResult;
	String id, nickname;
	
	public int getLoginResult() {
		return LoginResult;
	}
	public void setLoginResult(int loginResult) {
		LoginResult = loginResult;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
