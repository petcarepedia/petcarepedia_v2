package com.project.dao;

import java.util.ArrayList;

import com.project.vo.BookmarkVo;


public class BookmarkDao extends DBConn{
	/*
	 * �ϸ�ũ ��ü ����Ʈ ���
	 */
	public ArrayList<BookmarkVo> select() {
		ArrayList<BookmarkVo> list = new ArrayList<BookmarkVo>();
		String sql = "select bmid, b.mid , b.hid\r\n" + 
				"from pcp_bookmark b, pcp_hospital h where b.hid = h.hid";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookmarkVo bookmarkVo = new BookmarkVo();
				bookmarkVo.setBmid(rs.getString(1));
				bookmarkVo.setMid(rs.getString(2));
				bookmarkVo.setBmid(rs.getString(3));
				
				list.add(bookmarkVo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public BookmarkVo select(String hid) {
		BookmarkVo bookmarkVo = new BookmarkVo();
		String sql = "select bmid, b.mid, b.hid from pcp_bookmark b, pcp_hospital h where b.hid = h.hid and b.hid = ?";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			pstmt.setString(1, hid);
			while(rs.next()) {
				bookmarkVo.setBmid(rs.getString(1));
				bookmarkVo.setMid(rs.getString(2));
				bookmarkVo.setHid(rs.getString(3));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bookmarkVo;
	}
}
