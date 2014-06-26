package org.lavignelibrary.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class LibraryCard implements Serializable {

	private static final long serialVersionUID = -1925681478490156805L;

	private int id;
	private Date expiryDate;
	private List<BookStatus> books;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
				name="LibraryCards_To_BookStatuses",
				joinColumns={@JoinColumn(name="libraryCard_id")},
				inverseJoinColumns={@JoinColumn(name="bookStatus_id")}
			)
	public List<BookStatus> getBooks() {
		return books;
	}
	public void setBooks(List<BookStatus> books) {
		this.books = books;
	}
	
}
