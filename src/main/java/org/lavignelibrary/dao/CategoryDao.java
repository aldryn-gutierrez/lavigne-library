package org.lavignelibrary.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lavignelibrary.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends BaseDao {
	
	public Category get(int id){
				
		return (Category) sess().get(Category.class, id); 
		
	}

	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return (List<Category>) sess().createQuery("From Category").list();
	}
	
	
}
