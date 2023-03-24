package demoservlets;

import java.util.ArrayList;
import java.util.List;

public class UserDataUtil {
	public static List<User> getUser(){
		List<User> users = new ArrayList<>(); 
		users.add(new User("Tom","Cat","t@gmail.com",123));
		users.add(new User("sujith","Kumar","s@gmail.com",768));
		users.add(new User("Jerry","Cat","Jery@gmail.com",903));
		users.add(new User("Charan","Kumar","Cher@gmail.com",878));
		return users;

	}
	
}
