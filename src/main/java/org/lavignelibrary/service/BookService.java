package org.lavignelibrary.service;

import java.util.List;

import org.lavignelibrary.dao.BookDao;
import org.lavignelibrary.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;

	@Transactional
	public void save(Book book) {

		bookDao.save(book);
			
	}

	@Transactional
	public List<Book> searchBookBySpecificField(String searchText, String searchField) {
		
		return bookDao.searchBookBySpecificField(searchText, searchField);
		
	}

	@Transactional
	public Book getById(int id) {

		return bookDao.searchBookById(id);
		
	}

	@Transactional
	public Book reserveBookById(int id) {

		Book book = bookDao.getById(id);
		
		if(book == null){
			return null;
		} else {
			
			//Tell the Librarian to update the stock since you got a book, hence:
			book.getBookStatistics().setInShelves( book.getBookStatistics().getInShelves() - 1);
			book.getBookStatistics().setOutShelves( book.getBookStatistics().getOutShelves() + 1);
			book.getBookStatistics().setTimesBorrowed( book.getBookStatistics().getTimesBorrowed() + 1);
			return book;
			
		}
		
		
		
		
	}

	

	
	
	
	

}
