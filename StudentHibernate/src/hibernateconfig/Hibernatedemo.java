package hibernateconfig;

import org.hibernate.Session;

import hibernatehelloworld.Guide;
import hibernatehelloworld.Student;
import hibernateutil.HibernateUtil;

public class Hibernatedemo {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Student address = new Student("7th","Mumbai","500987");
		Student address1 = new Student("8th","Mumbai","500879");
		Guide person = new Guide("Sujith",address,address1);
		session.save(person);
		session.getTransaction().commit();
		session.close();
	}

}
