package com.HibernateAssignments.problem2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Locker {

	@Id
	private String lockerId;
	@Column
	private String lockerType;
	@Column
	private int rent;
	
	
	
	public Locker() {
		
	}
	public Locker(String lockerId, String lockerType, int rent) {
		this.lockerId = lockerId;
		this.lockerType = lockerType;
		this.rent = rent;
	}
	public String getLockerId() {
		return lockerId;
	}
	public void setLockerId(String lockerId) {
		this.lockerId = lockerId;
	}
	public String getLockerType() {
		return lockerType;
	}
	public void setLockerType(String lockerType) {
		this.lockerType = lockerType;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
}
