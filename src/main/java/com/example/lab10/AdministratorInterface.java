package com.example.lab10;

import java.io.Console;
import java.util.List;
import java.util.Scanner;

/**
 * todo Document type AdministratorInterface
 */
public class AdministratorInterface {
	private final Scanner in = new Scanner(System.in);
	public void show(){
		boolean repeat = true;
		while (repeat){
			System.out.println(
					"ID" + " " + "Логин" + " " + "Пароль" + " " + "Роль"
			);
			System.out.println("----------------------------------");
			List<User> userList = UserList.getUserArrayList();
			for (int i = 0; i < userList.size(); i++) {
				User user = userList.get(i);
				System.out.println(
						user.getLogin() + " " + user.getPassword() + " " + user.getRole()
				);
			}
			System.out.println("----------------------------------");
			System.out.println("Введите операцию (CREATE/READ/UPDATE/DELETE,ESC):");
			String cmd = in.nextLine().toUpperCase();

			if(Commands.ESC.toString().equals(cmd)){
				System.out.println("До свидания!");
				break;
				// TODO: 12/3/2023 Commands.ESC.toString().equals(cmd)
			} else if(Commands.CREATE.toString().equals(cmd)){
				new CreateUserInterface().createUser();
			} else if(Commands.READ.toString().equals(cmd)){
				// TODO: 12/3/2023 Commands.READ.toString().equals(cmd)
			} else if(Commands.UPDATE.toString().equals(cmd)){
				// TODO: 12/3/2023 Commands.UPDATE.toString().equals(cmd)
			}else if (Commands.DELETE.toString().equals(cmd)){
			} else {
				System.out.println("Неверно введена команда");
			}
		}
	}

//	private void createUser() {
//		boolean repeat = true;
//		while (repeat) {
//			System.out.println("Введите данные пользователя:");
//			System.out.print("Логин: ");
//			String login = in.nextLine();
//			System.out.print("Пароль: ");
//			String password = in.nextLine();
//			System.out.print("Роль: ");
//			String roleString = in.nextLine().toUpperCase();
//
//			Role role = RoleValidation.validateRoleFromString(roleString);
//
//			if (!role.equals(Role.NO_ROLE)) {
//				System.out.println("Неверно указана роль пользователя!");
//				continue;
//			}
//			UserList.userArrayList.add(new User(
//					login, password, role
//			));
//			repeat = false;
//		}
//	}
}
