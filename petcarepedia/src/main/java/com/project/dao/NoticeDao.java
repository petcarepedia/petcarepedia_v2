package com.project.dao;

import java.util.ArrayList;

import com.project.vo.NoticeVo;

public class NoticeDao extends DBConn {
	public ArrayList select() {
		ArrayList<NoticeVo> list = new ArrayList<NoticeVo>();
		String sql = "";
		getPreparedStatement(sql);
		try {

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
