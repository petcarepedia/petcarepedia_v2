package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.dao.ReviewLikeDao;
import com.project.vo.ReviewLikeVo;

public class ReviewLikeServiceImpl implements ReviewLikeService {

	@Autowired
	private ReviewLikeDao reviewLikeDao;
	
	@Override
	public int getLikesDownID(ReviewLikeVo reviewLikeVo) {
		return reviewLikeDao.LikesDownID(reviewLikeVo);
	}

	@Override
	public int getLikesDown(ReviewLikeVo reviewLikeVo) {
		return reviewLikeDao.LikesDown(reviewLikeVo);
	}

	@Override
	public int getLikesUpID(ReviewLikeVo reviewLikeVo) {
		return reviewLikeDao.LikesUpID(reviewLikeVo);
	}

	@Override
	public int getLikesUp(ReviewLikeVo reviewLikeVo) {
		return reviewLikeDao.LikesUp(reviewLikeVo);
	}

	@Override
	public int getIdCheck(ReviewLikeVo reviewLikeVo) {
		return reviewLikeDao.idCheck(reviewLikeVo);
	}
}
