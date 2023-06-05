package com.project.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.vo.BookingReviewVo;
import com.project.vo.BookingVo;

@Repository
public class BookingDao extends DBConn {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** 예약 등록 **/
	public int insert(BookingVo bookingVo) {
		return sqlSession.insert("mapper.booking.insert", bookingVo);

//		int result = 0;
//
//		String sql = "INSERT INTO PCP_BOOKING(bid, bdate, vdate, vtime, bstate, mid, hid)"
//				+ "  values ('B_'||LTRIM(to_char(SEQU_PCP_BOOKING_BID.nextVal, '0000')), sysdate, ?,?,'예약중',?,?)";
//
//		getPreparedStatement(sql);
//
//		try {
//			pstmt.setString(1, bookingVo.getVdate());
//			pstmt.setString(2, bookingVo.getVtime());
//			pstmt.setString(3, bookingVo.getMid());
//			pstmt.setString(4, bookingVo.getHid());
//
//			result = pstmt.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return result;
	} // insert(BookingVo bookingVo)

	
	/** select - 예약 리스트 **/
	public ArrayList<BookingVo> select() {
		List<BookingVo> list = sqlSession.selectList("mapper.booking.select");
		return (ArrayList<BookingVo>) list;
		
//		ArrayList<BookingVo> list = new ArrayList<BookingVo>();
//
//		String sql = "SELECT ROWNUM RNO, BID, to_char(BDATE, 'yyyy-mm-dd') BDATE,  to_char(BDATE, 'yyyy-mm-dd') VDATE, VTIME, BSTATE, MID, HNAME"
//				+ " FROM (SELECT * FROM PCP_BOOKING B, PCP_HOSPITAL H where b.hid = h.hid ORDER BY BID DESC)" ;
//		getPreparedStatement(sql);
//
//		try {
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				BookingVo bookingVo = new BookingVo();
//				bookingVo.setRno(rs.getInt(1));
//				bookingVo.setBid(rs.getString(2));
//				bookingVo.setBdate(rs.getString(3));
//				bookingVo.setVdate(rs.getString(4));
//				bookingVo.setVtime(rs.getString(5));
//				bookingVo.setBstate(rs.getString(6));
//				bookingVo.setMid(rs.getString(7));
//				bookingVo.setHname(rs.getString(8));
//
//				list.add(bookingVo);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return list;
	} // ArrayList<BookingVo> select()
	
	
	/** select - 예약 리스트(회원 기준 추가/05.22) **/
	public ArrayList<BookingVo> search(String mid) {
		List<BookingVo> list = sqlSession.selectList("mapper.booking.search", mid);
		return (ArrayList<BookingVo>) list;
		
//		ArrayList<BookingVo> list = new ArrayList<BookingVo>();
//
//		String sql = "SELECT BID, BDATE, VDATE, VTIME, BSTATE, MID, B.HID, H.HNAME, H.LOC, H.GLOC, H.TEL" + 
//				" FROM PCP_BOOKING B, PCP_HOSPITAL H" + 
//				" WHERE B.HID = H.HID" + 
//				" AND MID = ?";
//		
//		getPreparedStatement(sql);
//
//		try {
//			pstmt.setString(1, mid);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				BookingVo bookingVo = new BookingVo();
//				bookingVo.setBid(rs.getString(1));
//				bookingVo.setBdate(rs.getString(2));
//				bookingVo.setVdate(rs.getString(3));
//				bookingVo.setVtime(rs.getString(4));
//				bookingVo.setBstate(rs.getString(5));
//				bookingVo.setMid(rs.getString(6));
//				bookingVo.setHid(rs.getString(7));
//				bookingVo.setHname(rs.getString(8));
//				bookingVo.setLoc(rs.getString(9));
//				bookingVo.setGloc(rs.getString(10));
//				bookingVo.setTel(rs.getString(11));
//
//				list.add(bookingVo);
//			}
//			System.out.println(list.size());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return list;
	} // ArrayList<BookingVo> search(String mid)
	
	
	/** select - 예약 완료 리스트 날짜(회원 기준/수정 06.03) **/
	public ArrayList<BookingVo> search1(String mid) {
		List<BookingVo> list = sqlSession.selectList("mapper.booking.search1", mid);
		return (ArrayList<BookingVo>) list;
		
//		ArrayList<BookingVo> list = new ArrayList<BookingVo>();
//
//		String sql = "select bid, bdate, vdate, vtime, bstate, mid, hid, hname, loc, gloc, tel, hrink, img\r\n" + 
//				"from(select b.bid bid, b.bdate bdate, b.vdate vdate, b.vtime vtime, b.bstate bstate, b.mid mid, b.hid hid, h.hname hname, h.loc loc, h.gloc gloc,\r\n" + 
//				"h.tel tel, h.hrink hrink, h.img img from pcp_review r, pcp_booking b, pcp_hospital h, pcp_member m where r.bid(+) = b.bid \r\n" + 
//				"and b.hid = h.hid and b.mid = m.mid and b.mid = ? and  r.bid is null)\r\n" + 
//				"where vdate < to_char(sysdate,'yyyy-mm-dd') or (vdate = to_char(sysdate,'yyyy-mm-dd') and vtime < to_char(sysdate,'hh24:mi')) order by bid desc";
//		
//		getPreparedStatement(sql);
//
//		try {
//			pstmt.setString(1, mid);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				BookingVo bookingVo = new BookingVo();
//				bookingVo.setBid(rs.getString(1));
//				bookingVo.setBdate(rs.getString(2));
//				bookingVo.setVdate(rs.getString(3));
//				bookingVo.setVtime(rs.getString(4));
//				bookingVo.setBstate(rs.getString(5));
//				bookingVo.setMid(rs.getString(6));
//				bookingVo.setHid(rs.getString(7));
//				bookingVo.setHname(rs.getString(8));
//				bookingVo.setLoc(rs.getString(9));
//				bookingVo.setGloc(rs.getString(10));
//				bookingVo.setTel(rs.getString(11));
//				bookingVo.setHrink(rs.getString(12));
//				bookingVo.setImg(rs.getString(13));
//
//				list.add(bookingVo);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return list;
	} // ArrayList<BookingVo> search1(String mid)
	
	
	/** select - 예약중 리스트 날짜(회원 기준/수정 06.03) **/
	public ArrayList<BookingVo> search2(String mid) {
		List<BookingVo> list = sqlSession.selectList("mapper.booking.search2", mid);
		return (ArrayList<BookingVo>) list;
		
//		ArrayList<BookingVo> list = new ArrayList<BookingVo>();
//
//		String sql = "SELECT BID, BDATE, VDATE, VTIME, BSTATE, MID, HID, HNAME, LOC, GLOC, TEL,HRINK, IMG"
//				+ " FROM (SELECT BID, BDATE, VDATE, VTIME, BSTATE, MID, B.HID HID, H.HNAME HNAME, H.LOC LOC, H.GLOC GLOC, H.TEL TEL, H.HRINK HRINK, H.IMG IMG"
//					+ "	FROM PCP_BOOKING B, PCP_HOSPITAL H"
//					+ " WHERE B.HID = H.HID AND MID = ? AND VDATE = TO_CHAR(SYSDATE,'YYYY-MM-DD'))"
//				+ " WHERE VTIME >= TO_CHAR(SYSDATE,'HH24:MI') order by bid desc";
//		
//		getPreparedStatement(sql);
//
//		try {
//			pstmt.setString(1, mid);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				BookingVo bookingVo = new BookingVo();
//				bookingVo.setBid(rs.getString(1));
//				bookingVo.setBdate(rs.getString(2));
//				bookingVo.setVdate(rs.getString(3));
//				bookingVo.setVtime(rs.getString(4));
//				bookingVo.setBstate(rs.getString(5));
//				bookingVo.setMid(rs.getString(6));
//				bookingVo.setHid(rs.getString(7));
//				bookingVo.setHname(rs.getString(8));
//				bookingVo.setLoc(rs.getString(9));
//				bookingVo.setGloc(rs.getString(10));
//				bookingVo.setTel(rs.getString(11));
//				bookingVo.setHrink(rs.getString(12));
//				bookingVo.setImg(rs.getString(13));
//
//				list.add(bookingVo);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return list;
	} // ArrayList<BookingVo> search2(String mid)
	
	/** select3 - (회원 기준/수정 06.03) **/
	public ArrayList<BookingReviewVo> search3(String mid) {
		List<BookingReviewVo> list2 = sqlSession.selectList("mapper.booking.search3", mid);
		return (ArrayList<BookingReviewVo>) list2;
		
//		ArrayList<BookingReviewVo> list2 = new ArrayList<BookingReviewVo>();
//		
//		String sql = "select bid, bdate, vdate, vtime, bstate, mid, hid, hname, loc, gloc, tel, hrink, img\r\n" + 
//				"from(select b.bid bid, b.bdate bdate, b.vdate vdate, b.vtime vtime, b.bstate bstate, b.mid mid, b.hid hid, h.hname hname, h.loc loc, h.gloc gloc,\r\n" + 
//				"h.tel tel, h.hrink hrink, h.img img from pcp_review r, pcp_booking b, pcp_hospital h, pcp_member m \r\n" + 
//				"where b.hid = h.hid and b.mid = m.mid and b.mid = ? and b.bid = r.bid) order by bid desc";
//		
//		getPreparedStatement(sql);
//		try {
//			pstmt.setString(1, mid);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				BookingReviewVo bookingReviewVo = new BookingReviewVo();
//				bookingReviewVo.setBid(rs.getString(1));
//				bookingReviewVo.setBdate(rs.getString(2));
//				bookingReviewVo.setVdate(rs.getString(3));
//				bookingReviewVo.setVtime(rs.getString(4));
//				bookingReviewVo.setBstate(rs.getString(5));
//				bookingReviewVo.setMid(rs.getString(6));
//				bookingReviewVo.setHid(rs.getString(7));
//				bookingReviewVo.setHname(rs.getString(8));
//				bookingReviewVo.setLoc(rs.getString(9));
//				bookingReviewVo.setGloc(rs.getString(10));
//				bookingReviewVo.setTel(rs.getString(11));
//				bookingReviewVo.setHrink(rs.getString(12));
//				bookingReviewVo.setImg(rs.getString(13));
//				list2.add(bookingReviewVo);
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list2;
	} // ArrayList<BookingReviewVo> search3(String mid)
	
	
	/** select4 - (회원 기준/추가 06.03) **/
	public ArrayList<BookingVo> search4(String mid) {
		List<BookingVo> list = sqlSession.selectList("mapper.booking.search4", mid);
		return (ArrayList<BookingVo>) list;
		
//		ArrayList<BookingVo> list = new ArrayList<BookingVo>();
//		String sql = "SELECT BID, BDATE, VDATE, VTIME, BSTATE, MID, HID, HNAME, LOC, GLOC, TEL,HRINK, IMG\r\n" + 
//				"FROM (SELECT BID, BDATE, VDATE, VTIME, BSTATE, MID, B.HID HID, H.HNAME HNAME, H.LOC LOC, H.GLOC GLOC, H.TEL TEL, H.HRINK HRINK, H.IMG IMG\r\n" + 
//				"FROM PCP_BOOKING B, PCP_HOSPITAL H\r\n" + 
//				"WHERE B.HID = H.HID AND MID = ? AND VDATE > TO_CHAR(SYSDATE,'YYYY-MM-DD')) order by bid desc";
//		
//		getPreparedStatement(sql);
//		
//		try {
//			pstmt.setString(1, mid);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				BookingVo bookingVo = new BookingVo();
//				bookingVo.setBid(rs.getString(1));
//				bookingVo.setBdate(rs.getString(2));
//				bookingVo.setVdate(rs.getString(3));
//				bookingVo.setVtime(rs.getString(4));
//				bookingVo.setBstate(rs.getString(5));
//				bookingVo.setMid(rs.getString(6));
//				bookingVo.setHid(rs.getString(7));
//				bookingVo.setHname(rs.getString(8));
//				bookingVo.setLoc(rs.getString(9));
//				bookingVo.setGloc(rs.getString(10));
//				bookingVo.setTel(rs.getString(11));
//				bookingVo.setHrink(rs.getString(12));
//				bookingVo.setImg(rs.getString(13));
//				list.add(bookingVo);
//			}
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return list;
	} // ArrayList<BookingVo> search4(String mid)
	
	
	/** search5 - 회원아이디 상세 검색창 (06.05 추가)**/
	public ArrayList<BookingVo> search5(String mid) {
		List<BookingVo> list = sqlSession.selectList("mapper.booking.search5", mid);
		return (ArrayList<BookingVo>) list;
		
//		ArrayList<BookingVo> list = new ArrayList<BookingVo>();
//		String sql = " select bid, hname, mid,  to_char(BDATE, 'yyyy-mm-dd') VDATE, bstate "
//					+ " from  pcp_booking b, pcp_hospital h  where b.hid = h.hid and mid like ?";
//					
//		getPreparedStatement(sql);
//
//		try {
//			pstmt.setString(1, "%"+ mid + "%");
//
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				BookingVo booking = new BookingVo();
//				booking.setBid(rs.getString(1));
//				booking.setHname(rs.getString(2));
//				booking.setMid(rs.getString(3));
//				booking.setVdate(rs.getString(4));
//				booking.setBstate(rs.getString(5));
//
//				list.add(booking);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
	} // ArrayList<BookingVo> search5(String mid)

	
		
	/** select(mid) - 로그인 후 예약확인하기 **/
	public BookingVo select(String mid) {
		return sqlSession.selectOne("mapper.booking.select", mid);
		
//		BookingVo bookingVo = new BookingVo();
//		
//		String sql= "SELECT  ROWNUM RNO, BID, to_char(BDATE, 'yyyy-mm-dd') BDATE,  to_char(BDATE, 'yyyy-mm-dd') VDATE, VTIME, BSTATE, MID " + 
//				" FROM (SELECT * FROM PCP_BOOKING ORDER BY BID DESC)" + 
//				" WHERE MID=?";
//		getPreparedStatement(sql);
//		
//		try {
//			pstmt.setString(1, mid);
//			
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				bookingVo.setRno(rs.getInt(1));
//				bookingVo.setBid(rs.getString(2));
//				bookingVo.setBdate(rs.getString(3));
//				bookingVo.setVdate(rs.getString(4));
//				bookingVo.setVtime(rs.getString(5));
//				bookingVo.setBstate(rs.getString(6));
//				bookingVo.setMid(rs.getString(7));
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return bookingVo;
	} // select(String mid)
	
	
	/** select(mid) - 로그인 후 예약확인하기(추가 06.02) **/
	public BookingVo select2(String bid) {
		return sqlSession.selectOne("mapper.booking.select2", bid);
		
//		BookingVo bookingVo = new BookingVo();
//		
//		String sql= "select BID, VDATE, VTIME, MID, B.HID, H.HNAME, H.TEL, H.IMG FROM PCP_BOOKING B, PCP_HOSPITAL H WHERE B.HID = H.HID AND B.bid = ?";
//		getPreparedStatement(sql);
//		
//		try {
//			pstmt.setString(1, bid);
//			
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				bookingVo.setBid(rs.getString(1));
//				bookingVo.setVdate(rs.getString(2));
//				bookingVo.setVtime(rs.getString(3));
//				bookingVo.setMid(rs.getString(4));
//				bookingVo.setHid(rs.getString(5));
//				bookingVo.setHname(rs.getString(6));
//				bookingVo.setTel(rs.getString(7));
//				bookingVo.setImg(rs.getString(8));
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return bookingVo;
	}
	
	
	/** reviewCheck - 리뷰쓰기 예약 확인하기(06.03 추가) **/
	public int reviewCheck(String hid, String mid) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("hid", hid);
		param.put("mid", mid);

		return sqlSession.selectOne("mapper.booking.reviewCheck", param);
		
//		int result = 0;
//		
//	    String sql = "SELECT COUNT(*) FROM PCP_BOOKING WHERE HID=? AND MID=? AND BSTATE='진료완료'";
//	    getPreparedStatement(sql);
//
//	    try {
//	        pstmt.setString(1, hid);
//	        pstmt.setString(2, mid);
//
//	        rs = pstmt.executeQuery();
//	        if (rs.next()) {
//	            result = rs.getInt(1);
//	        }
//
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//
//	    return result;
	} // select(String mid)
	
		
	/** selectTime - 전체 영업시간(05.25) **/
	public ArrayList<BookingVo> selectTime() {
		List<BookingVo> list = sqlSession.selectList("mapper.booking.selectTime");
		return (ArrayList<BookingVo>) list;
		
//		ArrayList<BookingVo> time= new ArrayList<BookingVo>();
//		
//		String sql= "SELECT HID, HNAME, SUBSTR(HTIME, 0,5 ) 'START',  SUBSTR(HTIME, 7,6 ) 'END'" + 
//				" FROM PCP_HOSPITAL ORDER BY HID";
//		getPreparedStatement(sql);
//		
//		try {
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				BookingVo bookingVo = new BookingVo();
//				bookingVo.setHid(rs.getString(1));
//				bookingVo.setHname(rs.getString(2));
//				bookingVo.setStart(rs.getString(3));
//				bookingVo.setEnd(rs.getString(4));
//				
//				time.add(bookingVo);
//			}
//			System.out.println(time.get(1));
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return time;
	} // selectTime - 전체 영업시간
	
	
	/** selectTime - 영업시간(05.25) **/
	public BookingVo selectTime(String hid) {
		return sqlSession.selectOne("mapper.booking.selectTime2", hid);
		
//		BookingVo bookingVo = new BookingVo();
//		
//		String sql= "SELECT HID, HNAME, SUBSTR(HTIME, 0,5 ) \"START\",  SUBSTR(HTIME, 7,6 ) \"END\"" + 
//				" FROM PCP_HOSPITAL WHERE HID=?";
//		getPreparedStatement(sql);
//		
//		try {
//			pstmt.setString(1, hid);
//			
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				bookingVo.setHid(rs.getString(1));
//				bookingVo.setHname(rs.getString(2));
//				bookingVo.setStart(rs.getString(3));
//				bookingVo.setEnd(rs.getString(4));
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return bookingVo;
	} // selectTime - 영업시간

	
	/** update - 예약 수정하기 **/
	public int update(BookingVo bookingVo) {
		return sqlSession.update("mapper.booking.update", bookingVo);
		
//		int result = 0;
//
//		String sql = "UPDATE PCP_BOOKING SET VDATE=?, VTIME=?, BSTATE=? WHERE BID=?";
//
//		getPreparedStatement(sql);
//
//		try {
//			pstmt.setString(1, bookingVo.getVdate());
//			pstmt.setString(2, bookingVo.getVtime());
//			pstmt.setString(3, bookingVo.getBstate());
//
//			result = pstmt.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return result;
	} // int update(BookingVo bookingVo)

	
	/** delete - 예약 삭제하기 **/
	public int delete(String bid) {
		return sqlSession.delete("mapper.booking.delete", bid);
		
//		int result = 0;
//
//		String sql = "DELETE FROM PCP_BOOKING WHERE BID=? ";
//		getPreparedStatement(sql);
//
//		try {
//			pstmt.setString(1, bid);
//			result = pstmt.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return result;
	} // int delete(String bid)

} // class
