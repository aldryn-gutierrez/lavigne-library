package org.lavignelibrary.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.lavignelibrary.domain.Book;
import org.lavignelibrary.domain.BookStatus;
import org.lavignelibrary.domain.LibraryCard;
import org.lavignelibrary.domain.User;
import org.lavignelibrary.service.BookService;
import org.lavignelibrary.service.UserService;
import org.lavignelibrary.utilities.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UserPanelController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	private Authentication auth;
	
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile(Model model, @RequestParam(value="username", required=false) String username, HttpServletRequest request) {
    	
		User user;
		
		//System.out.println(username + "HUAHUE");
		
		if(username == null){
			auth = SecurityContextHolder.getContext().getAuthentication();
			user = userService.getByName( auth.getName() );
		} else {
			user = userService.getByName( username );
			//System.out.println("uu: " + user == null);
		}
		
		model.addAttribute("user", user);
		
		return (user == null) ? "pageNotFound" : "myprofile";
		
		
	}
	
	@RequestMapping(value = "/reserveBook", method = RequestMethod.GET)
    public String reserveBook(Model model, @RequestParam(value="id", required=true) int id, HttpServletRequest request) {
		
		Book book = bookService.reserveBookById(id);
		
		if(book == null){ return "pageNotFound"; }
		
		BookStatus bs = new BookStatus();
		bs.setReserved(true);
		bs.setSbook(book);
		bs.setToReturn( (DateUtil.addDays(new Date(), 3)) );
		
		auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.getByName( auth.getName() );
		LibraryCard myCard = user.getLibraryCard();
		
		List<BookStatus> myBooks = myCard.getBooks();
		myBooks.add( bs );
		
		userService.save(user);
		
    	model.addAttribute("book", book);
    	
		
		return "index";
	}

}
