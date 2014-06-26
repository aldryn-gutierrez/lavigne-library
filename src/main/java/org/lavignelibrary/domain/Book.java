package org.lavignelibrary.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;

@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 7358945107795731583L;

	private int id;
	private BookDetails bookDetails;
	private BookStatistics bookStatistics;
	private List<BookStatus> bookStatuses;
	
	

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	

	@OneToOne(cascade = CascadeType.ALL)
	public BookDetails getBookDetails() {
		return bookDetails;
	}
	public void setBookDetails(BookDetails bookDetails) {
		this.bookDetails = bookDetails;
	}
	

	@OneToOne(cascade = CascadeType.ALL)
	public BookStatistics getBookStatistics() {
		return bookStatistics;
	}
	public void setBookStatistics(BookStatistics bookStatistics) {
		this.bookStatistics = bookStatistics;
	}
	
	

	@OneToMany( mappedBy="sbook" )
	public List<BookStatus> getBookStatuses() {
		return bookStatuses;
	}

	public void setBookStatuses(List<BookStatus> bookStatuses) {
		this.bookStatuses = bookStatuses;
	}
	
}
