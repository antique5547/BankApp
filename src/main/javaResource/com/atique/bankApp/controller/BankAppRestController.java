package com.atique.bankApp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atique.bankApp.TO.UserMasterTO;
import com.atique.bankApp.dao.BankAppDAO;
import com.atique.bankApp.entity.AccountDetails;
import com.atique.bankApp.entity.AccountStatement;
import com.atique.bankApp.entity.UserMaster;
import com.atique.bankApp.service.BankAppService;

@RestController
@RequestMapping("/bankApp")
public class BankAppRestController {
	@Autowired
	BankAppService bAppService;
	@Autowired
	BankAppDAO baDao;
	
	@RequestMapping(value="/viewProfile/{uid}",method=RequestMethod.GET,produces= {"application/json"})
	public @ResponseBody UserMasterTO viewProfile(@PathVariable int  uid) {
		System.out.println("viewProfile()");
		UserMaster uDetails = bAppService.getUserDetails(uid);
		UserMasterTO to=new UserMasterTO();
		to.setUserId(uDetails.getUserId());
		to.setFullName(uDetails.getFullName());
		to.setEmailId(uDetails.getEmailId());
		to.setBankName(uDetails.getBankName());
		to.setUserName(uDetails.getUserName());
		to.setAddress(uDetails.getAddress());
		to.setAccDetails(uDetails.getAccDetails());
		return to;
	}
	
	@RequestMapping(value="/loginUser",method=RequestMethod.POST)
	public @ResponseBody int LoginUser(@RequestBody UserMasterTO to) {
		System.out.println("LoginUser()");
		String message="Successfully Logged In";
		String returnPage="bankHomePage";
		int loggedInId = baDao.verifyUser(to.getUserName(), to.getPassword(), to.getBankName());
		System.out.println("LoggedIn ID : "+loggedInId);
		return loggedInId;
	}
	
	@RequestMapping(value="/getAccountDetails/{uid}",method=RequestMethod.GET,produces= {"application/json"})
	public @ResponseBody AccountDetails getAccountDetails(@PathVariable int  uid) {
		System.out.println("getAccountDetails()");
		
		return bAppService.getAccountsDetails(uid);
	}
	
	@RequestMapping(value="/getStatements/{uid}",method=RequestMethod.GET,produces= {"application/json"})
	public @ResponseBody List<AccountStatement> getStatements(@PathVariable int  uid) {
		System.out.println("getStatements()");
		
		return baDao.getStatements(uid);
	}
}
