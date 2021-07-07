package com.koreait.springmvc0707.model.board.service;

import java.util.List;

import org.apache.catalina.Service;

import com.koreait.springmvc0707.model.board.repository.BoardDAO;
import com.koreait.springmvc0707.model.domain.Board;

import lombok.Setter;

//서비스를 구현한 객체
@Setter
public class BoardServiceImpl implements BoardService{
	
	private BoardDAO boardDAO; //스프링의 컨테이너로 부터 주입받자!!(DI)

	
	public List selectAll() {
		System.out.println("서비스의 selectAll() 호출");
		//서비스에서 리스트 반환처리
		return boardDAO.selectAll();
	}

	
	public void insert(Board board) {
		
		
	}

	
	public Board select(int baord_id) {
		return boardDAO.select(baord_id);
	}

	
	public void update(Board board) {
		
		
	}

	
	public void delete(int board_id) {
		
		
	}

}
