package com.koreait.shoppingmall.model.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.shoppingmall.domain.TopCategory;
import com.koreait.shoppingmall.model.repository.category.TopCategoryDAO;

@Service
public class TopCategoryServiceImpl implements TopCategoryService{
	@Autowired
	private TopCategoryDAO topCategoryDAO;

	@Override
	public List getSubCount() {

		return topCategoryDAO.getSubCount();
	}

	@Override
	public List selectAll() {

		return topCategoryDAO.selectAll();
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

}
