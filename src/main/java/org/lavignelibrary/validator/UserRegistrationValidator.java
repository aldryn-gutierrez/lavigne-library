package org.lavignelibrary.validator;

import org.lavignelibrary.domain.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class UserRegistrationValidator implements Validator{

	
	@Override
	public boolean supports(Class clazz) {
		//just validate the Customer instances
		return User.class.isAssignableFrom(clazz);

	}
	
	

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
				"required.userName", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", "Field name is required.");
			
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
				"required.confirmPassword", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userDetails.firstname",
				"required.userDetails.firstname", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userDetails.lastname",
				"required.userDetails.lastname", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userDetails.organizationIdNumber", 
				"required.userDetails.organizationIdNumber", "Field name is required.");
		
		User cust = (User)target;
		
		if(!(cust.getPassword().equals(cust.getConfirmPassword()))){
			errors.reject("password", "No Password Matched!");
		}
		
		if( (String.valueOf(cust.getUserDetails().getOrganizationIdNumber())).length() != 9 ){
			errors.reject("organizationIdNumber", "The Organization Id is strictly 9 Numbers");			
		}
		
		if(!cust.getUserDetails().getPicture().getImage().getContentType().equalsIgnoreCase("application/octet-stream")){
			if(!cust.getUserDetails().getPicture().getImage().getContentType().equalsIgnoreCase("image/jpeg")){
				errors.reject("image", "ONLY JPEG ALLOWED!");
			}
		}
		

		
	}



	
}