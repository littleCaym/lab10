module com.example.lab10 {
	requires javafx.controls;
	requires javafx.fxml;

	opens com.example.lab10 to javafx.fxml;
	exports com.example.lab10;
	exports com.example.lab10.application;
	opens com.example.lab10.application to javafx.fxml;
	exports com.example.lab10.entity;
	opens com.example.lab10.entity to javafx.fxml;
	exports com.example.lab10.interfaces;
	opens com.example.lab10.interfaces to javafx.fxml;
	exports com.example.lab10.validation;
	opens com.example.lab10.validation to javafx.fxml;
	exports com.example.lab10.repository;
	opens com.example.lab10.repository to javafx.fxml;
}