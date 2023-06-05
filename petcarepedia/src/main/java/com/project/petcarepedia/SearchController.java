package com.project.petcarepedia;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.project.dao.BookingDao;
import com.project.dao.BookmarkDao;
import com.project.dao.HospitalDao;
import com.project.dao.ReviewDao;
import com.project.dao.ReviewLikeDao;
import com.project.service.BookingService;
import com.project.service.BookmarkService;
import com.project.service.HospitalService;
import com.project.service.ReviewLikeService;
import com.project.service.ReviewService;
import com.project.vo.BookingVo;
import com.project.vo.BookmarkVo;
import com.project.vo.HospitalVo;
import com.project.vo.ReviewLikeVo;
import com.project.vo.ReviewVo;


@Controller
public class SearchController {
	
	@Autowired
	private BookingService bookingService;
	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private ReviewService reviewSerivce;
	@Autowired
	private ReviewLikeService reviewLikeService;
	@Autowired
	private BookmarkService bookmarkService;
	
	HospitalDao hospitalDao = new HospitalDao();
	BookingDao bookingDao = new BookingDao();
	
	
	/** search_main.do - 병원 리스트 출력하기 **/
	@RequestMapping(value="/search_main.do", method=RequestMethod.GET)
	public ModelAndView search_main() {
		ModelAndView model = new ModelAndView();
		
		ArrayList<HospitalVo> list = hospitalService.select();
		
		model.addObject("list", list);
		model.setViewName("/search/search_main");
		
		return model;
	}
	
	
	/** searchAreaProc.do - 지역구 병원 리스트 출력하기 **/
	@RequestMapping(value="/searchAreaProc.do", method=RequestMethod.GET)
	public ModelAndView searchAreaProc(String gloc) {
		ModelAndView model = new ModelAndView();
		
		ArrayList<HospitalVo> list = hospitalService.searchGloc(gloc);
		
		model.addObject("list", list);
		model.setViewName("/search/search_main");
		
		return model;
	}
	
	
	/** search_result.do - 병원 상세정보 **/
	@RequestMapping(value="/search_result.do", method=RequestMethod.GET)
	public ModelAndView search_result(String hid) {
		ModelAndView model = new ModelAndView();
		ReviewDao reviewDao = new ReviewDao();
		BookmarkDao bookmarkDao = new BookmarkDao();
		HospitalVo hospital = hospitalService.select(hid);
		HospitalVo star = hospitalService.selectStar(hid);
		BookingVo bookingVo = bookingService.getSelectTime(hid);
		ArrayList<ReviewVo> RM_select = reviewSerivce.getRM_select(hid);
		
		model.addObject("hospital", hospital);
		model.addObject("star", star);
		model.addObject("time", bookingVo);
		model.addObject("RM_select", RM_select);
		/* System.out.println(RM_select.size()); */
		
		// Check bookmark
	    BookmarkVo bookmarkVo = new BookmarkVo();
	    bookmarkVo.setHid(hid);
	    bookmarkVo.setMid("hong"); // 이 부분을 세션 정보 또는 다른 값을 가져와 설정해야합니다.
	    int bookmarkResult = bookmarkDao.checkBookmark(bookmarkVo);
	    model.addObject("bookmarkResult", bookmarkResult);
	    
	    model.setViewName("/search/search_result");
		
		return model;
	}
	
	
	/** search_result_map.do - 병원 상세 지도 정보 **/
	@RequestMapping(value="/search_result_map.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String search_result_map(String hid) {
		 HospitalVo list = hospitalService.select(hid);

	    JsonObject jobj = new JsonObject();
	    jobj.addProperty("hid", list.getHid());
	    jobj.addProperty("hname", list.getHname());
	    jobj.addProperty("x", list.getX());
	    jobj.addProperty("y", list.getY());

	    return new Gson().toJson(jobj);
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
		
		HospitalVo hospitalVo = hospitalService.select(hid);
		BookingVo bookingVo = bookingService.getSelectTime(hid);

		model.addObject("hospital", hospitalVo);
		model.addObject("time", bookingVo);
		
		model.setViewName("/search/search_reservation");
		return model;
	}
	
	
	/** reservationProc.do - 예약 처리 **/
	@RequestMapping(value="reservationProc.do", method=RequestMethod.POST)
	public String reservationProc(BookingVo bookingVo) {
		String viewName = "";
		int result = bookingService.getInsert(bookingVo);
		
		if(result == 1) {
			viewName = "redirect:/reservation.do?mid=hong";
		} else {
			// 실패 - 에러페이지 호출
			System.out.println("error");
		}
		
		return viewName;
	}	
	

	/** reviewCheckProc.do - 리뷰쓰기 처리 **/
	@RequestMapping(value="reviewCheckProc.do", method=RequestMethod.POST)
	@ResponseBody
	public String reviewCheckProc(String hid, String mid) {
		int review_result = bookingService.getReviewCheck(hid, mid);
		/* System.out.println(review_result); */
		
		if(review_result == 1) {
			return "success";
		} else {
			return "fail";
		}
	}	
	
	
	/** bookmarkProc.do - 북마크 처리 **/
	@RequestMapping(value = "bookmarkProc.do", method = RequestMethod.POST)
	@ResponseBody
	public String bookmarkProc(BookmarkVo bookmarkVo, @RequestParam("hid") String hid) {
	    BookmarkDao bookmarkDao = new BookmarkDao();
	    int result = bookmarkDao.checkBookmark(bookmarkVo);

	    if (result == 0) {
	        bookmarkDao.insert(bookmarkVo);
	        return "success";
	    } else if (result == 1) {
	        bookmarkDao.deleteBookmark(bookmarkVo);
	        return "fail";
	    }

	    return "";
	}
	
	/** bookmarkProc.do - 북마크 처리 **/
//	@RequestMapping(value="bookmarkProc.do", method=RequestMethod.POST)
//	public ModelAndView bookmarkProc(BookmarkVo bookmarkVo, @RequestParam("hid") String hid) {
//		ModelAndView model = new ModelAndView();
//		BookmarkDao bookmarkDao = new BookmarkDao();
//		String viewName = "";
//		int result = bookmarkDao.checkBookmark(bookmarkVo);
//		System.out.println("result가져옴"+result);
//		
//		if(result == 0) {
//			bookmarkDao.insert(bookmarkVo);
//			model.addObject("bookmark_result", "success");
//			model.setViewName("redirect:/search_result.do?hid=" + hid);
//			System.out.println("성공");
//		} else if(result == 1) {
//			bookmarkDao.deleteBookmark(bookmarkVo);
//			model.addObject("bookmark_result", "fail");
//			model.setViewName("redirect:/search_result.do?hid=" + hid);
//			System.out.println("실패");
//		}
//		return model;
//	}
	
	
//	/** rstateForm.do - 신고하기 처리 **/
//	@RequestMapping(value="rstateForm.do", method=RequestMethod.POST)
//	@ResponseBody
//	public String rstateForm(String rid) {
//	    ReviewDao reviewDao = new ReviewDao();
//	    int rstate_result = reviewDao.getIdCheckResult(rid);
//
//	    if (rstate_result == 0) {
//	        reviewDao.update(rid);
////	        System.out.println(rstate_result);
////	        System.out.println(rid);
//	        return "success";
//	    } else if (rstate_result == 1) {
////	    	System.out.println(rstate_result);
////	    	System.out.println(rid);
//	        return "fail";
//	    }
//
//	    return "";
//	}
	

	/** likeProc.do - 좋아요 처리 **/
	@RequestMapping(value="likeProc.do", method=RequestMethod.POST)
	@ResponseBody
	public String likeProc(ReviewLikeVo reviewLikeVo, @RequestParam("hid") String hid) {
	    ReviewLikeDao reviewLikeDao = new ReviewLikeDao();
	    int like_result = reviewLikeService.getIdCheck(reviewLikeVo);

        if (like_result == 0) { // 기록 없음
        	reviewLikeService.getLikesUpID(reviewLikeVo);
        	reviewLikeService.getLikesUp(reviewLikeVo);
            return "success";
        } else { // 기록 있음
        	reviewLikeService.getLikesDownID(reviewLikeVo);
        	reviewLikeService.getLikesDown(reviewLikeVo);
            System.out.println(like_result);
            return "fail";
        }
    }
	
	
	/** rstateForm.do - 신고하기 처리 **/
	@RequestMapping(value="rstateProc.do", method=RequestMethod.POST)
	@ResponseBody
	public String rstateProc(String rid, @RequestParam("hid") String hid) {
		ReviewDao reviewDao = new ReviewDao();
	    int rstate_result = reviewDao.getIdCheckResult(rid);

	    if (rstate_result == 0) {
	    	reviewDao.update(rid);
	    	System.out.println(rstate_result);
	    	return "success";
		} else if (rstate_result == 1) {
			System.out.println(rstate_result);
			return "fail";
		}
	    
	    return "";
	}
	
	
	/** search_map.do **/
	@RequestMapping(value="/search_map.do", method=RequestMethod.GET)
	public String search_map() {
		return "/search/search_map";
	}
	
	
	/** search_mian_map.do **/
	@RequestMapping(value="/search_main_map.do", method=RequestMethod.GET)
	public String search_main_map() {
		return "/search/search_main_map";
	}
	
	
	/** map_data.do **/
	@RequestMapping(value="/map_data.do",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String map_data(String gloc) {
		ArrayList<HospitalVo> list = hospitalService.searchGloc(gloc);
		
		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();
		
		for(HospitalVo hospitalVo : list) {
			JsonObject jobj = new JsonObject(); //{}
			jobj.addProperty("hid", hospitalVo.getHid());
			jobj.addProperty("hname", hospitalVo.getHname());
			jobj.addProperty("gloc", hospitalVo.getGloc());
			jobj.addProperty("loc", hospitalVo.getLoc());
			jobj.addProperty("tel", hospitalVo.getTel());
			jobj.addProperty("htime", hospitalVo.getHtime());
			jobj.addProperty("ntime", hospitalVo.getNtime());
			jobj.addProperty("holiday", hospitalVo.getHoliday());
			jobj.addProperty("animal", hospitalVo.getAnimal());
			jobj.addProperty("x", hospitalVo.getX());
			jobj.addProperty("y", hospitalVo.getY());
			
			jarray.add(jobj);
		}
		
		jlist.add("jlist", jarray);
		
		return new Gson().toJson(jlist);
	}
		
	
} // class