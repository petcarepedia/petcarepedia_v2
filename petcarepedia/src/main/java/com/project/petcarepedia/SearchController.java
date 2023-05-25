package com.project.petcarepedia;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.BookingDao;
import com.project.dao.HospitalDao;
import com.project.dao.ReviewDao;
import com.project.vo.BookingVo;
import com.project.vo.HospitalVo;
import com.project.vo.ReviewVo;


@Controller
public class SearchController {
	HospitalDao hospitalDao = new HospitalDao();
	BookingDao bookingDao = new BookingDao();
	
	
	/** search_main.do - 병원 리스트 출력하기 **/
	@RequestMapping(value="/search_main.do", method=RequestMethod.GET)
	public ModelAndView search_main() {
		ModelAndView model = new ModelAndView();
		
		ArrayList<HospitalVo> list = hospitalDao.select();
		ArrayList<BookingVo> time = bookingDao.selectTime();
		
		model.addObject("list", list);
		model.addObject("time", time);
		model.setViewName("/search/search_main");
		System.out.println(time.size());
		
		return model;
	}
	
/////////////////////
	
	/** search_result.do - 병원 상세정보 **/
	@RequestMapping(value="/search_result.do", method=RequestMethod.GET)
	public ModelAndView search_result(String hid) {
		ModelAndView model = new ModelAndView();
		ReviewDao reviewDao = new ReviewDao();
		HospitalVo hospital = hospitalDao.select(hid);
		BookingVo bookingVo = bookingDao.selectTime(hid);
		ArrayList<ReviewVo> RHList = reviewDao.RH_select(hid);
		
		
		model.addObject("hospital", hospital);
		model.addObject("RHList", RHList);
		model.addObject("time", bookingVo);
		
		model.setViewName("/search/search_result");
		
		
		return model;
		
	}
	
	
	/////////////////////
	
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
	
	
		
	
	
	
	
	/** search_map.do **/
	@RequestMapping(value="/search_map.do", method=RequestMethod.GET)
	public String search_map() {
		return "/search/search_map";
	}
	
	
	
} // class