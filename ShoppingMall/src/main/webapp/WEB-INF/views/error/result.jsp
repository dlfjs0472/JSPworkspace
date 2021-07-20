<%@ page contentType="text/html;charset=UTF-8"%>
<%
	RuntimeException e =(RuntimeException)request.getAttribute("e"); //에러 객체
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
이용에 불편을 드려 죄송합니다. 하지만 본인 잘못이잖아요 그쵸?
<%=e.getMessage() %>
</body>
</html>