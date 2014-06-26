package org.lavignelibrary.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.lavignelibrary.domain.Administrator;
import org.lavignelibrary.domain.User;
import org.lavignelibrary.service.AdministratorService;
import org.lavignelibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.transaction.annotation.Transactional;


/**
* A custom authentication manager that allows access if the user details
* exist in the database and if the username and password are not the same.
* Otherwise, throw a {@link BadCredentialsException}
*/

@Transactional
public class AccountAuthenticationManager implements AuthenticationManager {

	protected static Logger logger = Logger.getLogger("service");

	@Autowired
	private UserService userService;

	@Autowired
	private AdministratorService administratorService;

	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		logger.debug("Performing custom authentication");

		User verifiedUser = userService.isValid(auth.getName(), ((auth.getCredentials()).toString()) );
				
		if( verifiedUser != null ) {

			// We then create a UsernamePasswordAuthentication token,
			// for the account information to be used later on,
			// instead of storing it in the Session.		
			logger.debug("User details are good and ready to go");
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(auth.getName(),auth.getCredentials(),getAuthorities(0));
			//token.setDetails(verifiedUser.getUserId());
			return token;
				

		} else {

			// Create an Administrator instance
			// and set it with the user input information
			// to reflect its validity, using the AuthenticateLoginService,
			// from the database.
			Administrator verifiedAdmin = administratorService.isValid(auth.getName(), ((auth.getCredentials()).toString()) );
			
			if(verifiedAdmin !=null){
				
				// We then create a UsernamePasswordAuthentication token,
				// for the account information to be used later on,
				// instead of storing it in the Session.
				logger.debug("User details are good and ready to go");
				UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(auth.getName(),auth.getCredentials(),getAuthorities(1));
				//token.setDetails(verifiedAdmin.getAdminId());
				return token;
				
			} else {
				throw new BadCredentialsException("User does not exist!");
			}

		}




	}
	/**
	* Retrieves the correct ROLE type depending on the access level, where access level is an Integer.
	* Basically, this interprets the access value whether it's for a regular user or admin.
	*
	* @param access an integer value representing the access of the user
	* @return collection of granted authorities
	*/
	@SuppressWarnings("deprecation")
	public Collection<GrantedAuthority> getAuthorities(Integer access) {
		// Create a list of grants for this user
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

		// Check if this user has admin access
		// We interpret Integer(1) as an admin user
		if ( access.compareTo(1) == 0) {
			// User has admin access
			logger.debug("Grant ROLE_ADMIN to this user");
			authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		} else {
			
			logger.debug("Grant ROLE_USER to this user");
			authList.add(new GrantedAuthorityImpl("ROLE_USER"));
			
		}

		// Return list of granted authorities
		return authList;
	}

}