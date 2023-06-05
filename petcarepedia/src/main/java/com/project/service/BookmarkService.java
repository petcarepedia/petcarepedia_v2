package com.project.service;

import java.util.ArrayList;

import com.project.vo.BookmarkVo;

public interface BookmarkService {
	// �ϸ�ũ ��ü ����Ʈ ���
	ArrayList<BookmarkVo> getSelect(String mid);
	// �ϸ�ũ �߰�
	int bookmarkInsert(BookmarkVo bookmarkVo);
	// �ϸ�ũ ����
	int bookmarkDelete(String bmid);
	
	int deleteBookmark(BookmarkVo bookmarkVo);
	
	int checkBookmark(BookmarkVo bookmarkVo);
}
