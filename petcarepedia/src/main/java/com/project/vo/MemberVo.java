package com.project.vo;

public class MemberVo {

	String phone1, phone2, phone3, birth1, birth2, birth3;
	int rno;
	String mid, pass, name, nickname, phone, birth, email, addr, mdate;
	
	
	public String getBirth1() {
		return birth1;
	}
	public void setBirth1(String birth1) {
		this.birth1 = birth1;
	}
	public String getBirth2() {
		return birth2;
	}
	public void setBirth2(String birth2) {
		this.birth2 = birth2;
	}
	public String getBirth3() {
		return birth3;
	}
	public void setBirth3(String birth3) {
		this.birth3 = birth3;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		String phone = this.phone;
		
		if(phone1 != "" && phone2 != "" && phone3 != "" && 
			phone1 != null && phone2 != null && phone3 != null) {
			phone = phone1 + "-" + phone2 + "-" + phone3;
		}
		
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
		if(phone!=null) {
			String[] arr = phone.split("-");
			setPhone1(arr[0]);
			setPhone2(arr[1]);
			setPhone3(arr[2]);
		}
	}
	public String getBirth() {
		String birth = this.birth;
		
		if(birth1 != "" && birth2 != "" && birth3 != "" && 
			birth1 != null && birth2 != null && birth3 != null) {
			birth = birth1 + "-" + birth2 + "-" + birth3;
		}
		
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
		if(birth!=null) {
			String[] arr = birth.split("-");
			setBirth1(arr[0]);
			setBirth2(arr[1]);
			setBirth3(arr[2]);
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	
	

}
