package com.project.petcarepedia;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.BookingDao;
import com.project.dao.MemberDao;
import com.project.vo.BookingVo;
import com.project.vo.MemberVo;

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
	
	/*
	 * revise.do - 수정하기 폼
	 */
	@RequestMapping(value = "/revise.do", method = RequestMethod.GET)
	public ModelAndView revise(String mid) {
		ModelAndView model = new ModelAndView();
		MemberDao memberDao = new MemberDao();
		MemberVo memberVo = memberDao.select(mid);
		model.addObject("memberVo", memberVo);
		model.setViewName("/mypage/revise");
		return model;
	}
	
	/*
	 * informatin_update_proc - 정보 수정하기 처리
	 */
	@RequestMapping(value = "/member_update_proc.do", method = RequestMethod.POST)
	public String member_update_proc(MemberVo memberVo) {
		String viewName = "";
		MemberDao memberDao = new MemberDao();
		int result = memberDao.update(memberVo);
		if(result == 1) {
			viewName = "redirect:/information.do?mid=" + memberVo.getMid();
		} else {
			//오류페이지 호출
		}
		return viewName;
	}
	
	/*
	 * reservation.do - 예약내역 폼
	 */
	@RequestMapping(value = "/reservation.do", method = RequestMethod.GET)
	public ModelAndView reservation(String mid) {
		ModelAndView model = new ModelAndView();
		BookingDao bookingDao = new BookingDao();
		ArrayList<BookingVo> list = bookingDao.search(mid);
		
		model.setViewName("/mypage/reservation");
		model.addObject("list", list);
		
		return model;
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
	

	
	@RequestMapping(value = "/signout.do", method = RequestMethod.GET)
	public String signout() {
		return "/mypage/signout";
	}
	

}
