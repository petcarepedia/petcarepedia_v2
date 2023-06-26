package com.project.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.vo.MemberVo;
import com.project.vo.SessionVo;

@Repository
public class MemberDao extends DBConn{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * insert - 회원가입
	 */
	public int insert(MemberVo memberVo) {
		return sqlSession.insert("mapper.member.join",memberVo);
	}
	
	/**
	 * checkLogin - 로그인 체크
	 */
	public SessionVo checkLogin(MemberVo memberVo) {
		return sqlSession.selectOne("mapper.member.login",memberVo);
	}
	
	/**
	 * delete - 회원탈퇴
	 */
	public int delete(String mid, String pass) {
		Map<String,String> param = new HashMap<String,String>();
		param.put("mid", mid);
		param.put("pass", pass);
		return sqlSession.delete("mapper.member.delete", param);
	}
	
	/**
	 * select - 회원 전체 리스트(관리자)
	 */
	public ArrayList<MemberVo> select() {
		List<MemberVo> list = sqlSession.selectList("mapper.member.list");
		return (ArrayList<MemberVo>)list;
	}
	
	/**
	 * select - 회원 전체 리스트(관리자) / 페이징
	 */
	public ArrayList<MemberVo> select(int startCount, int endCount) {
		Map<String,Integer> param = new HashMap<String,Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		List<MemberVo> list = sqlSession.selectList("mapper.member.list2",param);
		return (ArrayList<MemberVo>)list;
	}
	
	/**
	 * select - 회원 개인 정보(마이페이지)
	 */
	public MemberVo select(String mid) {
		return sqlSession.selectOne("mapper.member.content",mid);
	}
	
	/**
	 * checkId - 회원가입 아이디 중복체크
	 */
	public int checkId(String mid) {
		return sqlSession.selectOne("mapper.member.checkId",mid);
	}
	
	/**
	 * checkMail - 회원가입 아이디 중복체크
	 */
	public int checkMail(String email) {
		return sqlSession.selectOne("mapper.member.checkMail",email);
	}
	
	/**
	 * update - 회원정보 수정(마이페이지)
	 */
	public int update(MemberVo memberVo) {
		return sqlSession.update("mapper.member.update",memberVo);
	}
	
	/**
	 * findId - 아이디 찾기
	 */
	public String findId(MemberVo memberVo) {
		return sqlSession.selectOne("mapper.member.find", memberVo);
	}
	
	/**
	 * findPass - 비밀번호 재설정 - 정보 일치 여부 확인
	 */
	public String findPass(MemberVo memberVo) {
		return sqlSession.selectOne("mapper.member.find", memberVo);
	}
	
	/**
	 * updatePass - 비밀번호 재설정 - 재설정
	 */
	public int updatePass(MemberVo memberVo) {
		return sqlSession.update("mapper.member.updatePass",memberVo);
	}
	
	/**
	 * search - 멤버 상세 검색
	 */
	public ArrayList<MemberVo> search(String mid) {
		List<MemberVo> list = sqlSession.selectList("mapper.member.search",mid);
		return (ArrayList<MemberVo>)list;
	}
	
	public int checkPass(String mid, String pass) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("mid", mid);
		param.put("pass", pass);
		return sqlSession.selectOne("mapper.member.checkPass", param);
	}
}


