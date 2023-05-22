package com.project.dao;

import java.util.ArrayList;

import com.project.vo.NoticeVo;

public class NoticeDao extends DBConn {
	
	/*
	 * 공지사항 리스트
	 */
	public ArrayList<NoticeVo> select() {
		ArrayList<NoticeVo> noticeList = new ArrayList<NoticeVo>();
		String sql = "select rownum rno, nid, title, ndate, nhits, ncontent " + 
				" from(select nid, title, ndate, nhits, ncontent from pcp_notice order by ndate desc)";
		getPreparedStatement(sql);
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVo list = new NoticeVo();
				list.setRno(rs.getInt(1));
				list.setNid(rs.getString(2));
				list.setTitle(rs.getString(3));
				list.setNdate(rs.getString(4));
				list.setNhits(rs.getInt(5));
				list.setNcontent(rs.getString(6));
				
				noticeList.add(list);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeList;
	}
	
	/*
	 * 공지사항 상세보기
	 */
	public NoticeVo select(String nid) {
		NoticeVo noticeVo = new NoticeVo();
		String sql = "select nid, title, ndate, nhits, ncontent from pcp_notice where nid = ? ";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, nid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				noticeVo.setNid(rs.getString(1));
				noticeVo.setTitle(rs.getString(2));
				noticeVo.setNdate(rs.getString(3));
				noticeVo.setNhits(rs.getInt(4));
				noticeVo.setNcontent(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeVo;
	}
	// 공지사항 html 띄어쓰기 출력
	public NoticeVo u_select(String nid) {
		NoticeVo noticeVo = new NoticeVo();
		String sql = "select nid, title, ndate, nhits, ncontent from pcp_notice where nid = ? ";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, nid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				noticeVo.setNid(rs.getString(1));
				noticeVo.setTitle(rs.getString(2));
				noticeVo.setNdate(rs.getString(3));
				noticeVo.setNhits(rs.getInt(4));
				noticeVo.setNcontent(rs.getString(5).replace("\n", "<br>"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeVo;
	}
	
	/*
	 * 공지사항 등록하기
	 */
	public int insert(NoticeVo noticeVo) {
		int result = 0;
		String sql = "insert into pcp_notice(nid, title, ndate, nhits, ncontent)"
				+ " values('n_'||ltrim(to_char(sequ_pcp_notice_nid.nextval,'0000')),?,sysdate,0,?)";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, noticeVo.getTitle());
			pstmt.setString(2, noticeVo.getNcontent());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/*
	 * 공지사항 수정
	 */
	public int update(NoticeVo noticeVo) {
		int result = 0;
		String sql = "update pcp_notice set title=?, ncontent=? where nid=?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, noticeVo.getTitle());
			pstmt.setString(2, noticeVo.getNcontent());
			pstmt.setString(3, noticeVo.getNid());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	/*
	 * 공지사항 삭제
	 */
	public int delete(String nid) {
		int result = 0;
		String sql = "delete pcp_notice where nid=?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, nid);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/*
	 * 조회수 증가
	 */
	public void updateHits(String nid) {
		String sql = "update pcp_notice set nhits = nhits+1 where nid = ?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, nid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
