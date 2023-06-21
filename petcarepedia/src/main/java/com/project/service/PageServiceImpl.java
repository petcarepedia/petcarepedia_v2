package com.project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.NoticeDao;
import com.project.dao.PageDao;
import com.project.dao.ReviewDao;
import com.project.vo.BookingVo;
import com.project.vo.HospitalVo;
import com.project.vo.MemberVo;
import com.project.vo.ReviewVo;


@Service("pageService")
public class PageServiceImpl {
	
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private ReviewDao reviewDao;
	@Autowired
	private PageDao pageDao;

	public ArrayList<ReviewVo> getMyListPage(int startCount, int endCount, String mid) {
		ArrayList<ReviewVo> rlist = new ArrayList<ReviewVo>();
		List<Object> list = pageDao.Myselect(startCount, endCount, mid);
		for(Object obj : list) {
			ReviewVo reviewVo = (ReviewVo)obj;
			rlist.add(reviewVo);
		}
		return rlist;
	}

	public ArrayList<ReviewVo> getMysListPage(int startCount, int endCount) {
		ArrayList<ReviewVo> rlist = new ArrayList<ReviewVo>();
		List<Object> list = pageDao.Rselect(startCount, endCount);
		for(Object obj : list) {
			ReviewVo reviewVo = (ReviewVo)obj;
			rlist.add(reviewVo);
		}
		return rlist;
	}
	
	public ArrayList<BookingVo> getBsListPage(int startCount, int endCount, String mid) {
		ArrayList<BookingVo> rlist = new ArrayList<BookingVo>();
		List<Object> list = pageDao.Bsselect(startCount, endCount, mid);
		for(Object obj : list) {
			BookingVo bookingVo = (BookingVo)obj;
			rlist.add(bookingVo);
		}
		return rlist;
	}
	
	public ArrayList<MemberVo> getMsListPage(int startCount, int endCount, String mid) {
		ArrayList<MemberVo> rlist = new ArrayList<MemberVo>();
		List<Object> list = pageDao.Msselect(startCount, endCount, mid);
		for(Object obj : list) {
			MemberVo memberVo = (MemberVo)obj;
			rlist.add(memberVo);
		}
		return rlist;
	}
	
	public ArrayList<HospitalVo> getHsListPage(int startCount, int endCount, String hname) {
		ArrayList<HospitalVo> rlist = new ArrayList<HospitalVo>();
		List<Object> list = pageDao.Hsselect(startCount, endCount, hname);
		for(Object obj : list) {
			HospitalVo hospitalVo = (HospitalVo)obj;
			rlist.add(hospitalVo);
		}
		return rlist;
	}
	
	public ArrayList<ReviewVo> getRListPage(int startCount, int endCount) {
		ArrayList<ReviewVo> rlist = new ArrayList<ReviewVo>();
		List<Object> list = pageDao.Rselect(startCount, endCount);
		for(Object obj : list) {
			ReviewVo reviewVo = (ReviewVo)obj;
			rlist.add(reviewVo);
		}
		return rlist;
	}
	
	public ArrayList<BookingVo> getBListPage(int startCount, int endCount) {
		ArrayList<BookingVo> rlist = new ArrayList<BookingVo>();
		List<Object> list = pageDao.Bselect(startCount, endCount);
		for(Object obj : list) {
			BookingVo bookingVo = (BookingVo)obj;
			rlist.add(bookingVo);
		}
		return rlist;
	}
	
	public ArrayList<MemberVo> getMListPage(int startCount, int endCount) {
		ArrayList<MemberVo> rlist = new ArrayList<MemberVo>();
		List<Object> list = pageDao.Mselect(startCount, endCount);
		for(Object obj : list) {
			MemberVo memberVo = (MemberVo)obj;
			rlist.add(memberVo);
		}
		return rlist;
	}
	
	public ArrayList<HospitalVo> getHListPage(int startCount, int endCount) {
		ArrayList<HospitalVo> rlist = new ArrayList<HospitalVo>();
		List<Object> list = pageDao.Hselect(startCount, endCount);
		for(Object obj : list) {
			HospitalVo hospitalVo = (HospitalVo)obj;
			rlist.add(hospitalVo);
		}
		return rlist;
	}

	public Map<String, Integer> getPageResult(String page, String serviceName) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		// 페이징 처리 - startCount, endCount 구하기
		int count = 0;
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5; // 한페이지당 게시물 수
		int reqPage = 1; // 요청페이지
		int pageCount = 1; // 전체 페이지 수
		int dbCount = 0; // DB에서 가져온 전체 행수

		
		
		if(serviceName.equals("notice")) {
			dbCount = noticeDao.totalRowCount();
			pageSize = 10;
		}
		else if(serviceName.equals("review")) {
			dbCount = reviewDao.totalRowCount();
			pageSize = 7;
		}
		else if (serviceName.equals("reviewSearch")) {
			dbCount = reviewDao.totalRowCount();
			pageSize = 7;
		}
		else if (serviceName.equals("booking")) {
			dbCount = pageDao.BtotalRowCount();
			pageSize = 7;
		}
		else if (serviceName.equals("review2")) {
			dbCount = pageDao.RtotalRowCount();
			pageSize = 7;
		}
		else if(serviceName.equals("review") || serviceName.equals("reviewSearch")) {
			pageCount = 7;
		}
		else {
			dbCount = pageDao.HstotalRowCount(serviceName);
			pageSize = 10;
		}
		
		if (dbCount % pageSize == 0) {
			pageCount = dbCount / pageSize;
		}
		else if(serviceName.equals("review") || serviceName.equals("reviewSearch")) {
			pageCount = 7;
		}
		else if(serviceName.equals("notice")) {
			pageCount = 10;
		}		
		else {
			pageCount = dbCount / pageSize + 1;
		}
		

		// 요청 페이지 계산
		if (page != null) {
			reqPage = Integer.parseInt(page);
			startCount = (reqPage - 1) * pageSize + 1;
			endCount = reqPage * pageSize;
			if(serviceName.equals("review")) {
				count++;
			}
		} else {
			if(serviceName.equals("notice"))  {
				startCount = 1;
				endCount = 10;
			}
			else if(serviceName.equals("review") || serviceName.equals("reviewSearch")) {
				startCount = 1;
				endCount = 7;	
			}
			else if(serviceName.equals("booking")) {
				startCount = 1;
				endCount = 10;				
			}
			else if(serviceName.equals("review2")) {
				startCount = 1;
				endCount = 10;				
			}
			else if(serviceName.equals("hospital_search")) {
				startCount = 1;
				endCount = 10;				
			}
			else {
				startCount = 1;
				endCount = 5;
			}

		}
		
		//param 객체에 데이터 put
		param.put("count", count);
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("dbCount", dbCount);
		param.put("pageSize", pageSize);
		param.put("maxSize", pageCount);
		param.put("page", reqPage);
		
		
		return param;
	}
	public Map<String, Integer> getHPageResult(String page, String serviceName) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		// 페이징 처리 - startCount, endCount 구하기
		int count = 0;
		int startCount = 0;
		int endCount = 0;
		int pageSize = 10; // 한페이지당 게시물 수
		int reqPage = 1; // 요청페이지
		int pageCount = 10; // 전체 페이지 수
		int dbCount = 0; // DB에서 가져온 전체 행수
		
		if (serviceName.equals("hospital")) {
			dbCount = pageDao.HtotalRowCount();
			pageSize = 10;
		}else {
			dbCount = pageDao.HstotalRowCount(serviceName);
			pageSize = 10;
		}
		
		// 요청 페이지 계산
		if (page != null) {
			reqPage = Integer.parseInt(page);
			startCount = (reqPage - 1) * pageSize + 1;
			endCount = reqPage * pageSize;
			if(serviceName.equals("notice")) {
				count++;
			}
		} else {
			if(serviceName.equals("hospital")) {
				startCount = 1;
				endCount = 10;				
			}else {
				startCount = 1;
				endCount = 5;
			}
			
		}
		//param 객체에 데이터 put
		param.put("count", count);
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("dbCount", dbCount);
		param.put("pageSize", pageSize);
		param.put("maxSize", pageCount);
		param.put("page", reqPage);
		
		
		return param;
	}
	
	public Map<String, Integer> getMPageResult(String page, String serviceName) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		// 페이징 처리 - startCount, endCount 구하기
		int count = 0;
		int startCount = 0;
		int endCount = 0;
		int pageSize = 10; // 한페이지당 게시물 수
		int reqPage = 1; // 요청페이지
		int pageCount = 5; // 전체 페이지 수
		int dbCount = 0; // DB에서 가져온 전체 행수
		
		if (serviceName.equals("member")) {
			dbCount = pageDao.MtotalRowCount();
			pageSize = 10;
		}else {
			dbCount = pageDao.MstotalRowCount(serviceName);
			pageSize = 10;
		}
		
		// 요청 페이지 계산
		if (page != null) {
			reqPage = Integer.parseInt(page);
			startCount = (reqPage - 1) * pageSize + 1;
			endCount = reqPage * pageSize;
			if(serviceName.equals("notice")) {
				count++;
			}
		} else {
			if(serviceName.equals("member")) {
				startCount = 1;
				endCount = 10;				
			}
			
		}
		//param 객체에 데이터 put
		param.put("count", count);
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("dbCount", dbCount);
		param.put("pageSize", pageSize);
		param.put("maxSize", pageCount);
		param.put("page", reqPage);
		
		return param;
	}
	
	public Map<String, Integer> getBPageResult(String page, String serviceName) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		// 페이징 처리 - startCount, endCount 구하기
		int count = 0;
		int startCount = 0;
		int endCount = 0;
		int pageSize = 10; // 한페이지당 게시물 수
		int reqPage = 1; // 요청페이지
		int pageCount = 5; // 전체 페이지 수
		int dbCount = 0; // DB에서 가져온 전체 행수
		
		if (serviceName.equals("booking")) {
			dbCount = pageDao.BtotalRowCount();
			pageSize = 10;
		}else {
			dbCount = pageDao.BstotalRowCount(serviceName);
			pageSize = 10;
		}
		
		// 요청 페이지 계산
		if (page != null) {
			reqPage = Integer.parseInt(page);
			startCount = (reqPage - 1) * pageSize + 1;
			endCount = reqPage * pageSize;
			if(serviceName.equals("notice")) {
				count++;
			}
		} else {
			if(serviceName.equals("booking")) {
				startCount = 1;
				endCount = 10;				
			}
			
		}
		//param 객체에 데이터 put
		param.put("count", count);
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("dbCount", dbCount);
		param.put("pageSize", pageSize);
		param.put("maxSize", pageCount);
		param.put("page", reqPage);
		
		return param;
	}
	
	public Map<String, Integer> getMyPageResult(String page, String serviceName) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		// 페이징 처리 - startCount, endCount 구하기
		int count = 0;
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5; // 한페이지당 게시물 수
		int reqPage = 1; // 요청페이지
		int pageCount = 5; // 전체 페이지 수
		int dbCount = 0; // DB에서 가져온 전체 행수
		dbCount = pageDao.MystotalRowCount(serviceName);
		// 요청 페이지 계산
		if (page != null) {
			reqPage = Integer.parseInt(page);
			startCount = (reqPage - 1) * pageSize + 1;
			endCount = reqPage * pageSize;
			if(serviceName.equals("notice")) {
				count++;
			}
		} else {
			if(serviceName.equals("review")) {
				startCount = 1;
				endCount = 5;				
			}
			
		}
		System.out.println(startCount);
		System.out.println(endCount);
		//param 객체에 데이터 put
		param.put("count", count);
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("dbCount", dbCount);
		param.put("pageSize", pageSize);
		param.put("maxSize", pageCount);
		param.put("page", reqPage);
		
		return param;
	}
	
}
