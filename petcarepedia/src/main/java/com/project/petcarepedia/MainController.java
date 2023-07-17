package com.project.petcarepedia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.project.service.HospitalService;
import com.project.service.ReviewService;
import com.project.service.SPWordService;
import com.project.vo.HospitalVo;
import com.project.vo.ReviewVo;
import com.project.vo.SPWordVo;

@Controller
public class MainController {
	@Autowired
	private HospitalService hospitalService;

	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private SPWordService spwordService;
	
	/**
	 * index.do
	 */
	@RequestMapping(value="/index.do",method=RequestMethod.GET)
	public ModelAndView index(String login_result,String logout_result) {
		ModelAndView model = new ModelAndView();
		model.addObject("login_result", login_result);
		model.addObject("logout_result", logout_result);
		model.setViewName("index");
		return model;
	}
	
	/**
	 * header.do
	 */
	@RequestMapping(value="/header.do",method=RequestMethod.GET)
	public String header() {
		return "header";
	}
	
	/**
	 * main_search_proc.do
	 */
	@RequestMapping(value="/main_search_proc.do",method=RequestMethod.GET)
	public ModelAndView main_search_proc(String hname) {
		ModelAndView model = new ModelAndView();
		
		spwordService.getInsert(hname);
		List<Object> list = hospitalService.search(hname);
		
		model.addObject("list", list);
		model.addObject("size", list.size());
		model.addObject("shname", hname);
		model.setViewName("/search/search_main");
		
		return model;
	}
	
	/**
	 * footer.do
	 */
	@RequestMapping(value="/footer.do",method=RequestMethod.GET)
	public String footer() {
		return "footer";
	}
	
	/**
	 * splist_data.do
	 */
	@RequestMapping(value="/splist_data.do",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String splist_data() {
		ArrayList<SPWordVo> list = spwordService.getSelect();
		
		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();
		
		if(list != null && list.size() != 0) {
			for(SPWordVo spwordVo : list) {
				JsonObject jobj = new JsonObject();
				jobj.addProperty("rno", spwordVo.getRno());
				jobj.addProperty("word", spwordVo.getWord());
				jobj.addProperty("wcnt", spwordVo.getWcnt());
				
				jarray.add(jobj);
			}
			
			jlist.add("jlist", jarray);
		} else {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("data", "null");
			jlist.add("null", jobj);
		}
		
		return new Gson().toJson(jlist);
	}
	
	/**
	 * best_review_list.do
	 */
	@RequestMapping(value="/best_review_list.do",method=RequestMethod.GET)
	public ModelAndView best_review_list(String rpage) {
		ModelAndView model = new ModelAndView();
		
		//페이징 처리 - startCount, endCount 구하기
		int startCount = 0;
		int endCount = 0;
		int pageSize = 3;	//한페이지당 게시물 수
		int reqPage = 1;	//요청페이지	
		int pageCount = 0;	//전체 페이지 수
		int dbCount = reviewService.getTotalRowCount();	//전체 행수
		if(dbCount>9) dbCount=9;
		
		//총 페이지 수 계산
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}
				
		//요청 페이지 계산
		if(rpage != null){
			reqPage = Integer.parseInt(rpage);
			startCount = (reqPage-1) * pageSize+1; 
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = pageSize;
		}
				
		ArrayList<ReviewVo> list = reviewService.getSelect(startCount, endCount);
		
		model.addObject("list", list);
		model.addObject("totals", dbCount);
		model.addObject("pageSize", pageSize);
		model.addObject("maxSize", pageCount);
		model.addObject("rpage", reqPage);
		
		model.setViewName("best_review_list");
		
		return model;
	}
	
	/**
	 * main_map.do
	 */
	@RequestMapping(value="/main_map.do",method=RequestMethod.GET)
	public String main_map() {
		return "main_map";
	}
	
	/**
	 * main_map_data.do
	 */
	@RequestMapping(value="/main_map_data.do",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String main_map_data(String gloc) {
		ArrayList<HospitalVo> list = hospitalService.searchGloc(gloc);
		
		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();
		
		for(HospitalVo hospitalVo : list) {
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
	
	
	/** 404 error **/
	@RequestMapping(value="//error.do", method=RequestMethod.GET)
	public String error() {
		
		return "error";
	}
	
}
