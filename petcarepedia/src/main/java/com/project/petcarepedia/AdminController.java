package com.project.petcarepedia;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.project.dao.BookingDao;
import com.project.service.BookingService;
import com.project.service.FileServiceImpl;
import com.project.service.HospitalService;
import com.project.service.MemberService;
import com.project.service.PageServiceImpl;
import com.project.service.ReviewService;
import com.project.vo.BookingVo;
import com.project.vo.HospitalVo;
import com.project.vo.MemberVo;
import com.project.vo.ReviewVo;

@Controller
public class AdminController {

	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private PageServiceImpl pageService;
	@Autowired
	private FileServiceImpl fileService;
	
	/**
	 * �뵳�됰윮 占쎈읂占쎌뵠筌욑옙
	 */
	@RequestMapping(value="/admin_review_list.do", method=RequestMethod.GET)
	public ModelAndView review_list(String page) {
		ModelAndView model = new ModelAndView();		
		Map<String, Integer> param = pageService.getPageResult(page, "review2");
		
		ArrayList<ReviewVo> list = pageService.getRListPage(param.get("startCount"), param.get("endCount"));
		
		model.addObject("list", list);
		model.addObject("totals", param.get("dbCount"));
		model.addObject("pageSize",param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		
		model.setViewName("/admin/review/admin_review_list");
		
		return model;
	}
	
	/**
	 * 占쎌굙占쎈튋 占쎈읂占쎌뵠筌욑옙
	 */
//	@RequestMapping(value="/admin_reserve_list.do", method=RequestMethod.GET)
//	public ModelAndView reserve_list(String page) {
//		ModelAndView model = new ModelAndView();		
//		Map<String, Integer> param = pageService.getPageResult(page, "booking");
//		
//		ArrayList<BookingVo> list = pageService.getBListPage(param.get("startCount"), param.get("endCount"));
//		
//		model.addObject("list", list);
//		model.addObject("totals", param.get("dbCount"));
//		model.addObject("pageSize",param.get("pageSize"));
//		model.addObject("maxSize", param.get("maxSize"));
//		model.addObject("page", param.get("page"));
//		
//		model.setViewName("/admin/reserve/admin_reserve_list");
//		
//		return model;
//	}
	
	@RequestMapping(value="/admin_reserve_list.do", method=RequestMethod.GET)
	public ModelAndView reserve_list(String page, String mid) {
		ModelAndView model = new ModelAndView();
		Map<String, Integer> param = new HashMap<String,Integer>();
		ArrayList<BookingVo> list = new ArrayList<BookingVo>();
		
		if(mid!=null && mid!="") {
			param = pageService.getBPageResult(page, mid);
			list = pageService.getBsListPage(param.get("startCount"), param.get("endCount"), mid);
		} else {
			param = pageService.getBPageResult(page, "booking");
			list = pageService.getBListPage(param.get("startCount"), param.get("endCount"));
		}
		
		model.addObject("list", list);
		model.addObject("totals", param.get("dbCount"));
		model.addObject("pageSize",param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		model.addObject("mid", mid);
		
		model.setViewName("/admin/reserve/admin_reserve_list");
		
		return model;
	}
	
	/**
	 * 占쎌돳占쎌뜚 占쎈읂占쎌뵠筌욑옙
	 */
	@RequestMapping(value="/admin_member_list.do", method=RequestMethod.GET)
	public ModelAndView member_list(String page, String mid) {
		ModelAndView model = new ModelAndView();
		Map<String, Integer> param = new HashMap<String,Integer>();
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		
		if(mid!=null && mid!="") {
			param = pageService.getMPageResult(page, mid);
			list = pageService.getMsListPage(param.get("startCount"), param.get("endCount"), mid);
		} else {
			param = pageService.getMPageResult(page, "member");
			list = pageService.getMListPage(param.get("startCount"), param.get("endCount"));
		}
		
		model.addObject("list", list);
		model.addObject("totals", param.get("dbCount"));
		model.addObject("pageSize",param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		model.addObject("mid", mid);
		
		model.setViewName("/admin/member/admin_member_list");
		
		return model;
	}
	
	/**
	 * 癰귣쵐�뜚 占쎈읂占쎌뵠筌욑옙
	 */
	@RequestMapping(value="/admin_hospital_list.do", method=RequestMethod.GET)
	public ModelAndView hospital_list(String page, String hname) {
		ModelAndView model = new ModelAndView();
		Map<String, Integer> param = new HashMap<String,Integer>();
		ArrayList<HospitalVo> list = new ArrayList<HospitalVo>();
		
		if(hname!=null && hname!="") {
			param = pageService.getHPageResult(page, hname);
			list = pageService.getHsListPage(param.get("startCount"), param.get("endCount"), hname);
		} else {
			param = pageService.getHPageResult(page, "hospital");
			list = pageService.getHListPage(param.get("startCount"), param.get("endCount"));
		}
		
		model.addObject("list", list);
		model.addObject("totals", param.get("dbCount"));
		model.addObject("pageSize",param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		model.addObject("hname", hname);
		
		model.setViewName("/admin/hospital/admin_hospital_list");
		
		return model;
	}
	
	/**
	 * 占쎌굙占쎈튋 - 占쎄맒占쎄묶 癰귨옙野껓옙 筌ｌ꼶�봺
	 */
	
	@RequestMapping(value = "/reserve_state_data.do", method = RequestMethod.POST)
	public String reserve_state_date(String bid) {
		String viewName = "";
		BookingDao bookingDao = new BookingDao();
		int result = bookingDao.Bselect(bid);
		
 		if(result == 1) {
 			viewName = "redirect:/admin_reserve_list.do";
 		}else {
 			
 		}

		return viewName;
	}
	
	/**
	 * 占쎌굙占쎈튋 - 野껓옙占쎄퉳
	 */
	@RequestMapping(value = "/admin_reserve_list_detail.do", method = RequestMethod.GET)
	public ModelAndView reserve_list_detail(String mid) {
		ModelAndView model = new ModelAndView();
		
		ArrayList<BookingVo> bookingVo = bookingService.getSelect();

		model.addObject("bookindVo", bookingVo);
		model.setViewName("/admin/reserve/admin_reserve_list_detail");

		return model;
	}

	/**
	 * 占쎌굙占쎈튋 - 野껓옙占쎄퉳 筌ｌ꼶�봺
	 */
	@RequestMapping(value = "/reserve_list_data.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String reserve_list_data(String mid) {
		ArrayList<BookingVo> list = bookingService.getSearch5(mid);

		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();

		for (BookingVo bookingVo : list) {
			JsonObject jobj = new JsonObject(); // {}
			jobj.addProperty("bid", bookingVo.getBid());
			jobj.addProperty("hname", bookingVo.getHname());
			jobj.addProperty("mid", bookingVo.getMid());
			jobj.addProperty("vdate", bookingVo.getVdate());
			jobj.addProperty("bstate", bookingVo.getBstate());

			jarray.add(jobj);
		}
		jlist.add("jlist", jarray);

		return new Gson().toJson(jlist);
	}
	
	/**
	 * 占쎈뻿�⑥쥓�봺�뀎占� - 占쎄텣占쎌젫 占쎈읂占쎌뵠筌욑옙
	 */
	@RequestMapping(value = "/review_delete_proc2.do", method = RequestMethod.POST)
	public String review_delete_proc2(String rid) {
		String viewName = "";
		int result = reviewService.getDelete(rid);
		if (result == 1) {
			viewName = "redirect:/admin_review_list.do";
		} else {

		}
		return viewName;
	}
	
	/**
	 * 占쎈뻿�⑥쥓�봺�뀎占� - 占쎄텣占쎌젫 占쎈읂占쎌뵠筌욑옙
	 */
	@RequestMapping(value="/admin_review_delete2.do", method=RequestMethod.GET)
	public ModelAndView review_delete2(String rid) {
		ModelAndView model = new ModelAndView();
		ReviewVo reviewVo = reviewService.getSelect(rid);
		
		model.addObject("reviewVo", reviewVo);
		model.setViewName("admin/review/admin_review_delete2");
		
		return model;
	}
	
	/**
	 * 占쎈뻿�⑥쥓�봺�뀎占� - 占쎄맒占쎄쉭 占쎈읂占쎌뵠筌욑옙
	 */
	@RequestMapping(value = "/admin_review_detail.do", method = RequestMethod.GET)
	public ModelAndView review_detail(String rid) {
		ModelAndView model = new ModelAndView();
		ReviewVo reviewVo = reviewService.getSelect(rid);

		model.addObject("reviewVo", reviewVo);
		model.setViewName("/admin/review/admin_review_detail");

		return model;
	}
	

	/**
	 * 占쎌돳占쎌뜚 - 野껓옙占쎄퉳筌∽옙
	 * */
	@RequestMapping(value = "/member_list_data.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String member_list_data(String mid) {
		ArrayList<MemberVo> list = memberService.getSearch(mid);

		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();

		for (MemberVo memberVo : list) {
			JsonObject jobj = new JsonObject(); // {}
			jobj.addProperty("mid", memberVo.getMid());
			jobj.addProperty("name", memberVo.getName());
			jobj.addProperty("email", memberVo.getEmail());
			jobj.addProperty("phone", memberVo.getPhone());
			jobj.addProperty("mdate", memberVo.getMdate());

			jarray.add(jobj);
		}
		jlist.add("jlist", jarray);

		return new Gson().toJson(jlist);
	}

	/**
	 * 占쎌돳占쎌뜚 - 占쎄맒占쎄쉭占쎈읂占쎌뵠筌욑옙
	 */
	@RequestMapping(value = "/admin_member_detail.do", method = RequestMethod.GET)
	public ModelAndView member_detail(String mid) {

		ModelAndView model = new ModelAndView();
		MemberVo memberVo = memberService.getSelect(mid);

		model.addObject("memberVo", memberVo);
		model.setViewName("/admin/member/admin_member_detail");

		return model;
	}

	/**
	 * 병원 삭제 처리
	 */
	@RequestMapping(value = "/hospital_delete_proc.do", method = RequestMethod.POST)
	public String hospital_delete_proc(String hid, String hsfile, HttpServletRequest request)
																			throws Exception{
		String viewName = "";
		int result = hospitalService.delete(hid);
		if (result == 1) {
			fileService.fileDelete(request, hsfile);
			viewName = "redirect:/admin_hospital_list.do";
		} else {

		}

		return viewName;
	}

	/**
	 * 병원 - 삭제
	 */
	@RequestMapping(value = "/admin_hospital_delete.do", method = RequestMethod.GET)
	public ModelAndView hostpital_delete(String hid, String hsfile ) {

		ModelAndView model = new ModelAndView();
		HospitalVo hospitalVo = hospitalService.select(hid);

		model.addObject("hospitalVo", hospitalVo);
		model.setViewName("/admin/hospital/admin_hospital_delete");

		return model;
	}

	/**
	 * 병원 - 수정 처리
	 */
	@RequestMapping(value = "/hospital_update_proc.do", method = RequestMethod.POST)
	public String hospital_update_proc(HospitalVo hospitalVo, HttpServletRequest request) 
																	throws Exception{
		String viewName = "";
		
		String oldFileName = hospitalVo.getHsfile();
		
		int result = hospitalService.update(fileService.fileCheck(hospitalVo));
		if (result == 1) {
			if(hospitalVo.getHfile() !=null && !hospitalVo.getHfile().equals("")) {
				fileService.fileSave(hospitalVo, request);
				fileService.fileDelete(hospitalVo, request, oldFileName);
			}
			viewName = "redirect:/admin_hospital_list.do";
		} else {
			
		}

		return viewName;
	}

	/**
	 * 癰귣쵐�뜚 - 占쎈땾占쎌젟
	 */
	@RequestMapping(value = "/admin_hospital_update.do", method = RequestMethod.GET)
	public ModelAndView hostpital_update(String hid) {

		ModelAndView model = new ModelAndView();
		HospitalVo hospitalVo = hospitalService.select(hid);

		model.addObject("hospitalVo", hospitalVo);
		model.setViewName("/admin/hospital/admin_hospital_update");

		return model;
	}

	/**
	 * �솻洹ｌ탳占쎈쐸 - �뜝�럡留믣뜝�럡�돪�뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕
	 */
	@RequestMapping(value = "/admin_hospital_content.do", method = RequestMethod.GET)
	public ModelAndView hostpital_content(String hid) {

		ModelAndView model = new ModelAndView();
		HospitalVo hospitalVo = hospitalService.select(hid);

		model.addObject("hospitalVo", hospitalVo);
		model.setViewName("/admin/hospital/admin_hospital_content");

		return model;
	}

	/**
	 * 癰귣쵐�뜚 - 占쎄맒占쎄쉭
	 */
	@RequestMapping(value = "/hospital_detail_proc.do", method = RequestMethod.POST)
	public String hostpital_detail_proc(HospitalVo hospitalVo, HttpServletRequest request) throws Exception {
		String viewName = "";
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";

		if (hospitalVo.getFile1().getOriginalFilename() != null
				&& !hospitalVo.getFile1().getOriginalFilename().equals("")) {

			UUID uuid = UUID.randomUUID();
			String hfile = hospitalVo.getFile1().getOriginalFilename();
			String hsfile = uuid + "_" + hfile;

			hospitalVo.setHfile(hfile);
			hospitalVo.setHsfile(hsfile);
		} else {
			System.out.println("占쎈솁占쎌뵬 X");
		}

		int result = hospitalService.insert(hospitalVo);
		if (result == 1) {
			File saveFile = new File(root_path + attach_path + hospitalVo.getHsfile());
			hospitalVo.getFile1().transferTo(saveFile);

			viewName = "redirect:/admin_hospital_list.do";
		} else {

		}
		return viewName;
	}

	/**
	 * �솻洹ｌ탳占쎈쐸 - �뇦猿볦삕�뜝�럡�돰
	 */
	@RequestMapping(value = "/admin_hospital_detail.do", method = RequestMethod.GET)
	public String hostpital_list_detail() {
		return "/admin/hospital/admin_hospital_detail";
	}

	/**
	 * �솻洹ｌ탳占쎈쐸 - �뇦猿볦삕�뜝�럡�돰 �뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕
	 */
	@RequestMapping(value = "/admin_hospital_list_detail.do", method = RequestMethod.GET)
	public ModelAndView hostpital_detail(String hname) {
		ModelAndView model = new ModelAndView();
		ArrayList<HospitalVo> list = hospitalService.search(hname);

		model.addObject("list", list);
		model.setViewName("/admin/hospital/admin_hospital_list_detail");

		return model;
	}

}