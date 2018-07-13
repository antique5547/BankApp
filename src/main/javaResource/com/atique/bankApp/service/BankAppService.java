package com.atique.bankApp.service;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.atique.bankApp.TO.UserMasterTO;
import com.atique.bankApp.entity.AccountDetails;
import com.atique.bankApp.entity.AccountStatement;
import com.atique.bankApp.entity.UserMaster;

public interface BankAppService {
public Serializable addUser(HttpServletRequest req);
public UserMaster getUserDetails(int loggedInId);
public void updateUser(HttpServletRequest req);
public int loginUser(HttpServletRequest req);
public AccountDetails getAccountsDetails(int loggedInId);
public String addDeposit(HttpServletRequest req);
public String withDrawMoney(HttpServletRequest req);
public List<AccountStatement> getStatements(HttpServletRequest req);
}
