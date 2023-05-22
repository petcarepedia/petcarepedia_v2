package com.project.dao;

import java.util.ArrayList;

import com.project.vo.BookingVo;

public class BookingDao extends DBConn {

	/** 예약 등록 **/
	public int insert(BookingVo bookingVo) {
		int result = 0;

		String sql = "INSERT INTO PCP_BOOKING(bid, bdate, vdate, vtime, bstate, mid)"
				+ "  values ('B_'||LTRIM(to_char(SEQU_PCP_BOOKING_BID.nextVal, '0000')), sysdate, ?,?,'예약중',?)";

		getPreparedStatement(sql);

		try {
			pstmt.setString(1, bookingVo.getVdate());
			pstmt.setString(2, bookingVo.getVtime());
			pstmt.setString(3, bookingVo.getMid());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	} // insert(BookingVo bookingVo)

	
	/** select - 예약 리스트 **/
	public ArrayList<BookingVo> select() {
		ArrayList<BookingVo> list = new ArrayList<BookingVo>();

		String sql = "SELECT ROWNUM RNO, BID, to_char(BDATE, 'yyyy-mm-dd') BDATE,  to_char(BDATE, 'yyyy-mm-dd') VDATE, VTIME, BSTATE, MID "
				+ "FROM (SELECT * FROM PCP_BOOKING ORDER BY BID DESC)";
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
	
	
	/** select - 예약 완료 리스트 날짜(회원 기준/05.22) **/
	public ArrayList<BookingVo> search1(String mid) {
		ArrayList<BookingVo> list = new ArrayList<BookingVo>();

		String sql = "SELECT BID, BDATE, VDATE, VTIME, BSTATE, MID, B.HID, H.HNAME, H.LOC, H.GLOC, H.TEL, H.HRINK" + 
				" FROM PCP_BOOKING B, PCP_HOSPITAL H" + 
				" WHERE B.HID = H.HID" + 
				" AND MID = ?" + 
				" AND VDATE <= SYSDATE";
		
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

		String sql = "SELECT BID, BDATE, VDATE, VTIME, BSTATE, MID, B.HID, H.HNAME, H.LOC, H.GLOC, H.TEL, H.HRINK" + 
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

				list.add(bookingVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	} // ArrayList<BookingVo> search2(String mid)
	
		
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
