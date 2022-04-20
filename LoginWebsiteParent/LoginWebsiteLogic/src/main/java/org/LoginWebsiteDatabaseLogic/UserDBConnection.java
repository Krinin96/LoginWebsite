package org.LoginWebsiteDatabaseLogic;

import org.LoginWebsiteLogic.*;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class UserDBConnection {

	public SessionFactory getSessionFactory() {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		return sf;
	}

	public void addUser(User user) {

		Session session = getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();

		session.save(user);

		tx.commit();
	}

	public boolean checkIfUserExist(User user) {
		Session session = getSessionFactory().openSession();

		if (user.equals((User) session.get(User.class, user.getUserName()))) {

			return true;
		}

		return false;
	}

	public boolean checkIfLoginIsCorrect(User user) {
		Session session = getSessionFactory().openSession();

		if (user.equals((User) session.get(User.class, user.getUserName()))) {

			return true;
		}

		return false;
	}

	
}
