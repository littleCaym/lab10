package com.example.lab10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserList {
	public static final User userEmpty = new User("", "", Role.NO_ROLE);
	private static final User user0 = new User("admin", "admin", Role.ADMINISTRATOR);
	private static final User user1 = new User("cashier", "cashier", Role.CASHIER);
	private static final User user2 = new User("personnelManager", "personnelManager", Role.PERSONNEL_MANAGER);
	private static final User user3 = new User("warehouseManager", "warehouseManager", Role.WAREHOUSE_MANAGER);
	private static final User user4 = new User("accountant", "accountant", Role.ACCOUNTANT);
	public static List<User> userArrayList = new ArrayList<>(Arrays.asList(user0, user1, user2, user3, user4));

//	public UserList() {
//		userArrayList = new ArrayList<>();
//		userArrayList.add(new User(0,"admin", "admin", Role.ADMINISTRATOR));
//		userArrayList.add(new User(1, "cashier", "cashier", Role.CASHIER));
//		userArrayList.add(new User(2, "personnelManager", "personnelManager", Role.PERSONNEL_MANAGER));
//		userArrayList.add(new User(3, "warehouseManager", "warehouseManager", Role.WAREHOUSE_MANAGER));
//		userArrayList.add(new User(4, "accountant", "accountant", Role.ACCOUNTANT));
//	}

	public static List<User> getUserArrayList() {
		return userArrayList;
	}


}

