package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import gui.util.Alerts;
import javafx.scene.control.Alert.AlertType;

public class ConexaoDAO {
	
	public Connection conectaBD() {
		Connection conn = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/bancoteste?user=root&password=";
			conn = DriverManager.getConnection(url);
			
		} catch (SQLException e) {
			Alerts.showAlert("Error", null,"ConexaoDAO" + e.getMessage(), AlertType.ERROR);
		}
		return conn;
	}

}


