package org.lavignelibrary.controller;

import java.text.SimpleDateFormat;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.lavignelibrary.domain.Book;
import org.lavignelibrary.domain.BookStatus;
import org.lavignelibrary.domain.LibraryCard;
import org.lavignelibrary.domain.Occupation;
import org.lavignelibrary.domain.Picture;
import org.lavignelibrary.domain.User;
import org.lavignelibrary.propertyeditor.OccupationEditor;
import org.lavignelibrary.service.OccupationService;
import org.lavignelibrary.service.SerialKeyService;
import org.lavignelibrary.service.UserService;
import org.lavignelibrary.utilities.PictureUtil;
import org.lavignelibrary.validator.UserRegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/users")
public class RegistrationController {
	
	@Autowired
	private SerialKeyService serialKeyService;
	
	@Autowired
	private OccupationService occupationService;
	
	@Autowired
	private UserService userService;
	
	private UserRegistrationValidator userRegistrationValidator;
	
	@Autowired
	public void UserRegistrationValidator(UserRegistrationValidator userRegistrationValidator){
		this.userRegistrationValidator = userRegistrationValidator;
	}
	
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Occupation.class, new OccupationEditor(this.occupationService));
    }
	
	@ModelAttribute("occupationList")
	public List<Occupation> populateOccupationList() {

		List<Occupation> occupations = new ArrayList<Occupation>();		
		occupations = occupationService.getAll();
		
		return occupations;
	}
	

	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String initForm(ModelMap model){
		
		User user = new User();
							
		//command object
		model.addAttribute("user", user);
		
		//return form view
		return "register";
		
	
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("user") User user, BindingResult result,
			SessionStatus status, HttpServletRequest request) throws Exception {
		
		System.out.println(user.getUserDetails().getPicture().getImage().getContentType());
		if(serialKeyService.validateKey(user.getSerialKey().getSerialKey())){ 
			
			userRegistrationValidator.validate(user, result);
			
			
			if (result.hasErrors()) { return "register"; } 
			else {
				
				status.setComplete();				
				processUserRegistration(request, user);				
				
				//form success
				return "redirect:/login";
				
			}
			
		} else {
			
			result.reject("serialKey", "The Key you provide was not legitimate.");
			return "register";
			
		}
		
		
	}

	private void processUserRegistration(HttpServletRequest request, User user) throws Exception {

		if(!user.getUserDetails().getPicture().getImage().isEmpty()){					
			user.getUserDetails().setPicture(PictureUtil.saveImage(request, user.getUsername() + ".jpg", user.getUserDetails().getPicture().getImage()));
		} else {
			
			user.getUserDetails().setPicture(PictureUtil.saveDefaultProfileImage());
			
		}
						
		LibraryCard lc = new LibraryCard();
		lc.setExpiryDate(new Date());
		user.setLibraryCard(lc);
		List<BookStatus> bs = new ArrayList<BookStatus>();
		user.getLibraryCard().setBooks(bs);
		userService.save(user);
		
		serialKeyService.setKeyAsUsed(user.getSerialKey().getSerialKey());
		
	}


	
}
