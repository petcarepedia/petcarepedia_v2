package com.project.petcarepedia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	/**
	 * login.do - 로그인
	 */
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String login() {
		return "/login/login";
	}
	
	/**
	 * login_proc.do - 로그인 처리
	 */
//	@RequestMapping(value="/login_proc.do",method=RequestMethod.GET)
//	public String login_proc() {
//	}
	
	/**
	 * login_idfind.do - 아이디찾기
	 */
	@RequestMapping(value="/login_idfind.do",method=RequestMethod.GET)
	public String login_idfind() {
		return "/login/login_idfind";
	}
	
	/**
	 * login_idfind_proc.do - 아이디찾기 처리
	 */
//	@RequestMapping(value="/login_idfind_proc.do",method=RequestMethod.GET)
//	public String login_idfind_proc() {
//	}
	
	/**
	 * login_idfind_success.do - 아이디찾기 성공
	 * POST 방식으로 수정
	 */
	@RequestMapping(value="/login_idfind_success.do",method=RequestMethod.GET)
	public String login_idfind_success() {
		return "/login/login_idfind_success";
	}
	
	/**
	 * login_idfind_fail.do - 아이디찾기 실패
	 * POST 방식으로 수정
	 */
	@RequestMapping(value="/login_idfind_fail.do",method=RequestMethod.GET)
	public String login_idfind_fail() {
		return "/login/login_idfind_fail";
	}
	
	/**
	 * login_pwfind.do - 비밀번호 재설정 - 정보 확인
	 */
	@RequestMapping(value="/login_pwfind.do",method=RequestMethod.GET)
	public String login_pwfind() {
		return "/login/login_pwfind";
	}
}
