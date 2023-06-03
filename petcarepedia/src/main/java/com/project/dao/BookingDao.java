package com.project.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.project.vo.BookingReviewVo;
import com.project.vo.BookingVo;
import com.project.vo.ReviewVo;

@Repository
public class BookingDao extends DBConn {
	
	/** 예약 등록 **/
	public int insert(BookingVo bookingVo) {
		int result = 0;

		String sql = "INSERT INTO PCP_BOOKING(bid, bdate, vdate, vtime, bstate, mid, hid)"
				+ "  values ('B_'||LTRIM(to_char(SEQU_PCP_BOOKING_BID.nextVal, '0000')), sysdate, ?,?,'예약중',?,?)";

		getPreparedStatement(sql);

		try {
			pstmt.setString(1, bookingVo.getVdate());
			pstmt.setString(2, bookingVo.getVtime());
			pstmt.setString(3, bookingVo.getMid());
			pstmt.setString(4, bookingVo.getHid());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	} // insert(BookingVo bookingVo)

	
	/** select - 예약 리스트 **/
	public ArrayList<BookingVo> select() {
		ArrayList<BookingVo> list = new ArrayList<BookingVo>();

		String sql = "SELECT ROWNUM RNO, BID, to_char(BDATE, 'yyyy-mm-dd') BDATE,  to_char(BDATE, 'yyyy-mm-dd') VDATE, VTIME, BSTATE, MID, HNAME"
				+ " FROM (SELECT * FROM PCP_BOOKING B, PCP_HOSPITAL H where b.hid = h.hid ORDER BY BID DESC)" ;
		getPreparedStatement(sql);

		try {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookingVo bookingVo = new BookingVo();
				bookingVo.setRno(rs.getInt(1));
				bookingVo.setBid(rs.getString(2));
				bookingVo.setBdate(rs.getString(3));
				bookingVo.setVdate(rs.getString(4));
				bookingVo.setVtime(rs.getString(5));
				bookingVo.setBstate(rs.getString(6));
				bookingVo.setMid(rs.getString(7));
				bookingVo.setHname(rs.getString(8));

				list.add(bookingVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	} // ArrayList<BookingVo> select()
	
	
	/** select - 예약 리스트(회원 기준 추가/05.22) **/
	public ArrayList<BookingVo> search(String mid) {
		ArrayList<BookingVo> list = new ArrayList<BookingVo>();

		String sql = "SELECT BID, BDATE, VDATE, VTIME, BSTATE, MID, B.HID, H.HNAME, H.LOC, H.GLOC, H.TEL" + 
				" FROM PCP_BOOKING B, PCP_HOSPITAL H" + 
				" WHERE B.HID = H.HID" + 
				" AND MID = ?";
		
		getPreparedStatement(sql);

		try {
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookingVo bookingVo = new BookingVo();
				bookingVo.setBid(rs.getString(1));
				bookingVo.setBdate(rs.getString(2));
				bookingVo.setVdate(rs.getString(3));
				bookingVo.setVtime(rs.getString(4));
				bookingVo.setBstate(rs.getString(5));
				bookingVo.setMid(rs.getString(6));
				bookingVo.setHid(rs.getString(7));
				bookingVo.setHname(rs.getString(8));
				bookingVo.setLoc(rs.getString(9));
				bookingVo.setGloc(rs.getString(10));
				bookingVo.setTel(rs.getString(11));

				list.add(bookingVo);
			}
			System.out.println(list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	} // ArrayList<BookingVo> search(String mid)
	
	
	/** select - 예약 완료 리스트 날짜(회원 기준/수정 05.30) **/
	public ArrayList<BookingVo> search1(String mid) {
		ArrayList<BookingVo> list = new ArrayList<BookingVo>();

		String sql = "select B.BID, B.BDATE, B.VDATE, B.VTIME, B.BSTATE, B.MID, B.HID, H.HNAME, H.LOC, H.GLOC, H.TEL, H.HRINK, H.IMG"
						+ " from pcp_review r, pcp_booking b, pcp_hospital h, pcp_member m where r.bid(+) = b.bid and "
						+ " b.hid = h.hid and b.mid = m.mid and b.mid = ? and vdate <= sysdate and r.BID is null";
		
		getPreparedStatement(sql);

		try {
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookingVo bookingVo = new BookingVo();
				bookingVo.setBid(rs.getString(1));
				bookingVo.setBdate(rs.getString(2));
				bookingVo.setVdate(rs.getString(3));
				bookingVo.setVtime(rs.getString(4));
				bookingVo.setBstate(rs.getString(5));
				bookingVo.setMid(rs.getString(6));
				bookingVo.setHid(rs.getString(7));
				bookingVo.setHname(rs.getString(8));
				bookingVo.setLoc(rs.getString(9));
				bookingVo.setGloc(rs.getString(10));
				bookingVo.setTel(rs.getString(11));
				bookingVo.setHrink(rs.getString(12));
				bookingVo.setImg(rs.getString(13));

				list.add(bookingVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	} // ArrayList<BookingVo> search1(String mid)
	
	
	/** select - 예약중 리스트 날짜(회원 기준/05.22) **/
	public ArrayList<BookingVo> search2(String mid) {
		ArrayList<BookingVo> list = new ArrayList<BookingVo>();

		String sql = "SELECT BID, BDATE, VDATE, VTIME, BSTATE, MID, B.HID, H.HNAME, H.LOC, H.GLOC, H.TEL, H.HRINK, H.IMG" + 
				" FROM PCP_BOOKING B, PCP_HOSPITAL H" + 
				" WHERE B.HID = H.HID" + 
				" AND MID = ?" + 
				" AND VDATE >= SYSDATE";
		
		getPreparedStatement(sql);

		try {
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookingVo bookingVo = new BookingVo();
				bookingVo.setBid(rs.getString(1));
				bookingVo.setBdate(rs.getString(2));
				bookingVo.setVdate(rs.getString(3));
				bookingVo.setVtime(rs.getString(4));
				bookingVo.setBstate(rs.getString(5));
				bookingVo.setMid(rs.getString(6));
				bookingVo.setHid(rs.getString(7));
				bookingVo.setHname(rs.getString(8));
				bookingVo.setLoc(rs.getString(9));
				bookingVo.setGloc(rs.getString(10));
				bookingVo.setTel(rs.getString(11));
				bookingVo.setHrink(rs.getString(12));
				bookingVo.setImg(rs.getString(13));

				list.add(bookingVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	} // ArrayList<BookingVo> search2(String mid)
	
	/** select3 - (회원 기준/05.30) **/
	public ArrayList<BookingReviewVo> search3(String mid) {
		ArrayList<BookingReviewVo> list2 = new ArrayList<BookingReviewVo>();
		String sql = "SELECT B.BID, B.BDATE, B.VDATE, B.VTIME, B.BSTATE, R.MID, B.HID, H.HNAME, H.LOC, H.GLOC, H.TEL, "
					+ " H.HRINK, H.IMG FROM PCP_BOOKING B, PCP_HOSPITAL H, PCP_REVIEW R"
					+ " WHERE B.HID = H.HID AND B.BID = R.BID AND B.MID = R.MID AND B.MID = ? and VDATE <= SYSDATE";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookingReviewVo bookingReviewVo = new BookingReviewVo();
				bookingReviewVo.setBid(rs.getString(1));
				bookingReviewVo.setBdate(rs.getString(2));
				bookingReviewVo.setVdate(rs.getString(3));
				bookingReviewVo.setVtime(rs.getString(4));
				bookingReviewVo.setBstate(rs.getString(5));
				bookingReviewVo.setMid(rs.getString(6));
				bookingReviewVo.setHid(rs.getString(7));
				bookingReviewVo.setHname(rs.getString(8));
				bookingReviewVo.setLoc(rs.getString(9));
				bookingReviewVo.setGloc(rs.getString(10));
				bookingReviewVo.setTel(rs.getString(11));
				bookingReviewVo.setHrink(rs.getString(12));
				bookingReviewVo.setImg(rs.getString(13));
				list2.add(bookingReviewVo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list2;
	} // ArrayList<BookingReviewVo> search3(String mid)
	
		
	/** select(mid) - 로그인 후 예약확인하기 **/
	public BookingVo select(String mid) {
		BookingVo bookingVo = new BookingVo();
		
		String sql= "SELECT  ROWNUM RNO, BID, to_char(BDATE, 'yyyy-mm-dd') BDATE,  to_char(BDATE, 'yyyy-mm-dd') VDATE, VTIME, BSTATE, MID " + 
				" FROM (SELECT * FROM PCP_BOOKING ORDER BY BID DESC)" + 
				" WHERE MID=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, mid);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bookingVo.setRno(rs.getInt(1));
				bookingVo.setBid(rs.getString(2));
				bookingVo.setBdate(rs.getString(3));
				bookingVo.setVdate(rs.getString(4));
				bookingVo.setVtime(rs.getString(5));
				bookingVo.setBstate(rs.getString(6));
				bookingVo.setMid(rs.getString(7));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bookingVo;
	} // select(String mid)
	
	
	/** select(mid) - 로그인 후 예약확인하기(추가 06.02) **/
	public BookingVo select2(String bid) {
		BookingVo bookingVo = new BookingVo();
		
		String sql= "select BID, VDATE, VTIME, MID, B.HID, H.HNAME, H.TEL, H.IMG FROM PCP_BOOKING B, PCP_HOSPITAL H WHERE B.HID = H.HID AND B.bid = ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, bid);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bookingVo.setBid(rs.getString(1));
				bookingVo.setVdate(rs.getString(2));
				bookingVo.setVtime(rs.getString(3));
				bookingVo.setMid(rs.getString(4));
				bookingVo.setHid(rs.getString(5));
				bookingVo.setHname(rs.getString(6));
				bookingVo.setTel(rs.getString(7));
				bookingVo.setImg(rs.getString(8));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bookingVo;
	}
	
	
	/** reviewCheck - 리뷰쓰기 예약 확인하기(06.03 추가) **/
	public int reviewCheck(String hid, String mid) {
		int result = 0;
		
	    String sql = "SELECT COUNT(*) FROM PCP_BOOKING WHERE HID=? AND MID=? AND BSTATE='진료완료'";
	    getPreparedStatement(sql);

	    try {
	        pstmt.setString(1, hid);
	        pstmt.setString(2, mid);

	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            result = rs.getInt(1);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return result;
	} // select(String mid)
	
		
	/** selectTime - 전체 영업시간(05.25) **/
	public ArrayList<BookingVo> selectTime() {
		ArrayList<BookingVo> time= new ArrayList<BookingVo>();
		
		String sql= "SELECT HID, HNAME, SUBSTR(HTIME, 0,5 ) 'START',  SUBSTR(HTIME, 7,6 ) 'END'" + 
				" FROM PCP_HOSPITAL ORDER BY HID";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookingVo bookingVo = new BookingVo();
				bookingVo.setHid(rs.getString(1));
				bookingVo.setHname(rs.getString(2));
				bookingVo.setStart(rs.getString(3));
				bookingVo.setEnd(rs.getString(4));
				
				time.add(bookingVo);
			}
			System.out.println(time.get(1));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return time;
	} // selectTime - 전체 영업시간
	
	
	/** selectTime - 영업시간(05.25) **/
	public BookingVo selectTime(String hid) {
		BookingVo bookingVo = new BookingVo();
		
		String sql= "SELECT HID, HNAME, SUBSTR(HTIME, 0,5 ) \"START\",  SUBSTR(HTIME, 7,6 ) \"END\"" + 
				" FROM PCP_HOSPITAL WHERE HID=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, hid);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bookingVo.setHid(rs.getString(1));
				bookingVo.setHname(rs.getString(2));
				bookingVo.setStart(rs.getString(3));
				bookingVo.setEnd(rs.getString(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bookingVo;
		
	} // selectTime - 영업시간
	

	
	/** update - 예약 수정하기 **/
	public int update(BookingVo bookingVo) {
		int result = 0;

		String sql = "UPDATE PCP_BOOKING SET VDATE=?, VTIME=?, BSTATE=? WHERE BID=?";

		getPreparedStatement(sql);

		try {
			pstmt.setString(1, bookingVo.getVdate());
			pstmt.setString(2, bookingVo.getVtime());
			pstmt.setString(3, bookingVo.getBstate());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	} // int update(BookingVo bookingVo)

	
	/** delete - 예약 삭제하기 **/
	public int delete(String bid) {
		int result = 0;

		String sql = "DELETE FROM PCP_BOOKING WHERE BID=? ";
		getPreparedStatement(sql);

		try {
			pstmt.setString(1, bid);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	} // int delete(String bid)

} // class
