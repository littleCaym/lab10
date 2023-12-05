package com.example.lab10;

import java.util.List;
import java.util.Scanner;

public class AdminApplication {
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
						user.getId() + " " + user.getLogin() + " " + user.getPassword() + " " + user.getRole()
				);
			}
			System.out.println("----------------------------------");
			System.out.println("Введите операцию (CREATE/READ/UPDATE/DELETE,ESC):");

			String cmd = in.nextLine().toUpperCase();

			if(Command.ESC.toString().equals(cmd)){
				System.out.println("До свидания!");
				return;
			} else if(Command.CREATE.toString().equals(cmd)){
				CRUDUserInterface.createUser();
			} else if(Command.READ.toString().equals(cmd)){
				CRUDUserInterface.readUser();
			} else if(Command.UPDATE.toString().equals(cmd)){
				// TODO: 12/3/2023 Commands.UPDATE.toString().equals(cmd)
			} else if (Command.DELETE.toString().equals(cmd)){
				CRUDUserInterface.deleteUser();
			} else {
				System.out.println("Введена неверная команда");
			}
		}
	}
}
