package gui;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import DAO.FuncionarioDAO;
import DTO.FuncionarioDTO;
import javafx.event.ActionEvent;

public class ViewController {
	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtDepartamento;
	@FXML
	private Button btnCadastrar;

	// Event Listener on Button[#btnCadastrar].onAction
	@FXML
	public void btnCadastrarActionPerformed(ActionEvent event) {
		String nome, departamento;
		
		nome = txtNome.getText();
		
		departamento = txtDepartamento.getText();
		
		FuncionarioDTO objFuncionarioDTO = new FuncionarioDTO(); 
		objFuncionarioDTO.setNomeFuncionario(nome);
		objFuncionarioDTO.setDepartamentoFuncionario(departamento);
		
		FuncionarioDAO objFuncionarioDAO = new FuncionarioDAO();
		objFuncionarioDAO.cadastrarFuncionario(objFuncionarioDTO);
	}
}
