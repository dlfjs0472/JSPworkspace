package com.koreait.model2app.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.board.dao.BoardDAO;
import com.koreait.model2app.model.board.dao.JdbcBoardDAO;
import com.koreait.model2app.model.board.dao.MybatisBoardDAO;
import com.koreait.model2app.model.domain.Board;

//게시판의 상세보기 요청을 처리하는 하위 컨트롤러
public class DetailController implements Controller{
	BoardDAO boardDAO;
	
	public DetailController() {
		//boardDAO = new MybatisBoardDAO();
		
		
		boardDAO = new JdbcBoardDAO();
		
	}
	//3단계 : 알맞는 객체에 일시킨다
	//4단계 : 결과가 있다면 결과저장(형님 컨트롤러가 사용할 수 있는 접근 장소)
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String board_id = request.getParameter("board_id"); //파라미터 받기
		
		Board board = boardDAO.select(Integer.parseInt(board_id));
		//4단계 : 결과 저장(결과 jsp가 꺼낼수 있도록)
		request.setAttribute("board", board);
		
	}

	
	public String getViewName() {
		
		return "/result/board/detail";
	}

	
	public boolean isForward() {
		
		return true;
	}

}
