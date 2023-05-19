package com.project.dao;

import java.util.ArrayList;

import com.project.vo.ReviewVo;

public class ReviewDao extends DBConn {
	
	
	
	
	
	
	// 리뷰와 병원 조인
	public ArrayList<ReviewVo> RH_select() {
		ArrayList<ReviewVo> RHList = new ArrayList<ReviewVo>();
		String sql = "select r.rid, r.rcontent, r.rdate, r.rlike, r.rstar, r.rstate, r.mid, r.hid, h.hname, h.animal, "
				+ " h.gloc, h.loc, h.tel, h.htime, h.ntime, h.holiday, h.intro, h.img, h.hrink "
				+ " from pcp_review r, pcp_hospital h where r.hid=h.hid and h.hid = 'H_0074' order by r.rdate desc";
		getPreparedStatement(sql);
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewVo list = new ReviewVo();
				list.setRid(rs.getString(1));
				list.setRcontent(rs.getString(2));
				list.setRdate(rs.getString(3));
				list.setRlike(rs.getInt(4));
				list.setRstar(rs.getString(5));
				list.setRstate(rs.getString(6));
				list.setMid(rs.getString(7));
				list.setHid(rs.getString(8));
				list.setHname(rs.getString(9));
				list.setAnimal(rs.getString(10));
				list.setGloc(rs.getString(11));
				list.setLoc(rs.getString(12));
				list.setTel(rs.getString(13));
				list.setHtime(rs.getString(14));
				list.setNtime(rs.getString(15));
				list.setHoliday(rs.getString(16));
				list.setIntro(rs.getString(17));
				list.setImg(rs.getString(18));
				list.setHrink(rs.getString(19));
				
				RHList.add(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RHList;
	}
	
	
	
	
	
	
	
	
	// 리뷰 리스트
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
	 *  리뷰 상세보기
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
	 * 리뷰 등록하기
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
	 * 리뷰 수정
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
	 * 리뷰 삭제
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
	
	//
	
}
