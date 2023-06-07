package com.project.service;

import java.util.ArrayList;

import com.project.vo.BookmarkVo;

public interface BookmarkService {
	// �ϸ�ũ ��ü ����Ʈ ���
	ArrayList<BookmarkVo> getSelect(String mid);
	// �ϸ�ũ �߰�
	int getInsert(BookmarkVo bookmarkVo);
	// �ϸ�ũ ����
	int getDelete(String bmid);
	
	int getDeleteBookmark(BookmarkVo bookmarkVo);
	
	int getCheckBookmark(BookmarkVo bookmarkVo);
}
