package hibernateconfig;

import org.hibernate.Session;


import hibernatehelloworld.Address;
import hibernatehelloworld.Person;
import hibernateutil.HibernateUtil;

public class Hibernatedemo {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Address address = new Address("7th","Mumbai","500987");
		Address address1 = new Address("8th","Mumbai","500879");
		Person person = new Person("Sujith",address,address1);
		session.save(person);
		session.getTransaction().commit();
		session.close();
	}

}
