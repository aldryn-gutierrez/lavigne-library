package org.lavignelibrary.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.lavignelibrary.domain.Book;
import org.lavignelibrary.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao {
	
	public void save(User user){
		sess().save(user);
		
	}
	
	public User getById(int id) {
		return (User) sess().get(User.class, id);		
	}

	public User getByUsernameAndPassword(String username, String password) {
		
		Criteria criteria = sess().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		
		return (User)criteria.uniqueResult();
	}

	public User getByUsername(String name) {
		
		Criteria criteria = sess().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", name));

		return (User)criteria.uniqueResult();
	}

	public boolean isValidByName(String username) {

		User user = this.getByUsername(username);
		
		return (user != null) ? true : false;
		
	}

	public List<User> searchBookBySpecificField(String searchText,
			String searchField) {


		Criteria criteria = sess().createCriteria(User.class);
		
		
		if(searchField.equalsIgnoreCase("firstname")){
			criteria.createCriteria("userDetails").add(Restrictions.eq("firstname", searchText));			
		} else if(searchField.equalsIgnoreCase("lastname")){
			criteria.createCriteria("userDetails").add(Restrictions.eq("lastname", searchText));			
		} else if(searchField.equalsIgnoreCase("organizationId")){
			criteria.createCriteria("userDetails").add(Restrictions.eq("organizationIdNumber", Integer.parseInt(searchText)));			
		} else if(searchField.equalsIgnoreCase("occupation")){
			criteria.createCriteria("userDetails").createCriteria("occupation").add(Restrictions.eq("description", searchText));					
		} else {
			
			if(searchField.equalsIgnoreCase("username")){
				criteria.add(Restrictions.eq("username", searchText));				
			}
			
		}
		
		
		
		return criteria.list();
		
	}

}
