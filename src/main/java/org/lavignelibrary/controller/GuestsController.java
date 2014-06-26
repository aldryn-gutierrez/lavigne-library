package org.lavignelibrary.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.lavignelibrary.domain.Book;
import org.lavignelibrary.domain.SerialKey;
import org.lavignelibrary.service.SerialKeyService;
import org.lavignelibrary.utilities.PictureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



/**
 * Handles and retrieves Owner request
 */
@Controller
@RequestMapping("/")
public class GuestsController {

	protected static Logger logger = Logger.getLogger("controller");
	
	
	
	/**
	 * Handles and retrieves all animals,
	 * that can be bought or in stock,
	 * and show it in a JSP page
	 * 
	 * @return the name of the JSP page
	 */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getAnimals(Model model, HttpServletRequest request) {
    	
    	return "index";
	}
    
    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String get404() {
    	
    	return "pageNotFound";
	}
    
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String getAboutUs() {
    	
    	return "about";
	}
    
	
    
    
    
    
            
}
