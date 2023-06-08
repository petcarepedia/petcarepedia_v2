package com.project.petcarepedia;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.service.PageServiceImpl;
import com.project.service.ReviewLikeService;
import com.project.service.ReviewService;
import com.project.vo.ReviewLikeVo;
import com.project.vo.ReviewVo;
import com.project.vo.SessionVo;

@Controller
public class ReviewController {
	
	
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ReviewLikeService reviewLikeService;
	@Autowired
	private PageServiceImpl pageService;
	
	//review_main.do ���� ����Ʈ ����¡
	@RequestMapping(value="/review_main.do", method=RequestMethod.GET)
	public ModelAndView review_main(String page, HttpSession session) {

		ModelAndView model = new ModelAndView();	
		//�ӽ� ���̵�
		//mid="test";
		Map<String, Integer> param = pageService.getPageResult(page, "review");
		/*
		//����¡ ó�� - startCount, endCount ���ϱ�
		int startCount = 0;
		int endCount = 0;
		int pageSize = 7;	//���������� �Խù� ��
		int reqPage = 1;	//��û������	
		int pageCount = 7;	//��ü ������ ��
		int dbCount = reviewService.getTotalRowCount();	//DB���� ������ ��ü ���
		*/

		
		
		//�� ������ �� ���
		/*
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}
		*/
		/*
		//��û ������ ���
		if(page != null){
			reqPage = Integer.parseInt(page);
			startCount = (reqPage-1) * pageSize+1; 
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = 7;
		}
		*/
		
		ArrayList<ReviewVo> list = reviewService.getSelectList(param.get("startCount"), param.get("endCount"));
		
		model.addObject("count", param.get("count"));
		model.addObject("list", list);
		model.addObject("totals", param.get("dbCount"));
		model.addObject("pageSize", param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		
		model.setViewName("/review/review_main");
		
		return model;
	} 
	
	
	
	
	
	
	//review_content.do ���� �� ������
	@RequestMapping(value="/review_content.do", method=RequestMethod.GET)
	public ModelAndView review_content(String rid, String page, String filter_location, HttpSession session)  {
		ModelAndView model = new ModelAndView();
		ReviewLikeVo reviewLikeVo = new ReviewLikeVo();
		ReviewVo reviewVo = reviewService.getEnter_select(rid);		
		String mid;
		
		if(session.getAttribute("svo") == null) {
			mid = "";
		}
		else {
			SessionVo sessionVo = (SessionVo) session.getAttribute("svo");
			mid = sessionVo.getMid();
		}
		reviewVo.setRcontent(reviewVo.getRcontent().replace("\n", "<br>"));
		reviewLikeVo.setRid(rid);
		reviewLikeVo.setMid(mid);
		
		int likeCheck = reviewLikeService.getIdCheck(reviewLikeVo);
		
		model.addObject("page", page);
		model.addObject("filter_location", filter_location);
		model.addObject("likeCheck", likeCheck);
		model.addObject("reviewVo", reviewVo);
		model.setViewName("/review/review_content");
		
		return model;
	}
	
	
	
	//review_delete.do ���� ���� ������
	@RequestMapping(value="/review_delete.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_delete(String rid, String page, String filter_location, String mid) {
		ModelAndView model = new ModelAndView();
		
		model.addObject("page", page);
		model.addObject("filter_location", filter_location);
		model.addObject("mid", mid);
		model.addObject("rid", rid);
		model.setViewName("/review/review_delete");
		
		return model;
	}
	
	
	//review_delete_proc.do ���� ���� ó��
	@RequestMapping(value="/review_delete_proc.do", method=RequestMethod.POST)
	public ModelAndView review_delete_proc(String rid) {
		ModelAndView model = new ModelAndView();
		int result = reviewService.getDelete(rid);
		if(result == 1) {
			model.setViewName("redirect:/review_main.do");
		}
		
		return model;
	}
	
	
	//review_report.do ���� �Ű� ������
	@RequestMapping(value="/review_report.do", method=RequestMethod.GET)
	public ModelAndView review_report(String rid, String page, String filter_location) {
		ModelAndView model = new ModelAndView();
		
		model.addObject("page", page);
		model.addObject("filter_location", filter_location);
		model.addObject("rid", rid);
		model.setViewName("/review/review_report");
		
		return model;
	}
	
	//review_report_check.do ���� �Ű� üũ
	@RequestMapping(value="/review_report_check.do", method=RequestMethod.GET)
	@ResponseBody
	public String review_report_check(String rid) {
		int result = reviewService.reviewCheckResult(rid);
		return String.valueOf(result);
	}
	
	
	//review_report_proc.do ���� �Ű� ó��
	@RequestMapping(value="/review_report_proc.do", method=RequestMethod.POST)
	public ModelAndView review_report_proc(String rid) {
		ModelAndView model = new ModelAndView();
		int result = reviewService.getUpdateReport(rid);
		if(result == 1) {
			model.setViewName("redirect:/review_main.do");
		}
		
		return model;
	}
	
	//���� ���ƿ� ó��
	@RequestMapping(value="/review_like_Proc.do", method=RequestMethod.POST)
	public ModelAndView review_like_Proc(ReviewLikeVo reviewLikeVo, String page, String filter_location, HttpSession session) {
		ModelAndView model = new ModelAndView();
		
		SessionVo sessionVo = (SessionVo) session.getAttribute("svo");
		reviewLikeVo.setMid(sessionVo.getMid());
		
		if(reviewLikeService.getIdCheck(reviewLikeVo) == 1) {
			reviewLikeService.getLikesDownID(reviewLikeVo);
			reviewLikeService.getLikesDown(reviewLikeVo);
		}
		else {
			reviewLikeService.getLikesUpID(reviewLikeVo);
			reviewLikeService.getLikesUp(reviewLikeVo);
		}
		if(filter_location != "") {
			model.addObject("filter_location", filter_location);
		}
		if(page != "") {
			model.addObject("page", page);
		}
		model.setViewName("redirect:/review_content.do?rid="+reviewLikeVo.getRid());
		
		return model;
	}	
	
	
	//���� �˻� ����¡
	@RequestMapping(value="/review_main_search.do", method=RequestMethod.GET)
	public ModelAndView review_search_Proc(String page, String filter_location, HttpSession session) {
		ModelAndView model = new ModelAndView();
		Map<String, Integer> param = pageService.getPageResult(page, "reviewSearch");
		/*
		//����¡ ó�� - startCount, endCount ���ϱ�
		int startCount = 0;
		int endCount = 0;
		int pageSize = 7;	//���������� �Խù� ��
		int reqPage = 1;	//��û������	
		int pageCount = 7;	//��ü ������ ��
		int dbCount = reviewService.getSearchRowCount(filter_location);	//DB���� ������ ��ü ���
		*/
		//�� ������ �� ���
		/*
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize;
		}
		*/
		/*
		//��û ������ ���
		if(page != null){
			reqPage = Integer.parseInt(page);
			startCount = (reqPage-1) * pageSize+1; 
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = 7;
		}
		*/
		
		ArrayList<ReviewVo> list = reviewService.getSelectSearchList(param.get("startCount"), param.get("endCount"), filter_location);

		model.addObject("filter_location", filter_location);
		model.addObject("list", list);
		model.addObject("totals", param.get("dbCount"));
		model.addObject("pageSize", param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		
		model.setViewName("/review/review_main_search");
		
		
		return model;
	}	
	
	
	


	
	
	
}
