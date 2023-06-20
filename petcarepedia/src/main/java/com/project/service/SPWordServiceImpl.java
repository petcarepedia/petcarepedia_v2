package com.project.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.SPWordDao;
import com.project.vo.SPWordVo;

@Service("spwordService")
public class SPWordServiceImpl implements SPWordService{

	@Autowired
	private SPWordDao spwordDao;
	
	@Override
	public int getInsert(String word) {
		return spwordDao.insert(word);
	};
	
	@Override
	public ArrayList<SPWordVo> getSelect(){
		return spwordDao.select();
	};
}
