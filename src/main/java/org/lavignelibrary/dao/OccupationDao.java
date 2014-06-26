package org.lavignelibrary.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lavignelibrary.domain.Occupation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OccupationDao extends BaseDao {
	
	public Occupation get(int id){
				
		return (Occupation) sess().get(Occupation.class, id); 
		
	}

	public List<Occupation> getAll() {
		// TODO Auto-generated method stub
		return (List<Occupation>) sess().createQuery("From Occupation").list();
	}
	
	
}
