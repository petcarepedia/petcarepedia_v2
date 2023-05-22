package com.project.dao;

import java.util.ArrayList;

import com.project.vo.ReviewVo;

public class ReviewDao extends DBConn {
	
	
	// 리뷰와 병원 조인
	public ArrayList<ReviewVo> RH_select(String hid) {
		ArrayList<ReviewVo> RHList = new ArrayList<ReviewVo>();
		String sql = "select rownum rno, rid, rcontent, to_char(rdate,'yyyy-mm-dd') rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc, loc, tel, htime, ntime, holiday, intro, img, hrink\r\n" + 
				"from (select r.rid, r.rcontent, r.rdate, r.rlike, r.rstar, r.rstate, r.mid, r.hid, h.hname, h.animal, h.gloc, h.loc, h.tel, h.htime, h.ntime, h.holiday, h.intro, h.img, h.hrink \r\n" + 
				"from pcp_review r, pcp_hospital h where r.hid=h.hid and h.hid = ? order by r.rdate desc)";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, hid);
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
		String sql = "select rownum rno, rid, rcontent, to_char(rdate,'yyyy-mm-dd') rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc " + 
				" from (select r.rid, r.rcontent, r.rdate, r.rlike, r.rstar, r.rstate, r.mid, r.hid, h.hname, h.animal, h.gloc from pcp_review r, pcp_hospital h " + 
				" where r.hid=h.hid order by r.rdate desc)";
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
	

	
	
	// 베스트 리뷰 리스트 3개 출력
	public ArrayList<ReviewVo> best_select3() {
		ArrayList<ReviewVo> reviewList = new ArrayList<ReviewVo>();
		String sql = "select rno, rid, rcontent, rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc " + 
				" from (select rownum rno, rid, rcontent, to_char(rdate,'yyyy-mm-dd') rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc " + 
				" from (select r.rid, r.rcontent, r.rdate, r.rlike, r.rstar, r.rstate, r.mid, r.hid, h.hname, h.animal, h.gloc from pcp_review r, pcp_hospital h " + 
				" where r.hid=h.hid order by r.rlike desc))" + 
				" where rno <= 3";
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
	
	
	
	// 베스트 리뷰 리스트 9개 출력
	public ArrayList<ReviewVo> best_select() {
		ArrayList<ReviewVo> reviewList = new ArrayList<ReviewVo>();
		String sql = "select rno, rid, rcontent, rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc " + 
				" from (select rownum rno, rid, rcontent, to_char(rdate,'yyyy-mm-dd') rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc " + 
				" from (select r.rid, r.rcontent, r.rdate, r.rlike, r.rstar, r.rstate, r.mid, r.hid, h.hname, h.animal, h.gloc from pcp_review r, pcp_hospital h " + 
				" where r.hid=h.hid order by r.rlike desc))" + 
				" where rno <= 9";
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
	public ReviewVo select(String rid) {
		ReviewVo reviewVo = new ReviewVo();
		String sql = "select rownum rno, rid, rcontent, to_char(rdate,'yyyy-mm-dd') rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc " + 
				" from (select r.rid, r.rcontent, r.rdate, r.rlike, r.rstar, r.rstate, r.mid, r.hid, h.hname, h.animal, h.gloc from pcp_review r, pcp_hospital h " + 
				" where r.hid=h.hid) where rid = ?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, rid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				reviewVo.setRno(rs.getInt(1));
				reviewVo.setRid(rs.getString(2));
				reviewVo.setRcontent(rs.getString(3));
				reviewVo.setRdate(rs.getString(4));
				reviewVo.setRlike(rs.getInt(5));
				reviewVo.setRstar(rs.getString(6));
				reviewVo.setRstate(rs.getString(7));
				reviewVo.setMid(rs.getString(8));
				reviewVo.setHid(rs.getString(9));
				reviewVo.setHname(rs.getString(10));
				reviewVo.setAnimal(rs.getString(11));
				reviewVo.setGloc(rs.getString(12));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewVo;
	}
	
	
	/*
	 *  리뷰 상세보기 띄어쓰기
	 */
	public ReviewVo enter_select(String rid) {
		ReviewVo reviewVo = new ReviewVo();
		String sql = "select rownum rno, rid, rcontent, to_char(rdate,'yyyy-mm-dd') rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc " + 
				" from (select r.rid, r.rcontent, r.rdate, r.rlike, r.rstar, r.rstate, r.mid, r.hid, h.hname, h.animal, h.gloc from pcp_review r, pcp_hospital h " + 
				" where r.hid=h.hid) where rid = ?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, rid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				reviewVo.setRno(rs.getInt(1));
				reviewVo.setRid(rs.getString(2));
				reviewVo.setRcontent(rs.getString(3));
				reviewVo.setRdate(rs.getString(4));
				reviewVo.setRlike(rs.getInt(5));
				reviewVo.setRstar(rs.getString(6));
				reviewVo.setRstate(rs.getString(7));
				reviewVo.setMid(rs.getString(8));
				reviewVo.setHid(rs.getString(9));
				reviewVo.setHname(rs.getString(10));
				reviewVo.setAnimal(rs.getString(11));
				reviewVo.setGloc(rs.getString(12));
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
		String sql = "insert into pcp_review(rid, rcontent, rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc)"
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
		String sql = "update pcp_review set rcontent=?, rstar=? where rid=?";
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
	
	//베스트리뷰

	/**
	 * select - 베스트리뷰
	 */
	public ArrayList<ReviewVo> select(int startCount, int endCount) {
		ArrayList<ReviewVo> list = new ArrayList<ReviewVo>();
		
		String sql = "select rno,rid,hid,rcontent,hname,gloc,rdate,rlike,rstar\r\n" + 
				"from(select rownum rno,rid,hid,rcontent,hname,gloc,rdate,rlike,rstar\r\n" + 
				"from(select rid,r.hid,rcontent,hname,gloc,to_char(rdate,'yyyy-mm-dd') rdate,rlike,rstar\r\n" + 
				"from pcp_review r, pcp_hospital h\r\n" + 
				"where r.hid=h.hid\r\n" + 
				"order by rlike desc))\r\n" + 
				"where rno between ? and ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, startCount);
			pstmt.setInt(2, endCount);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewVo reviewVo = new ReviewVo();
				
				reviewVo.setRno(rs.getInt(1));
				reviewVo.setRid(rs.getString(2));
				reviewVo.setHid(rs.getString(3));
				reviewVo.setRcontent(rs.getString(4));
				reviewVo.setHname(rs.getString(5));
				reviewVo.setGloc(rs.getString(6));
				reviewVo.setRdate(rs.getString(7));
				reviewVo.setRlike(rs.getInt(8));
				reviewVo.setRstar(rs.getString(9));
				
				
				list.add(reviewVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
