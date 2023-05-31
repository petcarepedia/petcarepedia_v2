package com.project.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.project.vo.ReviewLikeVo;
import com.project.vo.ReviewVo;

@Repository
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
				list.setRno(rs.getInt(1));
				list.setRid(rs.getString(2));
				list.setRcontent(rs.getString(3));
				list.setRdate(rs.getString(4));
				list.setRlike(rs.getInt(5));
				list.setRstar(rs.getFloat(6));
				list.setRstate(rs.getString(7));
				list.setMid(rs.getString(8));
				list.setHid(rs.getString(9));
				list.setHname(rs.getString(10));
				list.setAnimal(rs.getString(11));
				list.setGloc(rs.getString(12));
				list.setLoc(rs.getString(13));
				list.setTel(rs.getString(14));
				list.setHtime(rs.getString(15));
				list.setNtime(rs.getString(16));
				list.setHoliday(rs.getString(17));
				list.setIntro(rs.getString(18));
				list.setImg(rs.getString(19));
				list.setHrink(rs.getString(20));
				
				RHList.add(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RHList;
	}

	
	
	public ArrayList<ReviewVo> RM_select(String hid) {
		ArrayList<ReviewVo> RM_select = new ArrayList<ReviewVo>();
		String sql = "SELECT ROWNUM RNO, RID, M.NICKNAME, RCONTENT, TO_CHAR(RDATE, 'YYYY-MM-DD') RDATE, RLIKE, ROUND(RSTAR, 0) RSTAR" + 
				" FROM (SELECT * FROM PCP_REVIEW R, PCP_HOSPITAL H" + 
				"        WHERE R.HID = H.HID AND H.HID=?" + 
				"        ORDER BY R.RDATE) T, PCP_MEMBER M " + 
				"        WHERE T.MID = M.MID";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, hid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewVo list = new ReviewVo();
				list.setRno(rs.getInt(1));
				list.setRid(rs.getString(2));
				list.setNickname(rs.getString(3));
				list.setRcontent(rs.getString(4));
				list.setRdate(rs.getString(5));
				list.setRlike(rs.getInt(6));
				list.setRstar(rs.getFloat(7));
				
				RM_select.add(list);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RM_select;
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
				list.setRstar(rs.getFloat(6));
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
	

	// 리뷰 리스트 페이징 처리
	public ArrayList<ReviewVo> selectList(int startCount, int endCount) {
		ArrayList<ReviewVo> reviewList = new ArrayList<ReviewVo>();
		String sql = "select rno, rid, rcontent, rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc"
				+ " from (select rownum rno, rid, rcontent, to_char(rdate,'yyyy-mm-dd') rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc " + 
				" from (select r.rid, r.rcontent, r.rdate, r.rlike, r.rstar, r.rstate, r.mid, r.hid, h.hname, h.animal, h.gloc from pcp_review r, pcp_hospital h " + 
				" where r.hid=h.hid order by r.rdate desc))"
				+ " where rno between ? and ? ";
		getPreparedStatement(sql);
		try {
			pstmt.setInt(1, startCount);
			pstmt.setInt(2, endCount);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewVo list = new ReviewVo();
				
				list.setRno(rs.getInt(1));
				list.setRid(rs.getString(2));
				list.setRcontent(rs.getString(3));
				list.setRdate(rs.getString(4));
				list.setRlike(rs.getInt(5));
				list.setRstar(rs.getFloat(6));
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
	
	
	
	// 검색 리뷰 리스트 페이징 처리
	public ArrayList<ReviewVo> selectSearchList(int startCount, int endCount, String filter_location) {
		ArrayList<ReviewVo> reviewList = new ArrayList<ReviewVo>();
		String sql = "select rno, rid, rcontent, rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc " + 
				"from (select rownum rno, rid, rcontent, to_char(rdate,'yyyy-mm-dd') rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc " + 
				"from (select r.rid, r.rcontent, r.rdate, r.rlike, r.rstar, r.rstate, r.mid, r.hid, h.hname, h.animal, h.gloc from pcp_review r, pcp_hospital h " + 
				"where r.hid=h.hid order by r.rdate desc) where gloc = ?) " + 
				"where rno between ? and ?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, filter_location);
			pstmt.setInt(2, startCount);
			pstmt.setInt(3, endCount);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewVo list = new ReviewVo();
				
				list.setRno(rs.getInt(1));
				list.setRid(rs.getString(2));
				list.setRcontent(rs.getString(3));
				list.setRdate(rs.getString(4));
				list.setRlike(rs.getInt(5));
				list.setRstar(rs.getFloat(6));
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
	
	
	/* 리뷰 검색 카운트 가져오기(totalrowcount)*/
	public int SearchRowCount(String filter_location) {
			int count = 0;
			String sql = "select count(*)\r\n" + 
					"from (select rownum rno, rid, rcontent, to_char(rdate,'yyyy-mm-dd') rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc\r\n" + 
					"from (select r.rid, r.rcontent, r.rdate, r.rlike, r.rstar, r.rstate, r.mid, r.hid, h.hname, h.animal, h.gloc from pcp_review r, pcp_hospital h\r\n" + 
					"where r.hid=h.hid order by r.rdate desc) where gloc = ?)";
			getPreparedStatement(sql);

			try {
				pstmt.setString(1, filter_location);
				rs = pstmt.executeQuery();
				while(rs.next()) {				
					count = rs.getInt(1);
				}			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return count;		
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
				reviewVo.setRstar(rs.getFloat(6));
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
				reviewVo.setRstar(rs.getFloat(6));
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
		String sql = "insert into pcp_review(rid, rcontent, rdate, rlike, rstar, rstate, mid, hid,bid )"
				+ " values('R_'||ltrim(to_char(sequ_pcp_review_rid.nextval,'0000')),?,sysdate,0,?,'X',?,?,?)";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, reviewVo.getRcontent());
			if(reviewVo.getRstar() == 0) {
				pstmt.setFloat(2, 1);
			} else {
				pstmt.setFloat(2, reviewVo.getRstar());
			}
			pstmt.setString(3, reviewVo.getMid());
			pstmt.setString(4, reviewVo.getHid());
			pstmt.setString(5, reviewVo.getBid());
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
			pstmt.setFloat(2, reviewVo.getRstar());
			pstmt.setString(3, reviewVo.getRid());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/*
	 * 리뷰 신고
	 */
	public int update(String rid) {
		int result = 0;
		String sql = "update pcp_review set rstate='O' where rid=?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, rid);
			
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
		
		String sql = "select rno,rid,hid,rcontent,hname,gloc,rdate,rlike,rstar,mid\r\n" + 
				"from(select rownum rno,rid,hid,rcontent,hname,gloc,rdate,rlike,rstar,mid\r\n" + 
				"from(select rid,r.hid,rcontent,hname,gloc,to_char(rdate,'yyyy-mm-dd') rdate,rlike,rstar,mid\r\n" + 
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
				reviewVo.setRstar(rs.getFloat(9));
				reviewVo.setMid(rs.getString(10));
				
				
				list.add(reviewVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
	/* 전체 카운트 가져오기*/
	public int totalRowCount() {
			int count = 0;
			String sql = "select count(*) from pcp_review";
			getPreparedStatement(sql);
			
			try {
				rs = pstmt.executeQuery();
				while(rs.next()) {				
					count = rs.getInt(1);
				}			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return count;		
		}

	
	//내가 쓴 리뷰 
	public ArrayList<ReviewVo> my_select(String mid) {
		ArrayList<ReviewVo> list = new ArrayList<ReviewVo>();
		String sql = "select h.hname, m.nickname, h.tel, h.gloc, r.rcontent, rid, r.bid, h.img\r\n" + 
				"from pcp_review r, pcp_member m, pcp_hospital h, pcp_booking b where r.mid = m.mid and h.hid = r.hid and b.bid = r.bid and r.mid = ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewVo reviewVo = new ReviewVo();
				reviewVo.setHname(rs.getString(1));
				reviewVo.setNickname(rs.getString(2));
				reviewVo.setTel(rs.getString(3));
				reviewVo.setGloc(rs.getString(4));
				reviewVo.setRcontent(rs.getString(5));
				reviewVo.setRid(rs.getString(6));
				reviewVo.setBid(rs.getString(7));
				reviewVo.setImg(rs.getString(8));
				list.add(reviewVo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	

	
	/*
	 * 좋아요 감소  //좋아요 누른 아이디 삭제
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
	 * 좋아요 감소
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
	 * 좋아요 증가  //종아요 누른 아이디 생성
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
	 * 좋아요 증가
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
	
	
	
	// 종아요 누른 아이디 체크 (종아요 누름 = 1/ 안누름 = 0)
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