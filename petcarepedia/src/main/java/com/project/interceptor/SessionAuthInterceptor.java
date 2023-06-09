package com.project.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.project.vo.SessionVo;

public class SessionAuthInterceptor extends HandlerInterceptorAdapter{
	/**
	 * preHandle : Controller에 접근하기 전에 수행되는 메소드
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, 
								HttpServletResponse response, 
								Object handler)
										throws Exception {
		//클라이언트(브라우저)의 요청 확인 - 세션 객체 가져오기
		HttpSession session = request.getSession();
		
		//sid 확인하기
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		if(svo==null) {
			//로그인하지 않은 상태 -> 로그인폼으로 전송
			response.sendRedirect("/petcarepedia/login.do");
			return false;
		} else {
			if(!svo.getMid().equals("admin")) {
				String requestURI = request.getRequestURI();
				 if (requestURI.startsWith("/petcarepedia/admin_")) {
					response.sendRedirect("/petcarepedia/index.do");
					return false;
				}
			}
			
		}
		
		return true;
	}
}
