package com.project.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.vo.NoticeVo;

@Repository
public class NoticeDao extends DBConn {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/*
	 * 공지사항 리스트
	 */
	public ArrayList<NoticeVo> select() {
		List<NoticeVo> list = sqlSession.selectList("mapper.notice.list");
		
		return (ArrayList<NoticeVo>)list;
		
		/*
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
		*/
	}
	
	/*
	 * 공지사항 상세보기
	 */
	public NoticeVo select(String nid) {
		return sqlSession.selectOne("mapper.notice.content", nid);
		/*
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
		*/
	}
	
	
	// 공지사항 html 띄어쓰기 출력
	public NoticeVo enter_select(String nid) {
		return sqlSession.selectOne("mapper.notice.enter_content", nid);
		/*
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
		*/
	}
	
	/*
	 * 공지사항 등록하기
	 */
	public int insert(NoticeVo noticeVo) {
		return sqlSession.insert("mapper.notice.insert", noticeVo);
		/*
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
		*/
	}
	
	/*
	 * 공지사항 수정
	 */
	public int update(NoticeVo noticeVo) {
		return sqlSession.update("mapper.notice.update", noticeVo);
		/*
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
		*/
	}

	
	/*
	 * 공지사항 삭제
	 */
	public int delete(String nid) {
		return sqlSession.delete("mapper.notice.delete", nid);
		/*
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
		*/
	}
	
	
	/*
	 * 조회수 증가
	 */
	public void updateHits(String nid) {
		sqlSession.selectOne("mapper.notice.updateHits", nid);
		/*
		String sql = "update pcp_notice set nhits = nhits+1 where nid = ?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, nid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
	
	
	
	/* 전체 카운트 가져오기*/
	public int totalRowCount() {
		return sqlSession.selectOne("mapper.notice.count");
		/*
			int count = 0;
			String sql = "select count(*) from pcp_notice";
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
	
	
	
	/*전체 리스트 출력 페이징*/
	public List<Object> select(int startCount, int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList("mapper.notice.listPage", param);
		/*
		ArrayList<NoticeVo> noticeList = new ArrayList<NoticeVo>();
		String sql = "select rno, nid, title, ndate, nhits, ncontent"
				+ " from(select rownum rno, nid, title, ndate, nhits, ncontent " + 
				" from(select nid, title, ndate, nhits, ncontent from pcp_notice order by ndate desc))"
				+ " where rno between ? and ?";
		getPreparedStatement(sql);
		try {
			pstmt.setInt(1, startCount);
			pstmt.setInt(2, endCount);
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
		*/
	}
	
	
	
	
	
	
	
}
