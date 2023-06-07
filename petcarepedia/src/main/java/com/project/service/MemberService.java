package com.project.service;

import java.util.ArrayList;

import com.project.vo.MemberVo;
import com.project.vo.SessionVo;

public interface MemberService {
	public int getJoin(MemberVo memberVo);
	public SessionVo getLogin(MemberVo memberVo);
	public int getDelete(String mid, String pass);
	public ArrayList<MemberVo> getList();
	public ArrayList<MemberVo> getList(int startCount, int endCount);
	public MemberVo getSelect(String mid);
	public String getCheckId(String mid);
	public int getUpdate(MemberVo memberVo);
	public String getFindId(MemberVo memberVo);
	public String getFindPass(MemberVo memberVo);
	public int getUpdatePass(MemberVo memberVo);
	public ArrayList<MemberVo> getSearch(String mid);
}
