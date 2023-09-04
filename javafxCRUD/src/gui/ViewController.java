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
	private Button btnClear;
	@FXML
	private Button btncCarregarCampos;
	@FXML
	private Button btnUpdate;
	@FXML
	private Button btnDelete;
	@FXML
	private TableView<FuncionarioDTO> tabelaFuncionario;
	@FXML
	private TableColumn<FuncionarioDTO, String> departamentoColumn;
	@FXML
	private TableColumn<FuncionarioDTO, Integer> idColumn;
	@FXML
	private TableColumn<FuncionarioDTO, String> nomeColumn;


	@FXML
	public void initialize() {
		listarValores();
	}

	// Event Listener on Button[#btnCadastrar].onAction
	@FXML
	public void btnCadastrarActionPerformed(ActionEvent event) {
		cadastrarFuncionario();
		listarValores();
	}

	@FXML
	void btnClearActionPerformed(ActionEvent event) {
		limparCampos();
	}

	@FXML
	public void btnCarregarCampos(ActionEvent event) {
		carregarCampos();
	}
	@FXML
	public void btnUpdateTableValue(ActionEvent event) {
		updateFuncionario();
		listarValores();
		limparCampos();
	}
	@FXML
	void btnDeleteAction(ActionEvent event) {
		deleteFuncionario();
		listarValores();
	}

	private void cadastrarFuncionario() {
		String nome, departamento;

		nome = txtNome.getText();

		departamento = txtDepartamento.getText();

		FuncionarioDTO objFuncionarioDTO = new FuncionarioDTO();
		objFuncionarioDTO.setNomeFuncionario(nome);
		objFuncionarioDTO.setDepartamentoFuncionario(departamento);

		FuncionarioDAO objFuncionarioDAO = new FuncionarioDAO();
		objFuncionarioDAO.cadastrarFuncionario(objFuncionarioDTO);
	}

	private void listarValores() {
		try	{
			FuncionarioDAO objFuncionarioDAO = new FuncionarioDAO();
			List<FuncionarioDTO> listaFuncionarios = objFuncionarioDAO.pesquisarFuncionario();

			idColumn.setCellValueFactory(new PropertyValueFactory<>("idFuncionario"));
			nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nomeFuncionario"));
			departamentoColumn.setCellValueFactory(new PropertyValueFactory<>("departamentoFuncionario"));

			tabelaFuncionario.setItems(FXCollections.observableArrayList(listaFuncionarios));
		} catch (Exception e) {
			Alerts.showAlert("Error", null,"VIEW TABLE" + e.getMessage(), Alert.AlertType.ERROR);
		}
	}

	private void carregarCampos() {
		FuncionarioDTO selectedFuncionario = tabelaFuncionario.getSelectionModel().getSelectedItem();

		if (selectedFuncionario != null) {
			txtNome.setText(selectedFuncionario.getNomeFuncionario());
			txtDepartamento.setText(selectedFuncionario.getDepartamentoFuncionario());
			txtNome.requestFocus();
		}
	}

	private void limparCampos() {
		txtNome.setText("");
		txtDepartamento.setText("");
	}

	private void updateFuncionario() {
		FuncionarioDTO selectedFuncionario = tabelaFuncionario.getSelectionModel().getSelectedItem();
		FuncionarioDTO objFuncionarioDTO = new FuncionarioDTO();
		FuncionarioDAO objFuncionarioDAO = new FuncionarioDAO();

		if (selectedFuncionario != null && (!txtNome.getText().isEmpty() && !txtDepartamento.getText().isEmpty())) {
			int idFuncionario = selectedFuncionario.getIdFuncionario();
			String nomeFuncionario = txtNome.getText();
			String departamentoFuncionario = txtDepartamento.getText();

			objFuncionarioDTO.setIdFuncionario(idFuncionario);
			objFuncionarioDTO.setNomeFuncionario(nomeFuncionario);
			objFuncionarioDTO.setDepartamentoFuncionario(departamentoFuncionario);

			objFuncionarioDAO.updateFuncionario(objFuncionarioDTO);
		}else {
			Alerts.showAlert("Informações inválidas!", null,"Preencha os campos corretamente!", Alert.AlertType.WARNING);
		}
	}

	private void deleteFuncionario() {
		FuncionarioDTO selectedFuncionario = tabelaFuncionario.getSelectionModel().getSelectedItem();
		FuncionarioDTO objFuncionarioDTO = new FuncionarioDTO();
		FuncionarioDAO objFuncionarioDAO = new FuncionarioDAO();

		if (selectedFuncionario != null) {
			int idFuncionario = selectedFuncionario.getIdFuncionario();
			objFuncionarioDTO.setIdFuncionario(idFuncionario);

			objFuncionarioDAO.deletFuncionario(objFuncionarioDTO);
		}else {
			Alerts.showAlert("Delete ERROR", null,"Unable to delete!", Alert.AlertType.ERROR);
		}
	}
}

