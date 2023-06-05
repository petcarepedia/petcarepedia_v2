package com.project.petcarepedia;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.service.NoticeService;
import com.project.service.PageServiceImpl;
import com.project.vo.NoticeVo;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private PageServiceImpl pageService;
	
	//notice.do 관리자 공지사항 리스트 페이징

	@RequestMapping(value="/admin_notice.do", method=RequestMethod.GET)
	public ModelAndView admin_notice(String page) {
		ModelAndView model = new ModelAndView();		
		Map<String, Integer> param = pageService.getPageResult(page, "notice");
		/*
		//페이징 처리 - startCount, endCount 구하기
		int startCount = 0;
		int endCount = 0;
		int pageSize = 10;	//한페이지당 게시물 수
		int reqPage = 1;	//요청페이지	
		int pageCount = 1;	//전체 페이지 수
		int dbCount = noticeService.getTotalPageCount();	//DB에서 가져온 전체 행수
		
		//총 페이지 수 계산
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+3;
		}

		//요청 페이지 계산
		if(page != null){
			reqPage = Integer.parseInt(page);
			startCount = (reqPage-1) * pageSize+1; 
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = 10;
		}
		*/
		ArrayList<NoticeVo> list = noticeService.getListPage(param.get("startCount"), param.get("endCount"));
	
		model.addObject("list", list);
		model.addObject("totals", param.get("dbCount"));
		model.addObject("pageSize",param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		
		model.setViewName("/admin/notice/admin_notice");
		
		return model;
	} 
	
	
	
	
	// admin_notice_content.do 관리자 공지사항 상세보기 페이지
	@RequestMapping(value="/admin_notice_content.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_content(String nid) {
		ModelAndView model = new ModelAndView();
		NoticeVo noticeVo = noticeService.getEnterContent(nid);
		noticeVo.setNcontent(noticeVo.getNcontent().replace("\n", "<br>"));
		model.addObject("noticeVo", noticeVo);
		model.setViewName("/admin/notice/admin_notice_content");
		
		return model;
	}
	
	//admin_notice_write.do 관리자 공지사항 작성 페이지
	@RequestMapping(value="/admin_notice_write.do", method=RequestMethod.GET)
	public String admin_notice_write() {
		return "/admin/notice/admin_notice_write";
	}
	
	//admin_notice_write_proc.do 관리자 공지사항 작성 처리
	@RequestMapping(value="/admin_notice_write_proc.do", method=RequestMethod.POST)
	public String admin_notice_write_proc(NoticeVo noticeVo) {
		String viewName = "";
		int result = noticeService.getInsert(noticeVo);
		if(result == 1) {
			viewName = "redirect:/admin_notice.do";
		}
		else {
			//에러 처리
		}
		return viewName;
	}
	
	
	
	//admin_notice_update.do 관리자 공지사항 수정 페이지
	@RequestMapping(value="/admin_notice_update.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_update(String nid) {
		ModelAndView model = new ModelAndView();
		
		NoticeVo noticeVo = noticeService.getContent(nid);

		model.addObject("noticeVo", noticeVo);
		model.setViewName("/admin/notice/admin_notice_update");
		
		return model;
	}
	
	
	//admin_notice_update_proc.do 관리자 공지사항 수정 처리
	@RequestMapping(value="/admin_notice_update_proc.do", method=RequestMethod.POST)
	public ModelAndView admin_notice_update_proc(NoticeVo noticeVo) {
		ModelAndView model = new ModelAndView();
		int result = noticeService.getUpdate(noticeVo);
		
		if(result == 1) {
			model.setViewName("redirect:/admin_notice.do");
		}
		
		return model;
	}
	
	
	//admin_notice_delete.do 관리자 공지사항 삭제 페이지
	@RequestMapping(value="/admin_notice_delete.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_delete(String nid) {
		ModelAndView model = new ModelAndView();
		model.addObject("nid", nid);
		model.setViewName("/admin/notice/admin_notice_delete");
		
		return model;
	}
	
	
	// admin_notice_delete_proc.do 관리자 공지사항 삭제 처리
	@RequestMapping(value="/admin_notice_delete_proc.do", method=RequestMethod.POST)
	public ModelAndView admin_notice_delete_proc(String nid) {
		ModelAndView model = new ModelAndView();
		int result = noticeService.getDelete(nid);
		
		if(result == 1) {
			model.setViewName("redirect:/admin_notice.do");
		}
		
		return model;
	}
	
	
	
	
	//notice.do 사용자 공지사항 리스트 페이징

	@RequestMapping(value="/notice.do", method=RequestMethod.GET)
	public ModelAndView notice(String page) {
		ModelAndView model = new ModelAndView();		
		Map<String, Integer> param = pageService.getPageResult(page, "notice");
		/*
		//페이징 처리 - startCount, endCount 구하기
		int startCount = 0;
		int endCount = 0;
		int pageSize = 10;	//한페이지당 게시물 수
		int reqPage = 1;	//요청페이지	
		int pageCount = 1;	//전체 페이지 수
		int dbCount = noticeService.getTotalPageCount();	//DB에서 가져온 전체 행수
		
		//총 페이지 수 계산
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+3;
		}

		//요청 페이지 계산
		if(page != null){
			reqPage = Integer.parseInt(page);
			startCount = (reqPage-1) * pageSize+1; 
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = 10;
		}
		*/
		ArrayList<NoticeVo> list = noticeService.getListPage(param.get("startCount"), param.get("endCount"));
		
		model.addObject("list", list);
		model.addObject("totals", param.get("dbCount"));
		model.addObject("pageSize",param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		
		model.setViewName("/notice/notice");
		
		return model;
	} 
	
	
	
	
	// notice_content.do 사용자 공지사항 상세보기
	@RequestMapping(value="/notice_content.do", method=RequestMethod.GET)
	public ModelAndView notice_content(String nid) {
		ModelAndView model = new ModelAndView();
		NoticeVo noticeVo = noticeService.getEnterContent(nid);
		
		if(noticeVo != null) {
			// 조회수 업데이트 DB
			noticeService.getUpdateHits(nid);
		}
		model.addObject("noticeVo", noticeVo);
		model.setViewName("/notice/notice_content");
		
		return model;
	}
}
