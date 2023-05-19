package com.project.petcarepedia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.dao.MemberDao;

@Controller
public class JoinController {
	/**
	 * join.do - 회원가입
	 */
	@RequestMapping(value="/join.do",method=RequestMethod.GET)
	public String join() {
		return "/join/join";
	}
	
	/**
	 * join_proc.do - 회원가입 처리
	 */
//	@RequestMapping(value="/join_proc.do",method=RequestMethod.POST)
//	public String join_proc() {
//	}
	
	/**
	 * id_check - 아이디 중복체크
	 */
	@RequestMapping(value="/id_check.do",method=RequestMethod.GET) //쿼리스트링방식이므로 -> GET
	@ResponseBody
	public String id_check(String id) {
		MemberDao memberDao = new MemberDao();
		int result = memberDao.checkId(id);
		
		return String.valueOf(result);
	}
}
