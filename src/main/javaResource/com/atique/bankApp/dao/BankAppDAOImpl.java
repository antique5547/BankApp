package com.atique.bankApp.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.atique.bankApp.config.SessionUtil;
import com.atique.bankApp.entity.AccountStatement;
import com.atique.bankApp.entity.Address;
import com.atique.bankApp.entity.UserMaster;

@Repository
public class BankAppDAOImpl implements BankAppDAO{

	public Serializable addUser(UserMaster um) {
	Session sess = SessionUtil.getSession();
	Serializable id = sess.save(um);
	sess.flush();
	return id;
}
	public UserMaster getUserDetails(int loggedInId) {
		Session sess = SessionUtil.getSession();
		return (UserMaster) sess.get(UserMaster.class, loggedInId);
	}
	
	public String updateUser(UserMaster um) {
		Session sess = SessionUtil.getSession();
		UserMaster uMaster=(UserMaster) sess.get(UserMaster.class, um.getUserId());
		uMaster.setUserName(um.getUserName());
		uMaster.setFullName(um.getFullName());
		uMaster.setEmailId(um.getEmailId());
		uMaster.setBankName(um.getBankName());
		if(uMaster.getAddress()!=null) {
			uMaster.getAddress().setAddId(uMaster.getAddress().getAddId());
			uMaster.getAddress().setCountry(um.getAddress().getCountry());
			uMaster.getAddress().setLocality(um.getAddress().getLocality());
			uMaster.getAddress().setDistrict(um.getAddress().getDistrict());
			uMaster.getAddress().setState(um.getAddress().getState());
			uMaster.getAddress().setPinCode(um.getAddress().getPinCode());
			
		}else {
			
			uMaster.setAddress(um.getAddress());
		}
//		uMaster.setAccDetails(um.getAccDetails());
		sess.update(uMaster);
		sess.flush();
		return null;
	}
	
	public int verifyUser(String userName, String pwd,String bankName) {
		Session sess = SessionUtil.getSession();
		String sql="SELECT userId from UserMaster where userName=:userName and password=:password and bankName=:bankName";
		Query crQue = sess.createQuery(sql);
		crQue.setString("password", pwd);
		crQue.setString("userName", userName);
		crQue.setString("bankName", bankName);
		List list = crQue.list();
		if(list.size()==1) {
			return (Integer) list.get(0);
		}
		return 0;
	}
	
	public void updateBal(UserMaster um,AccountStatement aStmt) {
		Session sess = SessionUtil.getSession();
		Transaction tx = sess.beginTransaction();
		try {
			sess.saveOrUpdate(um);
			sess.save(aStmt);
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<AccountStatement> getStatements(int userId) {
		Session sess = SessionUtil.getSession();
		String hql=" from AccountStatement a where a.userId = :userId";
		return sess.createQuery(hql).setInteger("userId", userId).list();
		
	}
	
	public List getUserByUserName(String uname) {
		Session sess = SessionUtil.getSession();
		return sess.createQuery("select userName from UserMaster where userName=:uname").setString("uname", uname).list();
	}
	
}
