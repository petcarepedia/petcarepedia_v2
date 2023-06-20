package com.project.service;

import java.util.ArrayList;

import com.project.vo.SPWordVo;

public interface SPWordService {
	public int getInsert(String word);
	public ArrayList<SPWordVo> getSelect();
}
