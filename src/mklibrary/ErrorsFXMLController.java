package mklibrary;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ErrorsFXMLController {

    @FXML
    private Text errorMessage; // Reference to the label in the FXML file

    public void printError(String mes) {
        errorMessage.setText(mes); // Set the label to the string passed in

    }
}
