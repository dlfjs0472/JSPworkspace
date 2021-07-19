package test;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//웹 서버가 가동될때를 감지하여, 원하는 메시지 심기
public class MyListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		//웹 어플리케이션을 가동할때 호출되는 메서드
		System.out.println("서버가동");
		
		ServletContext servletContext=sce.getServletContext();
		String value = servletContext.getInitParameter("contextConfigLocation");
		
		servletContext.setAttribute("obj", value);
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		//웹 어플리케이션을 중지할때 호출되는 메서드
		System.out.println("서버중지");
	}

	
	
}
