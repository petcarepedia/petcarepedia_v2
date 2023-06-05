package com.project.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.NoticeDao;
import com.project.dao.ReviewDao;


@Service("pageService")
public class PageServiceImpl {
	
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private ReviewDao reviewDao;


	public Map<String, Integer> getPageResult(String page, String serviceName) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		// ����¡ ó�� - startCount, endCount ���ϱ�
		int count = 0;
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5; // ���������� �Խù� ��
		int reqPage = 1; // ��û������
		int pageCount = 1; // ��ü ������ ��
		int dbCount = 0; // DB���� ������ ��ü ���

		
		
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
		if(serviceName.equals("review") || serviceName.equals("reviewSearch")) {
			pageCount = 7;
		}
		else {
			// �� ������ �� ���
			if (dbCount % pageSize == 0) {
				pageCount = dbCount / pageSize;
			} else {
				pageCount = dbCount / pageSize + 1;
			}
		}

		// ��û ������ ���
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
			else {
				startCount = 1;
				endCount = 5;
			}

		}
		
		
		//param ��ü�� ������ put
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
