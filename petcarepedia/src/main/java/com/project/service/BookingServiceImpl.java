package com.project.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.BookingDao;
import com.project.vo.BookingReviewVo;
import com.project.vo.BookingVo;

@Service("bookingService")
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingDao bookingDao;
	
	@Override
	public int getInsert(BookingVo bookingVo) {
		return bookingDao.insert(bookingVo); 
	}
	
	@Override
	public ArrayList<BookingVo> getSelect() {
		return bookingDao.select();
	}
	
	@Override
	public ArrayList<BookingVo> getSearch(String mid) {
		return bookingDao.search(mid);
	}
	
	@Override
	public ArrayList<BookingVo> getSearch1(String mid) {
		return bookingDao.search1(mid);
	}
	
	@Override
	public ArrayList<BookingVo> getSearch2(String mid) {
		return bookingDao.search2(mid);
	}
	
	@Override
	public ArrayList<BookingReviewVo> getSearch3(String mid) {
		return bookingDao.search3(mid);
	}
	
	@Override
	public BookingVo getSelect(String mid) {
		return bookingDao.select(mid);
	}
	
	@Override
	public ArrayList<BookingVo> getSelectTime() {
		return bookingDao.selectTime();
	}
	
	@Override
	public BookingVo getSelectTime(String hid) {
		return bookingDao.selectTime(hid);
	}
	
	@Override
	public int getUpdate(BookingVo bookingVo) {
		return bookingDao.update(bookingVo);
	}
	
	@Override
	public int getDelete(String bid) {
		return bookingDao.delete(bid);
	}

}

