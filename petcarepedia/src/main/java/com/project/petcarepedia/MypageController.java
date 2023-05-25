package com.project.petcarepedia;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.BookingDao;
import com.project.dao.BookmarkDao;
import com.project.dao.MemberDao;
import com.project.dao.ReviewDao;
import com.project.vo.BookingVo;
import com.project.vo.BookmarkVo;
import com.project.vo.MemberVo;
import com.project.vo.ReviewVo;

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
	 * reservation.do - 예약내역(예약중) 폼
	 */
	@RequestMapping(value = "/reservation.do", method = RequestMethod.GET)
	public ModelAndView reservation(String mid) {
		ModelAndView model = new ModelAndView();
		BookingDao bookingDao = new BookingDao();
		ArrayList<BookingVo> list = bookingDao.search2(mid);
		
		model.setViewName("/mypage/reservation");
		model.addObject("list", list);
		
		return model;
	}
	
	/*
	 * reservation.do - 예약내역 삭제하기 폼
	 */
	@RequestMapping(value = "/reservation_delete.do", method = RequestMethod.GET)
	public ModelAndView reservation_delete(String bid, String mid) {
		ModelAndView model = new ModelAndView();
		model.addObject("bid", bid);
		model.addObject("mid", mid);
		model.setViewName("/mypage/reservation_delete");
		return model;
	}
	
	
	
	
	/*
	 * reservation_delete_proc.do - 예약내역(예약중)폼에서 삭제하기 처리
	 */
	@RequestMapping(value = "/reservation_delete_proc.do", method = RequestMethod.POST)
	public String reservation_delete_proc(String bid) {
		String viewName = "";
		BookingDao bookingDao = new BookingDao();
		int result = bookingDao.delete(bid);
		if(result == 1) {
			viewName = "redirect:/reservation.do?mid=hong";
		}
		return viewName;
	}
	
	
	
	
	/*
	 * reservation2.do - 예약내역(진료완료) 폼
	 */
	@RequestMapping(value = "/reservation2.do", method = RequestMethod.GET)
	public ModelAndView reservation2(String mid) {
		ModelAndView model = new ModelAndView();
		BookingDao bookingDao = new BookingDao();
		ArrayList<BookingVo> list = bookingDao.search1(mid);
		model.setViewName("/mypage/reservation2");
		model.addObject("list", list);
		return model;
	}
	
	
	/*
	 * bookmark.do - 즐겨찾기 폼
	 */
	@RequestMapping(value = "/bookmark.do", method = RequestMethod.GET)
	public ModelAndView bookmark(String mid) {
		ModelAndView model = new ModelAndView();
		BookmarkDao bookmarkDao = new BookmarkDao();
		ArrayList<BookmarkVo> list = bookmarkDao.select(mid);
		model.setViewName("/mypage/bookmark");
		model.addObject("list", list);
		return model;
	}
	
	/*
	 * bookmark_delete.do - 즐겨찾기 삭제하기 폼
	 */
	@RequestMapping(value = "/bookmark_delete.do", method = RequestMethod.GET)
	public ModelAndView bookmark_delete(String bmid) {
		ModelAndView model = new ModelAndView();
		model.setViewName("/mypage/bookmark_delete");
		model.addObject("bmid", bmid);
		return model;
	}
	
	/*
	 * bookmark_delete_proc.do - 즐겨찾기 삭제하기 처리
	 */
	@RequestMapping(value = "/bookmark_delete_proc.do", method = RequestMethod.POST)
	public String bookmark_delete_proc(String bmid) {
		String viewName = "";
		BookmarkDao bookmarkDao = new BookmarkDao();
		int result = bookmarkDao.delete(bmid);
		if(result == 1) {
			viewName = "redirect:/bookmark.do?mid=hong";
		}
		return viewName;
	}
	
	
	/*
	 * my_review.do - 내가 쓴 리뷰 폼
	 */
	@RequestMapping(value = "/my_review.do", method = RequestMethod.GET)
	public ModelAndView my_review(String mid) {
		ModelAndView model = new ModelAndView();
		ReviewDao reviewDao = new ReviewDao();
		ArrayList<ReviewVo> list = reviewDao.my_select(mid);
		
		model.addObject("list", list);
		model.setViewName("/mypage/my_review");
		return model;
	}
 	
	/*
	 * review_revise.do - 리뷰 수정 폼
	 */
	@RequestMapping(value = "/review_revise.do", method = RequestMethod.GET)
	public ModelAndView review_revise(String rid) {
		ModelAndView model = new ModelAndView();
		ReviewDao reviewDao = new ReviewDao();
		ReviewVo reviewVo = reviewDao.select(rid);
		
		model.addObject("reviewVo", reviewVo);
		model.setViewName("/mypage/review_revise");
		
		return model;
	}
	/*
	 * review_update_proc.do - 리뷰 수정하기 처리
	 */
	@RequestMapping(value = "/review_update_proc.do", method = RequestMethod.POST)
	public String review_update_proc(ReviewVo reviewVo) {
		String viewName = "";
		ReviewDao reviewDao = new ReviewDao();
		int result = reviewDao.update(reviewVo);
		if(result == 1) {
			viewName = "redirect:/my_review.do?mid=hong";
		} else {
			//오류페이지 호출
		}
		return viewName;
	}
	/*
	 * review_delete.do - 리뷰 삭제하기 폼
	 */
	@RequestMapping(value = "/my_review_delete.do", method = RequestMethod.GET)
	public ModelAndView reservation_delete(String rid) {
		ModelAndView model = new ModelAndView();
		model.addObject("rid", rid);
		model.setViewName("/mypage/my_review_delete");
		return model;
	}
	
	/*
	 * my_review_delete_proc.do.do - 내가 쓴 리뷰 삭제하기 처리
	 */
	@RequestMapping(value = "/my_review_delete_proc.do", method = RequestMethod.POST)
	public String my_review_delete_proc(String rid) {
		String viewName = "";
		ReviewDao reviewDao = new ReviewDao();
		int result = reviewDao.delete(rid);
		if(result == 1) {
			viewName = "redirect:/my_review.do?mid=hong";
		}
		return viewName;
	}
	
	
	
	
	/*
	 * review_write.do - 리뷰 쓰기폼
	 */
	@RequestMapping(value = "/review_write.do", method = RequestMethod.GET)
	public ModelAndView review_write(String mid, String hid) {
		ModelAndView model = new ModelAndView();
		model.addObject("mid", mid);
		model.addObject("hid", hid);
		model.setViewName("/mypage/review_write");
		return model;
	}
	
	/*
	 *  review_write_proc.do - 리뷰 쓰기처리
	 */
	@RequestMapping(value = "/review_write_proc.do", method = RequestMethod.POST)
	public String review_write_proc(ReviewVo reviewVo) {
		String viewName = "";
		ReviewDao reviewDao = new ReviewDao();
		int result = reviewDao.insert(reviewVo);
		if(result == 1) {
			viewName = "redirect:/my_review?mid=" + reviewVo.getMid();
		}
		return viewName;
	}
	
	
	@RequestMapping(value = "/signout.do", method = RequestMethod.GET)
	public String signout() {
		return "/mypage/signout";
	}
	

}
