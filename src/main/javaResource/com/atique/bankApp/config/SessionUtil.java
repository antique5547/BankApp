package com.atique.bankApp.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionUtil {
	
	public static SessionFactory sf;
	static {
		System.out.println("SessionFactory Loaded");
	}
	@Autowired
	public void setSf(SessionFactory sf) {
		SessionUtil.sf = sf;
	}
	public static Session getSession() {
		Session sess= sf.openSession();
		return sess;
	}
	public static void closeSession(Session session) {
		session.close();
	}
}
