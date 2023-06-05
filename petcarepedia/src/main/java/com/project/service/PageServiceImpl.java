package com.project.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.dao.NoticeDao;
import com.project.dao.PageDao;
import com.project.dao.ReviewDao;

public class PageServiceImpl {
	
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private ReviewDao reviewDao;
	@Autowired
	private PageDao pageDao;
	
	


	public Map<String, Integer> getPageResult(String page, String serviceName) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		// 페이징 처리 - startCount, endCount 구하기
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
		else if(serviceName.equals("hospital")) {
			dbCount = pageDao.HtotalRowCount();
			pageSize = 10;
		}
		else if(serviceName.equals("member")) {
			dbCount = pageDao.HtotalRowCount();
			pageSize = 10;
		}
		else if(serviceName.equals("booking")) {
			dbCount = pageDao.HtotalRowCount();
			pageSize = 10;
		}

		// 총 페이지 수 계산
		if (dbCount % pageSize == 0) {
			pageCount = dbCount / pageSize;
		} else {
			pageCount = dbCount / pageSize + 1;
		}

		// 요청 페이지 계산
		if (page != null) {
			reqPage = Integer.parseInt(page);
			startCount = (reqPage - 1) * pageSize + 1;
			endCount = reqPage * pageSize;
		} else {
			if(serviceName.equals("notice"))  {
				startCount = 1;
				endCount = 10;
			}
			else if(serviceName.equals("review")) {
				startCount = 1;
				endCount = 7;				
			}
			else if(serviceName.equals("hospital")) {
				startCount = 1;
				endCount = 7;				
			}
			else if(serviceName.equals("member")) {
				startCount = 1;
				endCount = 7;				
			}
			else if(serviceName.equals("booking")) {
				startCount = 1;
				endCount = 7;				
			}
			else {
				startCount = 1;
				endCount = 5;
			}

		}
		
		
		//param 객체에 데이터 put
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("dbCount", dbCount);
		param.put("pageSize", pageSize);
		param.put("maxSize", pageCount);
		param.put("page", reqPage);
		
		
		return param;
	}
}
