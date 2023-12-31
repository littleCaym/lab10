package com.example.lab10;

import com.example.lab10.application.AdminApplication;
import com.example.lab10.application.AuthApplication;
import com.example.lab10.entity.User;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

	@Override
	public void start(Stage stage) throws IOException {
//		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//		Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//		stage.setTitle("Hello!");
//		stage.setScene(scene);
//		stage.show();
	}

	public static void main(String[] args) {
		User user = new AuthApplication().show();
		new AdminApplication().show();

//		switch (user.getRole()){
//			case ADMINISTRATOR -> new AdministratorInterface().show(); break;
//			case ACCOUNTANT -> new AccountantInterface().show(); break;
//		}
	}

}