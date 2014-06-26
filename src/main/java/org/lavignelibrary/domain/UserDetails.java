package org.lavignelibrary.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String firstname;
	private String lastname;
	private long organizationIdNumber;
	private Occupation occupation;
	private Picture picture;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public long getOrganizationIdNumber() {
		return organizationIdNumber;
	}
	public void setOrganizationIdNumber(long organizationIdNumber) {
		this.organizationIdNumber = organizationIdNumber;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	public Occupation getOccupation() {
		return occupation;
	}
	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	
	
	
}
