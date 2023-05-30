package com.project.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.NoticeDao;
import com.project.vo.NoticeVo;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public ArrayList<NoticeVo> getListPage(int startCount, int endCount) {
		return noticeDao.select(startCount, endCount);
	}

	@Override
	public NoticeVo getEnterContent(String nid) {
		return noticeDao.enter_select(nid);
	}

	@Override
	public NoticeVo getContent(String nid) {
		return noticeDao.select(nid);
	}

	@Override
	public int getInsert(NoticeVo noticeVo) {
		return noticeDao.insert(noticeVo);
	}

	@Override
	public int getUpdate(NoticeVo noticeVo) {
		return noticeDao.update(noticeVo);
	}

	@Override
	public int getDelete(String nid) {
		return noticeDao.delete(nid);
	}

	@Override
	public void getUpdateHits(String nid) {
		noticeDao.updateHits(nid);
		
	}

	@Override
	public int getTotalPageCount() {
		return noticeDao.totalRowCount();
	}

}
