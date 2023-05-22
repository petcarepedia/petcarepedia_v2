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
	
	/** search_main.do - 병원 리스트 출력하기 **/
	@RequestMapping(value="/search_main.do", method=RequestMethod.GET)
	public ModelAndView search_main() {
		ModelAndView model = new ModelAndView();
		HospitalDao hospitalDao = new HospitalDao();
		ArrayList<HospitalVo> list = hospitalDao.select();
		
		model.addObject("list", list);
		model.setViewName("/search/search_main");
		System.out.println(list.size());
		
		return model;
	}
	
/////////////////////
	
	/** search_result.do - 병원 상세정보 수정예쩡 **/
	@RequestMapping(value="/search_result.do", method=RequestMethod.GET)
	public ModelAndView search_result(String hid) {
		ModelAndView model = new ModelAndView();
		
		HospitalDao hospitalDao = new HospitalDao();
		HospitalVo hospitalVo = new HospitalVo();
		
		int result = hospitalDao.select(hid);
		if(result == 1) {
			model.addObject("hospital", hospitalVo);
			System.out.println("hospital");
		}  else {
			System.out.println("오류");
		}
	
		
		ReviewDao reviewDao = new ReviewDao();
		ArrayList<ReviewVo> RHList = reviewDao.RH_select(hid);
		
		model.addObject("list", RHList);
		
		model.setViewName("/search/search_result");
		
		
		return model;
	}
	
	/////////////////////
	
	/** search_reservation.do **/
	@RequestMapping(value="/search_reservation.do", method=RequestMethod.GET)
	public String search_reservation() {
		return "/search/search_reservation";
	}
	
	
	/** search_map.do **/
	@RequestMapping(value="/search_map.do", method=RequestMethod.GET)
	public String search_map() {
		return "/search/search_map";
	}
	
	
	
} // class