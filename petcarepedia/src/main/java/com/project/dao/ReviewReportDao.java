package com.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.vo.ReviewReportVo;

@Repository
public class ReviewReportDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	/* ���� �Ű� �Է�	 */
	public int reviewReport(ReviewReportVo reviewReportVo) {
		return sqlSession.insert("mapper.reviewReport.report", reviewReportVo);
	}
	
	/* �ߺ� �Ű� Ȯ�� */
	public int reviewReportCheck(ReviewReportVo reviewReportVo) {
		return sqlSession.selectOne("mapper.reviewReport.check", reviewReportVo);
	}

}
