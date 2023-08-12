package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.scene.control.Label;

public class ViewController implements Initializable {
	@FXML
	private TextField textFieldFirstNumber;
	@FXML
	private TextField textFieldSecondNumber;
	@FXML
	private Button btSum;
	@FXML
	private Label labelResult;

	// Event Listener on Button[#btSum].onAction
	@FXML
	public void onBtSumAction() {
		try {
			Locale.setDefault(Locale.US);
			double number1 = Double.parseDouble(textFieldFirstNumber.getText());
			double number2 = Double.parseDouble(textFieldSecondNumber.getText());
			double sum = number1 + number2;
			labelResult.setText(String.format("%.2f", sum));
		} 
		catch (NumberFormatException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Constraints.setTextFieldDouble(textFieldFirstNumber);
		Constraints.setTextFieldDouble(textFieldFirstNumber);
		Constraints.setTextFieldMaxLength(textFieldFirstNumber, 12);
		Constraints.setTextFieldMaxLength(textFieldFirstNumber, 12);
	}
}
