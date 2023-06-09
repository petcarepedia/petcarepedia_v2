package com.project.petcarepedia;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.service.MailSendService;
import com.project.service.MemberService;
import com.project.vo.MemberVo;
import com.project.vo.SessionVo;

@Controller
public class LoginController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private MailSendService mailService;
	
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
	public ModelAndView login_proc(MemberVo memberVo, HttpSession session) {
		ModelAndView model = new ModelAndView();
		SessionVo svo = memberService.getLogin(memberVo);
		
		if(svo != null) {
			if(svo.getLoginResult()==1) {
				session.setAttribute("svo",svo);
				model.addObject("login_result", "success");
				model.setViewName("redirect:/index.do");
			}
		} else {
			model.addObject("login_result", "fail");
			model.setViewName("/login/login");
		}
		
		return model;
	}
	
	/**
	 * logout.do - 로그아웃
	 */
	@RequestMapping(value="/logout.do",method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		ModelAndView model = new ModelAndView();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		if(svo != null) {
			session.invalidate();
			model.addObject("logout_result","success");
		}
		
		model.setViewName("redirect:/index.do");
		
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
		
		String mid = memberService.getFindId(memberVo);
		
		if(mid!="" && mid!=null) {
			mailService.idFindEmail(memberVo, mid);
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
		
		String mid = memberService.getFindPass(memberVo);
		
		if(mid!="" && mid!=null) {
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
	public ModelAndView login_pwupdate_proc(MemberVo memberVo,HttpSession session) {
		ModelAndView model = new ModelAndView();
		
		if(memberService.getUpdatePass(memberVo)==1) {
			session.invalidate();
			model.addObject("pwupdate_result", "success");
			model.setViewName("/login/login");
		} else {
			//에러페이지
		}
		
		return model;
	}
	
	/**
	 * login_pwupdate_success.do - 비밀번호 재설정 - 재설정 성공
	 */
	@RequestMapping(value="/login_pwupdate_success.do",method=RequestMethod.GET)
	public String login_pwupdate_success() {
		return "/login/login_pwupdate_success";
	}
	
}
