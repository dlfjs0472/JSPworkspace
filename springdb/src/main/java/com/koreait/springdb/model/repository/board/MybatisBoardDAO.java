package com.koreait.springdb.model.repository.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.springdb.model.domain.Board;

@Repository //컴포넌트 스캔의 대상이 되어 자동 인스턴스 생성됨(without registration bean)
public class MybatisBoardDAO implements BoardDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List selectAll() {
		return sqlSessionTemplate.selectList("selectAll");
	}

	
	public void insert(Board board) {

		
	}

	
	public Board select(int board_id) {
		return sqlSessionTemplate.selectOne("Board.select",board_id);
	}

	
	public void update(Board board) {

		
	}

	
	public void delete(int board_id) {

		
	}

}
