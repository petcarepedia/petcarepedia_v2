package com.project.petcarepedia;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	 * login.do - �α���
	 */
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String login() {
		return "/login/login";
	}
	
	/**
	 * login_proc.do - �α��� ó��
	 */
	@RequestMapping(value="/login_proc.do",method=RequestMethod.POST)
	public ModelAndView login_proc(MemberVo memberVo, String rememberMid, HttpSession session, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		SessionVo svo = memberService.getLogin(memberVo);
		
		if(svo != null) {
			if(svo.getLoginResult()==1) {
				session.setAttribute("svo",svo);
				
				Cookie cookie = new Cookie("user_check", svo.getMid());
				if(rememberMid.equals("true")) {
					response.addCookie(cookie);
				} else {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
				
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
	 * logout.do - �α׾ƿ�
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
	 * login_idfind.do - ���̵�ã��
	 */
	@RequestMapping(value="/login_idfind.do",method=RequestMethod.GET)
	public String login_idfind() {
		return "/login/login_idfind";
	}
	
	/**
	 * login_idfind_proc.do - ���̵�ã�� ó��
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
	 * login_idfind_success.do - ���̵�ã�� ����
	 * POST ������� ����
	 */
	@RequestMapping(value="/login_idfind_success.do",method=RequestMethod.POST)
	public String login_idfind_success() {
		return "/login/login_idfind_success";
	}
	
	/**
	 * login_idfind_fail.do - ���̵�ã�� ����
	 * POST ������� ����
	 */
	@RequestMapping(value="/login_idfind_fail.do",method=RequestMethod.POST)
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
	
	/**
	 * login_pwfind_proc.do - ��й�ȣ �缳�� - ���� Ȯ�� ó��
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
	 * login_pwfind_fail.do - ��й�ȣ �缳�� - ���� Ȯ�� ����
	 * POST ������� ����
	 */
	@RequestMapping(value="/login_pwfind_fail.do",method=RequestMethod.POST)
	public String login_pwfind_fail() {
		return "/login/login_pwfind_fail";
	}
	
	/**
	 * login_pwupdate.do - ��й�ȣ �缳�� - �缳��
	 */
	@RequestMapping(value="/login_pwupdate.do",method=RequestMethod.GET)
	public String login_pwupdate() {
		return "/login/login_pwupdate";
	}
	
	/**
	 * login_pwupdate_proc.do - ��й�ȣ �缳�� - �缳�� ó��
	 */
	@RequestMapping(value="/login_pwupdate_proc.do",method=RequestMethod.POST)
	public ModelAndView login_pwupdate_proc(MemberVo memberVo,HttpSession session) {
		ModelAndView model = new ModelAndView();
		
		if(memberService.getUpdatePass(memberVo)==1) {
			session.invalidate();
			model.addObject("pwupdate_result", "success");
			model.setViewName("/login/login");
		} else {
			//����������
		}
		
		return model;
	}
	
	/**
	 * login_pwupdate_success.do - ��й�ȣ �缳�� - �缳�� ����
	 */
	@RequestMapping(value="/login_pwupdate_success.do",method=RequestMethod.GET)
	public String login_pwupdate_success() {
		return "/login/login_pwupdate_success";
	}
	
	/**
	 * pass_mulcheck - ��й�ȣ �ߺ�üũ
	 */
	@RequestMapping(value="/pass_mulcheck.do",method=RequestMethod.GET,produces="text/plain;charset=UTF-8") //������Ʈ������̹Ƿ� -> GET
	@ResponseBody
	public String pass_mulcheck(String mid, String pass) {
		return String.valueOf(memberService.getCheckPass(mid, pass));
	}
	
}
