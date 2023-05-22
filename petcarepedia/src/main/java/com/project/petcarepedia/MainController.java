package com.project.petcarepedia;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.ReviewDao;
import com.project.vo.ReviewVo;

@Controller
public class MainController {
	/**
	 * index.do
	 */
	@RequestMapping(value="/index.do",method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	/**
	 * header.do
	 */
	@RequestMapping(value="/header.do",method=RequestMethod.GET)
	public String header() {
		return "header";
	}
	
	/**
	 * footer.do
	 */
	@RequestMapping(value="/footer.do",method=RequestMethod.GET)
	public String footer() {
		return "footer";
	}
	
	/**
	 * best_review_list.do
	 */
	@RequestMapping(value="/best_review_list.do",method=RequestMethod.GET)
	public ModelAndView best_review_list(String page) {
		ModelAndView model = new ModelAndView();
		ReviewDao reviewDao = new ReviewDao();
		
		//페이징 처리 - startCount, endCount 구하기
		int startCount = 0;
		int endCount = 0;
		int pageSize = 3;	//한페이지당 게시물 수
		int reqPage = 1;	//요청페이지	
		int pageCount = 1;	//전체 페이지 수
		int dbCount = 9;	//전체 행수
		
		//요청 페이지 계산
		if(page != null){
			reqPage = Integer.parseInt(page);
			startCount = (reqPage-1) * pageSize+1; 
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = pageSize;
		}
				
		ArrayList<ReviewVo> list = reviewDao.select(startCount, endCount);
		
		model.addObject("list", list);
		model.addObject("totals", dbCount);
		model.addObject("pageSize", pageSize);
		model.addObject("maxSize", pageCount);
		model.addObject("page", reqPage);
		
		model.setViewName("best_review_list");
		
		return model;
	}
}
