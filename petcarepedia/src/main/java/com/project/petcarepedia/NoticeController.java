package com.project.petcarepedia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoticeController {
	
	// admin_norice.do 관리자 공지사항 리스트 페이지
	@RequestMapping(value="/admin_notice.do", method=RequestMethod.GET)
	public String admin_notice() {
		return "/admin/notice/admin_notice";
	}
	
	// admin_notice_content.do 관리자 공지사항 상세보기 페이지
	@RequestMapping(value="/admin_notice_content.do", method=RequestMethod.GET)
	public String admin_notice_content() {
		return "/admin/notice/admin_notice_content";
	}
	
	//admin_notice_write.do 관리자 공지사항 작성 페이지
	@RequestMapping(value="/admin_notice_write.do", method=RequestMethod.GET)
	public String admin_notice_write() {
		return "/admin/notice/admin_notice_write";
	}
	
	//admin_notice_delete.do 관리자 공지사항 삭제 페이지
	@RequestMapping(value="/admin_notice_delete.do", method=RequestMethod.GET)
	public String admin_notice_delete() {
		return "/admin/notice/admin_notice_delete";
	}
	
	//admin_notice_update.do 관리자 공지사항 수정 페이지
	@RequestMapping(value="/admin_notice_update.do", method=RequestMethod.GET)
	public String admin_notice_update() {
		return "/admin/notice/admin_notice_update";
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
