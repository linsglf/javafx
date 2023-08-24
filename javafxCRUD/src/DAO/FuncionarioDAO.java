package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import DTO.FuncionarioDTO;
import gui.util.Alerts;
import javafx.scene.control.Alert.AlertType;

public class FuncionarioDAO {
	
	Connection conn;
	PreparedStatement pstm;
	
	public void cadastrarFuncionario(FuncionarioDTO objFuncionarioDTO) {
		String sql = "INSERT INTO funcionario (nome_funcionario, departamento_funcionario) VALUES (?,?);";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objFuncionarioDTO.getNomeFuncionario());
			pstm.setString(2, objFuncionarioDTO.getDepartamentoFuncionario());
		
			pstm.execute();
			pstm.close();
			
		} catch (Exception e) {
			
			Alerts.showAlert("Error", null,"FuncionarioDAO" + e.getMessage(), AlertType.ERROR);
		}
	}
}
