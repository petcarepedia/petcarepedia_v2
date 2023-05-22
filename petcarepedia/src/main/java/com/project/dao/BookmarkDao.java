package com.project.dao;

import java.util.ArrayList;

import com.project.vo.BookmarkVo;
import com.project.vo.HospitalVo;


public class BookmarkDao extends DBConn{
	
	/*
	 * 북마크 전체 리스트 출력
	 */
	public ArrayList<BookmarkVo> select(String mid) {
		ArrayList<BookmarkVo> list = new ArrayList<BookmarkVo>();
		String sql = "select bmid, b.mid, b.hid, h.hname, h.gloc, h.hrink\r\n" + 
				"from pcp_bookmark b, pcp_hospital h where b.hid = h.hid and mid = ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookmarkVo bookmarkVo = new BookmarkVo();
				bookmarkVo.setBmid(rs.getString(1));
				bookmarkVo.setMid(rs.getString(2));
				bookmarkVo.setBmid(rs.getString(3));
				bookmarkVo.setHname(rs.getString(4));
				bookmarkVo.setGloc(rs.getString(4));
				bookmarkVo.setHrink(rs.getString(4));
				
				list.add(bookmarkVo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	/*
	 * public BookmarkVo select(String mid) { BookmarkVo bookmarkVo = new
	 * BookmarkVo(); String sql =
	 * "select bmid, b.mid, b.hid from pcp_bookmark b, pcp_hospital h where b.hid = h.hid and b.mid = ?"
	 * ; getPreparedStatement(sql);
	 * 
	 * try { rs = pstmt.executeQuery(); pstmt.setString(1, mid); while(rs.next()) {
	 * bookmarkVo.setBmid(rs.getString(1)); bookmarkVo.setMid(rs.getString(2));
	 * bookmarkVo.setHid(rs.getString(3)); } }catch (Exception e) {
	 * e.printStackTrace(); } return bookmarkVo; }
	 */
	
	/*
	 * 북마크 insert
	 */
	public int insert(BookmarkVo bookmarkVo) {
		int result = 0;
		String sql = "insert into pcp_bookmark values('BM_'||ltrim(to_char(SEQU_PCP_BOOKMARK_BMID.nextval,'0000')),?,?);";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, bookmarkVo.getMid());
			pstmt.setString(2, bookmarkVo.getHid());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int delete(String hid) {
		int result = 0;
		String sql = "delete from pcp_bookmark where hid = ?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, hid);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	

}
