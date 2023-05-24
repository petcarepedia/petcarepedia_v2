package com.project.petcarepedia;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.HospitalDao;
import com.project.dao.ReviewDao;
import com.project.vo.HospitalVo;
import com.project.vo.ReviewVo;


@Controller
public class SearchController {
	HospitalDao hospitalDao = new HospitalDao();
	
	
	/** search_main.do - ���� ����Ʈ ����ϱ� **/
	@RequestMapping(value="/search_main.do", method=RequestMethod.GET)
	public ModelAndView search_main() {
		ModelAndView model = new ModelAndView();
		ArrayList<HospitalVo> list = hospitalDao.select();
		
		model.addObject("list", list);
		model.setViewName("/search/search_main");
		System.out.println(list.size());
		
		return model;
	}
	
/////////////////////
	
	/** search_result.do - ���� ������ **/
	@RequestMapping(value="/search_result.do", method=RequestMethod.GET)
	public ModelAndView search_result(String hid) {
		ModelAndView model = new ModelAndView();
		HospitalVo hospital = hospitalDao.select(hid);
		
		model.addObject("hospital", hospital);
		
		ReviewDao reviewDao = new ReviewDao();
		ArrayList<ReviewVo> RHList = reviewDao.RH_select(hid);
		model.addObject("RHList", RHList);
		
		model.setViewName("/search/search_result");
		
		
		return model;
		
	}
	
	
	/////////////////////
	
	/** search_reservation.do **/
	
	 @RequestMapping(value="/search_reservation.do", method=RequestMethod.GET)
	 public String search_reservation() { 
		 return "/search/search_reservation"; 
		 }
	 
	
	/** search_reservation.do?hid=? **/
	@RequestMapping(value="/search_reservation.do", method=RequestMethod.GET)
	public ModelAndView search_reservation(String hid) {
		ModelAndView model = new ModelAndView();
		HospitalVo hospitalVo = hospitalDao.select(hid);
		System.out.println(hospitalVo.getHid());
		
		model.addObject("hospital", hospitalVo);
		model.setViewName("/search/search_reservation");
		return model;
	}
	
	
		
	
	
	
	
	/** search_map.do **/
	@RequestMapping(value="/search_map.do", method=RequestMethod.GET)
	public String search_map() {
		return "/search/search_map";
	}
	
	
	
} // class