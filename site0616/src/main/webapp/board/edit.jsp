<%@page import="site0616.model.domain.Board"%>
<%@page import="site0616.board.model.dao.BoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	BoardDAO boardDAO = new BoardDAO();
%>
<%
	
	//클라이언트인 detail.jsp 로 부터 4개의 파라미터 받자!!(한글 인코딩 해서)
	request.setCharacterEncoding("utf-8");
	String title=request.getParameter("title");
	String writer=request.getParameter("writer");
	String content=request.getParameter("content");
	String board_id=request.getParameter("board_id");
	
	//VO 값 채우기
	Board board = new Board(); //empty
	board.setTitle(title);
	board.setWriter(writer);
	board.setContent(content);
	board.setBoard_id(Integer.parseInt(board_id));
	
	
	int result=boardDAO.update(board);//수정 쿼리 수행
	
	out.print("<script>");
	if(result==0){
		out.print("alert('수정실패');");
		out.print("history.back();");
	}else{
		out.print("alert('수정성공');");
		out.print("location.href='/board/detail.jsp?board_id="+board_id+"';");
	}

	out.print("</script>");
	
%>