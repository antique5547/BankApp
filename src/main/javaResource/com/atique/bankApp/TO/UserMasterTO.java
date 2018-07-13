package com.atique.bankApp.TO;


import com.atique.bankApp.entity.AccountDetails;
import com.atique.bankApp.entity.Address;

public class UserMasterTO {
int userId;
	
	String userName;
	String fullName;
	String password;
	String emailId;
	String bankName;

	Address address;
	
	AccountDetails accDetails;
public UserMasterTO() {
	// TODO Auto-generated constructor stub
}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public AccountDetails getAccDetails() {
		return accDetails;
	}

	public void setAccDetails(AccountDetails accDetails) {
		this.accDetails = accDetails;
	}
	
}
