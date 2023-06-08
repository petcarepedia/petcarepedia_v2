package com.project.petcarepedia;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

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
import com.project.dao.HospitalDao;
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
import com.project.vo.SessionVo;


@Controller
public class SearchController {
	
	@Autowired
	private BookingService bookingService;
	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private ReviewService reviewService;
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
	public ModelAndView search_result(String hid, HttpSession session, String rid) {
	    ModelAndView model = new ModelAndView();
	    
	    // session
	    SessionVo svo = (SessionVo)session.getAttribute("svo");
	    String mid;
	    if(svo == null) {
	    	mid = ""; 
	    } else {
	    	mid = svo.getMid();
	    }
	    
	    HospitalVo hospital = hospitalService.select(hid);
	    HospitalVo star = hospitalService.selectStar(hid);
	    BookingVo bookingVo = bookingService.getSelectTime(hid);
	    ArrayList<ReviewVo> RM_select = reviewService.getRM_select(hid);
	    
	    model.addObject("hospital", hospital);
	    model.addObject("star", star);
	    model.addObject("time", bookingVo);
	    model.addObject("RM_select", RM_select);
	    
	    // Check bookmark
	    BookmarkVo bookmarkVo = new BookmarkVo();
	    bookmarkVo.setHid(hid);
	    bookmarkVo.setMid(mid); // 이 부분을 세션 정보 또는 다른 값을 가져와 설정해야합니다.
	    int bookmarkResult = bookmarkService.getCheckBookmark(bookmarkVo);
	    model.addObject("bookmarkResult", bookmarkResult);
	    
	    // Check like
	    ReviewLikeVo reviewLikeVo = new ReviewLikeVo();
	    reviewLikeVo.setMid(mid);
	    String targetRid = null;
	    
	    for (ReviewVo review : RM_select) {
	        targetRid = review.getRid();
	        break;
	    }
	    if (targetRid != null) {
	        reviewLikeVo.setRid(targetRid);
	        int likeResult = reviewLikeService.getIdCheck(reviewLikeVo);
	        model.addObject("likeResult", likeResult);
	    }
	    
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
	@ResponseBody
	public String reservationProc(BookingVo bookingVo) {
		int check_result = bookingService.getCheckBooking(bookingVo);
		System.out.println(check_result);
			
		if(check_result == 0) {
			bookingService.getInsert(bookingVo);
			return "success";
		} else {
			return "fail"; // 중복있음
		}
	}
	

	/** reviewCheckProc.do - 리뷰쓰기 처리 **/
	@RequestMapping(value="reviewCheckProc.do", method=RequestMethod.POST)
	@ResponseBody
	public String reviewCheckProc(String hid, String mid) {
		String result = "";
		if(hid != "" && mid != "") {
			result = "success";
			} else {
				result = "fail";
		}
		return result;
	}	
	
	
	/** bookmarkProc.do - 북마크 처리 **/
	@RequestMapping(value = "bookmarkProc.do", method = RequestMethod.POST)
	@ResponseBody
	public String bookmarkProc(BookmarkVo bookmarkVo, @RequestParam("hid") String hid) {
	    int result = bookmarkService.getCheckBookmark(bookmarkVo);

	    if (result == 0) {
	        bookmarkService.getInsert(bookmarkVo);
	        return "success";
	    } else if (result == 1) {
	    	bookmarkService.getDeleteBookmark(bookmarkVo);
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
	    int like_result = reviewLikeService.getIdCheck(reviewLikeVo);

        if (like_result == 0) { // 기록 없음
        	reviewLikeService.getLikesUpID(reviewLikeVo);
        	reviewLikeService.getLikesUp(reviewLikeVo);
            return "success";
        } else { // 기록 있음
        	reviewLikeService.getLikesDownID(reviewLikeVo);
        	reviewLikeService.getLikesDown(reviewLikeVo);
			/* System.out.println(like_result); */
            return "fail";
        }
    }
	
	
	/** rstateForm.do - 신고하기 처리 **/
	@RequestMapping(value="rstateProc.do", method=RequestMethod.POST)
	@ResponseBody
	public String rstateProc(String rid, @RequestParam("hid") String hid) {
	    int rstate_result = reviewService.reviewCheckResult(rid);

	    if (rstate_result == 0) {
	    	reviewService.getUpdateReport(rid);
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
	
	
	/** search_main_map.do **/
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