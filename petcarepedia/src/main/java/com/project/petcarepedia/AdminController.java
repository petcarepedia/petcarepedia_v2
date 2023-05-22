package com.project.petcarepedia;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.HospitalDao;
import com.project.vo.HospitalVo;

@Controller
public class AdminController {
	
	
	
	
	
	/**
	 * 병원 - 수정폼
	 * */
	@RequestMapping(value="/hospital_update_proc.do", method=RequestMethod.POST)
	public String hostpital_update_proc(HospitalVo hospitalVo) {
		String viewName="";
		HospitalDao hospitalDao = new HospitalDao();
		int result = hospitalDao.update(hospitalVo);
		if(result == 1) {
			viewName = "redirect:/hospital_list.do";
		}
		return viewName;
	}
	
	/**
	 * 병원 - 수정 페이지
	 * */
	@RequestMapping(value="/hospital_update.do", method=RequestMethod.GET)
	public ModelAndView hostpital_update(String hid) {
		
		ModelAndView model = new ModelAndView();
		HospitalDao hospitalDao = new HospitalDao();
		HospitalVo hospitalVo = hospitalDao.select(hid); 
		
		model.addObject("hospitalVo", hospitalVo);
		model.setViewName("/admin/hospital/hospital_update");
		
		return model;
	}
	
	/**
	 * 병원 - 병원 정보 등록 처리
	 * */
	@RequestMapping(value="/hospital_detail_proc.do", method=RequestMethod.POST)
	public String hostpital_detail_proc(HospitalVo hospitalVo) {
		String viewName="";
		HospitalDao hospitalDao = new HospitalDao();
		int result = hospitalDao.insert(hospitalVo);
		if(result == 1) {
			viewName = "redirect:/hospital_list.do";
		}
		return viewName;
	}
	
	/**
	 * 병원 - 등록페이지
	 * */
	@RequestMapping(value="/hospital_detail.do", method=RequestMethod.GET)
	public String hostpital_list_detail() {
		return "/admin/hospital/hospital_detail";
	}
	
	/**
	 * 병원 - 검색페이지
	 * */
	@RequestMapping(value="/hospital_list_detail.do", method=RequestMethod.GET)
	public String hostpital_detail(HospitalVo hospitalVo) {
		String viewName = "";
		HospitalDao hospitalDao = new HospitalDao();
		int result = hospitalDao.insert(hospitalVo);
		if(result == 1) {
			viewName = "redirect:/hospital_list.do";
		}
		return viewName;
	}
	
	/**
	 * 메인 - 병원 페이지
	 * */
	@RequestMapping(value="/hospital_list.do", method=RequestMethod.GET)
	public ModelAndView hospital_list() {
		ModelAndView model = new ModelAndView();
		HospitalDao hospitalDao = new HospitalDao();
		ArrayList<HospitalVo> list = hospitalDao.select();
		
		model.addObject("list", list);
		model.setViewName("/admin/hospital/hospital_list");
		
		return model;
	}
	
	
}