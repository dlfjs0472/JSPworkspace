package com.koreait.mvcframework.model.movie;


//영화에 대한 조언을 판단하는 모델객체(플랫폼에 중립적, 따라서 웹,응용 모두 사용가능==재사용성)
public class MovieService {
	public String getAdvice(String movie) {
		String msg=null;
		if(movie.equals("미션임파서블")) {
			msg="톰형 사랑해";
		}else if(movie.equals("크루엘라")) {
			msg="안봐도 될꺼같은데";
		}else if(movie.equals("어바웃타임")) {
			msg="한번 보면 너의 인생 영화";
		}else if(movie.equals("어벤져스")) {
			msg="I love you 3000";
		}
		return msg;
	}
}
