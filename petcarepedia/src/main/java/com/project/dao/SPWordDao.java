package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.vo.SPWordVo;

@Repository
public class SPWordDao extends DBConn{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * insert - �˻��� �Է�
	 */
	public int insert(String word) {
		return sqlSession.insert("mapper.spword.insert",word);
	}
	
	/**
	 * select - �α�˻��� ���� 5�� ���
	 */
	public ArrayList<SPWordVo> select() {
		List<SPWordVo> list = sqlSession.selectList("mapper.spword.select");
		return (ArrayList<SPWordVo>)list;
	}
}
