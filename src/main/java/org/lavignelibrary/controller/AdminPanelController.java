package org.lavignelibrary.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.lavignelibrary.domain.Book;
import org.lavignelibrary.domain.User;
import org.lavignelibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class AdminPanelController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/adminpanel", method = RequestMethod.GET)
    public String getAdmin(Model model, HttpServletRequest request) {
    	
    	return "admin";
	}
	
	@RequestMapping(value = "/searchUsers", method = RequestMethod.GET)
    public String searchUsers(Model model, HttpServletRequest request) {
    	
    	return "search-users";
	}
	
	@RequestMapping(value = "/searchUsers", method = RequestMethod.POST)
    public String getUsersResult(@RequestParam(value="searchText", required=false) String searchText, 
    		@RequestParam(value="searchCategory", required=true) String searchField, ModelMap model) {
		
		List<User> usersSearched = userService.searchUserBySpecificField(searchText, searchField);
    	model.put("usersSearched", usersSearched);
		
    	return "search-users";
	}

}
