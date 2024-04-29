package com.restapi.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class userDaoServices {
	
	public static List<User> users = new ArrayList<>();
	
	public static int userCount = 0;
	
	static {
		users.add(new User(++userCount,"fazil",LocalDate.now().minusYears(23)));
		users.add(new User(++userCount,"luffy",LocalDate.now().minusYears(20)));
		users.add(new User(++userCount,"zoro",LocalDate.now().minusYears(26)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		Predicate<? super User> predicate = user-> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void DeleteById(int id) {
		Predicate<? super User> predicate = user-> user.getId().equals(id);
		users.removeIf(predicate);
	}
}