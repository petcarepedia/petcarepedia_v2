package com.project.service;

import java.util.ArrayList;

import com.project.vo.HospitalVo;

public interface HospitalService {
		
		int totalRowCount();
		ArrayList<HospitalVo> select(int startCount, int endCount);
		HospitalVo selectStar(String hid);
		ArrayList<HospitalVo> searchGloc(String gloc);
		ArrayList<HospitalVo> search(String hname);
		int delete(String hid);
		int update(HospitalVo hospitalVo);
		HospitalVo select(String hid);
		ArrayList<HospitalVo> select();
		HospitalVo selectTime(String hid);
		int insert(HospitalVo hospitalVo);
}
