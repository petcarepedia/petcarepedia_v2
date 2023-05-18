package com.project.petcarepedia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReviewController {
	
	//review_main.do 리뷰 메인 페이지
	@RequestMapping(value="/review_main.do", method=RequestMethod.GET)
	public String review_main() {
		return"/review/review_main";
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
