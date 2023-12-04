package com.example.lab10;

import java.io.Console;
import java.util.Scanner;

// TODO: 12/3/2023 Добавить защиту от дураков
// TODO: 12/3/2023 Добавить повторный ввод
public class AuthInterface {
	private ResultValidation resultValidation;
	public User show(){
		while (true){
			Scanner in = new Scanner(System.in);
			User user = new User();

			System.out.println("АВТОРИЗАЦИЯ");
			System.out.println("---------");

			System.out.print("Логин: ");
			String login = in.nextLine();
			System.out.print("Пароль: ");
			String password = in.nextLine();

			user.setLogin(login);
			user.setPassword(password);

			resultValidation = new Auth().userValidation(user);

			switch (resultValidation.getResponseCode()) {
				case -1 -> {
					System.out.println("Неверно введен логин или пароль!");
					System.out.println();
				}
				case 1 -> {
					System.out.println("Авторизация пройдена успешно!");
					System.out.println("Роль: " + resultValidation.getUser().getRole());
					System.out.println();
					return user;
				}
				default -> {
					System.out.println("Ошибка ввода!");
					System.out.println();
				}
			}
		}
	}
}
