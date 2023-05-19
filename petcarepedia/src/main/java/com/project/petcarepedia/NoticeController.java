package com.project.petcarepedia;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.NoticeDao;
import com.project.vo.NoticeVo;

@Controller
public class NoticeController {
	
	// admin_norice.do 관리자 공지사항 리스트 페이지
	@RequestMapping(value="/admin_notice.do", method=RequestMethod.GET)
	public ModelAndView admin_notice() {
		ModelAndView model = new ModelAndView();
		NoticeDao noticeDao = new NoticeDao();
		ArrayList<NoticeVo> noticeList = noticeDao.select();
		
		model.addObject("noticeList", noticeList);
		model.setViewName("/admin/notice/admin_notice");
		
		return model;
	}
	
	// admin_notice_content.do 관리자 공지사항 상세보기 페이지
	@RequestMapping(value="/admin_notice_content.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_content(String nid) {
		ModelAndView model = new ModelAndView();
		NoticeDao noticeDao = new NoticeDao();
		NoticeVo noticeVo = noticeDao.select(nid);
		
		if(noticeVo != null) {
			// 조회수 업데이트 DB
			noticeDao.updateHits(nid);
		}
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
		NoticeDao noticeDao = new NoticeDao();
		int result = noticeDao.insert(noticeVo);
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
		
		NoticeDao noticeDao = new NoticeDao();
		NoticeVo noticeVo = noticeDao.select(nid);
		/*
		 * if(boardVo != null) { // 조회수 업데이트 DB boardDao.updateHits(bid); }
		 */
		model.addObject("nvo", noticeVo);
		model.setViewName("/admin/notice/admin_notice_update");
		
		return model;
	}
	
	
	
	
	
	
	//admin_notice_delete.do 관리자 공지사항 삭제 페이지
	@RequestMapping(value="/admin_notice_delete.do", method=RequestMethod.GET)
	public String admin_notice_delete() {
		return "/admin/notice/admin_notice_delete";
	}
	
	
	//notice.do 사용자 공지사항 리스트
	@RequestMapping(value="/notice.do", method=RequestMethod.GET)
	public String notice() {
		return "/notice/notice";
	}
	
	//notice_content.do 사용자 공지사항 리스트
	@RequestMapping(value="/notice_content.do", method=RequestMethod.GET)
	public String notice_content() {
		return "/notice/notice_content";
	}
}
