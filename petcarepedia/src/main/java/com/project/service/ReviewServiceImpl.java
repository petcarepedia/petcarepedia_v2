package com.project.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ReviewDao;
import com.project.vo.ReviewLikeVo;
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
	public int getInsert(ReviewVo reviewVo) {
		return reviewDao.insert(reviewVo);
	}

	@Override
	public int getUpdate(ReviewVo reviewVo) {
		return reviewDao.update(reviewVo);
	}

	@Override
	public int getUpdateReport(String rid) {
		return reviewDao.updateReport(rid);
	}

	@Override
	public int getDelete(String rid) {
		return reviewDao.delete(rid);
	}

	@Override
	public ArrayList<ReviewVo> getSelect(int startCount, int endCount) {
		return reviewDao.select(startCount, endCount);
	}

	@Override
	public ArrayList<ReviewVo> getMy_select(String mid) {
		return reviewDao.my_select(mid);
	}

	@Override
	public ReviewLikeVo getLikesDownID(ReviewLikeVo reviewLikeVo) {
		return reviewDao.LikesDownID(reviewLikeVo);
	}

	@Override
	public int getLikesDown(ReviewLikeVo reviewLikeVo) {
		return reviewDao.LikesDown(reviewLikeVo);
	}

	@Override
	public ReviewLikeVo getLikesUpID(ReviewLikeVo reviewLikeVo) {
		return reviewDao.LikesUpID(reviewLikeVo);
	}

	@Override
	public int getLikesUp(ReviewLikeVo reviewLikeVo) {
		return reviewDao.LikesUp(reviewLikeVo);
	}

	@Override
	public int getIdCheck(ReviewLikeVo reviewLikeVo) {
		return reviewDao.idCheck(reviewLikeVo);
	}

}
