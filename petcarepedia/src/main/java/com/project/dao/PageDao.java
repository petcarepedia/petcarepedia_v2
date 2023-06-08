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
	
	
	public List<Object> Rselect(int startCount, int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);		
		
		return sqlSession.selectList("mapper.page.Rlist", param);
	}
	
	public List<Object> Bselect(int startCount, int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);		
		
		return sqlSession.selectList("mapper.page.Blist", param);
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
	public int BtotalRowCount() {
		return sqlSession.selectOne("mapper.page.Bcount");
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
}
