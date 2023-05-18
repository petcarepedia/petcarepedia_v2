package com.project.dao;

import java.util.ArrayList;

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
	
	/**
	 * select - 회원 전체 리스트(관리자)
	 */
	public ArrayList<MemberVo> select() {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		
		String sql = "select rownum,mid,pass,name,nickname,phone,birth,email,addr,mdate\r\n" + 
				"from(select mid,pass,name,nickname,phone,birth,email,addr,mdate from pcp_member order by mdate)";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVo memberVo = new MemberVo();
				
				memberVo.setRno(rs.getInt(1));
				memberVo.setMid(rs.getString(2));
				memberVo.setPass(rs.getString(3));
				memberVo.setName(rs.getString(4));
				memberVo.setNickname(rs.getString(5));
				memberVo.setPhone(rs.getString(6));
				memberVo.setBirth(rs.getString(7));
				memberVo.setEmail(rs.getString(8));
				memberVo.setAddr(rs.getString(9));
				memberVo.setMdate(rs.getString(10));
				
				list.add(memberVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * select - 회원 개인 정보(마이페이지)
	 */
	public MemberVo select(String mid) {
		MemberVo memberVo = new MemberVo();
		
		String sql = "select mid,pass,name,nickname,phone,birth,email,addr,mdate from pcp_member\r\n" + 
				"where mid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				memberVo.setMid(rs.getString(1));
				memberVo.setPass(rs.getString(2));
				memberVo.setName(rs.getString(3));
				memberVo.setNickname(rs.getString(4));
				memberVo.setPhone(rs.getString(5));
				memberVo.setBirth(rs.getString(6));
				memberVo.setEmail(rs.getString(7));
				memberVo.setAddr(rs.getString(8));
				memberVo.setMdate(rs.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return memberVo;
	}
	
	/**
	 * idCheck - 회원가입 아이디 중복체크
	 */
	public int idCheck(String mid) {
		int result = 0;
		
		String sql = "select count(*) from pcp_member where mid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, mid);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
