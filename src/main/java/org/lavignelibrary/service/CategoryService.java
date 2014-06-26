package org.lavignelibrary.service;

import java.util.List;

import org.lavignelibrary.dao.CategoryDao;
import org.lavignelibrary.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	@Transactional
	public Category get(int id) {

		return categoryDao.get(id);
		
		
	}

	@Transactional
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return categoryDao.getAll();
	}
	
	
	
	

}
