package org.lavignelibrary.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.lavignelibrary.domain.Book;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class BookRegistrationValidator implements Validator{

	
	@Override
	public boolean supports(Class clazz) {
		//just validate the Customer instances
		return Book.class.isAssignableFrom(clazz);

	}
	
	

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmpty(errors, "bookDetails.title", "required.bookDetails.title", "Title is required.");
		
		ValidationUtils.rejectIfEmpty(errors, "bookDetails.author", "required.bookDetails.author", "Author is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookDetails.ISBN", "required.bookDetails.ISBN", "ISBN is required or must not contain spaces.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookDetails.published", "required.bookDetails.published", "Published is required or must not contain spaces.");
		
		ValidationUtils.rejectIfEmpty(errors, "bookDetails.publisher", "required.bookDetails.publisher", "Publisher is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookStatistics.stock", "required.bookStatistics.stock", "Stock is required or must not contain spaces.");
		
		Book book = (Book)target;
				
		if(!book.getBookDetails().getPicture().getImage().getContentType().equalsIgnoreCase("application/octet-stream")){			
			if(!book.getBookDetails().getPicture().getImage().getContentType().equalsIgnoreCase("image/jpeg")){
				errors.reject("image", "ONLY JPEG ALLOWED!");
			}
		}
		
		if(book.getBookDetails().getDescription().length() >= 230){
			errors.reject("description", "Description too long. Limit to less that 230 characters.");
		}
		
		if( (String.valueOf(book.getBookDetails().getISBN()).length()) != 13 ){
			errors.reject("organizationIdNumber", "The ISBN is strictly 13 Numbers");			
		}
		
		
		
			
		
		
		}
		

		
}



	
