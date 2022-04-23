
package mklibrary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;


public class ErrorsFXMLController {

    @FXML
    private TextField errorMessage;
    
    public void printError(String mes){
        errorMessage.setText(mes);
        
    }
   
}
