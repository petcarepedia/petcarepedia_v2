package com.project.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.BookmarkDao;
import com.project.vo.BookmarkVo;

@Service("bookmarkService")
public class BookmarkServiceImpl implements BookmarkService{
	
	@Autowired
	private BookmarkDao bookmarkDao;
	
	
	@Override
	public ArrayList<BookmarkVo> getSelect(String mid) {
		return bookmarkDao.select(mid);
	}
	
	@Override
	public int bookmarkInsert(BookmarkVo bookmarkVo) {
		return bookmarkDao.insert(bookmarkVo);
	}
	
	@Override
	public int bookmarkDelete(String bmid) {
		return bookmarkDao.delete(bmid);
	}
	
	@Override
	public int deleteBookmark(BookmarkVo bookmarkVo) {
		return bookmarkDao.deleteBookmark(bookmarkVo);
	}
	
	@Override
	public int checkBookmark(BookmarkVo bookmarkVo) {
		return bookmarkDao.checkBookmark(bookmarkVo);
	}
}
