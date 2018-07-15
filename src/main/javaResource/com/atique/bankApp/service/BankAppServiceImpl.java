package com.atique.bankApp.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atique.bankApp.TO.UserMasterTO;
import com.atique.bankApp.config.AccountNumberGenerator;
import com.atique.bankApp.dao.BankAppDAO;
import com.atique.bankApp.entity.AccountDetails;
import com.atique.bankApp.entity.AccountStatement;
import com.atique.bankApp.entity.Address;
import com.atique.bankApp.entity.UserMaster;
import com.mysql.fabric.xmlrpc.base.Data;

@Service
public class BankAppServiceImpl implements BankAppService{

@Autowired	
BankAppDAO baDao;

@Autowired
AccountNumberGenerator accNumGen;

public Serializable addUser(HttpServletRequest req) {
	UserMaster um = new UserMaster();
	um.setFullName(req.getParameter("fullname"));
	um.setUserName(req.getParameter("uname"));
	um.setEmailId(req.getParameter("emailId"));
	um.setPassword(req.getParameter("password"));
	um.setBankName(req.getParameter("bankName"));
	String accNum=accNumGen.generateAccountNumber(req.getParameter("bankName"));
	um.setAccDetails(new AccountDetails(accNum,0));
	return baDao.addUser(um);
}

public UserMaster getUserDetails(int loggedInId) {
	    UserMaster um = baDao.getUserDetails(loggedInId);
		return um;
	}

public void updateUser(HttpServletRequest req) {
	UserMaster um = new UserMaster();
	um.setUserId(Integer.parseInt(req.getSession().getAttribute("loggedInId").toString()));
	um.setFullName(req.getParameter("fullName"));
	um.setUserName(req.getParameter("userName"));
	um.setEmailId(req.getParameter("emailId"));
	um.setPassword(req.getParameter("password"));
	um.setBankName(req.getParameter("bankName"));
	Address add=new Address();
	add.setCountry(req.getParameter("country"));
	add.setLocality(req.getParameter("locality"));
	add.setDistrict(req.getParameter("district"));
	add.setState(req.getParameter("state"));
	add.setPinCode(req.getParameter("pinCode"));
	um.setAddress(add);
	baDao.updateUser(um);
	}

public int loginUser(HttpServletRequest req) {
		return baDao.verifyUser(req.getParameter("uname"), req.getParameter("password"),req.getParameter("bankName"));
	}

public AccountDetails getAccountsDetails(int loggedInId) {
	UserMaster um = baDao.getUserDetails(loggedInId);
		return new AccountDetails(um.getAccDetails().getAccNo(), um.getAccDetails().getAccBal());
	}

public String addDeposit(HttpServletRequest req) {
		int loggedInId=Integer.parseInt(req.getSession().getAttribute("loggedInId").toString());
		String message="Successfully Deposited";
		try {
			UserMaster um = baDao.getUserDetails(loggedInId);
			
			AccountStatement aStmt=new AccountStatement();
			
			aStmt.setAmount(req.getParameter("amount"));
			Date currTime = new Date();
			aStmt.setTime(currTime.toString());
			aStmt.setType("CREDIT");
			aStmt.setUserId(um.getUserId());
			AccountDetails aDetail=um.getAccDetails();
			double bal = aDetail.getAccBal();
			bal+=Double.parseDouble(req.getParameter("amount"));
			aDetail.setAccBal(bal);
			baDao.updateBal(um,aStmt);
		}catch (Exception e) {
			message = "Something went wrong while deposit Money! Try Again";
			e.printStackTrace();
		}
		
		return message;
	}

public String withDrawMoney(HttpServletRequest req) {
	int loggedInId=Integer.parseInt(req.getSession().getAttribute("loggedInId").toString());
	String message="Successfully Debited";
	try {
		UserMaster um = baDao.getUserDetails(loggedInId);
		
		AccountStatement aStmt=new AccountStatement();
		
		double withDrawAmt=Double.parseDouble(req.getParameter("amount"));
		aStmt.setAmount(req.getParameter("amount"));
		Date currTime = new Date();
		aStmt.setTime(currTime.toString());
		aStmt.setType("DEBIT");
		aStmt.setUserId(um.getUserId());
//		aStmt.setAsId(um.getAccDetails().getAcStmts().get(0).getAsId());
		
		AccountDetails aDetail=um.getAccDetails();
		double bal = aDetail.getAccBal();
		
		if(bal>=withDrawAmt) {
			bal-=withDrawAmt;
		}else {
			message="Not Enough Amount to withdraw! Try with less amount";
		}
		
		aDetail.setAccBal(bal);
		baDao.updateBal(um,aStmt);
	}catch (Exception e) {
		message = "Something went wrong while deposit Money! Try Again";
		e.printStackTrace();
	}
	
	return message;
	}

public List<AccountStatement> getStatements(HttpServletRequest req) {
	int loggedInId=Integer.parseInt(req.getSession().getAttribute("loggedInId").toString());
		return baDao.getStatements(loggedInId);
	}

public boolean checkUserAvailibility(String uname) {
	List list = baDao.getUserByUserName(uname);
	if(list.size()==0)
		return true;
	else
		return false;
}
}
