package mklibrary;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ErrorsFXMLController {

    @FXML
    private Text errorMessage;

    public void printError(String mes) {
        errorMessage.setText(mes);

    }
}
