package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.EventHandler;

import java.net.URL;
import java.util.ResourceBundle;

public class MyController implements Initializable {
	@FXML
	public Label welcomeLabel;

	@FXML
	public ChoiceBox<String> choiceBox;

	@FXML
	public TextField userInputField;

	@FXML
	public Button convertButton;

	private static final String C_to_F_Text ="Celsius to Fahrenheit";
	private static final String F_to_C_Text="Fahrenheit to celsius";

	private boolean isC_to_F = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choiceBox.getItems().add(C_to_F_Text);
		choiceBox.getItems().add(F_to_C_Text);

		choiceBox.setValue(C_to_F_Text);

		choiceBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
			if (newValue.equals(C_to_F_Text)) {
				isC_to_F = true;
			} else {
				isC_to_F = false;
			}
		});

		convertButton.setOnAction(event -> {
			convert();
		});
	}

	private void convert(){
		 String input=userInputField.getText();
		float enteredTemperature = 0.0F;
		try {
			enteredTemperature = Float.parseFloat(input);
		} catch (Exception exception){
			WarnUser();
			return;
		}

		float newTemperature = 0.0f;
		if(isC_to_F){
			newTemperature = (enteredTemperature*9/5)+32;
		 }else {
		 	newTemperature = (enteredTemperature-32)*5/9;
		 }
		 display(newTemperature);
	}

	private void WarnUser() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occured");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please enter a valid temperature");
		alert.show();
	}

	private void display(float newTemperature) {
		String unit = isC_to_F? "F":"C";
		System.out.println("The new temperature is: "+ newTemperature + unit);

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new temperature is: "+ newTemperature + unit);
		alert.show();
	}


}

