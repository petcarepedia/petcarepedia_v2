package com.project.service;

import com.project.vo.ReviewLikeVo;

public interface ReviewLikeService {

	//���ƿ� ���� ���̵� ����
	public int getLikesDownID(ReviewLikeVo reviewLikeVo);
	
	//���ƿ� ����
	public int getLikesDown(ReviewLikeVo reviewLikeVo);
	
	//���ƿ� ���� ���̵� ����
	public int getLikesUpID(ReviewLikeVo reviewLikeVo);
	
	//���ƿ� ����
	public int getLikesUp(ReviewLikeVo reviewLikeVo);
	
	//���ƿ� ���� ���̵� �˻�
	public int getIdCheck(ReviewLikeVo reviewLikeVo);
}
