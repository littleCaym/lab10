package com.example.lab10.interfaces;

import com.example.lab10.validation.InputValidation;
import com.example.lab10.validation.RoleValidation;
import com.example.lab10.UserList;
import com.example.lab10.entity.Role;
import com.example.lab10.entity.User;
import java.util.Scanner;

/**
 * todo Запретить удалять админа
 * todo Не давать создавать юзера с тем же логином или id
 */
public class CRUDInterface {
	public static void createUser() {
		Scanner in = new Scanner(System.in);
		boolean repeat = true;
		while (repeat) {
			System.out.println("Введите данные пользователя:");
			System.out.print("Логин: ");
			String login = in.nextLine();
			System.out.print("Пароль: ");
			String password = in.nextLine();
			System.out.print("Роль: ");
			String roleString = in.nextLine().toUpperCase();

			Role role = RoleValidation.validateFromString(roleString.toUpperCase());

			if (role.equals(Role.NO_ROLE)) {
				System.out.println("Неверно указана роль пользователя!");
				continue;
			}
			if(UserList.addUser(new User(
					login, password, role
			)).equals(UserList.userEmpty)){
				System.out.println("Логин занят");
			} else {
				System.out.println("Пользователь успешно создан!");
			}
			repeat = false;
		}
	}
	public static void deleteUser(){
		Scanner in = new Scanner(System.in);
		System.out.print("Введите id или логин пользователя на удаление: ");
		String userInputString = in.nextLine();

		User user;
		if (InputValidation.tryParseInt(userInputString, -1) == -1){
			//По логину
			user = UserList.removeUser(userInputString);
		} else {
			//По ID
			user = UserList.removeUser(Integer.parseInt(
					userInputString));
		}
		if (user.equals(UserList.userEmpty)){
			System.out.println("Пользователь не найден.");
		} else {
			System.out.println("Пользователь " + user.getId() + ". " + user.getLogin() +" удален");
		}
	}

	public static void readUser(){
		Scanner in = new Scanner(System.in);
		System.out.print("Введите id или логин пользователя: ");
		String userInputString = in.nextLine();

		if (userInputString == null || userInputString.isBlank()){
			System.out.println("Ошибка ввода");
			return;
		}
		User user;
		if (InputValidation.tryParseInt(userInputString, -1) == -1){
			//По логину
			user = UserList.getUser(userInputString);
		} else {
			//По ID
			user = UserList.getUser(Integer.parseInt(
					userInputString));
		}
		if (user.equals(UserList.userEmpty)){
			System.out.println("Пользователь не найден.");
		} else {
			System.out.println("--------------");
			System.out.println("Логин: " + user.getLogin());
			System.out.println("Пароль: " + user.getPassword());
			System.out.println("Роль: " + user.getRole());
			System.out.println("--------------");

			System.out.println("Нажмите enter, чтобы выйти");
			String cmd = in.nextLine().toUpperCase();
		}
	}

	public static void updateUser(){
		Scanner in = new Scanner(System.in);
		System.out.print("Введите id или логин пользователя: ");
		String userInputString = in.nextLine();

		if (userInputString == null || userInputString.isBlank()){
			System.out.println("Ошибка ввода");
			return;
		}

		User user;
		if (InputValidation.tryParseInt(userInputString, -1) == -1){
			//По логину
			user = UserList.getUser(userInputString);
		} else {
			//По ID
			user = UserList.getUser(Integer.parseInt(
					userInputString));
		}
		if (user.equals(UserList.userEmpty)){
			System.out.println("Ошибка при обновлении пользователя");
		} else {
			System.out.println("--------------");
			System.out.println("Логин: " + user.getLogin());
			System.out.println("Пароль: " + user.getPassword());
			System.out.println("Роль: " + user.getRole());
			System.out.println("--------------");
			System.out.println("Введите поле для обновления: LOGIN, PASSWORD, ROLE");
			userInputString = in.nextLine();
			switch (userInputString.toUpperCase()){
				case User.LOGIN -> {
					System.out.print("Новый логин: ");
					String login = in.nextLine();
					if (!UserList.updateUserLoginById(user.getId(), login)){
						System.out.println("Ошибка обновления логина");
					}
				}
				case User.PASSWORD -> {
					System.out.print("Новый пароль: ");
					String password = in.nextLine();
					if (!UserList.updateUserPasswordById(user.getId(), password)){
						System.out.println("Ошибка обновления пароля");
					}
				}
				case User.ROLE -> {
					System.out.println("Новая роль:");
					String role = in.nextLine().toUpperCase();
					if(!UserList.updateUserRoleById(user.getId(), role)){
						System.out.println("Ошибка обновления роли");
					}
				}
			}
		}
	}
}
