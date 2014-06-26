package org.lavignelibrary.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.lavignelibrary.domain.Book;
import org.lavignelibrary.domain.BookStatus;
import org.lavignelibrary.domain.Category;
import org.lavignelibrary.domain.Occupation;
import org.lavignelibrary.domain.User;
import org.lavignelibrary.propertyeditor.CategoryEditor;
import org.lavignelibrary.propertyeditor.OccupationEditor;
import org.lavignelibrary.service.BookService;
import org.lavignelibrary.service.BookStatusService;
import org.lavignelibrary.service.CategoryService;
import org.lavignelibrary.service.UserService;
import org.lavignelibrary.utilities.PictureUtil;
import org.lavignelibrary.validator.BookRegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/books")
public class BookManagementController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookStatusService bookStatusService;
	
	@Autowired
	private BookService bookService;
	
	private BookRegistrationValidator bookRegistrationValidator;
	
	@Autowired
	public void BookRegistrationValidator(BookRegistrationValidator bookRegistrationValidator){
		this.bookRegistrationValidator = bookRegistrationValidator;
	}
	
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Category.class, new CategoryEditor(this.categoryService));
    }
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("MM/dd/yyyy"), true);
        binder.registerCustomEditor(Date.class, editor);
    }
	
	@ModelAttribute("categoryList")
	public List<Category> populateCategoryList() {
			
		List<Category> categories = new ArrayList<Category>();
		categories = categoryService.getAll();
		
		return categories;
		
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String initForm(ModelMap model){
				
		//command object
		model.addAttribute("book", new Book());
		
		//return form view
		return "addBook";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("book") Book book, BindingResult result, SessionStatus status, HttpServletRequest request) throws Exception {
		
		bookRegistrationValidator.validate(book, result);
		
		if (result.hasErrors()) {
			//if validator failed
			return "addBook";
		} else {
			status.setComplete();
			
			processBookRegistration(request, book);
			
			//form success
			return "redirect:/adminpanel";
		}
	}
	
	
	private void processBookRegistration(HttpServletRequest request, Book book) throws Exception {
		
		if(!book.getBookDetails().getPicture().getImage().isEmpty()){					
			book.getBookDetails().setPicture(PictureUtil.saveImage(request, String.valueOf(book.getBookDetails().hashCode()) + ".jpg", book.getBookDetails().getPicture().getImage()));
		} else {
			
			book.getBookDetails().setPicture(PictureUtil.saveDefaultBookImage());
			
		}
		
		book.getBookStatistics().setAcquisition(new Date());
		book.getBookStatistics().setInShelves( book.getBookStatistics().getStock() );
		
		bookService.save(book);
		
	}

	@RequestMapping(value="/lendBook", method = RequestMethod.GET)
	public String lendBook(Model model, @RequestParam(value="username", required=false) String username,
			@RequestParam(value="bookStatusId", required=false) Integer bookStatusId, HttpServletRequest request) {
		
		System.out.println("userId is:" + bookStatusId + " bookS!");
		
		if( (bookStatusId == null) && (userService.isValidByName(username) == false)){ return "pageNotFound"; }
						
		BookStatus bs = bookStatusService.getById(bookStatusId);
		
		if(bs.getBorrowed() == null){
			bs.setBorrowed(new Date());
			bookStatusService.update(bs);
		}
		
		
		return "forward:/profile";
	
		
	}
	
	@RequestMapping(value="/returnBook", method = RequestMethod.GET)
	public String returnBook(Model model, @RequestParam(value="username", required=false) String username,
			@RequestParam(value="bookStatusId", required=false) Integer bookStatusId, HttpServletRequest request) {
		
		System.out.println("userId is:" + bookStatusId + " bookS!");
		
		if( (bookStatusId == null) && (userService.isValidByName(username) == false)){ return "pageNotFound"; }
						
		BookStatus bs = bookStatusService.getById(bookStatusId);
		
		if(bs.getReturned() == null){
			bs.setReturned(new Date());
			bookStatusService.update(bs);
		}
		
		
		return "forward:/profile";
	
		
	}
	

}
