package com.project.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.project.dao.MemberDao;
import com.project.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService{

	private MemberDao memberDao = new MemberDao();
	
	@Override
	public int getJoin(MemberVo memberVo) {
		return memberDao.insert(memberVo);
	};
	
	@Override
	public int getLogin(MemberVo memberVo) {
		return memberDao.checkLogin(memberVo);
	};
	
	@Override
	public int getDelete(String mid, String pass) {
		return memberDao.delete(mid, pass);
	};
	
	@Override
	public ArrayList<MemberVo> getList(){
		return memberDao.select();
	};
	
	@Override
	public ArrayList<MemberVo> getList(int startCount, int endCount){
		return memberDao.select(startCount, endCount);
	};
	
	@Override
	public MemberVo getSelect(String mid) {
		return memberDao.select(mid);
	};
	
	@Override
	public String getCheckId(String mid) {
		return String.valueOf(memberDao.checkId(mid));
	};
	
	@Override
	public int getUpdate(MemberVo memberVo) {
		return memberDao.update(memberVo);
	};
	
	@Override
	public String getFindId(MemberVo memberVo) {
		return memberDao.findId(memberVo);
	};
	
	@Override
	public String getFindPass(MemberVo memberVo) {
		return memberDao.findPass(memberVo);
	};
	
	@Override
	public int getUpdatePass(MemberVo memberVo) {
		return memberDao.updatePass(memberVo);
	};
	
	@Override
	public ArrayList<MemberVo> getSearch(String mid){
		return memberDao.search(mid);
	};
}
