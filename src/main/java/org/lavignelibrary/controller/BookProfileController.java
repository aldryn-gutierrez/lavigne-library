package org.lavignelibrary.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.lavignelibrary.domain.Book;
import org.lavignelibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class BookProfileController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/bookProfile", method = RequestMethod.GET)
    public String viewBook(Model model, @RequestParam(value="id", required=true) int id, HttpServletRequest request) {
		
		Book book = bookService.getById(id);
		
		if(book == null){ return "pageNotFound"; }
		
    	model.addAttribute("book", book);
    	
		
		return "viewBook";
	}


}
