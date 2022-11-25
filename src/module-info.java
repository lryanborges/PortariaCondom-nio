module modulo {
	
	exports model.entity;
	exports model.services;
	exports model.dao;

	requires java.sql;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens viewer to javafx.graphics, javafx.fxml;
	opens controller.api to javafx.graphics, javafx.fxml, javafx.base;
	opens controller.dto to javafx.graphics, javafx.fxml, javafx.base;
	
}