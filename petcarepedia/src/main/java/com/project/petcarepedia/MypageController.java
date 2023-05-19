package com.project.petcarepedia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MypageController {
	/*
	 * information.do - 나의 회원정보 폼
	 */
	@RequestMapping(value = "/information.do", method = RequestMethod.GET)
	public ModelAndView information(String mid) {
		ModelAndView model = new ModelAndView();
		MemberDao memberDao = new MemberDao();
		MemberVo memberVo = memberDao.select(mid);
		model.addObject("memberVo", memberVo);
		model.setViewName("/mypage/information");
		return model;
	}
	
	@RequestMapping(value = "/reservation.do", method = RequestMethod.GET)
	public String reservation() {
		return "/mypage/reservation";
	}
	
	@RequestMapping(value = "/reservation2.do", method = RequestMethod.GET)
	public String reservation2() {
		return "/mypage/reservation2";
	}
	
	@RequestMapping(value = "/bookmark.do", method = RequestMethod.GET)
	public String bookmark() {
		return "/mypage/bookmark";
	}
	
	@RequestMapping(value = "/my_review.do", method = RequestMethod.GET)
	public String my_review() {
		return "/mypage/my_review";
	}
 	
	@RequestMapping(value = "/review_revise.do", method = RequestMethod.GET)
	public String review_revise() {
		return "/mypage/review_revise";
	}
	
	@RequestMapping(value = "/review_write.do", method = RequestMethod.GET)
	public String review_write() {
		return "/mypage/review_write";
	}
	
	@RequestMapping(value = "/revise.do", method = RequestMethod.GET)
	public String revise() {
		return "/mypage/revise";
	}
	
	@RequestMapping(value = "/signout.do", method = RequestMethod.GET)
	public String signout() {
		return "/mypage/signout";
	}
	

}
