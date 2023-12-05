package com.example.lab10;

import com.example.lab10.entity.Role;
import com.example.lab10.entity.User;
import com.example.lab10.validation.RoleValidation;
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

	public static User addUser(User user){
		if (user.getId() == 0){
			user.setId(userArrayList
					.get(userArrayList.size()-1)
					.getId()
					+ 1
			);
		}
		//Логин должен быть уникальным
		if (!getUser(user.getLogin()).equals(userEmpty)){
			return userEmpty;
		}
		userArrayList.add(user);
		return user;
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

	public static boolean updateUserLoginById(long id, String newLogin){
		if (newLogin.isEmpty()){
			return false;
		}
		//логин должен быть уникальным
		if(!getUser(newLogin).equals(userEmpty)){
			return false;
		}
		for (int i = 0; i < userArrayList.size(); i++) {
			if (userArrayList.get(i).getId() == id){
				User user = userArrayList.get(i);
				user.setLogin(newLogin);
				userArrayList.set(i, user);
				return true;
			}
		}
		return false;
	}

	public static boolean updateUserLoginByLogin(String login, String newLogin){
		if (newLogin.isEmpty()){
			return false;
		}
		//логин должен быть уникальным
		if(!getUser(newLogin).equals(userEmpty)){
			return false;
		}
		for (int i = 0; i < userArrayList.size(); i++) {
			if (userArrayList.get(i).getLogin().equals(login)){
				User user = userArrayList.get(i);
				user.setLogin(newLogin);
				userArrayList.set(i, user);
				return true;
			}
		}
		return false;
	}

	public static boolean updateUserPasswordById(long id, String newPassword){
		if (newPassword.isEmpty()){
			return false;
		}
		for (int i = 0; i < userArrayList.size(); i++) {
			if (userArrayList.get(i).getId() == id){
				User user = userArrayList.get(i);
				user.setPassword(newPassword);
				userArrayList.set(i, user);
				return true;
			}
		}
		return false;
	}

	public static boolean updateUserPasswordByLogin(String login, String newPassword){
		if (newPassword.isEmpty()){
			return false;
		}
		for (int i = 0; i < userArrayList.size(); i++) {
			if (userArrayList.get(i).getLogin().equals(login)){
				User user = userArrayList.get(i);
				user.setPassword(newPassword);
				userArrayList.set(i, user);
				return true;
			}
		}
		return false;
	}

	public static boolean updateUserRoleById(long id, String newRoleString) {
		if (newRoleString.isEmpty()){
			return false;
		}
		Role newRole = RoleValidation.validateFromString(newRoleString);
		if (newRole.equals(Role.NO_ROLE)){
			return false;
		}
		for (int i = 0; i < userArrayList.size(); i++) {
			if (userArrayList.get(i).getId() == id){
				User user = userArrayList.get(i);
				user.setRole(newRole);
				userArrayList.set(i, user);
				return true;
			}
		}
		return false;
	}

}

