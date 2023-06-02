package com.project.service;

import java.util.ArrayList;

import com.project.vo.BookingReviewVo;
import com.project.vo.BookingVo;


public interface BookingService {
	
	public int getInsert(BookingVo bookingVo);
	public ArrayList<BookingVo> getSelect();
	public ArrayList<BookingVo> getSearch(String mid);
	public ArrayList<BookingVo> getSearch1(String mid);
	public ArrayList<BookingVo> getSearch2(String mid);
	public ArrayList<BookingReviewVo> getSearch3(String mid);
	public BookingVo getSelect(String mid);
	public ArrayList<BookingVo> getSelectTime();
	public BookingVo getSelectTime(String hid);
	public int getUpdate(BookingVo bookingVo);
	public int getDelete(String bid);

}
