package com.project.service;

import java.util.ArrayList;
import java.util.List;

import com.project.vo.HospitalVo;

public interface HospitalService {
		
		int totalRowCount();
		HospitalVo selectStar(String hid);
		ArrayList<HospitalVo> searchGloc(String gloc);
		List<Object> search(String hname);
		int delete(String hid);
		int update(HospitalVo hospitalVo);
		HospitalVo select(String hid);
		ArrayList<HospitalVo> select();
		HospitalVo selectTime(String hid);
		int insert(HospitalVo hospitalVo);
}
