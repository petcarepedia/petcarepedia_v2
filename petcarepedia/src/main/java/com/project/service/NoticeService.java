package com.project.service;

import java.util.ArrayList;


import com.project.vo.NoticeVo;

public interface NoticeService {
	//공지사항 리스트 출력
	public ArrayList<NoticeVo> getListPage(int startCount, int endCount);
	
	//공지사항 띄어쓰기 반영 상세보기
	public NoticeVo getEnterContent(String nid);
	
	//공지사항 수정 페이지 내용 불러오기
	public NoticeVo getContent(String nid);
	
	//공지사항 등록
	public int getInsert(NoticeVo noticeVo);
	
	//공지사항 수정
	public int getUpdate(NoticeVo noticeVo);
	
	//공지사항 삭제
	public int getDelete(String nid);
	
	//조회수 증가
	public void getUpdateHits(String nid);
	
	//공지사항 전체 페이지 확인
	public int getTotalPageCount();
	
}
