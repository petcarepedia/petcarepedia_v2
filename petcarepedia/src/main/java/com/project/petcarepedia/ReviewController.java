package com.project.petcarepedia;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.MemberDao;
import com.project.dao.ReviewDao;
import com.project.vo.MemberVo;
import com.project.vo.ReviewLikeVo;
import com.project.vo.ReviewVo;

@Controller
public class ReviewController {
	
	//review_main.do 리뷰 리스트 페이징

	@RequestMapping(value="/review_main.do", method=RequestMethod.GET)
	public ModelAndView review_main(String page, String mid) {
		int count = 0;
		ModelAndView model = new ModelAndView();		
		ReviewDao reviewDao = new ReviewDao();
		//페이징 처리 - startCount, endCount 구하기
		int startCount = 0;
		int endCount = 0;
		int pageSize = 7;	//한페이지당 게시물 수
		int reqPage = 1;	//요청페이지	
		int pageCount = 7;	//전체 페이지 수
		int dbCount = reviewDao.totalRowCount();	//DB에서 가져온 전체 행수
		
		//임시 아이디
		mid = "hong";
		
		
		//총 페이지 수 계산
		/*
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}
		*/
		//요청 페이지 계산
		if(page != null){
			reqPage = Integer.parseInt(page);
			startCount = (reqPage-1) * pageSize+1; 
			endCount = reqPage *pageSize;
			count++;
		}else{
			startCount = 1;
			endCount = 7;
		}
		
		ArrayList<ReviewVo> list = reviewDao.selectList(startCount, endCount);
		
		model.addObject("mid", mid);
		model.addObject("count", count);
		model.addObject("list", list);
		model.addObject("totals", dbCount);
		model.addObject("pageSize", pageSize);
		model.addObject("maxSize", pageCount);
		model.addObject("page", reqPage);
		
		model.setViewName("/review/review_main");
		
		return model;
	} 
	
	
	
	
	
	
	//review_content.do 리뷰 상세 페이지
	@RequestMapping(value="/review_content.do", method=RequestMethod.GET)
	public ModelAndView review_content(String rid, String page, String mid, String filter_location)  {
		ModelAndView model = new ModelAndView();
		ReviewDao reviewDao = new ReviewDao();
		ReviewLikeVo reviewLikeVo = new ReviewLikeVo();
		
		ReviewVo reviewVo = reviewDao.enter_select(rid);		
		reviewLikeVo.setRid(reviewVo.getRid());
		reviewLikeVo.setMid(mid);
		
		int likeCheck = reviewDao.idCheck(reviewLikeVo);
		
		model.addObject("mid", mid);
		model.addObject("page", page);
		model.addObject("filter_location", filter_location);
		model.addObject("likeCheck", likeCheck);
		model.addObject("reviewLikeVo", reviewLikeVo);
		model.addObject("reviewVo", reviewVo);
		model.setViewName("/review/review_content");
		
		return model;
	}
	
	
	
	//review_delete.do 리뷰 삭제 페이지
	@RequestMapping(value="/review_delete.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_delete(String rid) {
		ModelAndView model = new ModelAndView();
		model.addObject("rid", rid);
		model.setViewName("/review/review_delete");
		
		return model;
	}
	
	
	//review_delete_proc.do 리뷰 삭제 처리
	@RequestMapping(value="/review_delete_proc.do", method=RequestMethod.POST)
	public ModelAndView review_delete_proc(String rid) {
		ModelAndView model = new ModelAndView();
		ReviewDao reviewDao = new ReviewDao();
		int result = reviewDao.delete(rid);
		if(result == 1) {
			//내가 쓴 리뷰로 돌아감 (임시)
			model.setViewName("redirect:/review_main.do");
		}
		
		return model;
	}
	
	
	//review_report.do 리뷰 신고 페이지
	@RequestMapping(value="/review_report.do", method=RequestMethod.GET)
	public ModelAndView review_report(String rid) {
		ModelAndView model = new ModelAndView();
		model.addObject("rid", rid);
		model.setViewName("/review/review_report");
		
		return model;
	}
	
	
	//review_report_proc.do 리뷰 신고 처리
	@RequestMapping(value="/review_report_proc.do", method=RequestMethod.POST)
	public ModelAndView review_report_proc(String rid) {
		ModelAndView model = new ModelAndView();
		ReviewDao reviewDao = new ReviewDao();
		int result = reviewDao.update(rid);
		if(result == 1) {
			//내가 쓴 리뷰로 돌아감 (임시)
			model.setViewName("redirect:/review_main.do");
		}
		
		return model;
	}
	
	//리뷰 좋아요 처리
	@RequestMapping(value="/review_like_Proc.do", method=RequestMethod.POST)
	public ModelAndView review_like_Proc(ReviewLikeVo reviewLikeVo, String mid, String page, String filter_location) {
		ModelAndView model = new ModelAndView();
		ReviewDao reviewDao = new ReviewDao();
		reviewLikeVo.setMid(mid);
		
		if(reviewDao.idCheck(reviewLikeVo) == 1) {
			reviewDao.LikesDownID(reviewLikeVo);
			reviewDao.LikesDown(reviewLikeVo);
		}
		else {
			reviewDao.LikesUpID(reviewLikeVo);
			reviewDao.LikesUp(reviewLikeVo);
		}
		if(filter_location != "") {
			model.addObject("filter_location", filter_location);
		}
		if(page != "") {
			model.addObject("page", page);
		}
		model.addObject("mid", mid);
		model.setViewName("redirect:/review_content.do?rid="+reviewLikeVo.getRid());
		
		return model;
	}	
	
	
	@RequestMapping(value="/review_main_search.do", method=RequestMethod.GET)
	public ModelAndView review_search_Proc(String page, String filter_location) {
		ModelAndView model = new ModelAndView();
		ReviewDao reviewDao = new ReviewDao();
		
		//페이징 처리 - startCount, endCount 구하기
		int startCount = 0;
		int endCount = 0;
		int pageSize = 7;	//한페이지당 게시물 수
		int reqPage = 1;	//요청페이지	
		int pageCount = 7;	//전체 페이지 수
		int dbCount = reviewDao.SearchRowCount(filter_location);	//DB에서 가져온 전체 행수
		
		//총 페이지 수 계산
		/*
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize;
		}
		*/
		//요청 페이지 계산
		if(page != null){
			reqPage = Integer.parseInt(page);
			startCount = (reqPage-1) * pageSize+1; 
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = 7;
		}
		
		ArrayList<ReviewVo> list = reviewDao.selectSearchList(startCount, endCount, filter_location);

		model.addObject("filter_location", filter_location);
		model.addObject("list", list);
		model.addObject("totals", dbCount);
		model.addObject("pageSize", pageSize);
		model.addObject("maxSize", pageCount);
		model.addObject("page", reqPage);
		
		model.setViewName("/review/review_main_search");
		
		
		return model;
	}	
	
	
	


	
	
	
}
