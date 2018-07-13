package com.atique.bankApp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="AccountDetails")
public class AccountDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int accId;
	
	String accNo;
	double accBal;

	public AccountDetails() {
		// TODO Auto-generated constructor stub
	}

	public AccountDetails(String accNo, double accBal) {
		super();
		this.accNo = accNo;
		this.accBal = accBal;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	

	public String getAccNo() {
		return accNo;
	}

	public void setAccNocenter(String accNo) {
		this.accNo = accNo;
	}

	public double getAccBal() {
		return accBal;
	}

	public void setAccBal(double accBal) {
		this.accBal = accBal;
	}
	
	

}
