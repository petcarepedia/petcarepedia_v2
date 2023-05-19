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
