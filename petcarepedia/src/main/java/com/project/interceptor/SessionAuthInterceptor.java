package com.project.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.project.vo.SessionVo;

public class SessionAuthInterceptor extends HandlerInterceptorAdapter{
	/**
	 * preHandle : Controller�� �����ϱ� ���� ����Ǵ� �޼ҵ�
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, 
								HttpServletResponse response, 
								Object handler)
										throws Exception {
		//Ŭ���̾�Ʈ(������)�� ��û Ȯ�� - ���� ��ü ��������
		HttpSession session = request.getSession();
		
		//sid Ȯ���ϱ�
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		if(svo==null) {
			//�α������� ���� ���� -> �α��������� ����
			response.sendRedirect("/petcarepedia/login.do");
			return false;
		}
		
		return true;
	}
}
