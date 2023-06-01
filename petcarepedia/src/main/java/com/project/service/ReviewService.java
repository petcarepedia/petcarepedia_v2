package com.project.service;

import java.util.ArrayList;

import com.project.vo.ReviewLikeVo;
import com.project.vo.ReviewVo;

public interface ReviewService {
	
	// ����� ���� ����
	public ArrayList<ReviewVo> getRH_select(String hid);
	
	public ArrayList<ReviewVo> getRM_select(String hid);
	
	//���� ����Ʈ
	public ArrayList<ReviewVo> getSelect();
	
	//���� ����Ʈ ������
	public ArrayList<ReviewVo> getSelectList(int startCount, int endCount);
	
	//���� �˻� ����Ʈ ������
	public ArrayList<ReviewVo> getSelectSearchList(int startCount, int endCount, String filter_location);
	
	//���� �󼼺���
	public ReviewVo getSelect(String rid);
	 
	//���� �󼼺��� ���� ���
	public ReviewVo getEnter_select(String rid);
	
	//���� ���
	public int getInsert(ReviewVo reviewVo);
	
	//���� ����
	public int getUpdate(ReviewVo reviewVo);
	
	//���� �Ű�
	public int getUpdateReport(String rid);
	
	//���� ����
	public int getDelete(String rid);
	
	//����Ʈ ���� ����Ʈ
	public ArrayList<ReviewVo> getSelect(int startCount, int endCount);
	
	//���� �� ����
	public ArrayList<ReviewVo> getMy_select(String mid);
	
}
