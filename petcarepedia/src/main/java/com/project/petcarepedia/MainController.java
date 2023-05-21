package com.project.petcarepedia;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.MemberDao;
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
	public ModelAndView best_review_list(int start, int end) {
		ModelAndView model = new ModelAndView();
		
		MemberDao memberDao = new MemberDao();
		ArrayList<ReviewVo> list = memberDao.selectBR();
		
		model.addObject("list", list);
		model.addObject("start", start);
		model.addObject("end", end);
		model.setViewName("best_review_list");
		
		return model;
	}
}
