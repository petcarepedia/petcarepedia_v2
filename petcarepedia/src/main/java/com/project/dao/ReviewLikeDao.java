package com.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.vo.ReviewLikeVo;

@Repository
public class ReviewLikeDao extends DBConn {
	
	@Autowired
	private SqlSession sqlSession;

	/*
	 * ���ƿ� ����  //���ƿ� ���� ���̵� ����
	 */
	
	public int LikesDownID(ReviewLikeVo reviewLikeVo) {
		return sqlSession.delete("mapper.reviewlike.likesDownID", reviewLikeVo);
		/*
		String sql = "delete pcp_review_like where rid = ? and mid = ?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, reviewLikeVo.getRid());
			pstmt.setString(2, reviewLikeVo.getMid());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reviewLikeVo;
		*/
	}
	
	/*
	 * ���ƿ� ����
	 */
	
	public int LikesDown(ReviewLikeVo reviewLikeVo) {
		return sqlSession.update("mapper.reviewlike.likesDown", reviewLikeVo);
		/*
		int result = 0;
		String sql = "update pcp_review set rlike = rlike-1 where rid = ?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, reviewLikeVo.getRid());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		*/
	}
	
	
	/*
	 * ���ƿ� ����  //���ƿ� ���� ���̵� ����
	 */
	
	public int LikesUpID(ReviewLikeVo reviewLikeVo) {
		return sqlSession.insert("mapper.reviewlike.likesUpID", reviewLikeVo);
		/*
		String sql = "insert into pcp_review_like(rid, mid, like_state) values(?,?,'O')";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, reviewLikeVo.getRid());
			pstmt.setString(2, reviewLikeVo.getMid());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reviewLikeVo;
		*/
	}
	
	
	/*
	 * ���ƿ� ����
	 */
	
	public int LikesUp(ReviewLikeVo reviewLikeVo) {
		return sqlSession.update("mapper.reviewlike.likesUp", reviewLikeVo);
		/*
		int result = 0;
		String sql = "update pcp_review set rlike = rlike+1 where rid = ?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, reviewLikeVo.getRid());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		*/
	}
	
	
	
	// ���ƿ� ���� ���̵� üũ (���ƿ� ���� = 1/ �ȴ��� = 0)
	public int idCheck(ReviewLikeVo reviewLikeVo) {
		return sqlSession.selectOne("mapper.reviewlike.idCheck", reviewLikeVo);
		/*
		int result=0;
		String sql = "select count(*) from pcp_review_like where mid=? and rid=?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, reviewLikeVo.getMid());
			pstmt.setString(2, reviewLikeVo.getRid());
			rs = pstmt.executeQuery();
			while(rs.next()) result=rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		*/
	}
}
