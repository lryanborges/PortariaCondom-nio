package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConexaoDAO{
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3307/condominio";	// remover esse ":3307" ou adicionar a porta q seu BD tá
	String user = "root";	// colocar seu usuario, mas geralmente é "root" mesmo
	String password = "admin";	// colocar a senha de acesso aos seus BDs

	synchronized public Connection getConnection() {
		if(conn == null) {
			try {
				conn = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		else return conn;
	}
}
