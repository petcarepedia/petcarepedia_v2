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
	 * insert - ȸ������
	 */
	public int insert(MemberVo memberVo) {
		return sqlSession.insert("mapper.member.join",memberVo);
	}
	
	/**
	 * checkLogin - �α��� üũ
	 */
	public SessionVo checkLogin(MemberVo memberVo) {
		return sqlSession.selectOne("mapper.member.login",memberVo);
	}
	
	/**
	 * delete - ȸ��Ż��
	 */
	public int delete(String mid, String pass) {
		Map<String,String> param = new HashMap<String,String>();
		param.put("mid", mid);
		param.put("pass", pass);
		return sqlSession.delete("mapper.member.delete", param);
	}
	
	/**
	 * select - ȸ�� ��ü ����Ʈ(������)
	 */
	public ArrayList<MemberVo> select() {
		List<MemberVo> list = sqlSession.selectList("mapper.member.list");
		return (ArrayList<MemberVo>)list;
	}
	
	/**
	 * select - ȸ�� ��ü ����Ʈ(������) / ����¡
	 */
	public ArrayList<MemberVo> select(int startCount, int endCount) {
		Map<String,Integer> param = new HashMap<String,Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		List<MemberVo> list = sqlSession.selectList("mapper.member.list2",param);
		return (ArrayList<MemberVo>)list;
	}
	
	/**
	 * select - ȸ�� ���� ����(����������)
	 */
	public MemberVo select(String mid) {
		return sqlSession.selectOne("mapper.member.content",mid);
	}
	
	/**
	 * checkId - ȸ������ ���̵� �ߺ�üũ
	 */
	public int checkId(String mid) {
		return sqlSession.selectOne("mapper.member.checkId",mid);
	}
	
	/**
	 * checkMail - ȸ������ ���̵� �ߺ�üũ
	 */
	public int checkMail(String email) {
		return sqlSession.selectOne("mapper.member.checkMail",email);
	}
	
	/**
	 * update - ȸ������ ����(����������)
	 */
	public int update(MemberVo memberVo) {
		return sqlSession.update("mapper.member.update",memberVo);
	}
	
	/**
	 * findId - ���̵� ã��
	 */
	public String findId(MemberVo memberVo) {
		return sqlSession.selectOne("mapper.member.find", memberVo);
	}
	
	/**
	 * findPass - ��й�ȣ �缳�� - ���� ��ġ ���� Ȯ��
	 */
	public String findPass(MemberVo memberVo) {
		return sqlSession.selectOne("mapper.member.find", memberVo);
	}
	
	/**
	 * updatePass - ��й�ȣ �缳�� - �缳��
	 */
	public int updatePass(MemberVo memberVo) {
		return sqlSession.update("mapper.member.updatePass",memberVo);
	}
	
	/**
	 * search - ��� �� �˻�
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


