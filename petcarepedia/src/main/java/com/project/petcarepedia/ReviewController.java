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
	
	//review_main.do ���� ����Ʈ ����¡

	@RequestMapping(value="/review_main.do", method=RequestMethod.GET)
	public ModelAndView review_main(String page, String mid) {
		int count = 0;
		ModelAndView model = new ModelAndView();		
		ReviewDao reviewDao = new ReviewDao();
		//����¡ ó�� - startCount, endCount ���ϱ�
		int startCount = 0;
		int endCount = 0;
		int pageSize = 7;	//���������� �Խù� ��
		int reqPage = 1;	//��û������	
		int pageCount = 7;	//��ü ������ ��
		int dbCount = reviewDao.totalRowCount();	//DB���� ������ ��ü ���
		
		//�ӽ� ���̵�
		mid = "hong";
		
		
		//�� ������ �� ���
		/*
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}
		*/
		//��û ������ ���
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
	
	
	
	
	
	
	//review_content.do ���� �� ������
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
	
	
	
	//review_delete.do ���� ���� ������
	@RequestMapping(value="/review_delete.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_delete(String rid) {
		ModelAndView model = new ModelAndView();
		model.addObject("rid", rid);
		model.setViewName("/review/review_delete");
		
		return model;
	}
	
	
	//review_delete_proc.do ���� ���� ó��
	@RequestMapping(value="/review_delete_proc.do", method=RequestMethod.POST)
	public ModelAndView review_delete_proc(String rid) {
		ModelAndView model = new ModelAndView();
		ReviewDao reviewDao = new ReviewDao();
		int result = reviewDao.delete(rid);
		if(result == 1) {
			//���� �� ����� ���ư� (�ӽ�)
			model.setViewName("redirect:/review_main.do");
		}
		
		return model;
	}
	
	
	//review_report.do ���� �Ű� ������
	@RequestMapping(value="/review_report.do", method=RequestMethod.GET)
	public ModelAndView review_report(String rid) {
		ModelAndView model = new ModelAndView();
		model.addObject("rid", rid);
		model.setViewName("/review/review_report");
		
		return model;
	}
	
	
	//review_report_proc.do ���� �Ű� ó��
	@RequestMapping(value="/review_report_proc.do", method=RequestMethod.POST)
	public ModelAndView review_report_proc(String rid) {
		ModelAndView model = new ModelAndView();
		ReviewDao reviewDao = new ReviewDao();
		int result = reviewDao.update(rid);
		if(result == 1) {
			//���� �� ����� ���ư� (�ӽ�)
			model.setViewName("redirect:/review_main.do");
		}
		
		return model;
	}
	
	//���� ���ƿ� ó��
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
		
		//����¡ ó�� - startCount, endCount ���ϱ�
		int startCount = 0;
		int endCount = 0;
		int pageSize = 7;	//���������� �Խù� ��
		int reqPage = 1;	//��û������	
		int pageCount = 7;	//��ü ������ ��
		int dbCount = reviewDao.SearchRowCount(filter_location);	//DB���� ������ ��ü ���
		
		//�� ������ �� ���
		/*
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize;
		}
		*/
		//��û ������ ���
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
