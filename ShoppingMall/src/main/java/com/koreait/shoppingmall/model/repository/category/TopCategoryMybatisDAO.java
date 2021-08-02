package com.koreait.shoppingmall.model.repository.category;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.shoppingmall.domain.TopCategory;

@Repository
public class TopCategoryMybatisDAO implements TopCategoryDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List getSubCount() {
		return sqlSessionTemplate.selectList("TopCategory.getSubCount");
	}

	@Override
	public List selectAll() {

		return sqlSessionTemplate.selectList("TopCategory.selectAll");
	}

	@Override
	public void insert(TopCategory topCategory) {

		
	}

	@Override
	public TopCategory select(int topCategory_id) {

		return null;
	}

	@Override
	public void update(TopCategory topCategory) {

		
	}

	@Override
	public void delete(int topCategory_id) {

		
	}

	@Override
	public List selectChild() {

		return sqlSessionTemplate.selectList("TopCategory.selectChild");
	}

}
