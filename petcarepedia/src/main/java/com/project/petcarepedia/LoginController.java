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
	 * login_proc.do - �α��� ó��
	 */
//	@RequestMapping(value="/login_proc.do",method=RequestMethod.GET)
//	public String login_proc() {
//	}
	
	/**
	 * login_idfind.do - ���̵�ã��
	 */
	@RequestMapping(value="/login_idfind.do",method=RequestMethod.GET)
	public String login_idfind() {
		return "/login/login_idfind";
	}
	
	/**
	 * login_idfind_proc.do - ���̵�ã�� ó��
	 */
//	@RequestMapping(value="/login_idfind_proc.do",method=RequestMethod.GET)
//	public String login_idfind_proc() {
//	}
	
	/**
	 * login_idfind_success.do - ���̵�ã�� ����
	 * POST ������� ����
	 */
	@RequestMapping(value="/login_idfind_success.do",method=RequestMethod.GET)
	public String login_idfind_success() {
		return "/login/login_idfind_success";
	}
	
	/**
	 * login_idfind_fail.do - ���̵�ã�� ����
	 * POST ������� ����
	 */
	@RequestMapping(value="/login_idfind_fail.do",method=RequestMethod.GET)
	public String login_idfind_fail() {
		return "/login/login_idfind_fail";
	}
	
	/**
	 * login_pwfind.do - ��й�ȣ �缳�� - ���� Ȯ��
	 */
	@RequestMapping(value="/login_pwfind.do",method=RequestMethod.GET)
	public String login_pwfind() {
		return "/login/login_pwfind";
	}
}
