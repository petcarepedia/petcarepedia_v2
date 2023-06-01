package com.project.service;

import com.project.vo.ReviewLikeVo;

public interface ReviewLikeService {

	//좋아요 누른 아이디 삭제
	public ReviewLikeVo getLikesDownID(ReviewLikeVo reviewLikeVo);
	
	//좋아요 감소
	public int getLikesDown(ReviewLikeVo reviewLikeVo);
	
	//좋아요 누른 아이디 생성
	public ReviewLikeVo getLikesUpID(ReviewLikeVo reviewLikeVo);
	
	//좋아요 증가
	public int getLikesUp(ReviewLikeVo reviewLikeVo);
	
	//좋아요 누른 아이디 검색
	public int getIdCheck(ReviewLikeVo reviewLikeVo);
}
