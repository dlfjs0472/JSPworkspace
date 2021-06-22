package com.koreait.site0622.model.mybatis;

import org.apache.ibatis.session.SqlSession;

import com.koreait.site0622.model.domain.Board;

public class Test {

	
	public static void main(String[] args) {
		//mybatis가 제대로 동작하는지 테스트 해보자!!
		MybatisConfigManager mybatisConfigManager = MybatisConfigManager.getInstance();
		
		//이미 SqlSession내부에서는 db와 접속이 처리되어있다..
		SqlSession sqlSession = mybatisConfigManager.getSession();
		Board board = new Board();
		board.setTitle("테스트중");
		board.setWriter("나님");
		board.setContent("내용 없음");
		
		//sqlSession.insert("쿼리문이 장성된 xml의 id", "파라미터"); //mybatis 프레임웍으로 하여금 insert를 수행하라!!
		int result = sqlSession.insert("com.koreait.site0622.model.board.domain.Board.insert", board);
		sqlSession.commit();
		if(result<1) { //실패
			System.out.println("실패");
		}else {
			System.out.println("성공");
		}
		mybatisConfigManager.closeSession(sqlSession);
	}
}
