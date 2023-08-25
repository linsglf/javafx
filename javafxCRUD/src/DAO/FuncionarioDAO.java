package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;

import DTO.FuncionarioDTO;
import gui.util.Alerts;
import javafx.scene.control.Alert.AlertType;

public class FuncionarioDAO {
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<FuncionarioDTO> lista = new ArrayList<>();
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

			Alerts.showAlert("Error", null,"FuncionarioDAO Cadastrar" + e.getMessage(), AlertType.ERROR);
		}
	}

	public ArrayList<FuncionarioDTO> PesquisarFuncionario() {
		String sql = "SELECT * FROM funcionario;";

		conn = new ConexaoDAO().conectaBD();

		try{
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()){
				FuncionarioDTO objFuncionarioDTO = new FuncionarioDTO();
				objFuncionarioDTO.setIdFuncionario(rs.getInt("id_funcionario"));
				objFuncionarioDTO.setNomeFuncionario(rs.getString("nome_funcionario"));
				objFuncionarioDTO.setDepartamentoFuncionario(rs.getString("departamento_funcionario"));

				lista.add(objFuncionarioDTO);
			}
		} catch (Exception e) {
			Alerts.showAlert("Error", null,"FuncionarioDAO Pesquisar:" + e.getMessage(), AlertType.ERROR);
		}

		return lista;
	}

	public void updateFuncionario(FuncionarioDTO objFuncionarioDTO) {
		String sql = "UPDATE funcionario SET nome_funcionario = ?, departamento_funcionario = ? WHERE id_funcionario = ?;";

		conn = new ConexaoDAO().conectaBD();

		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objFuncionarioDTO.getNomeFuncionario());
			pstm.setString(2, objFuncionarioDTO.getDepartamentoFuncionario());
			pstm.setInt(3, objFuncionarioDTO.getIdFuncionario());

			pstm.execute();
			pstm.close();
		} catch (Exception e) {

			Alerts.showAlert("Error", null,"FuncionarioDAO Update" + e.getMessage(), AlertType.ERROR);
		}
	}
}
