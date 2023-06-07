package com.project.vo;

public class BookmarkVo {
	String bmid, hid, mid;
	//조인컬럼
	String hname, gloc, hrink;
	
	int rno;
	
	
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getGloc() {
		return gloc;
	}
	public void setGloc(String gloc) {
		this.gloc = gloc;
	}
	public String getHrink() {
		return hrink;
	}
	public void setHrink(String hrink) {
		this.hrink = hrink;
	}
	public String getBmid() {
		return bmid;
	}
	public void setBmid(String bmid) {
		this.bmid = bmid;
	}
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}

}
