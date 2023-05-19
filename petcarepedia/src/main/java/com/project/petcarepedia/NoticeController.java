package com.project.petcarepedia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoticeController {
	
	// admin_norice.do ������ �������� ����Ʈ ������
	@RequestMapping(value="/admin_notice.do", method=RequestMethod.GET)
	public String admin_notice() {
		return "/admin/notice/admin_notice";
	}
	
	// admin_notice_content.do ������ �������� �󼼺��� ������
	@RequestMapping(value="/admin_notice_content.do", method=RequestMethod.GET)
	public String admin_notice_content() {
		return "/admin/notice/admin_notice_content";
	}
	
	//admin_notice_write.do ������ �������� �ۼ� ������
	@RequestMapping(value="/admin_notice_write.do", method=RequestMethod.GET)
	public String admin_notice_write() {
		return "/admin/notice/admin_notice_write";
	}
	
	//admin_notice_delete.do ������ �������� ���� ������
	@RequestMapping(value="/admin_notice_delete.do", method=RequestMethod.GET)
	public String admin_notice_delete() {
		return "/admin/notice/admin_notice_delete";
	}
	
	//admin_notice_update.do ������ �������� ���� ������
	@RequestMapping(value="/admin_notice_update.do", method=RequestMethod.GET)
	public String admin_notice_update() {
		return "/admin/notice/admin_notice_update";
	}
	
	//notice.do ����� �������� ����Ʈ
	@RequestMapping(value="/notice.do", method=RequestMethod.GET)
	public String notice() {
		return "/notice/notice";
	}
	
	//notice_content.do ����� �������� ����Ʈ
	@RequestMapping(value="/notice_content.do", method=RequestMethod.GET)
	public String notice_content() {
		return "/notice/notice_content";
	}
}
