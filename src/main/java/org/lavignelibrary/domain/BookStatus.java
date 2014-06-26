package org.lavignelibrary.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class BookStatus implements Serializable {

	private static final long serialVersionUID = -3032256809625276617L;

	private int id;
	private Date borrowed;
	private Date toReturn;
	private Date returned;
	private boolean isReserved;
	private Book sbook;
	private List<LibraryCard> libraryCards;
	

	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getBorrowed() {
		return borrowed;
	}
	public void setBorrowed(Date borrowed) {
		this.borrowed = borrowed;
	}
	public Date getToReturn() {
		return toReturn;
	}
	public void setToReturn(Date toReturn) {
		this.toReturn = toReturn;
	}
	public Date getReturned() {
		return returned;
	}
	public void setReturned(Date returned) {
		this.returned = returned;
	}
	
	public boolean isReserved() {
		return isReserved;
	}
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="book_Id")
	public Book getSbook() {
		return sbook;
	}
	public void setSbook(Book sbook) {
		this.sbook = sbook;
	}
	
	@ManyToMany( mappedBy="books" )
	public List<LibraryCard> getLibraryCards() {
		return libraryCards;
	}

	public void setLibraryCards(List<LibraryCard> libraryCards) {
		this.libraryCards = libraryCards;
	}
	

	
}

