package com.atique.bankApp.config;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AccountNumberGenerator {
public static String generateAccountNumber(String bankName) {
	String pid=bankName+"/0001";
	try {
		Session sess=SessionUtil.getSession();
		Transaction tx = sess.beginTransaction();
		Query q1 = sess.createQuery("from AccountDetails d");
		int size=q1.list().size();
		
		if(size!=0) {
			Query query=(Query) sess.createQuery("select max(d.accNo) from AccountDetails d where d.accNo like '"+bankName+"%'");
			List list=query.list();
			Object o=list.get(0);
			String id=o.toString();
			int len=id.split("/")[0].length();
			String p2=id.substring(len+1);
			int x=Integer.parseInt(p2);
			x=x+1;
			if(x<=9) {
				pid=bankName+"/000"+x;
			}else if(x<=99) {
				pid=bankName+"/00"+x;
			}else if(x<=999) {
				pid=bankName+"/0"+x;
			}else {
				pid=bankName+"/"+x;
			}
			
		}
	} catch (Exception e) {
		e.printStackTrace();;
	}
	return pid;
}
}
