package site0617.gallery;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import site0617.model.domain.Gallery;
import site0617.model.gallery.dao.GalleryDAO;
import site0617.util.FileManager;

//이미 jsp로도 업로드 처리가 가능하겠으나, 서블릿을 다시 한번 공부해보고자 이 클래스를 작성하는 것임!!
public class UploadServlet extends HttpServlet{
   ServletContext context;
   GalleryDAO galleryDAO;
   
   public void init(ServletConfig config) throws ServletException {
      context = config.getServletContext();
      galleryDAO = new GalleryDAO();
   }
   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html;charset=utf-8");      //jsp의 ??영역에 해당
      // @page contentType = "text/html;charset=utf-8"에 해당
      
      PrintWriter out = response.getWriter();      //jsp에서의 out.내장객체의 print()메소드 호출에 해당
      out.print("제가 업로드 처리할게요");      // <%="제가 업로드 처리할게요" %> or <% out.print("");%> 와 동일
      
      request.setCharacterEncoding("utf-8");      //jsp의 request 객체의 setCharacterEncoding()과 동일
      
      // 요청 파라미터 받기 (인코딩 되어 전송되므로, 이를 해석(decode)할 컴포넌트가 사용되어야 한다.
      /* 아래처럼 경로를 개발자가 직접 구할 경우, 시스템에 의존적이 되므로, 이 웹 어플리케이션을 다른 기반의 플랫폼에서 배포해
      실행할 때 문제가 발생할 수 있다.
      해결책 = 프로그래밍적으로 경로를 동적으로 얻어와서 처리하면 된다. => 개발자가 하지말자!
      현재 어플리케이션에 대한 정보를 얻을 수 있는 javaEE의 객체를 이용해본다! */
      String path = context.getRealPath("/data");
      out.print(path);
      
      //String path = "C:/0_korea202102_jspworkspace/site0617/src/main/webapp/data";
      
      // 첫번째 생성자는 파일명이 영문이 아닌 경우 한글이 깨진다.
      //MultipartRequest multi = new MultipartRequest(request, path);         // path = "저장경로". 하지만 원래는 이렇게 직접 지정은 안한다. 말도 안되는 짓...
      
      // 두번째 생성자는 업로드 용량을 제한할 수 있다.
      // 숫자KB! 1024KB = 1MB
      
      // 네번쨰 생성자는 업로드 용량을 제한 + 파일명의 인코딩 처리 (한글 안 깨지게)
      
      int maxSize = 6*1024*1024;      //6MB!
      //int maxSize = 500;      //500byte = 거의 모든 파일이 안 올라감ㅋㅋㅋ
      try {
         MultipartRequest multi = new MultipartRequest(request, path, maxSize, "utf-8");
         out.print("<br>업로드 성공 <br>");
         
         // 이미 서버에 업로드된 파일의 이름을 바꾸자!
         File file = multi.getFile("myfile");      //이미 업로드된 파일 얻기
         //File destination = new File("새롭게 생성될 파일의 경로와 이름")
         long time = System.currentTimeMillis();
         //file.substring(가장 마지막 점의 index 바로 다음부터 마지막 문자열까지);      확장자 구하기
         
         String destName=time + "." + FileManager.getExt(file.getName()); //새로운 파일명
         File dest = new File(path + "/" +destName);      //새로 만들어질 파일명
         file.renameTo(dest);
         
         out.print("<br> 업로드에 성공 <br>");
         
         // 텍스트 파라미터 받기!
         String title = multi.getParameter("title");
         String writer = multi.getParameter("writer");
         String content = multi.getParameter("content");

         
         //DB에 넣기!!
         Gallery gallery = new Gallery(); //empty
         gallery.setTitle(title);//제목
         gallery.setWriter(writer);//작성자
         gallery.setContent(content);//내용
         gallery.setFilename(destName);//새로운 파일명
         
         
         int result = galleryDAO.insert(gallery);
         if(result==0) {
        	 out.print("등록실패");
         }else {
        	 out.print("등록성공");
        	 //리스트요청
        	 response.sendRedirect("/gallery/list.jsp"); //지정한 url로 다시 재접속을 명령(클라이언트에게..)
         }
         
         
      } catch (IOException e) {
         out.print("<br>업로드 실패 : 제한 용량을 확인해보세요<br>");
         e.printStackTrace();      // 원인을 분석할 수 있도록 스택구조로 출력 (개발자를 위한 것)
      }
      
      out.print("<br>업로드 완료 <br>");
      
   }
   
}