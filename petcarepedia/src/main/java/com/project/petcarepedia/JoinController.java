package com.project.petcarepedia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import com.project.dao.MemberDao;
import com.project.vo.MemberVo;

@Controller
public class JoinController {
	MemberDao memberDao = new MemberDao();
	
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
	@RequestMapping(value="/join_proc.do",method=RequestMethod.POST)
	public ModelAndView join_proc(MemberVo memberVo) {
		ModelAndView model = new ModelAndView();
		
		int result = memberDao.insert(memberVo);
		
		if(result==1) {
			model.addObject("join_result", "success");
			model.setViewName("/login/login");
		} else {
			//����������
		}
		
		return model;
	}
	
	/**
	 * id_check - ���̵� �ߺ�üũ
	 */
	@RequestMapping(value="/id_check.do",method=RequestMethod.GET) //������Ʈ������̹Ƿ� -> GET
	@ResponseBody
	public String id_check(String id) {
		int result = memberDao.checkId(id);
		
		return String.valueOf(result);
	}
	
	/**
	 * join_term.do - ȸ������ ��� �󼼺���
	 */
	@RequestMapping(value="/join_term.do",method=RequestMethod.GET)
	public String join_term() {
		return "join/join_term";
	}
	
	/**
	 * join_term_data.do - ȸ������ ��� �󼼺���
	 */

}
