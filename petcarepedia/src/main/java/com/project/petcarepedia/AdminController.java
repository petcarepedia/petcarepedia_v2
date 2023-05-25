package com.project.petcarepedia;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.project.dao.HospitalDao;
import com.project.dao.MemberDao;
import com.project.vo.HospitalVo;
import com.project.vo.MemberVo;

@Controller
public class AdminController {
	
	
	
	
	
	
	/**
	 * ȸ�� - ��������
	 * */
	@RequestMapping(value="/member_detail.do", method=RequestMethod.GET)
	public String member_detail(String mid) {
		String viewName = "";
		MemberDao memberDao = new MemberDao();
		int result = memberDao.select(mid);
		if(result == 1) {
			viewName=("admin/ ")
		}
		
		
		return viewName;
	}
	
	/**
	 * ȸ�� - ��ȸ������
	 * */
	@RequestMapping(value="/member_list.do", method=RequestMethod.GET)
	public ModelAndView member_list() {
		ModelAndView model = new ModelAndView();
		MemberDao memberDao = new MemberDao();
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		
		list = memberDao.select();
		
		model.addObject("list", list);
		model.setViewName("/admin/member/member_list");
		
		return model;
	}
	
	/**
	 * ���� - ������
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
	 * ���� - ���� ������
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
	 * ���� - ���� ���� ��� ó��
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
	 * ���� - ���������
	 * */
	@RequestMapping(value="/hospital_detail.do", method=RequestMethod.GET)
	public String hostpital_list_detail() {
		return "/admin/hospital/hospital_detail";
	}
	
	/**
	 * ���� - ���� �˻� ó��
	 * */
//	@RequestMapping(value="/hospital_list_detail_proc.do", method=RequestMethod.POST)
//	public String hostpital_list_detail_proc(String hname) {
//		String viewName="";
//		HospitalDao hospitalDao = new HospitalDao();
//		int result = hospitalDao.search(hname);
//		if(result == 1) {
//			viewName = "redirect:/hospital_list.do";
//		}
//		return viewName;
//	}
	
	/**
	 * ���� - �˻�������
	 * */
	@RequestMapping(value="/hospital_list_detail.do", method=RequestMethod.GET)
	public ModelAndView hostpital_detail(String hname) {
		ModelAndView model = new ModelAndView(); 
		HospitalDao hospitalDao = new HospitalDao();
		ArrayList<HospitalVo> list = hospitalDao.search(hname);
		
		model.addObject("list", list);
		model.setViewName("/admin/hospital/hospital_list_detail");
		
		return model;
	}
	

	
	/**
	 * ���� - ���� ������
	 * */
	@RequestMapping(value="/hospital_list.do", method=RequestMethod.GET)
	public ModelAndView hospital_list() {
		ModelAndView model = new ModelAndView();
		HospitalDao hospitalDao = new HospitalDao();
		ArrayList<HospitalVo> list = new ArrayList<HospitalVo>();
		
		list = hospitalDao.select();
		
		model.addObject("list", list);
		model.setViewName("/admin/hospital/hospital_list");
		
		return model;
	}
	
	/**
	 * ���� - ���� ������ �˻�
	 * */
	@RequestMapping(value="/hospital_list_data.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String hospital_list_data(String hname) {
		HospitalDao hospitalDao = new HospitalDao();
		ArrayList<HospitalVo> list = hospitalDao.search(hname);
		
		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();
		
		for(HospitalVo hospitalVo :list) {
			JsonObject jobj = new JsonObject(); //{}
			jobj.addProperty("hid", hospitalVo.getHid());
			jobj.addProperty("hname", hospitalVo.getHname());
			jobj.addProperty("gloc", hospitalVo.getGloc());
			jobj.addProperty("loc", hospitalVo.getLoc());
			jobj.addProperty("tel", hospitalVo.getTel());
			jobj.addProperty("htime", hospitalVo.getHtime());
			jobj.addProperty("ntime", hospitalVo.getNtime());
			jobj.addProperty("holiday", hospitalVo.getHoliday());
			jobj.addProperty("animal", hospitalVo.getAnimal());
			jobj.addProperty("x", hospitalVo.getX());
			jobj.addProperty("y", hospitalVo.getY());
			
			jarray.add(jobj);
		}
		jlist.add("jlist", jarray);
		
		return new Gson().toJson(jlist);
	}
	
	
}