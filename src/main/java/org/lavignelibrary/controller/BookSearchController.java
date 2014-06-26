package org.lavignelibrary.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.lavignelibrary.domain.Book;
import org.lavignelibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class BookSearchController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/searchBooks", method = RequestMethod.GET)
    public String getBooks(Model model, HttpServletRequest request) {
    	
    	return "search";
	}
	
	
	@RequestMapping(value = "/searchBooks", method = RequestMethod.POST)
    public String getBooksResult(@RequestParam(value="searchText", required=false) String searchText, 
    		@RequestParam("searchCategory") String searchField, ModelMap model) {
		
		List<Book> booksSearched = bookService.searchBookBySpecificField(searchText, searchField);
    	model.put("booksSearched", booksSearched);
		
    	return "search";
	}

}
