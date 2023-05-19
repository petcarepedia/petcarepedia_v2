package com.project.petcarepedia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchController {
	/** search_main.do **/
	@RequestMapping(value="/search_main.do", method=RequestMethod.GET)
	public String search_main() {
		return "/search/search_main";
	}
	
	/** search_result.do **/
	@RequestMapping(value="/search_result.do", method=RequestMethod.GET)
	public String search_result() {
		return "/search/search_result";
	}
	
	/** search_reservation.do **/
	@RequestMapping(value="/search_reservation.do", method=RequestMethod.GET)
	public String search_reservation() {
		return "/search/search_reservation";
	}
	
	/** search_map.do **/
	@RequestMapping(value="/search_map.do", method=RequestMethod.GET)
	public String search_map() {
		return "/search/search_map";
	}
	
} // class