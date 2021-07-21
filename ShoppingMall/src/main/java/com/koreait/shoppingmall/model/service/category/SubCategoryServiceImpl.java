package com.koreait.shoppingmall.model.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.shoppingmall.domain.SubCategory;
import com.koreait.shoppingmall.model.repository.category.SubCategoryDAO;


@Service
public class SubCategoryServiceImpl implements SubCategoryService{
	@Autowired
	private SubCategoryDAO subCategoryDAO;

	@Override
	public List selectAllById(int topcategory_id) {
		return subCategoryDAO.selectAllById(topcategory_id);
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
