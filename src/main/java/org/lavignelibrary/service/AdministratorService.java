package org.lavignelibrary.service;

import org.lavignelibrary.dao.AdministratorDao;
import org.lavignelibrary.domain.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdministratorService {
	
	@Autowired
	AdministratorDao administratorDao;
	
	
	@Transactional	
	public Administrator isValid(String username, String password) {
		
		return administratorDao.getByUsernameAndPassword(username, password);
		
	}

}
