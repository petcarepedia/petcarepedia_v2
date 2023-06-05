package com.project.petcarepedia;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.BookingDao;
import com.project.dao.MemberDao;
import com.project.dao.ReviewDao;
import com.project.service.BookingService;
import com.project.service.BookmarkService;
import com.project.service.MemberService;
import com.project.service.ReviewService;
import com.project.vo.BookingReviewVo;
import com.project.vo.BookingVo;
import com.project.vo.BookmarkVo;
import com.project.vo.MemberVo;
import com.project.vo.ReviewVo;

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
	 * information.do - ���� ȸ������ ��
	 */
	@RequestMapping(value = "/information.do", method = RequestMethod.GET)
	public ModelAndView information(String mid) {
		ModelAndView model = new ModelAndView();
		//MemberDao memberDao = new MemberDao();
		MemberVo memberVo = memberService.getSelect(mid);
		model.addObject("memberVo", memberVo);
		model.setViewName("/mypage/information");
		return model;
	}
	
	/*
	 * revise.do - �����ϱ� ��
	 */
	@RequestMapping(value = "/revise.do", method = RequestMethod.GET)
	public ModelAndView revise(String mid) {
		ModelAndView model = new ModelAndView();
		//MemberDao memberDao = new MemberDao();
		MemberVo memberVo = memberService.getSelect(mid);
		model.addObject("memberVo", memberVo);
		model.setViewName("/mypage/revise");
		return model;
	}
	
	/*
	 * informatin_update_proc - ���� �����ϱ� ó��
	 */
	@RequestMapping(value = "/member_update_proc.do", method = RequestMethod.POST)
	public String member_update_proc(MemberVo memberVo) {
		String viewName = "";
		//MemberDao memberDao = new MemberDao();
		int result = memberService.getUpdate(memberVo);
		if(result == 1) {
			viewName = "redirect:/information.do?mid=" + memberVo.getMid();
		} else {
			//���������� ȣ��
		}
		return viewName;
	}
	
	/*
	 * reservation.do - ���೻��(������) ��
	 */
	@RequestMapping(value = "/reservation.do", method = RequestMethod.GET)
	public ModelAndView reservation(String mid) {
		ModelAndView model = new ModelAndView();
		//BookingDao bookingDao = new BookingDao();
		ArrayList<BookingVo> list = bookingService.getSearch2(mid);
		ArrayList<BookingVo> list2 = bookingService.getSearch4(mid);
		model.setViewName("/mypage/reservation");
		model.addObject("list", list);
		model.addObject("list2", list2);
		
		return model;
	}
	
	/*
	 * reservation.do - ���೻�� �����ϱ� ��
	 */
	@RequestMapping(value = "/reservation_delete.do", method = RequestMethod.GET)
	public ModelAndView reservation_delete(String bid, String mid) {
		ModelAndView model = new ModelAndView();
		//BookingDao bookingDao = new BookingDao();
		BookingVo bookingVo = bookingService.getSelect2(bid);
		model.addObject("bid", bid);
		model.addObject("mid", mid);
		model.addObject("bookingVo", bookingVo);
		model.setViewName("/mypage/reservation_delete");
		return model;
	}
	
	
	
	
	/*
	 * reservation_delete_proc.do - ���೻��(������)������ �����ϱ� ó��
	 */
	@RequestMapping(value = "/reservation_delete_proc.do", method = RequestMethod.POST)
	public String reservation_delete_proc(String bid) {
		String viewName = "";
		//BookingDao bookingDao = new BookingDao();
		int result = bookingService.getDelete(bid);
		if(result == 1) {
			viewName = "redirect:/reservation.do?mid=hong";
		}
		return viewName;
	}
	
	
	
	
	/*
	 * reservation2.do - ���೻��(����Ϸ�) ��
	 */
	@RequestMapping(value = "/reservation2.do", method = RequestMethod.GET)
	public ModelAndView reservation2(String mid) {
		ModelAndView model = new ModelAndView();
		//BookingDao bookingDao = new BookingDao();
		ArrayList<BookingVo> list = bookingService.getSearch1(mid);
		ArrayList<BookingReviewVo> list2 = bookingService.getSearch3(mid);
		model.setViewName("/mypage/reservation2");
		model.addObject("list", list);
		model.addObject("list2", list2);
		return model;
	}
	
	
	/*
	 * bookmark.do - ���ã�� ��
	 */
	@RequestMapping(value = "/bookmark.do", method = RequestMethod.GET)
	public ModelAndView bookmark(String mid) {
		ModelAndView model = new ModelAndView();
		//BookmarkDao bookmarkDao = new BookmarkDao();
		ArrayList<BookmarkVo> list = bookmarkService.getSelect(mid);
		model.setViewName("/mypage/bookmark");
		model.addObject("list", list);
		return model;
	}
	
	/*
	 * bookmark_delete.do - ���ã�� �����ϱ� ��
	 */
//	@RequestMapping(value = "/bookmark_delete.do", method = RequestMethod.GET)
//	public ModelAndView bookmark_delete(String bmid) {
//		ModelAndView model = new ModelAndView();
//		model.setViewName("/mypage/bookmark_delete");
//		model.addObject("bmid", bmid);
//		return model;
//	}
	
	/*
	 * bookmark_delete_proc.do - ���ã�� �����ϱ� ó��
	 */
	@RequestMapping(value = "/bookmark_delete_proc.do", method = RequestMethod.GET)
	public String bookmark_delete_proc(String bmid) {
		String viewName = "";
		//BookmarkDao bookmarkDao = new BookmarkDao();
		int result = bookmarkService.getDelete(bmid);
		if(result == 1) {
			viewName = "redirect:/bookmark.do?mid=hong";
		}
		return viewName;
	}
	
	
	/*
	 * my_review.do - ���� �� ���� ��
	 */
	@RequestMapping(value = "/my_review.do", method = RequestMethod.GET)
	public ModelAndView my_review(String mid) {
		ModelAndView model = new ModelAndView();
		//ReviewDao reviewDao = new ReviewDao();
		ArrayList<ReviewVo> list = reviewService.getMy_select(mid);
		
		model.addObject("list", list);
		model.setViewName("/mypage/my_review");
		return model;
	}
 	
	/*
	 * review_revise.do - ���� ���� ��
	 */
	@RequestMapping(value = "/review_revise.do", method = RequestMethod.GET)
	public ModelAndView review_revise(String rid) {
		ModelAndView model = new ModelAndView();
		//ReviewDao reviewDao = new ReviewDao();
		ReviewVo reviewVo = reviewService.getSelect(rid);
		
		model.addObject("reviewVo", reviewVo);
		model.setViewName("/mypage/review_revise");
		
		return model;
	}
	/*
	 * review_update_proc.do - ���� �����ϱ� ó��
	 */
	@RequestMapping(value = "/review_update_proc.do", method = RequestMethod.POST)
	public String review_update_proc(ReviewVo reviewVo) {
		String viewName = "";
		//ReviewDao reviewDao = new ReviewDao();
		int result = reviewService.getUpdate(reviewVo);
		if(result == 1) {
			viewName = "redirect:/my_review.do?mid=hong";
		} else {
			//���������� ȣ��
		}
		return viewName;
	}
	/*
	 * review_delete.do - ���� �����ϱ� ��
	 */
	@RequestMapping(value = "/my_review_delete.do", method = RequestMethod.GET)
	public ModelAndView reservation_delete(String rid) {
		ModelAndView model = new ModelAndView();
		//ReviewDao reviewDao = new ReviewDao();
		ReviewVo reviewVo = reviewService.getSelect(rid);
		model.addObject("rid", rid);
		model.addObject("reviewVo", reviewVo);
		model.setViewName("/mypage/my_review_delete");
		return model;
	}
	
	/*
	 * my_review_delete_proc.do.do - ���� �� ���� �����ϱ� ó��
	 */
	@RequestMapping(value = "/my_review_delete_proc.do", method = RequestMethod.POST)
	public String my_review_delete_proc(String rid) {
		String viewName = "";
		//ReviewDao reviewDao = new ReviewDao();
		int result = reviewService.getDelete(rid);
		if(result == 1) {
			viewName = "redirect:/my_review.do?mid=hong";
		}
		return viewName;
	}
	
	
	
	
	/*
	 * review_write.do - ���� ������
	 */
	@RequestMapping(value = "/review_write.do", method = RequestMethod.GET)
	public ModelAndView review_write(String mid, String hid, String bid) {
		ModelAndView model = new ModelAndView();
		//MemberDao memberDao = new MemberDao();
		MemberVo memberVo = memberService.getSelect(mid);
		model.addObject("memberVo", memberVo);
		model.addObject("hid", hid);
		model.addObject("bid", bid);
		model.setViewName("/mypage/review_write");
		return model;
	}
	
	/*
	 *  review_write_proc.do - ���� ����ó��
	 */
	@RequestMapping(value = "/review_write_proc.do", method = RequestMethod.POST)
	public String review_write_proc(ReviewVo reviewVo) {
		String viewName = "";
		//ReviewDao reviewDao = new ReviewDao();
		int result = reviewService.getInsert(reviewVo);
		if(result == 1) {
			viewName = "redirect:/my_review.do?mid=hong";
		} else {
			
		}
		return viewName;
	}
	
	/*
	 * signout.do - ȸ��Ż����
	 */
	@RequestMapping(value = "/signout.do", method = RequestMethod.GET)
	public ModelAndView signout(String mid) {
		ModelAndView model = new ModelAndView();
		model.addObject("mid", mid);
		model.setViewName("/mypage/signout");
		return model;
	}
	
	/*
	 * member_delete_proc - ȸ��Ż�� ó��
	 */
	@RequestMapping(value = "/member_delete_proc.do", method = RequestMethod.POST ,produces="application/x-www-form-urlencoded;charset=UTF-8")
	public String member_delete_proc(String mid, String pass) {
		String viewName = "";
		//MemberDao memberDao = new MemberDao();
		int result = memberService.getDelete(mid, pass);
		if(result == 1) {
			viewName = "redirect:/login.do";
		} else {
			//���������� ȣ��
		}
		return viewName;
	}

}
