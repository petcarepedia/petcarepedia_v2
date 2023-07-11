package com.project.petcarepedia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.service.BookingService;
import com.project.service.BookmarkService;
import com.project.service.FileServiceImpl;
import com.project.service.MemberService;
import com.project.service.PageServiceImpl;
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
	@Autowired
	private PageServiceImpl pageService;
	@Autowired
	private FileServiceImpl fileService;
	/*
	 * information.do - ���� ȸ������ ��
	 */
	@RequestMapping(value = "/mypage_member_information.do", method = RequestMethod.GET)
	public ModelAndView information(HttpSession session) {
		//HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		ModelAndView model = new ModelAndView();
		//MemberDao memberDao = new MemberDao();
		MemberVo memberVo = memberService.getSelect(svo.getMid());
		model.addObject("memberVo", memberVo);
		model.setViewName("/mypage/mypage_member_information");
		return model;
	}
	
	/*
	 * revise.do - ȸ������ �����ϱ� ��
	 */
	@RequestMapping(value = "/mypage_member_revise.do", method = RequestMethod.GET)
	public ModelAndView revise(HttpSession session) {
		//HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		ModelAndView model = new ModelAndView();
		//MemberDao memberDao = new MemberDao();
		MemberVo memberVo = memberService.getSelect(svo.getMid());
		model.addObject("memberVo", memberVo);
		model.setViewName("/mypage/mypage_member_revise");
		return model;
	}
	
	/*
	 * informatin_update_proc - ���� �����ϱ� ó��
	 */
	@RequestMapping(value = "/member_update_proc.do", method = RequestMethod.POST)
	public String member_update_proc(MemberVo memberVo, HttpServletRequest request) throws Exception{
		String viewName = "";
		String oldFileName = memberVo.getMsfile();
		//MemberDao memberDao = new MemberDao();
		int result = memberService.getUpdate(memberVo);
		if(result == 1) {
			if(memberVo.getMfile() != null && !memberVo.getMsfile().equals("")) {
				fileService.mfileSave(memberVo, request); // ���ο� ���� ����
				// �������� ����
				fileService.mfileDelete(memberVo, request, oldFileName);
			}
			viewName = "redirect:/mypage_member_information.do";
		} 
		else {
		//���������� ȣ��
		}
		return viewName;
	}
	
	/*
	 * reservation.do - ���೻��(������) ��
	 */
	@RequestMapping(value = "/mypage_reservation.do", method = RequestMethod.GET)
	public ModelAndView reservation(HttpSession session) {
		//HttpSession session = request.getSession();
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
	 * reservation.do - ���೻�� �����ϱ� ��
	 */
	@RequestMapping(value = "/mypage_reservation_delete.do", method = RequestMethod.GET)
	public ModelAndView reservation_delete(String bid, HttpSession session) {
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
	 * reservation_delete_proc.do - ���೻��(������)������ �����ϱ� ó��
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
	 * reservation2.do - ���೻��(����Ϸ�) ��
	 */
	@RequestMapping(value = "/mypage_reservation2.do", method = RequestMethod.GET)
	public ModelAndView reservation2(HttpSession session) {
		//HttpSession session = request.getSession();
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
	 * bookmark.do - ���ã�� ��
	 */
	@RequestMapping(value = "/mypage_bookmark.do", method = RequestMethod.GET)
	public ModelAndView bookmark(HttpSession session) {
		//HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		ModelAndView model = new ModelAndView();
		//BookmarkDao bookmarkDao = new BookmarkDao();
		ArrayList<BookmarkVo> list = bookmarkService.getSelect(svo.getMid());
		model.setViewName("/mypage/mypage_bookmark");
		model.addObject("list", list);
		return model;
	}
	
	
	/*
	 * bookmark_delete_proc.do - ���ã�� �����ϱ� ó��
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
	 * my_review.do - ���� �� ���� ��
	 */
	@RequestMapping(value = "/mypage_my_review.do", method = RequestMethod.GET)
	public ModelAndView my_review(String page, HttpSession session) {
		//HttpSession session = request.getSession();
		ModelAndView model = new ModelAndView();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		Map<String, Integer> param = new HashMap<String,Integer>();
		//ReviewDao reviewDao = new ReviewDao();
//		ArrayList<ReviewVo> list = reviewService.getMy_select(mid);
		ArrayList<ReviewVo> list = new ArrayList<ReviewVo>();
		param = pageService.getMyPageResult(page, svo.getMid());
		if (page == null) {
	        page = "1";
	    }
		list = pageService.getMyListPage(param.get("startCount"), param.get("endCount"), svo.getMid());
		
		if(svo.getMid()!=null && svo.getMid()!="") {
			param = pageService.getMyPageResult(page, svo.getMid());
			list = pageService.getMyListPage(param.get("startCount"), param.get("endCount"), svo.getMid());
		} else {
			param = pageService.getMyPageResult(page, "review");
			list = pageService.getMysListPage(param.get("startCount"), param.get("endCount"));
		}
		
		
		model.addObject("list", list);
		model.addObject("totals", param.get("dbCount"));
		model.addObject("pageSize",param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		model.addObject("mid", svo.getMid());
		model.setViewName("/mypage/mypage_my_review");
		return model;
	}
 	
	/*
	 * mypage_review_content.do - ���� �󼼺��� ������
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
	 * review_revise.do - ���� ���� ��
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
	 * review_update_proc.do - ���� �����ϱ� ó��
	 */
	@RequestMapping(value = "/review_update_proc.do", method = RequestMethod.POST)
	public String review_update_proc(ReviewVo reviewVo, HttpServletRequest request) throws Exception {
		String[] oldFileName = {reviewVo.getRsfile1(), reviewVo.getRsfile2() };	
		String viewName = "";
		
		//ReviewDao reviewDao = new ReviewDao();
		int result = reviewService.getUpdate(fileService.multiFileCheck(reviewVo));
		if(result == 1) {
			fileService.multiFileSave(reviewVo, request);
			fileService.multiFileDelete(reviewVo, request, oldFileName);
			viewName = "redirect:/mypage_review_content.do?rid=" + reviewVo.getRid();
		} else {
			//���������� ȣ��
		}
		return viewName;
	}
	/*
	 * review_delete.do - ���� �����ϱ� ��
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
	 * my_review_delete_proc.do.do - ���� �� ���� �����ϱ� ó��
	 */
	@RequestMapping(value = "/my_review_delete_proc.do", method = RequestMethod.POST)
	public String my_review_delete_proc(ReviewVo reviewVo, HttpServletRequest request) throws Exception {
		String viewName = "";
		//ReviewDao reviewDao = new ReviewDao();
		int result = reviewService.getDelete(reviewVo.getRid());
		String[] oldFileName = {reviewVo.getRsfile1(),reviewVo.getRsfile2()};
		if(result == 1) {
			fileService.multiFileDelete(request, oldFileName);
			viewName = "redirect:/mypage_my_review.do";
		}
		return viewName;
	}
	
	
	
	
	/*
	 * review_write.do - ���� ������
	 */
	@RequestMapping(value = "/mypage_review_write.do", method = RequestMethod.GET)
	public ModelAndView review_write(HttpSession session, String hid, String bid) {
		//HttpSession session = request.getSession();
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
	 *  review_write_proc.do - ���� ����ó��
	 */
	@RequestMapping(value = "/review_write_proc.do", method = RequestMethod.POST)
	public String review_write_proc(ReviewVo reviewVo, HttpServletRequest request) throws Exception {
		String viewName = "";
		//ReviewDao reviewDao = new ReviewDao();
		int result = reviewService.getInsert(fileService.multiFileCheck(reviewVo));
		if(result == 1) {
			if(!reviewVo.getFiles()[0].getOriginalFilename().equals("")) {
				fileService.multiFileSave(reviewVo, request);
			}
			viewName = "redirect:/mypage_my_review.do";
		} else {
			
		}
		return viewName;
	}
	
	/*
	 * signout.do - ȸ��Ż����
	 */
	@RequestMapping(value = "/mypage_signout.do", method = RequestMethod.GET)
	public ModelAndView signout(HttpSession session) {
		//HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		ModelAndView model = new ModelAndView();
		model.addObject("mid", svo.getMid());
		model.setViewName("/mypage/mypage_signout");
		return model;
	}
	
	/*
	 * member_delete_proc - ȸ��Ż�� ó��
	 */
	@RequestMapping(value = "/member_delete_proc.do", method = RequestMethod.POST ,produces="application/x-www-form-urlencoded;charset=UTF-8")
	public String member_delete_proc(HttpSession session, String pass) {
		String viewName = "";
		//HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		//MemberDao memberDao = new MemberDao();
		int result = memberService.getDelete(svo.getMid(), pass);
		if(result == 1) {
			session.invalidate();
			viewName = "redirect:/login.do";
		} else {
			viewName = "redirect:/mypage_member_information.do";
		}
		return viewName;
	}
	
	/*
	 * pass_check.do - �н����� üũ
	 */
	@RequestMapping(value = "/pass_check.do", method = RequestMethod.GET, produces="application/x-www-form-urlencoded;charset=UTF-8") 
	@ResponseBody
	public String pass_check(String mid, String pass){
		int result = memberService.getCheckPass(mid,pass);
		return String.valueOf(result);
	}
}
