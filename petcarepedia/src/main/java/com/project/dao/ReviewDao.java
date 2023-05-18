package com.project.dao;

import java.util.ArrayList;

import com.project.vo.ReviewVo;

public class ReviewDao extends DBConn {
	public ArrayList select() {
		ArrayList<ReviewVo> list = new ArrayList<ReviewVo>();
		String sql = "select rid, rcontent, rdate, rlike, rstar, rstate, mid, hid, hname, animal, gloc\r\n" + 
				" from (select r.rid, r.rcontent, r.rdate, r.rlike, r.rstar, r.rstate, r.mid, r.hid, h.hname, h.animal, h.gloc from pcp_review r, pcp_hospital h where r.hid=h.hid)\r\n" + 
				" order by rdate desc;";
		getPreparedStatement(sql);
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
