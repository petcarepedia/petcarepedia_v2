package com.project.vo;

import java.util.ArrayList;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @author tj
 *
 */
public class ReviewVo {
	// 리뷰에서 필요한 Vo
	String rid, rcontent, rdate, rstate, hid, mid, hname, animal, gloc, rfile1, rsfile1, rfile2, rsfile2;
	int rlike, rno, likeresult;
	float rstar;
	CommonsMultipartFile[] files;
	ArrayList<String> rfiles = new ArrayList<String>();
	ArrayList<String> rsfiles = new ArrayList<String>();
	
	//병원과 조인 Vo
	String loc, tel, htime, ntime, holiday, intro, img, hrink;
	// 내가 쓴 리뷰
	String bid, nickname;
	String hsfile;
	String msfile;
	
	
	
	public String getMsfile() {
		return msfile;
	}
	public void setMsfile(String msfile) {
		this.msfile = msfile;
	}
	

	public String getRfile1() {
		return rfile1;
	}
	public void setRfile1(String rfile1) {
		this.rfile1 = rfile1;
	}
	public String getRsfile1() {
		return rsfile1;
	}
	public void setRsfile1(String rsfile1) {
		this.rsfile1 = rsfile1;
	}
	public String getRfile2() {
		return rfile2;
	}
	public void setRfile2(String rfile2) {
		this.rfile2 = rfile2;
	}
	public String getRsfile2() {
		return rsfile2;
	}
	public void setRsfile2(String rsfile2) {
		this.rsfile2 = rsfile2;
	}
	public CommonsMultipartFile[] getFiles() {
		return files;
	}
	public void setFiles(CommonsMultipartFile[] files) {
		this.files = files;
	}
	public ArrayList<String> getRfiles() {
		return rfiles;
	}
	public void setRfiles(ArrayList<String> rfiles) {
		this.rfiles = rfiles;
	}
	public ArrayList<String> getRsfiles() {
		return rsfiles;
	}
	public void setRsfiles(ArrayList<String> rsfiles) {
		this.rsfiles = rsfiles;
	}
	
	
	public String getHsfile() {
		return hsfile;
	}
	public void setHsfile(String hsfile) {
		this.hsfile = hsfile;
	}
	public int getLikeresult() {
		return likeresult;
	}
	public void setLikeresult(int likeresult) {
		this.likeresult = likeresult;
	}
	public float getRstar() {
		return rstar;
	}
	public void setRstar(float rstar) {
		this.rstar = rstar;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	
	
	//병원 조인
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
	

	//리뷰사용
	
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	public String getGloc() {
		return gloc;
	}
	public void setGloc(String gloc) {
		this.gloc = gloc;
	}
	
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getRstate() {
		return rstate;
	}
	public void setRstate(String rstate) {
		this.rstate = rstate;
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
	public int getRlike() {
		return rlike;
	}
	public void setRlike(int rlike) {
		this.rlike = rlike;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
}
