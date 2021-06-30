package com.koreait.mvcframework.controller.blood;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvcframework.controller.Controller;
import com.koreait.mvcframework.model.blood.BloodService;

//혈액형 요청을 처리하는 컨트롤러 클래스
public class BloodController implements Controller{
	BloodService service;
	
	public BloodController() {
		service = new BloodService();
	}

	public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blood=request.getParameter("blood");

		String msg= service.getAdvice(blood); //DispatcherServlet 3단계
		
		//요청 객체에 데이터 저장!! //DispatcherServlet 4단계
		request.setAttribute("msg", msg); //request객체는 사실 Map임 
	}

	public String getViewName() {
		return "/blood/result.jsp";
	}
	
}
