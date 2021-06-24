package com.koreait.site0622.model.comments.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.site0622.model.domain.Comments;
import com.koreait.site0622.model.mybatis.MybatisConfigManager;

public class MybatisCommentsDAO implements CommentsDAO{
	MybatisConfigManager configManager = MybatisConfigManager.getInstance();

	public int insert(Comments comments) {
		SqlSession sqlSession = configManager.getSession(); //쿼리수행 객체얻기
		int result = sqlSession.insert("Comments.insert",comments);
		sqlSession.commit(); //DML이라서
		configManager.closeSession(sqlSession);
		return result;
	}

	public List selectAll() {
		return null;
	}

	public Comments select(int comments_id) {
		return null;
	}

	public int update(Comments comments) {
		return 0;
	}

	public int delete(int comments_id) {
		return 0;
	}


	public List selectByNewsId(int news_id) {
		SqlSession sqlSession = configManager.getSession(); //쿼리수행 객체얻기
		List list=sqlSession.selectList("Comments.selectByNewsId", news_id);
		configManager.closeSession(sqlSession);
		return list;
	}
}
