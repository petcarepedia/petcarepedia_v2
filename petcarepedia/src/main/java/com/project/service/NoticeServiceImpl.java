package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.NoticeDao;
import com.project.vo.NoticeVo;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public ArrayList<NoticeVo> getListPage(int startCount, int endCount) {
		ArrayList<NoticeVo> rlist = new ArrayList<NoticeVo>();
		List<Object> list = noticeDao.select(startCount, endCount);
		for(Object obj : list) {
			NoticeVo noticeVo = (NoticeVo)obj;
			rlist.add(noticeVo);
		}
		return rlist;
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
