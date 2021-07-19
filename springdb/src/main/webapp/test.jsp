<%@ page contentType="text/html;charset=UTF-8"%>
<%
	request.setAttribute("msg1", "요청객체 데이터");
	session.setAttribute("msg2", "세션 객체데이터");
	application.setAttribute("msg3", "어플리케이션객체데이터");

%>
<a href="/result.jsp">심기완료</a>