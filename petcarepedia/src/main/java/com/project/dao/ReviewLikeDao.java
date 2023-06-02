package com.project.dao;

import org.springframework.stereotype.Repository;

import com.project.vo.ReviewLikeVo;

@Repository
public class ReviewLikeDao extends DBConn {

	/*
	 * ���ƿ� ����  //���ƿ� ���� ���̵� ����
	 */
	
	public ReviewLikeVo LikesDownID(ReviewLikeVo reviewLikeVo) {
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
	}
	
	/*
	 * ���ƿ� ����
	 */
	
	public int LikesDown(ReviewLikeVo reviewLikeVo) {
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
	}
	
	
	/*
	 * ���ƿ� ����  //���ƿ� ���� ���̵� ����
	 */
	
	public ReviewLikeVo LikesUpID(ReviewLikeVo reviewLikeVo) {
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
	}
	
	
	/*
	 * ���ƿ� ����
	 */
	
	public int LikesUp(ReviewLikeVo reviewLikeVo) {
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
	}
	
	
	
	// ���ƿ� ���� ���̵� üũ (���ƿ� ���� = 1/ �ȴ��� = 0)
	public int idCheck(ReviewLikeVo reviewLikeVo) {
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
	}
}