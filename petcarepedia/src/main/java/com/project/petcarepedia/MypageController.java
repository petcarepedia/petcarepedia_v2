package com.project.petcarepedia;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.service.BookingService;
import com.project.service.BookmarkService;
import com.project.service.MemberService;
import com.project.service.ReviewService;
import com.project.vo.BookingReviewVo;
import com.project.vo.BookingVo;
import com.project.vo.BookmarkVo;
import com.project.vo.MemberVo;
import com.project.vo.ReviewVo;
import com.project.vo.SessionVo;

@Controller
public class MypageController {
	@Autowired
	private BookmarkService bookmarkService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private ReviewService reviewService;
	
	/*
	 * information.do - 나의 회원정보 폼
	 */
	@RequestMapping(value = "/mypage_member_information.do", method = RequestMethod.GET)
	public ModelAndView information(HttpServletRequest request) {
		HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		ModelAndView model = new ModelAndView();
		//MemberDao memberDao = new MemberDao();
		MemberVo memberVo = memberService.getSelect(svo.getMid());
		model.addObject("memberVo", memberVo);
		model.setViewName("/mypage/mypage_member_information");
		return model;
	}
	
	/*
	 * revise.do - 회원정보 수정하기 폼
	 */
	@RequestMapping(value = "/mypage_member_revise.do", method = RequestMethod.GET)
	public ModelAndView revise(HttpServletRequest request) {
		HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		ModelAndView model = new ModelAndView();
		//MemberDao memberDao = new MemberDao();
		MemberVo memberVo = memberService.getSelect(svo.getMid());
		model.addObject("memberVo", memberVo);
		model.setViewName("/mypage/mypage_member_revise");
		return model;
	}
	
	/*
	 * informatin_update_proc - 정보 수정하기 처리
	 */
	@RequestMapping(value = "/member_update_proc.do", method = RequestMethod.POST)
	public String member_update_proc(MemberVo memberVo) {
		String viewName = "";
		//MemberDao memberDao = new MemberDao();
		int result = memberService.getUpdate(memberVo);
		if(result == 1) {
			viewName = "redirect:/mypage_member_information.do";
		} else {
			//오류페이지 호출
		}
		return viewName;
	}
	
	/*
	 * reservation.do - 예약내역(예약중) 폼
	 */
	@RequestMapping(value = "/mypage_reservation.do", method = RequestMethod.GET)
	public ModelAndView reservation(HttpServletRequest request) {
		HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		ModelAndView model = new ModelAndView();
		//BookingDao bookingDao = new BookingDao();
		ArrayList<BookingVo> list = bookingService.getSearch2(svo.getMid());
		ArrayList<BookingVo> list2 = bookingService.getSearch4(svo.getMid());
		model.setViewName("/mypage/mypage_reservation");
		model.addObject("list", list);
		model.addObject("list2", list2);
		
		return model;
	}
	
	/*
	 * reservation.do - 예약내역 삭제하기 폼
	 */
	@RequestMapping(value = "/mypage_reservation_delete.do", method = RequestMethod.GET)
	public ModelAndView reservation_delete(String bid, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		//BookingDao bookingDao = new BookingDao();
		BookingVo bookingVo = bookingService.getSelect2(bid);
		model.addObject("bid", bid);
		//model.addObject("mid", mid);
		model.addObject("bookingVo", bookingVo);
		model.setViewName("/mypage/mypage_reservation_delete");
		return model;
	}
	
	
	
	
	/*
	 * reservation_delete_proc.do - 예약내역(예약중)폼에서 삭제하기 처리
	 */
	@RequestMapping(value = "/reservation_delete_proc.do", method = RequestMethod.POST)
	public String reservation_delete_proc(String bid) {
		String viewName = "";
		//BookingDao bookingDao = new BookingDao();
		int result = bookingService.getDelete(bid);
		if(result == 1) {
			viewName = "redirect:/mypage_reservation.do";
		}
		return viewName;
	}
	
	
	
	
	/*
	 * reservation2.do - 예약내역(진료완료) 폼
	 */
	@RequestMapping(value = "/mypage_reservation2.do", method = RequestMethod.GET)
	public ModelAndView reservation2(HttpServletRequest request) {
		HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		ModelAndView model = new ModelAndView();
		//BookingDao bookingDao = new BookingDao();
		ArrayList<BookingVo> list = bookingService.getSearch1(svo.getMid());
		ArrayList<BookingReviewVo> list2 = bookingService.getSearch3(svo.getMid());
		model.setViewName("/mypage/mypage_reservation2");
		model.addObject("list", list);
		model.addObject("list2", list2);
		return model;
	}
	
	
	/*
	 * bookmark.do - 즐겨찾기 폼
	 */
	@RequestMapping(value = "/mypage_bookmark.do", method = RequestMethod.GET)
	public ModelAndView bookmark(HttpServletRequest request) {
		HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		ModelAndView model = new ModelAndView();
		//BookmarkDao bookmarkDao = new BookmarkDao();
		ArrayList<BookmarkVo> list = bookmarkService.getSelect(svo.getMid());
		model.setViewName("/mypage/mypage_bookmark");
		model.addObject("list", list);
		return model;
	}
	
	/*
	 * bookmark_delete.do - 즐겨찾기 삭제하기 폼
	 */
//	@RequestMapping(value = "/bookmark_delete.do", method = RequestMethod.GET)
//	public ModelAndView bookmark_delete(String bmid) {
//		ModelAndView model = new ModelAndView();
//		model.setViewName("/mypage/bookmark_delete");
//		model.addObject("bmid", bmid);
//		return model;
//	}
	
	/*
	 * bookmark_delete_proc.do - 즐겨찾기 삭제하기 처리
	 */
	@RequestMapping(value = "/bookmark_delete_proc.do", method = RequestMethod.GET)
	public String bookmark_delete_proc(String bmid) {
		String viewName = "";
		//BookmarkDao bookmarkDao = new BookmarkDao();
		int result = bookmarkService.getDelete(bmid);
		if(result == 1) {
			viewName = "redirect:/mypage_bookmark.do";
		}
		return viewName;
	}
	
	
	/*
	 * my_review.do - 내가 쓴 리뷰 폼
	 */
	@RequestMapping(value = "/mypage_my_review.do", method = RequestMethod.GET)
	public ModelAndView my_review(HttpServletRequest request) {
		HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		ModelAndView model = new ModelAndView();
		//ReviewDao reviewDao = new ReviewDao();
		ArrayList<ReviewVo> list = reviewService.getMy_select(svo.getMid());
		
		model.addObject("list", list);
		model.setViewName("/mypage/mypage_my_review");
		return model;
	}
 	
	/*
	 * mypage_review_content.do - 리뷰 상세보기 페이지
	 */
	@RequestMapping(value = "/mypage_review_content.do", method = RequestMethod.GET)
	public ModelAndView mypage_review_content(String rid) {
		ModelAndView model = new ModelAndView();
		ReviewVo reviewVo = reviewService.getEnter_select(rid);	
		model.addObject("reviewVo", reviewVo);
		model.setViewName("/mypage/mypage_review_content");
		return model;
	}
	
	
	
	
	
	
	/*
	 * review_revise.do - 리뷰 수정 폼
	 */
	@RequestMapping(value = "/mypage_review_revise.do", method = RequestMethod.GET)
	public ModelAndView review_revise(String rid) {
		ModelAndView model = new ModelAndView();
		//ReviewDao reviewDao = new ReviewDao();
		ReviewVo reviewVo = reviewService.getSelect(rid);
		
		model.addObject("reviewVo", reviewVo);
		model.setViewName("/mypage/mypage_review_revise");
		
		return model;
	}
	/*
	 * review_update_proc.do - 리뷰 수정하기 처리
	 */
	@RequestMapping(value = "/review_update_proc.do", method = RequestMethod.POST)
	public String review_update_proc(ReviewVo reviewVo) {
		String viewName = "";
		//ReviewDao reviewDao = new ReviewDao();
		int result = reviewService.getUpdate(reviewVo);
		if(result == 1) {
			viewName = "redirect:/mypage_review_content.do?rid=" + reviewVo.getRid();
		} else {
			//오류페이지 호출
		}
		return viewName;
	}
	/*
	 * review_delete.do - 리뷰 삭제하기 폼
	 */
	@RequestMapping(value = "/mypage_review_delete.do", method = RequestMethod.GET)
	public ModelAndView reservation_delete(String rid) {
		ModelAndView model = new ModelAndView();
		//ReviewDao reviewDao = new ReviewDao();
		ReviewVo reviewVo = reviewService.getSelect(rid);
		model.addObject("rid", rid);
		model.addObject("reviewVo", reviewVo);
		model.setViewName("/mypage/mypage_review_delete");
		return model;
	}
	
	/*
	 * my_review_delete_proc.do.do - 내가 쓴 리뷰 삭제하기 처리
	 */
	@RequestMapping(value = "/my_review_delete_proc.do", method = RequestMethod.POST)
	public String my_review_delete_proc(String rid) {
		String viewName = "";
		//ReviewDao reviewDao = new ReviewDao();
		int result = reviewService.getDelete(rid);
		if(result == 1) {
			viewName = "redirect:/mypage_my_review.do";
		}
		return viewName;
	}
	
	
	
	
	/*
	 * review_write.do - 리뷰 쓰기폼
	 */
	@RequestMapping(value = "/mypage_review_write.do", method = RequestMethod.GET)
	public ModelAndView review_write(HttpServletRequest request, String hid, String bid) {
		HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		ModelAndView model = new ModelAndView();
		//MemberDao memberDao = new MemberDao();
		MemberVo memberVo = memberService.getSelect(svo.getMid());
		model.addObject("memberVo", memberVo);
		model.addObject("hid", hid);
		model.addObject("bid", bid);
		model.setViewName("/mypage/mypage_review_write");
		return model;
	}
	
	/*
	 *  review_write_proc.do - 리뷰 쓰기처리
	 */
	@RequestMapping(value = "/review_write_proc.do", method = RequestMethod.POST)
	public String review_write_proc(ReviewVo reviewVo) {
		String viewName = "";
		//ReviewDao reviewDao = new ReviewDao();
		int result = reviewService.getInsert(reviewVo);
		if(result == 1) {
			viewName = "redirect:/mypage_my_review.do";
		} else {
			
		}
		return viewName;
	}
	
	/*
	 * signout.do - 회원탈퇴폼
	 */
	@RequestMapping(value = "/mypage_signout.do", method = RequestMethod.GET)
	public ModelAndView signout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		ModelAndView model = new ModelAndView();
		model.addObject("mid", svo.getMid());
		model.setViewName("/mypage/mypage_signout");
		return model;
	}
	
	/*
	 * member_delete_proc - 회원탈퇴 처리
	 */
	@RequestMapping(value = "/member_delete_proc.do", method = RequestMethod.POST ,produces="application/x-www-form-urlencoded;charset=UTF-8")
	public String member_delete_proc(HttpServletRequest request, String pass) {
		String viewName = "";
		HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		//MemberDao memberDao = new MemberDao();
		int result = memberService.getDelete(svo.getMid(), pass);
		if(result == 1) {
			session.invalidate();
			viewName = "redirect:/login.do";
		} else {
			//오류페이지 호출
		}
		return viewName;
	}

}
