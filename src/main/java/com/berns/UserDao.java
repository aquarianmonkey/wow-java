package com.berns;

import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao {

	public List<User> getAllUsers() {
		List<User> userList = null;

		if (!file.exists()) {
			User user = new User(String.valueOf(1), "Mahesh", "Teacher");
			userList = new ArrayList<User>();
			User user2 = new User(String.valueOf(2), "Berns", "Dreamer");
			userList.add(user);
			userList.add(user2);

			saveUserList(userList, file);
		} else {

			userList = retrieveSourceList();
		}

		return userList;
	}

	public User getUser(String id) {
		return retrieveSourceList().stream().filter(u -> u.getId().equals(id)).findFirst().get();
	}

	public User createUser(User user) {

		List<User> userList = retrieveSourceList();
		userList.add(user);
		saveUserList(userList, file);

		return user;

	}
}
