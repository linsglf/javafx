package gui;

import gui.util.Alerts;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import javafx.scene.control.*;

import DAO.FuncionarioDAO;
import DTO.FuncionarioDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;

public class ViewController {
	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtDepartamento;
	@FXML
	private Button btnCadastrar;
	@FXML
	private TableColumn<FuncionarioDTO, String> departamentoColumn;
	@FXML
	private TableColumn<FuncionarioDTO, Integer> idColumn;
	@FXML
	private TableColumn<FuncionarioDTO, String> nomeColumn;
	@FXML
	private TableView<FuncionarioDTO> tabelaFuncionario;

	@FXML
	public void initialize() {
		listarValores();
	}

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

		listarValores();
	}

	private void listarValores() {
		try	{
			FuncionarioDAO objFuncionarioDAO = new FuncionarioDAO();
			List<FuncionarioDTO> listaFuncionarios = objFuncionarioDAO.PesquisarFuncionario();

			idColumn.setCellValueFactory(new PropertyValueFactory<>("idFuncionario"));
			nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nomeFuncionario"));
			departamentoColumn.setCellValueFactory(new PropertyValueFactory<>("departamentoFuncionario"));

			tabelaFuncionario.setItems(FXCollections.observableArrayList(listaFuncionarios));
		} catch (Exception e) {
			Alerts.showAlert("Error", null,"VIEW TABLE" + e.getMessage(), Alert.AlertType.ERROR);
		}
	}
}
