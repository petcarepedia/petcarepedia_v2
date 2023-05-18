package com.project.dao;

import com.project.vo.MemberVo;

public class MemberDao extends DBConn{
	/**
	 * insert - 회원가입
	 */
	public int insert(MemberVo memberVo) {
		int result = 0;
		
		String sql = "INSERT INTO PCP_MEMBER(mid,pass,name,nickname,phone,birth,email,addr,mdate) VALUES(?,?,?,?,?,?,?,?,SYSDATE)";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, memberVo.getMid());
			pstmt.setString(2, memberVo.getPass());
			pstmt.setString(3, memberVo.getName());
			pstmt.setString(4, memberVo.getNickname());
			pstmt.setString(5, memberVo.getPhone());
			pstmt.setString(6, memberVo.getBirth());
			pstmt.setString(7, memberVo.getEmail());
			pstmt.setString(8, memberVo.getAddr());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
