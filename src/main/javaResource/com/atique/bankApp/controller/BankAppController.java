package com.atique.bankApp.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atique.bankApp.config.AccountNumberGenerator;
import com.atique.bankApp.entity.UserMaster;
import com.atique.bankApp.service.BankAppService;

@Controller
public class BankAppController {
	
	@Autowired
	BankAppService bAppService;
	
	@RequestMapping(value="register.bapp")
	public String showRegisterPage(HttpServletRequest req) {
		System.out.println("showRegisterPage()");
		Map<String, String> bankName=new HashMap<String, String>();
		bankName.put("SBI", "SBI");
		bankName.put("AXIS", "AXIS");
		bankName.put("OBC", "OBC");
		bankName.put("BOI", "Bank Of India");
		bankName.put("IDBI", "IDBI");
		bankName.put("PNB", "PUNJAB BANK");
		req.setAttribute("bankName", bankName);
		req.setAttribute("isRegisterPage", "YES");
		return "registerPage";
	}
	
	
	@RequestMapping(value="registerUser.bapp")
	public String registerUser(HttpServletRequest req) {
		System.out.println("registerUser()");
		String message="Successfully Registered";
		String returnPage="bankHomePage";
		Serializable loggedInId=0;
		if(req.getSession().getAttribute("FormSubmittedSuccessfully")==null) {
			loggedInId = bAppService.addUser(req);
			req.getSession().setAttribute("FormSubmittedSuccessfully",true);
			req.getSession().setAttribute("isLoggedIn",true);
			req.getSession().setAttribute("loggedInId", loggedInId);
		}else {
			loggedInId = Integer.parseInt(req.getSession().getAttribute("loggedInId").toString());
		}
		
		System.out.println("LoggedIn ID : "+loggedInId);
		if(loggedInId ==null) {
			message="Somthing Went Wrong! Try Again";
			returnPage="registerPage";
		}
		req.setAttribute("isUpdateProfilePage", "YES");
		req.setAttribute("message", message);
		return returnPage;
	}
	
	@RequestMapping(value="editProfile.bapp")
	public String editProfile(HttpServletRequest req) {
		System.out.println("editProfile()");
		int loggedInId = Integer.parseInt(req.getSession().getAttribute("loggedInId").toString());
		req.setAttribute("userDetails", bAppService.getUserDetails(loggedInId));
		Map<String, String> bankName=new HashMap<String, String>();
		bankName.put("SBI", "SBI");
		bankName.put("AXIS", "AXIS");
		bankName.put("OBC", "OBC");
		bankName.put("BOI", "Bank Of India");
		bankName.put("IDBI", "IDBI");
		bankName.put("PNB", "PUNJAB BANK");
		req.setAttribute("bankName", bankName);
		req.setAttribute("isEdit", "YES");
		return "userEditPage";
	}
	
	@RequestMapping(value="viewProfile.bapp")
	public String viewProfile(HttpServletRequest req) {
		System.out.println("editProfile()");
		int loggedInId = Integer.parseInt(req.getSession().getAttribute("loggedInId").toString());
		req.setAttribute("userDetails", bAppService.getUserDetails(loggedInId));
		req.setAttribute("viewUsers", "YES");
		return "userEditPage";
	}
	
	@RequestMapping(value="updateProfile.bapp")
	public String updateProfile(HttpServletRequest req) {
		System.out.println("editProfile()");
		bAppService.updateUser(req);
		req.setAttribute("isUpdateProfilePage", "YES");
		return "bankHomePage";
	}
	
	@RequestMapping(value="login.bapp")
	public String showLoginPage(HttpServletRequest req) {
		System.out.println("showRegisterPage()");
		Map<String, String> bankName=new HashMap<String, String>();
		bankName.put("SBI", "SBI");
		bankName.put("AXIS", "AXIS");
		bankName.put("OBC", "OBC");
		bankName.put("BOI", "Bank Of India");
		bankName.put("IDBI", "IDBI");
		bankName.put("PNB", "PUNJAB BANK");
		req.setAttribute("bankName", bankName);
		req.setAttribute("isLoginPage", "YES");
		return "registerPage";
	}
	
	@RequestMapping(value="LoginUser.bapp")
	public String LoginUser(HttpServletRequest req) {
		System.out.println("LoginUser()");
		String message="Successfully Logged In";
		String returnPage="bankHomePage";
		int loggedInId = bAppService.loginUser(req);
		System.out.println("LoggedIn ID : "+loggedInId);
		if(loggedInId ==0) {
			message="Somthing Went Wrong! Try Again";
			Map<String, String> bankName=new HashMap<String, String>();
			bankName.put("SBI", "SBI");
			bankName.put("AXIS", "AXIS");
			bankName.put("OBC", "OBC");
			bankName.put("BOI", "Bank Of India");
			bankName.put("IDBI", "IDBI");
			bankName.put("PNB", "PUNJAB BANK");
			req.setAttribute("bankName", bankName);
			req.setAttribute("isLoginPage", "YES");
			req.setAttribute("loggedOutMessage", message);
			returnPage="index";
		}
		req.getSession().setAttribute("isLoggedIn",true);
		req.getSession().setAttribute("loggedInId", loggedInId);
		req.setAttribute("isUpdateProfilePage", "YES");
		return returnPage;
	}
	
	@RequestMapping(value="accountsDetails.bapp")
	public String accountsDetails(HttpServletRequest req) {
		System.out.println("editProfile()");
		int loggedInId = Integer.parseInt(req.getSession().getAttribute("loggedInId").toString());
		req.setAttribute("accountsDetails", bAppService.getUserDetails(loggedInId));
		req.setAttribute("isAccountDetails", "YES");
		return "userEditPage";
	}
	
	@RequestMapping(value="logout.bapp")
	public String getLoggedOut(HttpServletRequest req) {
		if(req.getSession().getAttribute("isLoggedIn")!=null) {
			req.getSession().invalidate();
			req.setAttribute("loggedOutMessage", "You have Logged Out Successfully!");
		}
		
		return "index";
	}
	
	@RequestMapping(value="deposit.bapp")
	public String showDepositPage(HttpServletRequest req) {
		int loggedInId = Integer.parseInt(req.getSession().getAttribute("loggedInId").toString());
		req.setAttribute("accountsDetails", bAppService.getUserDetails(loggedInId));
		req.setAttribute("isDepositPage", "YES");
		return "userEditPage";
	}
	
	@RequestMapping(value="depositBal.bapp")
	public String depositBal(HttpServletRequest req) {
		bAppService.addDeposit(req);
		
		req.setAttribute("isDepositPage", "YES");
		return "bankHomePage";
	}
	
	@RequestMapping(value="withdraw.bapp")
	public String showWithdrawPage(HttpServletRequest req) {
		int loggedInId = Integer.parseInt(req.getSession().getAttribute("loggedInId").toString());
		req.setAttribute("accountsDetails", bAppService.getUserDetails(loggedInId));
		req.setAttribute("isWithdrawPage", "YES");
		return "userEditPage";
	}
	
	@RequestMapping(value="withdrawBal.bapp")
	public String withdrawBal(HttpServletRequest req) {
		bAppService.withDrawMoney(req);
		
		req.setAttribute("isDepositPage", "YES");
		return "bankHomePage";
	}
	
	@RequestMapping(value="viewStatements.bapp")
	public String viewStatements(HttpServletRequest req) {
		int loggedInId = Integer.parseInt(req.getSession().getAttribute("loggedInId").toString());
		UserMaster uDetails = bAppService.getUserDetails(loggedInId);
		
		req.setAttribute("statements", bAppService.getStatements(req));
		req.setAttribute("uDetails", uDetails);
		req.setAttribute("isStatementPage", "YES");
		return "userEditPage";
	}
	
	@RequestMapping(value="checkUserValidation.bapp")
	public @ResponseBody boolean checkUserValidation(HttpServletRequest req) {
		String uname=req.getParameter("uname");
		
		return bAppService.checkUserAvailibility(uname);
	}
	
}
