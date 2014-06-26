package org.lavignelibrary.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SerialKey implements Serializable {
	
	private static final long serialVersionUID = -6684683751220897110L;
	
	private int id;
	private String serialKey;
	private boolean isUsed;

	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSerialKey() {
		return serialKey;
	}
	public void setSerialKey(String serialKey) {
		this.serialKey = serialKey;
	}
	public boolean isUsed() {
		return isUsed;
	}
	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

}
