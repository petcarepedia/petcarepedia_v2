package com.project.service;

import java.util.ArrayList;

import com.project.vo.ReviewLikeVo;
import com.project.vo.ReviewVo;

public interface ReviewService {
	
	// 리뷰와 병원 조인
	public ArrayList<ReviewVo> getRH_select(String hid);
	
	public ArrayList<ReviewVo> getRM_select(String hid);
	
	//리뷰 리스트
	public ArrayList<ReviewVo> getSelect();
	
	//리뷰 리스트 페이지
	public ArrayList<ReviewVo> getSelectList(int startCount, int endCount);
	
	//리뷰 검색 리스트 페이지
	public ArrayList<ReviewVo> getSelectSearchList(int startCount, int endCount, String filter_location);
	
	//리뷰 상세보기
	public ReviewVo getSelect(String rid);
	 
	//리뷰 상세보기 띄어쓰기 출력
	public ReviewVo getEnter_select(String rid);
	
	//리뷰 등록
	public int getInsert(ReviewVo reviewVo);
	
	//리뷰 수정
	public int getUpdate(ReviewVo reviewVo);
	
	//리뷰 신고
	public int getUpdateReport(String rid);
	
	//리뷰 삭제
	public int getDelete(String rid);
	
	//베스트 리뷰 리스트
	public ArrayList<ReviewVo> getSelect(int startCount, int endCount);
	
	//내가 쓴 리뷰
	public ArrayList<ReviewVo> getMy_select(String mid);
	
}
