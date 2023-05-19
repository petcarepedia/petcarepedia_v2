package com.project.petcarepedia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	/**
	 * login.do - �α���
	 */
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String login() {
		return "/login/login";
	}
	
	/**
	 * login_idfind.do - ���̵�ã��
	 */
	@RequestMapping(value="/login_idfind.do",method=RequestMethod.GET)
	public String login_idfind() {
		return "/login/login_idfind";
	}
	
	/**
	 * login_pwfind.do - ��й�ȣ �缳�� - ���� Ȯ��
	 */
	@RequestMapping(value="/login_pwfind.do",method=RequestMethod.GET)
	public String login_pwfind() {
		return "/login/login_pwfind";
	}
}
