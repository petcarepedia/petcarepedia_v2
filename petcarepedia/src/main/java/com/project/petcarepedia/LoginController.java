package com.project.petcarepedia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.MemberDao;
import com.project.vo.MemberVo;

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
	@RequestMapping(value="/login_proc.do",method=RequestMethod.POST)
	public ModelAndView login_proc(MemberVo memberVo) {
		ModelAndView model = new ModelAndView();
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.checkLogin(memberVo);
		
		if(result==1) {
			model.addObject("login_result", "success");
			model.setViewName("index");
		} else {
			model.addObject("login_result", "fail");
			model.setViewName("/login/login");
		}
		
		return model;
	}
	
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
	@RequestMapping(value="/login_idfind_proc.do",method=RequestMethod.POST)
	public ModelAndView login_idfind_proc(MemberVo memberVo) {
		ModelAndView model = new ModelAndView();
		
		MemberDao memberDao = new MemberDao();
		String mid = memberDao.findId(memberVo);
		
		if(mid!="") {
			model.addObject("mid", mid);
			model.setViewName("/login/login_idfind_success");
		} else {
			model.setViewName("/login/login_idfind_fail");
		}
		
		return model;
	}
	
	/**
	 * login_idfind_success.do - 아이디찾기 성공
	 * POST 방식으로 수정
	 */
	@RequestMapping(value="/login_idfind_success.do",method=RequestMethod.POST)
	public String login_idfind_success() {
		return "/login/login_idfind_success";
	}
	
	/**
	 * login_idfind_fail.do - 아이디찾기 실패
	 * POST 방식으로 수정
	 */
	@RequestMapping(value="/login_idfind_fail.do",method=RequestMethod.POST)
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
	
	/**
	 * login_pwfind_proc.do - 비밀번호 재설정 - 정보 확인 처리
	 */
	@RequestMapping(value="/login_pwfind_proc.do",method=RequestMethod.POST)
	public ModelAndView login_pwfind_proc(MemberVo memberVo) {
		ModelAndView model = new ModelAndView();
		
		MemberDao memberDao = new MemberDao();
		String mid = memberDao.findPass(memberVo);
		
		if(mid!="") {
			model.addObject("mid", mid);
			model.setViewName("/login/login_pwupdate");
		} else {
			model.setViewName("/login/login_pwfind_fail");
		}
		
		return model;
	}
	
	/**
	 * login_pwfind_fail.do - 비밀번호 재설정 - 정보 확인 실패
	 * POST 방식으로 수정
	 */
	@RequestMapping(value="/login_pwfind_fail.do",method=RequestMethod.POST)
	public String login_pwfind_fail() {
		return "/login/login_pwfind_fail";
	}
	
	/**
	 * login_pwupdate.do - 비밀번호 재설정 - 재설정
	 */
	@RequestMapping(value="/login_pwupdate.do",method=RequestMethod.GET)
	public String login_pwupdate() {
		return "/login/login_pwupdate";
	}
	
	/**
	 * login_pwupdate_proc.do - 비밀번호 재설정 - 재설정 처리
	 */
	@RequestMapping(value="/login_pwupdate_proc.do",method=RequestMethod.POST)
	public String login_pwupdate_proc(MemberVo memberVo) {
		String viewName = "";
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.updatePass(memberVo);
		
		if(result==1) {
			viewName = "/login/login_pwupdate_success";
		} else {
			//에러페이지
		}
		
		return viewName;
	}
	
	/**
	 * login_pwupdate_success.do - 비밀번호 재설정 - 재설정 성공
	 */
	@RequestMapping(value="/login_pwupdate_success.do",method=RequestMethod.GET)
	public String login_pwupdate_success() {
		return "/login/login_pwupdate_success";
	}
}
