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

	public Map<String, Integer> getPageResultRS(String page, String serviceName, String filter_location) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		// 占쎈읂占쎌뵠筌욑옙 筌ｌ꼶�봺 - startCount, endCount �뤃�뗫릭疫뀐옙
		int count = 0;
		int startCount = 0;
		int endCount = 0;
		int pageSize = 7; // 占쎈립占쎈읂占쎌뵠筌욑옙占쎈뼣 野껊슣�뻻�눧占� 占쎈땾
		int reqPage = 1; // 占쎌뒄筌ｏ옙占쎈읂占쎌뵠筌욑옙
		int pageCount = 7; // 占쎌읈筌ｏ옙 占쎈읂占쎌뵠筌욑옙 占쎈땾
		int dbCount = 0; // DB占쎈퓠占쎄퐣 揶쏉옙占쎌죬占쎌궔 占쎌읈筌ｏ옙 占쎈뻬占쎈땾

		
		dbCount = reviewDao.SearchRowCount(filter_location);
		
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
		

		// 占쎌뒄筌ｏ옙 占쎈읂占쎌뵠筌욑옙 �④쑴沅�
		if (page != null) {
			reqPage = Integer.parseInt(page);
			startCount = (reqPage - 1) * pageSize + 1;
			endCount = reqPage * pageSize;
			if(serviceName.equals("review")) {
				count++;
			}
		} else {

			if(serviceName.equals("review") || serviceName.equals("reviewSearch")) {
				startCount = 1;
				endCount = 7;	
			}
			else {
				startCount = 1;
				endCount = 5;
			}

		}
		
		//param 揶쏆빘猿쒙옙肉� 占쎈쑓占쎌뵠占쎄숲 put
		param.put("count", count);
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("dbCount", dbCount);
		param.put("pageSize", pageSize);
		param.put("maxSize", pageCount);
		param.put("page", reqPage);
		
		
		return param;
	}
	
	
	
	public Map<String, Integer> getPageResult(String page, String serviceName) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		// 占쎈읂占쎌뵠筌욑옙 筌ｌ꼶�봺 - startCount, endCount �뤃�뗫릭疫뀐옙
		int count = 0;
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5; // 占쎈립占쎈읂占쎌뵠筌욑옙占쎈뼣 野껊슣�뻻�눧占� 占쎈땾
		int reqPage = 1; // 占쎌뒄筌ｏ옙占쎈읂占쎌뵠筌욑옙
		int pageCount = 1; // 占쎌읈筌ｏ옙 占쎈읂占쎌뵠筌욑옙 占쎈땾
		int dbCount = 0; // DB占쎈퓠占쎄퐣 揶쏉옙占쎌죬占쎌궔 占쎌읈筌ｏ옙 占쎈뻬占쎈땾

		
		
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
		

		// 占쎌뒄筌ｏ옙 占쎈읂占쎌뵠筌욑옙 �④쑴沅�
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
		
		//param 揶쏆빘猿쒙옙肉� 占쎈쑓占쎌뵠占쎄숲 put
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
		// 占쎈읂占쎌뵠筌욑옙 筌ｌ꼶�봺 - startCount, endCount �뤃�뗫릭疫뀐옙
		int count = 0;
		int startCount = 0;
		int endCount = 0;
		int pageSize = 10; // 占쎈립占쎈읂占쎌뵠筌욑옙占쎈뼣 野껊슣�뻻�눧占� 占쎈땾
		int reqPage = 1; // 占쎌뒄筌ｏ옙占쎈읂占쎌뵠筌욑옙
		int pageCount = 10; // 占쎌읈筌ｏ옙 占쎈읂占쎌뵠筌욑옙 占쎈땾
		int dbCount = 0; // DB占쎈퓠占쎄퐣 揶쏉옙占쎌죬占쎌궔 占쎌읈筌ｏ옙 占쎈뻬占쎈땾
		
		if (serviceName.equals("hospital")) {
			dbCount = pageDao.HtotalRowCount();
			pageSize = 10;
		}else {
			dbCount = pageDao.HstotalRowCount(serviceName);
			pageSize = 10;
		}
		
		// 占쎌뒄筌ｏ옙 占쎈읂占쎌뵠筌욑옙 �④쑴沅�
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
		//param 揶쏆빘猿쒙옙肉� 占쎈쑓占쎌뵠占쎄숲 put
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
		// 占쎈읂占쎌뵠筌욑옙 筌ｌ꼶�봺 - startCount, endCount �뤃�뗫릭疫뀐옙
		int count = 0;
		int startCount = 0;
		int endCount = 0;
		int pageSize = 10; // 占쎈립占쎈읂占쎌뵠筌욑옙占쎈뼣 野껊슣�뻻�눧占� 占쎈땾
		int reqPage = 1; // 占쎌뒄筌ｏ옙占쎈읂占쎌뵠筌욑옙
		int pageCount = 5; // 占쎌읈筌ｏ옙 占쎈읂占쎌뵠筌욑옙 占쎈땾
		int dbCount = 0; // DB占쎈퓠占쎄퐣 揶쏉옙占쎌죬占쎌궔 占쎌읈筌ｏ옙 占쎈뻬占쎈땾
		
		if (serviceName.equals("member")) {
			dbCount = pageDao.MtotalRowCount();
			pageSize = 10;
		}else {
			dbCount = pageDao.MstotalRowCount(serviceName);
			pageSize = 10;
		}
		
		// 占쎌뒄筌ｏ옙 占쎈읂占쎌뵠筌욑옙 �④쑴沅�
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
		//param 揶쏆빘猿쒙옙肉� 占쎈쑓占쎌뵠占쎄숲 put
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
		// 占쎈읂占쎌뵠筌욑옙 筌ｌ꼶�봺 - startCount, endCount �뤃�뗫릭疫뀐옙
		int count = 0;
		int startCount = 0;
		int endCount = 0;
		int pageSize = 10; // 占쎈립占쎈읂占쎌뵠筌욑옙占쎈뼣 野껊슣�뻻�눧占� 占쎈땾
		int reqPage = 1; // 占쎌뒄筌ｏ옙占쎈읂占쎌뵠筌욑옙
		int pageCount = 5; // 占쎌읈筌ｏ옙 占쎈읂占쎌뵠筌욑옙 占쎈땾
		int dbCount = 0; // DB占쎈퓠占쎄퐣 揶쏉옙占쎌죬占쎌궔 占쎌읈筌ｏ옙 占쎈뻬占쎈땾
		
		if (serviceName.equals("booking")) {
			dbCount = pageDao.BtotalRowCount();
			pageSize = 10;
		}else {
			dbCount = pageDao.BstotalRowCount(serviceName);
			pageSize = 10;
		}
		
		// 占쎌뒄筌ｏ옙 占쎈읂占쎌뵠筌욑옙 �④쑴沅�
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
		//param 揶쏆빘猿쒙옙肉� 占쎈쑓占쎌뵠占쎄숲 put
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
		// 占쎈읂占쎌뵠筌욑옙 筌ｌ꼶�봺 - startCount, endCount �뤃�뗫릭疫뀐옙
		int count = 0;
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5; // 占쎈립占쎈읂占쎌뵠筌욑옙占쎈뼣 野껊슣�뻻�눧占� 占쎈땾
		int reqPage = 1; // 占쎌뒄筌ｏ옙占쎈읂占쎌뵠筌욑옙
		int pageCount = 5; // 占쎌읈筌ｏ옙 占쎈읂占쎌뵠筌욑옙 占쎈땾
		int dbCount = 0; // DB占쎈퓠占쎄퐣 揶쏉옙占쎌죬占쎌궔 占쎌읈筌ｏ옙 占쎈뻬占쎈땾
		dbCount = pageDao.MystotalRowCount(serviceName);
		// 占쎌뒄筌ｏ옙 占쎈읂占쎌뵠筌욑옙 �④쑴沅�
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
		//param 揶쏆빘猿쒙옙肉� 占쎈쑓占쎌뵠占쎄숲 put
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
