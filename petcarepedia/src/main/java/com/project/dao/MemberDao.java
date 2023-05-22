package com.project.dao;

import java.util.ArrayList;

import com.project.vo.MemberVo;
import com.project.vo.ReviewVo;

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
		
		String sql = "select rownum,mid,pass,name,nickname,phone,to_char(to_date(birth),'yyyy-mm-dd') birth,email,addr,to_char(mdate,'yyyy-mm-dd') mdate\r\n" + 
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
		
		String sql = "select mid,pass,name,nickname,phone,to_char(to_date(birth),'yyyy-mm-dd') birth,email,addr,to_char(mdate,'yyyy-mm-dd') mdate from pcp_member\r\n" + 
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
	 * checkId - 회원가입 아이디 중복체크
	 */
	public int checkId(String mid) {
		int result = 0;
		
		String sql = "select count(*) from pcp_member where mid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * loginCheck - 로그인 체크
	 */
	public int checkLogin(MemberVo memberVo) {
		int result = 0;
		
		String sql = "select count(*) from pcp_member where mid=? and pass=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, memberVo.getMid());
			pstmt.setString(2, memberVo.getPass());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * update - 회원정보 수정(마이페이지)
	 */
	public int update(MemberVo memberVo) {
		int result = 0;
		
		String sql = "update pcp_member \r\n" + 
				"set nickname=?,phone=?,birth=?,email=?,addr=?\r\n" + 
				"where mid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, memberVo.getNickname());
			pstmt.setString(2, memberVo.getPhone());
			pstmt.setString(3, memberVo.getBirth());
			pstmt.setString(4, memberVo.getEmail());
			pstmt.setString(5, memberVo.getAddr());
			pstmt.setString(6, memberVo.getMid());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * findId - 아이디 찾기
	 */
	public String findId(MemberVo memberVo) {
		String mid = "";
		
		String sql = "select mid from pcp_member where name=? and phone=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, memberVo.getName());
			pstmt.setString(2, memberVo.getPhone());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mid = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mid;
	}
	
	/**
	 * findPass - 비밀번호 재설정 - 정보 일치 여부 확인
	 */
	public String findPass(MemberVo memberVo) {
		String mid = "";
		
		String sql = "select mid from pcp_member where mid=? and name=? and phone=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, memberVo.getMid());
			pstmt.setString(2, memberVo.getName());
			pstmt.setString(3, memberVo.getPhone());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mid = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mid;
	}
	
	/**
	 * updatePass - 비밀번호 재설정 - 재설정
	 */
	public int updatePass(MemberVo memberVo) {
		int result = 0;
		
		String sql = "update pcp_member \r\n" + 
				"set pass=?\r\n" + 
				"where mid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, memberVo.getPass());
			pstmt.setString(2, memberVo.getMid());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
