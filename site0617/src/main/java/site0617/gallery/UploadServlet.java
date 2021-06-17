package site0617.gallery;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class UploadServlet extends HttpServlet{
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=uft-8");
		PrintWriter out = response.getWriter();
		out.print("제가 업로드 처리할께요");
		
		request.setCharacterEncoding("utf-8");
		
	}
}
