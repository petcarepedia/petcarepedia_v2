package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.HospitalDao;
import com.project.vo.HospitalVo;

@Service("hospitalService")
public class HospitalServiceImpl implements HospitalService{
	@Autowired
	private HospitalDao hospitalDao; 
	
	@Override	
	public int totalRowCount() {
		return hospitalDao.totalRowCount();
	}
	
	@Override
	public HospitalVo selectStar(String hid) {
		return hospitalDao.selectStar(hid);
	}

	@Override
	public ArrayList<HospitalVo> searchGloc(String gloc){
		return hospitalDao.searchGloc(gloc);
	}
	
	@Override
	public List<Object> search(String hname, String gloc){
		return hospitalDao.search(hname, gloc);
	}
	
	@Override
	public int delete(String hid) {
		return hospitalDao.delete(hid);
	}
	
	@Override
	public int update(HospitalVo hospitalVo) {
		return hospitalDao.update(hospitalVo);
	}
	
	@Override
	public HospitalVo select(String hid) {
		return hospitalDao.select(hid);
	}
	
	@Override
	public ArrayList<HospitalVo> select(){
		return hospitalDao.select();
	}
	
	@Override
	public HospitalVo selectTime(String hid) {
		return hospitalDao.selectTime(hid);
	}
	
	@Override
	public int insert(HospitalVo hospitalVo) {
		return hospitalDao.insert(hospitalVo);
	}
}
