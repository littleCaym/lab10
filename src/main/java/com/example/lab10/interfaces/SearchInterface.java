package com.example.lab10.interfaces;

import com.example.lab10.entity.Role;
import com.example.lab10.entity.User;
import com.example.lab10.repository.UserList;
import com.example.lab10.validation.InputValidation;
import com.example.lab10.validation.RoleValidation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * todo Document type SearchInterface
 */
public class SearchInterface {

	public static void show(){
		Scanner in = new Scanner(System.in);

		boolean repeat = true;
		while (repeat) {
			System.out.println();

			System.out.println("----------------------------------");
			System.out.println(
					"ID" + " " + "Логин" + " " + "Пароль" + " " + "Роль"
			);
			List<User> userList = UserList.getUserArrayList();
			for (int i = 0; i < userList.size(); i++) {
				User user = userList.get(i);
				System.out.println(
						user.getId() + " " + user.getLogin() + " " + user.getPassword() + " " + user.getRole()
				);
			}
			System.out.println("----------------------------------");
			System.out.println();

			System.out.println("Введите атрибут для поиска (ID, LOGIN, PASSWORD, ROLE) или ESC для выхода");
			String attributeString = in.nextLine().toUpperCase();

			List<User> outputList = new ArrayList<>();

			switch (attributeString){
				case User.ID -> {
					System.out.print("Введите ID: ");
					long id = InputValidation.tryParseInt(in.nextLine(), -1);
					if (id == -1){
						System.out.println("Ошибка ввода");
						break;
					}
					User user = UserList.getUser(id);
					if (user.equals(UserList.userEmpty)){
						System.out.println("Пользователь не найден");
					} else {
						outputList.add(user);
					}
				}
				case User.LOGIN -> {
					System.out.print("Введите логин: ");
					String login = in.nextLine();
					if (login == null || login.isBlank()){
						System.out.println("Ошибка ввода");
						break;
					}
					User user = UserList.getUser(login);
					if (user.equals(UserList.userEmpty)){
						System.out.println("Пользователь не найден");
					} else {
						outputList.add(user);
					}
				}
				case User.PASSWORD -> {
					System.out.print("Введите пароль: ");
					String password = in.nextLine();
					if (password == null || password.isBlank()){
						System.out.println("Ошибка ввода");
						break;
					}
					outputList = UserList.getUserListByPassword(password);
					if (outputList.isEmpty()){
						System.out.println("Пользователи не найдены");
					}
				}
				case User.ROLE -> {
					System.out.print("Введите роль: ");
					Role role = RoleValidation.validateFromString(
							in.nextLine().toUpperCase());
					if (role.equals(Role.NO_ROLE)){
						System.out.println("Роль не найдена");
						break;
					}
					outputList = UserList.getUserListByRole(role);
					if (outputList.isEmpty()){
						System.out.println("Пользователи не найдены");
					}
				}
				case "ESC" -> {
					return;
				}
				default -> {
					System.out.println("Ошибка ввода");
				}
			}
			System.out.println("----------РЕЗУЛЬТАТ:------------------------");
			System.out.println(
					"ID" + " " + "Логин" + " " + "Пароль" + " " + "Роль"
			);
			for (int i = 0; i < outputList.size(); i++) {
				User user = outputList.get(i);
				System.out.println(
						user.getId() + " " + user.getLogin() + " " + user.getPassword() + " " + user.getRole()
				);
			}
			System.out.println("--------------------------------------------");
			System.out.println("Для продолжения нажмите Enter");
			in.nextLine();
		}

	}
}
