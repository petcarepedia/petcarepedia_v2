package com.project.vo;

public class SessionVo {
	int LoginResult;
	String mid, name;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
