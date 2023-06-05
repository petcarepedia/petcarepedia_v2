package com.project.petcarepedia;

import java.io.File;
import java.util.ArrayList;
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
import com.project.dao.MemberDao;
import com.project.dao.ReviewDao;
import com.project.service.HospitalService;
import com.project.vo.BookingVo;
import com.project.vo.HospitalVo;
import com.project.vo.MemberVo;
import com.project.vo.ReviewVo;

@Controller
public class AdminController {

	@Autowired
	private HospitalService hospitalService;

	/**
	 * 리뷰 - 페이징 처리
	 */
	@RequestMapping(value = "/review_list.do", method = RequestMethod.GET)
	public ModelAndView review_list(String page) {
		ModelAndView model = new ModelAndView();
		ReviewDao reviewDao = new ReviewDao();
		
		int startCount = 0;
		int endCount = 0;
		int pageSize = 10; // �븳�럹�씠吏��떦 寃뚯떆臾� �닔
		int reqPage = 1; // �슂泥��럹�씠吏�
		int pageCount = 1; // �쟾泥� �럹�씠吏� �닔
		int dbCount = reviewDao.totalRowCount(); // DB�뿉�꽌 媛��졇�삩 �쟾泥� �뻾�닔
		
		if (dbCount % pageSize == 0) {
			pageCount = dbCount / pageSize;
		} else {
			pageCount = dbCount / pageSize + 3;
		}
		
		if (page != null) {
			reqPage = Integer.parseInt(page);
			startCount = (reqPage - 1) * pageSize + 1;
			endCount = reqPage * pageSize;
		} else {
			startCount = 1;
			endCount = 10;
		}
		
		ArrayList<ReviewVo> list = reviewDao.select(startCount, endCount);
		
		model.addObject("list", list);
		model.addObject("totals", dbCount);
		model.addObject("pageSize", pageSize);
		model.addObject("maxSize", pageCount);
		model.addObject("page", reqPage);
		
		model.setViewName("/admin/review/review_list");
		
		return model;
	}
	/**
	 * 예약 - 페이징 처리
	 */
	@RequestMapping(value = "/reserve_list.do", method = RequestMethod.GET)
	public ModelAndView reserve_list(String page) {
		ModelAndView model = new ModelAndView();
		BookingDao bookingDao = new BookingDao();
		
		int startCount = 0;
		int endCount = 0;
		int pageSize = 10; // �븳�럹�씠吏��떦 寃뚯떆臾� �닔
		int reqPage = 1; // �슂泥��럹�씠吏�
		int pageCount = 1; // �쟾泥� �럹�씠吏� �닔
		int dbCount = bookingDao.totalRowCount(); // DB�뿉�꽌 媛��졇�삩 �쟾泥� �뻾�닔

		if (dbCount % pageSize == 0) {
			pageCount = dbCount / pageSize;
		} else {
			pageCount = dbCount / pageSize + 3;
		}

		if (page != null) {
			reqPage = Integer.parseInt(page);
			startCount = (reqPage - 1) * pageSize + 1;
			endCount = reqPage * pageSize;
		} else {
			startCount = 1;
			endCount = 10;
		}

		ArrayList<BookingVo> list = bookingDao.select(startCount, endCount);

		model.addObject("list", list);
		model.addObject("totals", dbCount);
		model.addObject("pageSize", pageSize);
		model.addObject("maxSize", pageCount);
		model.addObject("page", reqPage);

		model.setViewName("/admin/reserve/reserve_list");

		return model;
	}

	/**
	 * 회원 - 페이징 처리
	 */
	@RequestMapping(value = "/member_list.do", method = RequestMethod.GET)
	public ModelAndView member_list(String page) {
		ModelAndView model = new ModelAndView();
		MemberDao memberDao = new MemberDao();
		
		int startCount = 0;
		int endCount = 0;
		int pageSize = 10; // �븳�럹�씠吏��떦 寃뚯떆臾� �닔
		int reqPage = 1; // �슂泥��럹�씠吏�
		int pageCount = 1; // �쟾泥� �럹�씠吏� �닔
		int dbCount = memberDao.totalRowCount(); // DB�뿉�꽌 媛��졇�삩 �쟾泥� �뻾�닔

		if (dbCount % pageSize == 0) {
			pageCount = dbCount / pageSize;
		} else {
			pageCount = dbCount / pageSize + 3;
		}

		if (page != null) {
			reqPage = Integer.parseInt(page);
			startCount = (reqPage - 1) * pageSize + 1;
			endCount = reqPage * pageSize;
		} else {
			startCount = 1;
			endCount = 10;
		}

		ArrayList<MemberVo> list = memberDao.select(startCount, endCount);

		model.addObject("list", list);
		model.addObject("totals", dbCount);
		model.addObject("pageSize", pageSize);
		model.addObject("maxSize", pageCount);
		model.addObject("page", reqPage);

		model.setViewName("/admin/member/member_list");

		return model;
	}

	/**
	 * �병원 - 페이징 처리
	 */
	@RequestMapping(value = "/hospital_list.do", method = RequestMethod.GET)
	public ModelAndView hospital_list(String page) {
		ModelAndView model = new ModelAndView();

		// �럹�씠吏� 泥섎━ - startCount, endCount 援ы븯湲�
		int startCount = 0;
		int endCount = 0;
		int pageSize = 10; // �븳�럹�씠吏��떦 寃뚯떆臾� �닔
		int reqPage = 1; // �슂泥��럹�씠吏�
		int pageCount = 1; // �쟾泥� �럹�씠吏� �닔
		int dbCount = hospitalService.totalRowCount(); // DB�뿉�꽌 媛��졇�삩 �쟾泥� �뻾�닔

		// 珥� �럹�씠吏� �닔 怨꾩궛
		if (dbCount % pageSize == 0) {
			pageCount = dbCount / pageSize;
		} else {
			pageCount = dbCount / pageSize + 3;
		}

		// �슂泥� �럹�씠吏� 怨꾩궛
		if (page != null) {
			reqPage = Integer.parseInt(page);
			startCount = (reqPage - 1) * pageSize + 1;
			endCount = reqPage * pageSize;
		} else {
			startCount = 1;
			endCount = 10;
		}

		ArrayList<HospitalVo> list = hospitalService.select(startCount, endCount);

		model.addObject("list", list);
		model.addObject("totals", dbCount);
		model.addObject("pageSize", pageSize);
		model.addObject("maxSize", pageCount);
		model.addObject("page", reqPage);

		model.setViewName("/admin/hospital/hospital_list");

		return model;
	}

	/**
	 * 예약 - 검색
	 */
	@RequestMapping(value = "/reserve_list_detail.do", method = RequestMethod.GET)
	public ModelAndView reserve_list_detail(String mid) {
		ModelAndView model = new ModelAndView();
		BookingDao bookingDao = new BookingDao();
		ArrayList<BookingVo> bookingVo = bookingDao.select();

		model.addObject("bookindVo", bookingVo);
		model.setViewName("/admin/reserve/reserve_list_detail");

		return model;
	}

	/**
	 * 예약 - 검색 처리
	 */
	@RequestMapping(value = "/reserve_list_data.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String reserve_list_data(String mid) {
		BookingDao bookingDao = new BookingDao();
		ArrayList<BookingVo> list = bookingDao.search5(mid);

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
	 * 신고 - 리뷰 상세 페이지
	 */
	@RequestMapping(value = "/review_detail.do", method = RequestMethod.GET)
	public ModelAndView review_detail(String rid) {
		ModelAndView model = new ModelAndView();
		ReviewDao reviewDao = new ReviewDao();
		ReviewVo reviewVo = reviewDao.select(rid);

		model.addObject("reviewVo", reviewVo);
		model.setViewName("/admin/review/review_detail");

		return model;
	}

	/**
	 * 회원 - 검색창
	 * */
	@RequestMapping(value = "/member_list_data.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String member_list_data(String mid) {
		MemberDao memberDao = new MemberDao();
		ArrayList<MemberVo> list = memberDao.search(mid);

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
	 * 회원 - 상세페이지
	 */
	@RequestMapping(value = "/member_detail.do", method = RequestMethod.GET)
	public ModelAndView member_detail(String mid) {

		ModelAndView model = new ModelAndView();
		MemberDao memberDao = new MemberDao();
		MemberVo memberVo = memberDao.select(mid);

		model.addObject("memberVo", memberVo);
		model.setViewName("/admin/member/member_detail");

		return model;
	}

	/**
	 * 병원 - 삭제 처리
	 */
	@RequestMapping(value = "/hospital_delete_proc.do", method = RequestMethod.POST)
	public String hospital_delete_proc(String hid) {
		String viewName = "";
		int result = hospitalService.delete(hid);
		if (result == 1) {
			viewName = "redirect:/hospital_list.do";
		} else {

		}

		return viewName;
	}

	/**
	 * 병원 - 삭제 페이지
	 */
	@RequestMapping(value = "/hospital_delete.do", method = RequestMethod.GET)
	public ModelAndView hostpital_delete(String hid) {

		ModelAndView model = new ModelAndView();
		HospitalVo hospitalVo = hospitalService.select(hid);

		model.addObject("hospitalVo", hospitalVo);
		model.setViewName("/admin/hospital/hospital_delete");

		return model;
	}

	/**
	 * 병원 수정 처리
	 */
	@RequestMapping(value = "/hospital_update_proc.do", method = RequestMethod.POST)
	public String hospital_update_proc(HospitalVo hospitalVo) {
		String viewName = "";
		int result = hospitalService.update(hospitalVo);
		if (result == 1) {
			viewName = "redirect:/hospital_list.do";
		} else {
			// 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 호占쏙옙
		}

		return viewName;
	}

	/**
	 * 蹂묒썝 - �닔�젙�럹�씠吏�
	 */
	@RequestMapping(value = "/hospital_update.do", method = RequestMethod.GET)
	public ModelAndView hostpital_update(String hid) {

		ModelAndView model = new ModelAndView();
		HospitalVo hospitalVo = hospitalService.select(hid);

		model.addObject("hospitalVo", hospitalVo);
		model.setViewName("/admin/hospital/hospital_update");

		return model;
	}

	/**
	 * 蹂묒썝 - �긽�꽭�럹�씠吏�
	 */
	@RequestMapping(value = "/hospital_content.do", method = RequestMethod.GET)
	public ModelAndView hostpital_content(String hid) {

		ModelAndView model = new ModelAndView();
		HospitalVo hospitalVo = hospitalService.select(hid);

		model.addObject("hospitalVo", hospitalVo);
		model.setViewName("/admin/hospital/hospital_content");

		return model;
	}

	/**
	 * 蹂묒썝- �벑濡� �럹�씠吏�
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
			System.out.println("파일 X");
		}

		int result = hospitalService.insert(hospitalVo);
		if (result == 1) {
			File saveFile = new File(root_path + attach_path + hospitalVo.getHsfile());
			hospitalVo.getFile1().transferTo(saveFile);

			viewName = "redirect:/hospital_list.do";
		} else {

		}
		return viewName;
	}

	/**
	 * 蹂묒썝 - 寃��깋
	 */
	@RequestMapping(value = "/hospital_detail.do", method = RequestMethod.GET)
	public String hostpital_list_detail() {
		return "/admin/hospital/hospital_detail";
	}

	/**
	 * 蹂묒썝 - 寃��깋 �럹�씠吏�
	 */
	@RequestMapping(value = "/hospital_list_detail.do", method = RequestMethod.GET)
	public ModelAndView hostpital_detail(String hname) {
		ModelAndView model = new ModelAndView();
		ArrayList<HospitalVo> list = hospitalService.search(hname);

		model.addObject("list", list);
		model.setViewName("/admin/hospital/hospital_list_detail");

		return model;
	}

	/**
	 * 蹂묒썝 - 寃��깋李� �솢�꽦�솕
	 */
	@RequestMapping(value = "/hospital_list_data.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String hospital_list_data(String hname) {
		ArrayList<HospitalVo> list = hospitalService.search(hname);

		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();

		for (HospitalVo hospitalVo : list) {
			JsonObject jobj = new JsonObject(); // {}
			jobj.addProperty("hid", hospitalVo.getHid());
			jobj.addProperty("hname", hospitalVo.getHname());
			jobj.addProperty("ntime", hospitalVo.getNtime());
			jobj.addProperty("animal", hospitalVo.getAnimal());
			jobj.addProperty("holiday", hospitalVo.getHoliday());

			jarray.add(jobj);
		}
		jlist.add("jlist", jarray);

		return new Gson().toJson(jlist);
	}

}