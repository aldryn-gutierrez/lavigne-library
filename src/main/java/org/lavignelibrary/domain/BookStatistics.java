package org.lavignelibrary.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BookStatistics implements Serializable {

	private static final long serialVersionUID = 7099368689028141397L;

	private int id;
	private int stock;
	private int inShelves;
	private int outShelves;
	private int timesBorrowed;
	private Date acquisition;
	private boolean forPublic;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getInShelves() {
		return inShelves;
	}
	public void setInShelves(int inShelves) {
		this.inShelves = inShelves;
	}
	public int getOutShelves() {
		return outShelves;
	}
	public void setOutShelves(int outShelves) {
		this.outShelves = outShelves;
	}
	public int getTimesBorrowed() {
		return timesBorrowed;
	}
	public void setTimesBorrowed(int timesBorrowed) {
		this.timesBorrowed = timesBorrowed;
	}
	public Date getAcquisition() {
		return acquisition;
	}
	public void setAcquisition(Date acquisition) {
		this.acquisition = acquisition;
	}
	public boolean isForPublic() {
		return forPublic;
	}
	public void setForPublic(boolean forPublic) {
		this.forPublic = forPublic;
	}
	
}
