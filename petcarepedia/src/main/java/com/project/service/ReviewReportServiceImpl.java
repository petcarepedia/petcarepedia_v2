package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ReviewReportDao;
import com.project.vo.ReviewReportVo;

@Service("reviewReportService")
public class ReviewReportServiceImpl implements ReviewReportService {

	@Autowired
	private ReviewReportDao reviewReportDao;
	
	@Override
	public int getReviewReport(ReviewReportVo reviewReportVo) {
		return reviewReportDao.reviewReport(reviewReportVo);
	}
	
	@Override
	public int getReiviewReportCheck(ReviewReportVo reviewReportVo) {
		return reviewReportDao.reviewReportCheck(reviewReportVo);
	}

}
