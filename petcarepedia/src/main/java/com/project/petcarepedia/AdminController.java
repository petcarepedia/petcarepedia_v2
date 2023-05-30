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
import com.project.dao.ReviewDao;
import com.project.vo.HospitalVo;
import com.project.vo.MemberVo;
import com.project.vo.ReviewVo;

@Controller
public class AdminController {
	
	
	
	/**
	 * 회원 - 조회페이지
	 * */
	@RequestMapping(value="/review_list.do", method=RequestMethod.GET)
	public ModelAndView review_list(ReviewVo reviewVo) {
		ModelAndView model = new ModelAndView();
		ReviewDao reviewDao = new ReviewDao();
		ArrayList<ReviewVo> list = reviewDao.select();
		
		model.addObject("list", list);
		model.setViewName("/admin/review/review_list");
		
		return model;
	}
	
	/**
	 * 회원 - 회원 아이디 검색
	 * */
	@RequestMapping(value="/member_list_data.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String member_list_data(String mid) {
		MemberDao memberDao = new MemberDao();
		ArrayList<MemberVo> list = memberDao.search(mid);
		
		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();
		
		for(MemberVo memberVo :list) {
			JsonObject jobj = new JsonObject(); //{}
			jobj.addProperty("rno", memberVo.getRno());
			jobj.addProperty("mid", memberVo.getMid());
			jobj.addProperty("name", memberVo.getName());
			jobj.addProperty("email", memberVo.getEmail());
			jobj.addProperty("phone", memberVo.getPhone());
			
			jarray.add(jobj);
		}
		jlist.add("jlist", jarray);
		
		return new Gson().toJson(jlist);
	}
	/**
	 * 회원 - 상세 페이지
	 * */
	@RequestMapping(value="/member_detail.do", method=RequestMethod.GET)
	public ModelAndView member_detail(String mid) {
		
		ModelAndView model = new ModelAndView();
		MemberDao memberDao = new MemberDao();
		MemberVo memberVo = memberDao.select(mid); 
		
		model.addObject("memberVo", memberVo);
		model.setViewName("/admin/member/member_detail");
		
		return model;
	}
	
	/**
	 * 회원 - 조회페이지
	 * */
	@RequestMapping(value="/member_list.do", method=RequestMethod.GET)
	public ModelAndView member_list(MemberVo memberVo) {
		ModelAndView model = new ModelAndView();
		MemberDao memberDao = new MemberDao();
		ArrayList<MemberVo> list = memberDao.select();
		
		
		model.addObject("list", list);
		model.setViewName("/admin/member/member_list");
		
		return model;
	}
	
	

	/**
	 * 병원 - 수정 처리 페이지
	 * */
	@RequestMapping(value = "/hospital_update_proc.do", method = RequestMethod.GET)
	public String hospital_update_proc(HospitalVo hospitalVo) {
		String viewName = "";
		HospitalDao hospitalDao = new HospitalDao();
		int result = hospitalDao.update(hospitalVo);
		if (result == 1) {
			viewName = "redirect:/hospital_list.do";
		} else {
			// 에러 페이지 호출
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
	@RequestMapping(value="/hospital_detail_proc.do", method=RequestMethod.GET)
	public String hostpital_detail_proc(HospitalVo hospitalVo){
		String viewName="";
		HospitalDao hospitalDao = new HospitalDao();
		int result = hospitalDao.insert(hospitalVo);
		if(result == 1) {
			
			viewName = "redirect:/hospital_list.do";
		}else {
			
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
	public ModelAndView hostpital_detail(String hname) {
		ModelAndView model = new ModelAndView(); 
		HospitalDao hospitalDao = new HospitalDao();
		ArrayList<HospitalVo> list = hospitalDao.search(hname);
		
		model.addObject("list", list);
		model.setViewName("/admin/hospital/hospital_list_detail");
		
		return model;
	}
	

	
	/**
	 * 메인 - 병원 페이지
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
	 * 메인 - 병원 페이지 검색
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
			jobj.addProperty("rno", hospitalVo.getRno());
			jobj.addProperty("hname", hospitalVo.getHname());
			jobj.addProperty("ntime", hospitalVo.getNtime());
			jobj.addProperty("animal", hospitalVo.getAnimal());
			jobj.addProperty("hid", hospitalVo.getHid());		
			
			jarray.add(jobj);
		}
		jlist.add("jlist", jarray);
		
		return new Gson().toJson(jlist);
	}
	
	
}