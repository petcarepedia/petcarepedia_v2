package com.project.vo;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class HospitalVo {
	int rno;
	String hid, hname, gloc, loc, tel, htime, ntime, holiday, animal,intro, img, hrink, x, y, starttime, endtime, hfile, hsfile;
	float rstar;
	CommonsMultipartFile file1;
	
	public float getRstar() {
		return rstar;
	}
	public void setRstar(float rstar) {
		this.rstar = rstar;
	}
	public String getHfile() {
		return hfile;
	}
	public void setHfile(String hfile) {
		this.hfile = hfile;
	}
	public String getHsfile() {
		return hsfile;
	}
	public void setHsfile(String hsfile) {
		this.hsfile = hsfile;
	}
	public CommonsMultipartFile getFile1() {
		return file1;
	}
	public void setFile1(CommonsMultipartFile file1) {
		this.file1 = file1;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
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
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHtime() {
		return htime;
	}
	public void setHtime(String htime) {
		this.htime = htime;
	}
	public String getNtime() {
		return ntime;
	}
	public void setNtime(String ntime) {
		this.ntime = ntime;
	}
	public String getHoliday() {
		return holiday;
	}
	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getHrink() {
		return hrink;
	}
	public void setHrink(String hrink) {
		this.hrink = hrink;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	
	
}
