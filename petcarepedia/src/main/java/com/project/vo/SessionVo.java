package com.project.vo;

public class SessionVo {
	int LoginResult;
	String mid, nickname;
	
	public int getLoginResult() {
		return LoginResult;
	}
	public void setLoginResult(int loginResult) {
		LoginResult = loginResult;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
