package com.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.vo.ReviewReportVo;

@Repository
public class ReviewReportDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	/* 리뷰 신고 입력	 */
	public int reviewReport(ReviewReportVo reviewReportVo) {
		return sqlSession.insert("mapper.reviewReport.report", reviewReportVo);
	}
	
	/* 중복 신고 확인 */
	public int reviewReportCheck(ReviewReportVo reviewReportVo) {
		return sqlSession.selectOne("mapper.reviewReport.check", reviewReportVo);
	}

}
