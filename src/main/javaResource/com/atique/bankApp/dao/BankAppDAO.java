package com.atique.bankApp.dao;

import java.io.Serializable;
import java.util.List;

import com.atique.bankApp.entity.AccountStatement;
import com.atique.bankApp.entity.UserMaster;

public interface BankAppDAO {
public Serializable addUser(UserMaster um);
public UserMaster getUserDetails(int loggedInId);
public String updateUser(UserMaster um);
public int verifyUser(String userName,String pwd,String bankName);
public void updateBal(UserMaster um,AccountStatement astmt);
public List<AccountStatement> getStatements(int userId);
public List getUserByUserName(String uname);
}

