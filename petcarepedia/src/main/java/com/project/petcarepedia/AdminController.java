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
import com.project.dao.BookingDao;
import com.project.dao.HospitalDao;
import com.project.dao.MemberDao;
import com.project.dao.NoticeDao;
import com.project.dao.ReviewDao;
import com.project.vo.BookingVo;
import com.project.vo.HospitalVo;
import com.project.vo.MemberVo;
import com.project.vo.NoticeVo;
import com.project.vo.ReviewVo;

@Controller
public class AdminController {
	
	@RequestMapping(value="/hospital_list.do", method=RequestMethod.GET)
	public ModelAndView admin_notice(String page) {
		ModelAndView model = new ModelAndView();		
		HospitalDao hospitalDao = new HospitalDao();
		
		//페이징 처리 - startCount, endCount 구하기
		int startCount = 0;
		int endCount = 0;
		int pageSize = 10;	//한페이지당 게시물 수
		int reqPage = 1;	//요청페이지	
		int pageCount = 1;	//전체 페이지 수
		int dbCount = hospitalDao.totalRowCount();	//DB에서 가져온 전체 행수
		
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
		
		ArrayList<HospitalVo> list = hospitalDao.select(startCount, endCount);
	
		model.addObject("list", list);
		model.addObject("totals", dbCount);
		model.addObject("pageSize", pageSize);
		model.addObject("maxSize", pageCount);
		model.addObject("page", reqPage);
		
		model.setViewName("/admin/hospital/hospital_list");
		
		return model;
	} 
	
	/**
	 * 예약 - 검색 결과
	 * */
	@RequestMapping(value="/reserve_list_detail.do", method=RequestMethod.GET)
	public ModelAndView reserve_list_detail(String mid) {
		ModelAndView model = new ModelAndView();
		BookingDao bookingDao = new BookingDao();
		ArrayList<BookingVo> bookingVo = bookingDao.search5(mid);
		
		model.addObject("bookindVo", bookingVo);
		model.setViewName("/admin/reserve/reserve_list_detail");
		
		return model;
	}
	
	
	/**
	 * 예약 - 검색 창
	 * */
	@RequestMapping(value="/reserve_list_data.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String reserve_list_data(String mid) {
		BookingDao bookingDao = new BookingDao();
		ArrayList<BookingVo> list = bookingDao.search5(mid);
		
		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();
		
		for(BookingVo bookingVo :list) {
			JsonObject jobj = new JsonObject(); //{}
			jobj.addProperty("rno", bookingVo.getRno());
			jobj.addProperty("hname", bookingVo.getHname());
			jobj.addProperty("mid", bookingVo.getMid());
			jobj.addProperty("Bdate", bookingVo.getBdate());
			jobj.addProperty("Bstate", bookingVo.getBstate());
			
			jarray.add(jobj);
		}
		jlist.add("jlist", jarray);
		
		return new Gson().toJson(jlist);
	}
	
	/**
	 * 예약 - 조회페이지
	 * */
	@RequestMapping(value="/reserve_list.do", method=RequestMethod.GET)
	public ModelAndView reserve_list(BookingVo bookingVo) {
		ModelAndView model = new ModelAndView();
		BookingDao bookingDao = new BookingDao();
		ArrayList<BookingVo> list = bookingDao.select();
		
		
		model.addObject("list", list);
		model.setViewName("/admin/reserve/reserve_list");
		
		return model;
	}
	/**
	 * �Ű����� - ��������
	 * */
	@RequestMapping(value="/review_detail.do", method=RequestMethod.GET)
	public ModelAndView review_detail(String rid) {
		ModelAndView model = new ModelAndView();
		ReviewDao reviewDao = new ReviewDao();
		ReviewVo reviewVo = reviewDao.select(rid);
		
		model.addObject("reviewVo", reviewVo);
		model.setViewName("/admin/review/review_detail");
		
		return model;
	}
	
	/**
	 *리뷰 - 조회페이지
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
	 * ȸ�� - �� ������
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
	 * ȸ�� - ��ȸ������
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
	 * ���� - ���� ó�� ������
	 * */
	@RequestMapping(value = "/hospital_update_proc.do", method = RequestMethod.POST)
	public String hospital_update_proc(HospitalVo hospitalVo) {
		String viewName = "";
		HospitalDao hospitalDao = new HospitalDao();
		System.out.println(hospitalVo.getHname());
		int result = hospitalDao.update(hospitalVo);
		if (result == 1) {
			viewName = "redirect:/hospital_list.do";
		} else {
			// ���� ������ ȣ��
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
	 * 병원- 등록 페이지
	 * */
	@RequestMapping(value="/hospital_detail_proc.do", method=RequestMethod.POST)
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
	 * 병원 - 검색
	 * */
	@RequestMapping(value="/hospital_detail.do", method=RequestMethod.GET)
	public String hostpital_list_detail() {
		return "/admin/hospital/hospital_detail";
	}
	
	
	/**
	 * 병원 - 검색 페이지
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
	

	
//	/**
//	 * 메인 - 병원 페이지
//	 * */
//	@RequestMapping(value="/hospital_list.do", method=RequestMethod.GET)
//	public ModelAndView hospital_list() {
//		ModelAndView model = new ModelAndView();
//		HospitalDao hospitalDao = new HospitalDao();
//		ArrayList<HospitalVo> list = new ArrayList<HospitalVo>();
//		
//		list = hospitalDao.select();
//		
//		model.addObject("list", list);
//		model.setViewName("/admin/hospital/hospital_list");
//		
//		return model;
//	}
	
	/**
	 * 병원 - 검색창 활성화
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