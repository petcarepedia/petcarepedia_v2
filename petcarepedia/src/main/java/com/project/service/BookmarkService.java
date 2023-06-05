package com.project.service;

import java.util.ArrayList;

import com.project.vo.BookmarkVo;

public interface BookmarkService {
	// 북마크 전체 리스트 출력
	ArrayList<BookmarkVo> getSelect(String mid);
	// 북마크 추가
	int getInsert(BookmarkVo bookmarkVo);
	// 북마크 삭제
	int getDelete(String bmid);
	
	int getDeleteBookmark(BookmarkVo bookmarkVo);
	
	int getCheckBookmark(BookmarkVo bookmarkVo);
}
