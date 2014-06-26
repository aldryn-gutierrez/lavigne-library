package org.lavignelibrary.service;

import org.lavignelibrary.dao.SerialKeyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SerialKeyService {
	
	@Autowired
	private SerialKeyDao serialKeyDao;
	
	@Transactional
	public boolean validateKey(String sk){
		
		return serialKeyDao.validateKey(sk);
		
	}
	
	@Transactional
	public void setKeyAsUsed(String sk){
		
		serialKeyDao.useSerialKey(sk);
		
	}
	

}
