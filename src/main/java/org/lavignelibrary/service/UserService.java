package org.lavignelibrary.service;

import java.util.List;

import org.lavignelibrary.dao.UserDao;
import org.lavignelibrary.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	@Transactional
	public void save(User user) {

		userDao.save(user);
			
	}
	
	@Transactional	
	public User isValid(String username, String password) {
		
		return userDao.getByUsernameAndPassword(username, password);
		
	}

	@Transactional
	public User getByName(String name) {
		// TODO Auto-generated method stub
		return userDao.getByUsername(name);
	}

	
	public User getById(int id){
		
		return userDao.getById(id);
		
	}
	
	public boolean isValidByName(String username){
		
		return userDao.isValidByName(username);
		
	}

	public List<User> searchUserBySpecificField(String searchText,
			String searchField) {

		return userDao.searchBookBySpecificField(searchText, searchField);
		
	}
	
	

}
