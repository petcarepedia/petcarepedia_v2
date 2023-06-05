package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.vo.BookmarkVo;


@Repository
public class BookmarkDao extends DBConn{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	
	public int deleteBookmark(BookmarkVo bookmarkVo) {
		return sqlSession.delete("mapper.bookmark.deleteBookmark",bookmarkVo);
//		int result = 0;
//		
//		String sql = "DELETE FROM PCP_BOOKMARK WHERE HID=? AND MID=?";
//		getPreparedStatement(sql);
//		
//		try {
//			pstmt.setString(1, bookmarkVo.getHid());
//			pstmt.setString(2, bookmarkVo.getMid());
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return result;
	}
	
	
	public int checkBookmark(BookmarkVo bookmarkVo) {
		return sqlSession.selectOne("mapper.bookmark.checkBookmark", bookmarkVo);
//		int result = 0;
//		
//		String sql = "SELECT COUNT(*) FROM PCP_BOOKMARK WHERE HID=? AND MID=?";
//		getPreparedStatement(sql);
//		
//		try {
//			pstmt.setString(1, bookmarkVo.getHid());
//			pstmt.setString(2, bookmarkVo.getMid());
//			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				result = rs.getInt(1);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return result;
	}

	
	
	
	/*
	 * 북마크 전체 리스트 출력
	 */
	public ArrayList<BookmarkVo> select(String mid) {
		List<BookmarkVo> list = sqlSession.selectList("mapper.bookmark.select", mid);
		return (ArrayList<BookmarkVo>)list;
//		ArrayList<BookmarkVo> list = new ArrayList<BookmarkVo>();
//		String sql = "select bmid, b.mid, b.hid, h.hname, h.gloc, h.hrink\r\n" + 
//				"from pcp_bookmark b, pcp_hospital h where b.hid = h.hid and mid = ?";
//		getPreparedStatement(sql);
//		
//		try {
//			pstmt.setString(1, mid);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				BookmarkVo bookmarkVo = new BookmarkVo();
//				bookmarkVo.setBmid(rs.getString(1));
//				bookmarkVo.setMid(rs.getString(2));
//				bookmarkVo.setHid(rs.getString(3));
//				bookmarkVo.setHname(rs.getString(4));
//				bookmarkVo.setGloc(rs.getString(5));
//				bookmarkVo.setHrink(rs.getString(6));
//				
//				list.add(bookmarkVo);
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return list;
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
		return sqlSession.insert("mapper.bookmark.insert", bookmarkVo);
//		int result = 0;
//		String sql = "insert into pcp_bookmark values('BM_'||ltrim(to_char(SEQU_PCP_BOOKMARK_BMID.nextval,'0000')),?,?)";
//		getPreparedStatement(sql);
//		
//		try {
//			pstmt.setString(1, bookmarkVo.getHid());
//			pstmt.setString(2, bookmarkVo.getMid());
//			result = pstmt.executeUpdate();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
	}
	
	public int delete(String bmid) {
		return sqlSession.delete("mapper.bookmark.bookDelete", bmid);
//		int result = 0;
//		String sql = "delete from pcp_bookmark where bmid = ?";
//		getPreparedStatement(sql);
//		try {
//			pstmt.setString(1, bmid);
//			result = pstmt.executeUpdate();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
	}
	

}
