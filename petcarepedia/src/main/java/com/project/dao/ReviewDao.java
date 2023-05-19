package com.project.dao;

import java.util.ArrayList;

import com.project.vo.ReviewVo;

public class ReviewDao extends DBConn {
	
	// ¸®ºä ¸®½ºÆ®
	public ArrayList<ReviewVo> select() {
		ArrayList<ReviewVo> reviewList = new ArrayList<ReviewVo>();
		String sql = "select rownum rno, rid, rcontent, to_char(rdate,'yyyy-mm-dd hh24:mi') rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc " + 
				" from (select r.rid, r.rcontent, r.rdate, r.rlike, r.rstar, r.rstate, r.mid, r.hid, h.hname, h.animal, h.gloc from pcp_review r, pcp_hospital h "
				+ " where r.hid=h.hid order by r.rdate desc)";
		getPreparedStatement(sql);
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewVo list = new ReviewVo();
				list.setRno(rs.getInt(1));
				list.setRid(rs.getString(2));
				list.setRcontent(rs.getString(3));
				list.setRdate(rs.getString(4));
				list.setRlike(rs.getInt(5));
				list.setRstar(rs.getString(6));
				list.setRstate(rs.getString(7));
				list.setMid(rs.getString(8));
				list.setHid(rs.getString(9));
				list.setHname(rs.getString(10));
				list.setAnimal(rs.getString(11));
				list.setGloc(rs.getString(12));
				
				reviewList.add(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewList;
	}
	/*
	 *  ¸®ºä »ó¼¼º¸±â
	 */
	public ReviewVo select(String nid) {
		ReviewVo reviewVo = new ReviewVo();
		String sql = "select rid, rcontent, to_char(rdate,'yyyy-mm-dd hh24:mi') rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc from pcp_notice where rid = ? ";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, nid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				reviewVo.setRid(rs.getString(1));
				reviewVo.setRcontent(rs.getString(2));
				reviewVo.setRdate(rs.getString(3));
				reviewVo.setRlike(rs.getInt(4));
				reviewVo.setRstar(rs.getString(5));
				reviewVo.setRstate(rs.getString(6));
				reviewVo.setMid(rs.getString(7));
				reviewVo.setHid(rs.getString(8));
				reviewVo.setHname(rs.getString(9));
				reviewVo.setAnimal(rs.getString(10));
				reviewVo.setGloc(rs.getString(11));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewVo;
	}
	
	/*
	 * ¸®ºä µî·ÏÇÏ±â
	 */
	public int insert(ReviewVo reviewVo) {
		int result = 0;
		String sql = "insert into pcp_notice(rid, rcontent, rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc)"
				+ " values('r_'||ltrim(to_char(sequ_pcp_review_rid.nextval,'0000')),?,sysdate,0,?,'defualt',?,?,?,?,?)";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, reviewVo.getRcontent());
			pstmt.setString(2, reviewVo.getRstar());
			pstmt.setString(3, reviewVo.getMid());
			pstmt.setString(4, reviewVo.getHid());
			pstmt.setString(5, reviewVo.getHname());
			pstmt.setString(6, reviewVo.getAnimal());
			pstmt.setString(7, reviewVo.getGloc());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/*
	 * ¸®ºä ¼öÁ¤
	 */
	public int update(ReviewVo reviewVo) {
		int result = 0;
		String sql = "update pcp_reviewVo set rcontent=?, rstar=? where rid=?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, reviewVo.getRcontent());
			pstmt.setString(2, reviewVo.getRstar());
			pstmt.setString(3, reviewVo.getRid());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/*
	 * ¸®ºä »èÁ¦
	 */
	public int delete(String rid) {
		int result = 0;
		String sql = "delete pcp_review where rid=?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, rid);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
