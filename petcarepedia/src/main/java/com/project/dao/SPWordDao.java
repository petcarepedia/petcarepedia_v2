package com.project.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.vo.MemberVo;

@Repository
public class SPWordDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * insert - ȸ������
	 */
	public int insert(MemberVo memberVo) {
		return sqlSession.insert("mapper.member.join",memberVo);
	}
}
