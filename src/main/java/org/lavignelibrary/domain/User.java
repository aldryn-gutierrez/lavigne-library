package org.lavignelibrary.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="LibraryUser")
public class User implements Serializable {

	private static final long serialVersionUID = 8892374421372922501L;
	
	private int id;
	private String username;
	private String password;
	private String confirmPassword;
	private UserDetails userDetails;
	private LibraryCard libraryCard;
	private boolean isBanned;
	private SerialKey serialKey;
	
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	public LibraryCard getLibraryCard() {
		return libraryCard;
	}
	public void setLibraryCard(LibraryCard libraryCard) {
		this.libraryCard = libraryCard;
	}
	
	public boolean isBanned() {
		return isBanned;
	}
	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}
	

	@Transient
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	@Transient
	public SerialKey getSerialKey() {
		return serialKey;
	}
	public void setSerialKey(SerialKey serialKey) {
		this.serialKey = serialKey;
	}
	
	

}
