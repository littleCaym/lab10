package com.example.lab10;

import java.util.Scanner;

/**
 * todo Document type CreateUserInterface
 */
public class CreateUserInterface {
	private final Scanner in = new Scanner(System.in);
	public void createUser() {
		boolean repeat = true;
		while (repeat) {
			System.out.println("Введите данные пользователя:");
			System.out.print("Логин: ");
			String login = in.nextLine();
			System.out.print("Пароль: ");
			String password = in.nextLine();
			System.out.print("Роль: ");
			String roleString = in.nextLine().toUpperCase();

			Role role = RoleValidation.validateRoleFromString(roleString);

			if (role.equals(Role.NO_ROLE)) {
				System.out.println("Неверно указана роль пользователя!");
				continue;
			}
			UserList.userArrayList.add(new User(
					login, password, role
			));
			System.out.println("Пользователь успешно создан!");
			repeat = false;
		}
	}
}
