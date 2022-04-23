
package mklibrary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;


public class ErrorsFXMLController {

    @FXML
    private Text errorMessage;
    
    public void printError(String mes){
        errorMessage.setText(mes);
        
    }
   
}
