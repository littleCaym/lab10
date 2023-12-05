package com.example.lab10;

import java.util.Scanner;

/**
 * todo Запретить удалять админа
 *
 */
public class CRUDUserInterface {
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
			UserList.addUser(new User(
					login, password, role
			));
			System.out.println("Пользователь успешно создан!");
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
			System.out.println("Ошибка удаления пользователя");
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
			System.out.println("Ошибка удаления пользователя");
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
// TODO: 12/4/2023 updateUser 
//	public static void updateUser(){
//		Scanner in = new Scanner(System.in);
//		System.out.print("Введите id или логин пользователя: ");
//		String userInputString = in.nextLine();
//
//		if (userInputString == null || userInputString.isBlank()){
//			System.out.println("Ошибка ввода");
//			return;
//		}
//		User user;
//		if (InputValidation.tryParseInt(userInputString, -1) == -1){
//			//По логину
//			user = UserList.getUser(userInputString);
//		} else {
//			//По ID
//			user = UserList.getUser(Integer.parseInt(
//					userInputString));
//		}
//		if (user.equals(UserList.userEmpty)){
//			System.out.println("Ошибка удаления пользователя");
//		} else {
//			String login = user.getLogin();
//			String password = user.getPassword();
//			Role role = user.getRole();
//			// while
//			System.out.println("--------------");
//			System.out.println("Логин: " + user.getLogin());
//			System.out.println("Пароль: " + user.getPassword());
//			System.out.println("Роль: " + user.getRole());
//			System.out.println("--------------");
//
//			System.out.println("Введите, что необходимо изменить: LOGIN/PASSWORD/ROLE: ");
//			String cmd = in.nextLine();
//			switch (cmd.toUpperCase()){
//				case "LOGIN":
//					System.out.print("Новый логин: ");
//					login
//					if (login == null || login.isBlank()){
//						System.out.println("Ошибка ввода");
//						return;
//					} else {
//						login
//					}
//			}
//		}
//	}
}
