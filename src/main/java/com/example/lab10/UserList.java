package com.example.lab10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserList {
	public static final User userEmpty = new User(-1, "", "", Role.NO_ROLE);
	private static final User user0 = new User(0, "admin", "admin", Role.ADMINISTRATOR);
	private static final User user1 = new User(1, "cashier", "cashier", Role.CASHIER);
	private static final User user2 = new User(2, "personnelManager", "personnelManager", Role.PERSONNEL_MANAGER);
	private static final User user3 = new User(3, "warehouseManager", "warehouseManager", Role.WAREHOUSE_MANAGER);
	private static final User user4 = new User(4, "accountant", "accountant", Role.ACCOUNTANT);
	private static final List<User> userArrayList = new ArrayList<>(Arrays.asList(user0, user1, user2, user3, user4));
	public static List<User> getUserArrayList() {
		return userArrayList;
	}

	public static void addUser(User user){
		if (user.getId() == 0){
			user.setId(userArrayList
					.get(userArrayList.size()-1)
					.getId()
					+ 1
			);
		}
		userArrayList.add(user);
	}

	public static User removeUser(long id){
		for (int i = 0; i < userArrayList.size(); i++) {
			if (userArrayList.get(i).getId() == id){
				return userArrayList.remove(i);
			}
		}
		return userEmpty;
	}

	public static User removeUser(String login){
		for (int i = 0; i < userArrayList.size(); i++) {
			if (userArrayList.get(i).getLogin() == login){
				return userArrayList.remove(i);
			}
		}
		return userEmpty;
	}

	//Поиск по id
	public static User getUser(long id){
		for (int i = 0; i < userArrayList.size(); i++) {
			if (userArrayList.get(i).getId() == id){
				return userArrayList.get(i);
			}
		}
		return userEmpty;
	}

	//Поиск по логину
	public static User getUser(String login){
		for (int i = 0; i < userArrayList.size(); i++) {
			if (userArrayList.get(i).getLogin().equals(login)){
				return userArrayList.get(i);
			}
		}
		return userEmpty;
	}

}

