package hibernatehelloworld;

import org.hibernate.Session;

import hibernateconfig.Message;
import hibernateutil.HibernateUtil;

public class Hibernatedemo {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Message message = new Message("Hello from hibernate");
		session.save(message);
		session.getTransaction().commit();
		session.close();
	}

}
