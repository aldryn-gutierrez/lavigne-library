package org.lavignelibrary.dao;

import org.lavignelibrary.domain.BookStatus;
import org.springframework.stereotype.Repository;

@Repository
public class BookStatusDao extends BaseDao {
	
	public void save(BookStatus bks){
		sess().save(bks);
		
	}
	
	public void update(BookStatus bks){
		sess().update(bks);
	}
	
	public BookStatus getById(int id) {
		return (BookStatus) sess().get(BookStatus.class, id);		
	}

}
