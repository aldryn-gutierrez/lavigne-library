package org.lavignelibrary.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.lavignelibrary.domain.Book;
import org.lavignelibrary.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao extends BaseDao {
	
	public void save(Book bk){
		sess().save(bk);
		
	}
	
	public Book getById(int id) {
		return (Book) sess().get(Book.class, id);		
	}

	public List<Book> searchBookBySpecificField(String searchText, String searchField) {
		// TODO Auto-generated method stub
		Criteria criteria = sess().createCriteria(Book.class);
		
		
		if(searchField.equalsIgnoreCase("Author")){
			criteria.createCriteria("bookDetails").add(Restrictions.eq("author", searchText));			
		} else if(searchField.equalsIgnoreCase("Publisher")){
			criteria.createCriteria("bookDetails").add(Restrictions.eq("publisher", searchText));			
		} else if(searchField.equalsIgnoreCase("Category")){
			criteria.createCriteria("bookDetails").createCriteria("category").add(Restrictions.eq("description", searchText));			
		} else if(searchField.equalsIgnoreCase("ISBN")){
			criteria.createCriteria("bookDetails").add(Restrictions.eq("ISBN", searchText));					
		} else {
			
			if(searchField.equalsIgnoreCase("Title")){
				criteria.createCriteria("bookDetails").add(Restrictions.eq("title", searchText));				
			}
			
		}
		
		
		
		return criteria.list();
	}

	public Book searchBookById(int id) {

		Criteria criteria = sess().createCriteria(Book.class);
		criteria.add(Restrictions.eq("id", id));
		
		return (Book)criteria.uniqueResult();
		
	}

}
