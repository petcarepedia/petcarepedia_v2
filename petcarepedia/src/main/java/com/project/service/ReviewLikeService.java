package com.project.service;

import com.project.vo.ReviewLikeVo;

public interface ReviewLikeService {

	//���ƿ� ���� ���̵� ����
	public ReviewLikeVo getLikesDownID(ReviewLikeVo reviewLikeVo);
	
	//���ƿ� ����
	public int getLikesDown(ReviewLikeVo reviewLikeVo);
	
	//���ƿ� ���� ���̵� ����
	public ReviewLikeVo getLikesUpID(ReviewLikeVo reviewLikeVo);
	
	//���ƿ� ����
	public int getLikesUp(ReviewLikeVo reviewLikeVo);
	
	//���ƿ� ���� ���̵� �˻�
	public int getIdCheck(ReviewLikeVo reviewLikeVo);
}
