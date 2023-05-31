package com.project.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ReviewDao;
import com.project.vo.ReviewVo;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewDao reviewDao;
	
	@Override
	public ArrayList<ReviewVo> getRH_select(String hid) {
		return reviewDao.RH_select(hid);
	}

	@Override
	public ArrayList<ReviewVo> getRM_select(String hid) {
		return reviewDao.RM_select(hid);
	}

	@Override
	public ArrayList<ReviewVo> getSelect() {
		return reviewDao.select();
	}

	@Override
	public ArrayList<ReviewVo> getSelectList(int startCount, int endCount) {
		return reviewDao.selectList(startCount, endCount);
	}

	@Override
	public ArrayList<ReviewVo> getSelectSearchList(int startCount, int endCount, String filter_location) {
		return reviewDao.selectSearchList(startCount, endCount, filter_location);
	}

	@Override
	public ReviewVo getSelect(String rid) {
		return reviewDao.select(rid);
	}

	@Override
	public ReviewVo getEnter_select(String rid) {
		return reviewDao.enter_select(rid);
	}

	@Override
	public int insert(ReviewVo reviewVo) {
		return reviewDao.insert(reviewVo);
	}

	@Override
	public int update(ReviewVo reviewVo) {
		return reviewDao.update(reviewVo);
	}

}
