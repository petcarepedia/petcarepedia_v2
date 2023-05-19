package com.project.petcarepedia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.dao.MemberDao;

@Controller
public class JoinController {
	/**
	 * join.do - ȸ������
	 */
	@RequestMapping(value="/join.do",method=RequestMethod.GET)
	public String join() {
		return "/join/join";
	}
	
	/**
	 * join_proc.do - ȸ������ ó��
	 */
//	@RequestMapping(value="/join_proc.do",method=RequestMethod.POST)
//	public String join_proc() {
//	}
	
	/**
	 * id_check - ���̵� �ߺ�üũ
	 */
	@RequestMapping(value="/id_check.do",method=RequestMethod.GET) //������Ʈ������̹Ƿ� -> GET
	@ResponseBody
	public String id_check(String id) {
		MemberDao memberDao = new MemberDao();
		int result = memberDao.checkId(id);
		
		return String.valueOf(result);
	}
}
