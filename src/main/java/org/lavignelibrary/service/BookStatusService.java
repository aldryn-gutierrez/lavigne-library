package org.lavignelibrary.service;

import org.lavignelibrary.dao.BookStatusDao;
import org.lavignelibrary.domain.BookStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookStatusService {
	
	@Autowired
	private BookStatusDao bookStatusDao;
	
	@Transactional
	public void update(BookStatus bks){
		
		bookStatusDao.update(bks);
		
	}
	
	@Transactional
	public BookStatus getById(int id) {

		return bookStatusDao.getById(id);
		
	}

}
