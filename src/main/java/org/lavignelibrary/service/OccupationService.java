package org.lavignelibrary.service;

import java.util.List;

import org.lavignelibrary.dao.OccupationDao;
import org.lavignelibrary.domain.Occupation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OccupationService {
	
	@Autowired
	private OccupationDao occupationDao;

	@Transactional
	public Occupation get(int id) {

		return occupationDao.get(id);
		
		
	}

	@Transactional
	public List<Occupation> getAll() {
		// TODO Auto-generated method stub
		return occupationDao.getAll();
	}
	
	
	
	

}
