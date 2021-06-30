package com.koreait.mvcframework.controller.movie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvcframework.controller.Controller;
import com.koreait.mvcframework.model.movie.MovieService;

//영화에 대한 요청을 처리하는 컨트롤러
public class MovieController implements Controller{
	MovieService service;
	
	public MovieController() {
		service = new MovieService();
	}
	
	public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movie = request.getParameter("movie"); //파라미터 받기!!!
		
		//로직은 재서용 가능성이 있으므로 컨트롤러에 소속시키지 말고, 별도의 물리적 파일로 분리
		String msg = service.getAdvice(movie);//DispatcherServlet 3단계
		
		//결과를 request객체에 심기!!//요청 객체에 데이터 저장!! //DispatcherServlet 4단계
		request.setAttribute("msg", msg);
	}
	
	public String getViewName() {
		return "/movie/result.jsp";
	}
}
