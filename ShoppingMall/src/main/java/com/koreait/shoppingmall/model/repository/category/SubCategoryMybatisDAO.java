package com.koreait.shoppingmall.model.repository.category;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.shoppingmall.domain.SubCategory;

@Repository
public class SubCategoryMybatisDAO implements SubCategoryDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public List selectAllById(int topcategory_id) {
		return sqlSessionTemplate.selectList("SubCategory.selectAllById", topcategory_id);
	}

	@Override
	public List selectAll() {

		return null;
	}

	@Override
	public SubCategory select(int subcategory_id) {

		return null;
	}

	@Override
	public void insert(SubCategory subCategory) {

		
	}

	@Override
	public void update(SubCategory subCategory) {

		
	}

	@Override
	public void delete(int subcategory_id) {

		
	}

}
