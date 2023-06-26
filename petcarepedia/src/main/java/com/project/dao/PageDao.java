package com.project.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PageDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Object> Myselect(int startCount, int endCount, String mid) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", startCount);
		param.put("end", endCount);
		param.put("mid", mid);	
		
		return sqlSession.selectList("mapper.page.Mylist", param);
	}
	public List<Object> Mysselect(int startCount, int endCount) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", startCount);
		param.put("end", endCount);	
		
		return sqlSession.selectList("mapper.page.Myslist", param);
	}
	
	
	
	public List<Object> Rselect(int startCount, int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);		
		
		return sqlSession.selectList("mapper.page.Rlist", param);
	}
	public List<Object> Bsselect(int startCount, int endCount, String mid) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", startCount);
		param.put("end", endCount);	
		param.put("mid", mid);	
		
		return sqlSession.selectList("mapper.page.Bslist", param);
	}
	
	public List<Object> Bselect(int startCount, int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);		
		
		return sqlSession.selectList("mapper.page.Blist", param);
	}
	
	public List<Object> Msselect(int startCount, int endCount, String mid) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", startCount);
		param.put("end", endCount);		
		param.put("mid", mid);		
		
		return sqlSession.selectList("mapper.page.Mslist", param);
	}
	public List<Object> Mselect(int startCount, int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);		
		
		return sqlSession.selectList("mapper.page.Mlist", param);
	}
	
	public List<Object> Hsselect(int startCount, int endCount, String hname) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", startCount);
		param.put("end", endCount);	
		param.put("hname", hname);	
		
		return sqlSession.selectList("mapper.page.Hslist", param);
	}
	
	public List<Object> Hselect(int startCount, int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);		
		
		return sqlSession.selectList("mapper.page.Hlist", param);
	}
	
	
	public int RtotalRowCount() {
		return sqlSession.selectOne("mapper.page.Rcount");
	}
	public int BstotalRowCount(String mid) {
		return sqlSession.selectOne("mapper.page.Bscount", mid);
	}
	public int BtotalRowCount() {
		return sqlSession.selectOne("mapper.page.Bcount");
	}
	public int MstotalRowCount(String mid) {
		return sqlSession.selectOne("mapper.page.Mscount", mid);
	}
	public int MtotalRowCount() {
		return sqlSession.selectOne("mapper.page.Mcount");
	}
	public int HstotalRowCount(String hname) {
		return sqlSession.selectOne("mapper.page.Hscount", hname);
	}
	public int HtotalRowCount() {
		return sqlSession.selectOne("mapper.page.Hcount");
	}
	public int MytotalRowCount() {
		return sqlSession.selectOne("mapper.page.Mycount");
	}
	public int MystotalRowCount(String mid) {
		return sqlSession.selectOne("mapper.page.Myscount", mid);
	}
}
