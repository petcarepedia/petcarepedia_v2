package com.project.petcarepedia;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.BookingDao;
import com.project.dao.BookmarkDao;
import com.project.dao.HospitalDao;
import com.project.dao.ReviewDao;
import com.project.vo.BookingVo;
import com.project.vo.BookmarkVo;
import com.project.vo.HospitalVo;
import com.project.vo.ReviewLikeVo;
import com.project.vo.ReviewVo;


@Controller
public class SearchController {
	HospitalDao hospitalDao = new HospitalDao();
	BookingDao bookingDao = new BookingDao();
	
	
	/** search_main.do - ���� ����Ʈ ����ϱ� **/
	@RequestMapping(value="/search_main.do", method=RequestMethod.GET)
	public ModelAndView search_main() {
		ModelAndView model = new ModelAndView();
		
		ArrayList<HospitalVo> list = hospitalDao.select();
		
		model.addObject("list", list);
		model.setViewName("/search/search_main");
		
		return model;
	}
	
	
	/** searchAreaProc.do - ���� ����Ʈ ����ϱ� **/
	@RequestMapping(value="/searchAreaProc.do", method=RequestMethod.GET)
	public ModelAndView searchAreaProc(String gloc) {
		ModelAndView model = new ModelAndView();
		
		ArrayList<HospitalVo> list = hospitalDao.searchGloc(gloc);
		
		model.addObject("list", list);
		model.setViewName("/search/search_main");
		
		return model;
	}
	
	
	/** search_result.do - ���� ������ **/
	@RequestMapping(value="/search_result.do", method=RequestMethod.GET)
	public ModelAndView search_result(String hid) {
		ModelAndView model = new ModelAndView();
		ReviewDao reviewDao = new ReviewDao();
		HospitalVo hospital = hospitalDao.select(hid);
		HospitalVo star = hospitalDao.selectStar(hid);
		BookingVo bookingVo = bookingDao.selectTime(hid);
		ArrayList<ReviewVo> RM_select = reviewDao.RM_select(hid);
		
		
		model.addObject("hospital", hospital);
		model.addObject("star", star);
		model.addObject("time", bookingVo);
		model.addObject("RM_select", RM_select);
		/* System.out.println(RM_select.size()); */
		
		model.setViewName("/search/search_result");
		
		
		return model;
		
	}
	
	
	/** search_reservation.do **/
	/*
	 * @RequestMapping(value="/search_reservation.do", method=RequestMethod.GET)
	 * public String search_reservation() { return "/search/search_reservation"; }
	 */
	 
	
	/** search_reservation.do?hid=? **/
	@RequestMapping(value="/search_reservation.do", method=RequestMethod.GET)
	public ModelAndView search_reservation(String hid) {
		ModelAndView model = new ModelAndView();
		
		HospitalVo hospitalVo = hospitalDao.select(hid);
		BookingVo bookingVo = bookingDao.selectTime(hid);

		model.addObject("hospital", hospitalVo);
		model.addObject("time", bookingVo);
		
		model.setViewName("/search/search_reservation");
		return model;
	}
	
	
	/** reservationProc.do - ���� ó�� **/
	@RequestMapping(value="reservationProc.do", method=RequestMethod.POST)
	public String reservationProc(BookingVo bookingVo) {
		String viewName = "";
		int result = bookingDao.insert(bookingVo);
		
		if(result == 1) {
			viewName = "redirect:/reservation.do";
		} else {
			// ���� - ���������� ȣ��
			System.out.println("error");
		}
		
		return viewName;
		
	}	
	
	
	/** bookProc.do.do - ���ϱ� ó�� **/
	@RequestMapping(value="bookmarkProc.do", method=RequestMethod.GET)
	public String bookmarkProc(BookmarkVo bookmarkVo, @RequestParam("hid") String hid) {
	    BookmarkDao bookmarkDao = new BookmarkDao();
	    int result = bookmarkDao.insert(bookmarkVo);
	    
	    if(result == 1) {
	        return "redirect:/search_result.do?hid=" + hid;
	    } else {
	        // ���� - ���и� ��Ÿ���� ���ڿ� ��ȯ
	        return "failure";
	    }
	}
	
	
	/** likeProc.do - ���ƿ� ó�� **/
	@RequestMapping(value="likeProc.do", method=RequestMethod.GET)
	public String likeProc(ReviewLikeVo reviewLikeVo, @RequestParam("hid") String hid) {
	    ReviewDao reviewDao = new ReviewDao();
	    int result = reviewDao.LikesUp2(reviewLikeVo);
		/* System.out.println(result); */

	    if (result == 1) {
	        return "redirect:/search_result.do?hid=" + hid;
	    } else {
	        // ���� - ���и� ��Ÿ���� ���ڿ� ��ȯ
	        return "failure";
	    }
	}
	
	
	/** stateProc.do - �Ű��ϱ� ó�� **/
	@RequestMapping(value="rstateProc.do", method=RequestMethod.POST)
	public String rstateProc(String rid, @RequestParam("hid") String hid) {
		ReviewDao reviewDao = new ReviewDao();
	    int result = reviewDao.update(rid);
		/* System.out.println(result); */

	    if (result == 1) {
			return "redirect:/search_result.do?hid=" + hid;
		} else {
			return "failure";
		}
	}
		
	    
	
		
		
	
	
	
	
		
	
	
	
	
	/** search_map.do **/
	@RequestMapping(value="/search_map.do", method=RequestMethod.GET)
	public String search_map() {
		return "/search/search_map";
	}
	
	
	
} // class