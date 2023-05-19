package com.project.petcarepedia;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.ReviewDao;
import com.project.vo.ReviewVo;

@Controller
public class ReviewController {
	
	//review_main.do 리뷰 메인 페이지
	@RequestMapping(value="/review_main.do", method=RequestMethod.GET)
	public ModelAndView review_main() {
		ModelAndView model = new ModelAndView();
		ReviewDao reviewDao = new ReviewDao();
		ArrayList<ReviewVo> list = reviewDao.select();
		
		model.addObject("list", list);
		model.setViewName("/review/review_main");
		
		return model;
	}
	
	//review_content.do 리뷰 메인 페이지
	@RequestMapping(value="/review_content.do", method=RequestMethod.GET)
	public String review_content() {
		return"/review/review_content";
	}
	
	//review_delete.do 리뷰 메인 페이지
	@RequestMapping(value="/review_delete.do", method=RequestMethod.GET)
	public String review_delete() {
		return"/review/review_delete";
	}
}
