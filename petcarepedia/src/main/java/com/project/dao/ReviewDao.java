package com.project.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.vo.RSpagingVo;
import com.project.vo.ReviewVo;

@Repository
public class ReviewDao extends DBConn {
	
	@Autowired
	private SqlSession sqlSession;
	
	//신고된 리뷰 조회
	public ArrayList<ReviewVo> reportList() {
		List<ReviewVo> list = sqlSession.selectList("mapper.review.reportList");
		return (ArrayList<ReviewVo>)list;
	}
	
	// 리뷰와 병원 조인
	public ArrayList<ReviewVo> RH_select(String hid) {
		return sqlSession.selectOne("mapper.review.RH_select", hid);
		/*
		ArrayList<ReviewVo> RHList = new ArrayList<ReviewVo>();
		String sql = " select rownum rno, rid, rcontent, to_char(rdate,'yyyy-mm-dd') rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc, loc, tel, htime, ntime, holiday, intro, img, hrink\r\n" + 
				" from (select r.rid, r.rcontent, r.rdate, r.rlike, r.rstar, r.rstate, r.mid, r.hid, h.hname, h.animal, h.gloc, h.loc, h.tel, h.htime, h.ntime, h.holiday, h.intro, h.img, h.hrink \r\n" + 
				" from pcp_review r, pcp_hospital h where r.hid=h.hid and h.hid = ? order by r.rdate desc)";
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
		*/
	}

	
	
	public ArrayList<ReviewVo> RM_select(String hid) {
		List<ReviewVo> list = sqlSession.selectList("mapper.review.RM_select", hid);
		return (ArrayList<ReviewVo>)list;
		/*
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
		*/
	}

	
	
	
	
	
	
	// 리뷰 리스트
	public ArrayList<ReviewVo> select() {
		List<ReviewVo> list = sqlSession.selectList("mapper.review.list");
		return (ArrayList<ReviewVo>)list;
		/*
		ArrayList<ReviewVo> reviewList = new ArrayList<ReviewVo>();
		String sql = " select rownum rno, rid, rcontent, to_char(rdate,'yyyy-mm-dd') rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc, nickname " + 
				" from (select r.rid, r.rcontent, r.rdate, r.rlike, r.rstar, r.rstate, r.mid, r.hid, h.hname, h.animal, h.gloc, m.nickname from pcp_review r, pcp_hospital h, pcp_member m " + 
				" where r.hid=h.hid and r.mid = m.mid order by r.rdate desc)";
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
				list.setNickname(rs.getString(13));
				
				reviewList.add(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewList;
		*/
	}
	

	// 리뷰 리스트 페이징 처리 
	public List<Object> selectList(int startCount, int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList("mapper.review.listPage", param);
		/*
		ArrayList<ReviewVo> reviewList = new ArrayList<ReviewVo>();
		String sql = " select rno, rid, rcontent, rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc, nickname"
				+ " from (select rownum rno, rid, rcontent, to_char(rdate,'yyyy-mm-dd') rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc, nickname " + 
				" from (select r.rid, r.rcontent, r.rdate, r.rlike, r.rstar, r.rstate, r.mid, r.hid, h.hname, h.animal, h.gloc, m.nickname from pcp_review r, pcp_hospital h, pcp_member m " + 
				" where r.hid=h.hid and r.mid = m.mid order by r.rdate desc))"
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
				list.setNickname(rs.getString(13));
				
				reviewList.add(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewList;
		*/
	}
	
	
	
	// 검색 리뷰 리스트 페이징 처리
	public List<Object> selectSearchList(int startCount, int endCount, String filter_location) {
		RSpagingVo rspagingVo = new RSpagingVo();
		rspagingVo.setStart(startCount);
		rspagingVo.setEnd(endCount);
		rspagingVo.setGloc(filter_location);
		return sqlSession.selectList("mapper.review.searchListPage", rspagingVo);
		/*
		ArrayList<ReviewVo> reviewList = new ArrayList<ReviewVo>();
		String sql = "select rno, rid, rcontent, rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc, nickname " + 
				" from (select rownum rno, rid, rcontent, to_char(rdate,'yyyy-mm-dd') rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc, nickname " + 
				" from (select r.rid, r.rcontent, r.rdate, r.rlike, r.rstar, r.rstate, r.mid, r.hid, h.hname, h.animal, h.gloc, m.nickname from pcp_review r, pcp_hospital h, pcp_member m " + 
				" where r.hid=h.hid and r.mid = m.mid order by r.rdate desc) where gloc = ?) " + 
				" where rno between ? and ?";
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
				list.setNickname(rs.getString(13));
				
				reviewList.add(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewList;
		*/
	}
	
	
	/* 리뷰 검색 카운트 가져오기(totalrowcount)*/
	public int SearchRowCount(String filter_location) {
		String gloc = filter_location;
		return sqlSession.selectOne("mapper.review.searchCount", gloc);
		/*
		int count = 0;
		String sql = "select count(*)\r\n" + 
				" from (select rownum rno, rid, rcontent, to_char(rdate,'yyyy-mm-dd') rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc, nickname \r\n" + 
				" from (select r.rid, r.rcontent, r.rdate, r.rlike, r.rstar, r.rstate, r.mid, r.hid, h.hname, h.animal, h.gloc, m.nickname from pcp_review r, pcp_hospital h, pcp_member m \r\n" + 
				" where r.hid=h.hid and r.mid = m.mid order by r.rdate desc) where gloc = ?)";
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
		*/
	}

	/*
	 *  리뷰 상세보기
	 */
	public ReviewVo select(String rid) {
		return sqlSession.selectOne("mapper.review.content", rid);
		/*
		ReviewVo reviewVo = new ReviewVo();
		String sql = "select rownum rno, rid, rcontent, to_char(rdate,'yyyy-mm-dd') rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc, nickname " + 
				" from (select r.rid, r.rcontent, r.rdate, r.rlike, r.rstar, r.rstate, r.mid, r.hid, h.hname, h.animal, h.gloc, m.nickname from pcp_review r, pcp_hospital h, pcp_member m " + 
				" where r.hid=h.hid and r.mid = m.mid) where rid = ?";
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
				reviewVo.setNickname(rs.getString(13));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewVo;
		*/
	}
	
	
	/*
	 *  리뷰 상세보기 띄어쓰기
	 */
	public ReviewVo enter_select(String rid) {
		return sqlSession.selectOne("mapper.review.enter_content", rid);
		/*
		ReviewVo reviewVo = new ReviewVo();
		String sql = "select rownum rno, rid, rcontent, to_char(rdate,'yyyy-mm-dd') rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc, nickname " + 
				" from (select r.rid, r.rcontent, r.rdate, r.rlike, r.rstar, r.rstate, r.mid, r.hid, h.hname, h.animal, h.gloc, m.nickname from pcp_review r, pcp_hospital h, pcp_member m " + 
				" where r.hid=h.hid and r.mid = m.mid) where rid = ?";
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
				reviewVo.setNickname(rs.getString(13));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewVo;
		*/
	}
	
	
	
	
	/*
	 * 리뷰 등록하기
	 */
	public int insert(ReviewVo reviewVo) {
		return sqlSession.insert("mapper.review.insert", reviewVo);
		/*
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
		*/
	}
	
	
	/*
	 * 리뷰 수정
	 */
	public int update(ReviewVo reviewVo) {
		return sqlSession.update("mapper.review.update", reviewVo);
		/*
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
		*/
	}
	
	
	/*
	 * 리뷰 신고
	 */
	public int update(String rid) {
		return sqlSession.update("mapper.review.report", rid);
		/*
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
		*/
	}
	
	
	/*
	 * 리뷰 삭제
	 */
	public int delete(String rid) {
		return sqlSession.delete("mapper.review.delete", rid);
		/*
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
		*/
	}
	
	//베스트리뷰

	/**
	 * select - 베스트리뷰
	 */
	public List<Object> select(int startCount, int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList("mapper.review.bestList", param);
		/*
		ArrayList<ReviewVo> list = new ArrayList<ReviewVo>();
		
		String sql = "select rno,rid,hid,rcontent,hname,gloc,rdate,rlike,rstar,mid, nickname \r\n" + 
				" from(select rownum rno,rid,hid,rcontent,hname,gloc,rdate,rlike,rstar,mid,nickname \r\n" + 
				" from(select r.rid,r.hid,r.rcontent,h.hname,h.gloc,to_char(r.rdate,'yyyy-mm-dd') rdate,r.rlike,r.rstar,r.mid,m.nickname \r\n" + 
				" from pcp_review r, pcp_hospital h, pcp_member m \r\n" + 
				" where r.hid=h.hid and r.mid = m.mid \r\n" + 
				" order by rlike desc))\r\n" + 
				" where rno between ? and ?";
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
				reviewVo.setNickname(rs.getString(11));
				
				
				list.add(reviewVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		*/
	}
	
	
	
	
	/* 전체 카운트 가져오기*/
	public int totalRowCount() {
		return sqlSession.selectOne("mapper.review.count");
		/*
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
		*/
	}

	
	//내가 쓴 리뷰 
	public ArrayList<ReviewVo> my_select(String mid) {
		List<ReviewVo> list = sqlSession.selectList("mapper.review.my_select", mid);
		return (ArrayList<ReviewVo>)list;
		/*
		ArrayList<ReviewVo> list = new ArrayList<ReviewVo>();
		String sql = "select h.hname, m.nickname, h.tel, h.gloc, r.rcontent, rid, r.bid, h.img\r\n" + 
				" from pcp_review r, pcp_member m, pcp_hospital h, pcp_booking b where r.mid = m.mid and h.hid = r.hid and b.bid = r.bid and r.mid = ?";
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
		*/
	}


	//신고된 리뷰 체크
	public int reviewCheckResult(String rid) {
		return sqlSession.selectOne("mapper.review.reportReivew", rid);
		
		/*
		int result = 0;
		String sql ="select count(*) from pcp_review where rid = ? and rstate = 'O'";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, rid);
			rs = pstmt.executeQuery();		
			while(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		*/
	}
	
	
	// 리뷰 병원 조인
	public ArrayList<ReviewVo> RM_select2(String hid) {
		List<ReviewVo> list = sqlSession.selectList("mapper.review.RM_select2", hid);
		return (ArrayList<ReviewVo>)list;
	}
	
	// 리뷰 병원 조인
	public ArrayList<ReviewVo> RM_select3(String hid) {
		List<ReviewVo> list = sqlSession.selectList("mapper.review.RM_select3", hid);
		return (ArrayList<ReviewVo>)list;
	}
	
	// 리뷰 병원 조인
	public ArrayList<ReviewVo> RM_select4(String hid) {
		List<ReviewVo> list = sqlSession.selectList("mapper.review.RM_select4", hid);
		return (ArrayList<ReviewVo>)list;
	}

	
	
	
}