package mklibrary;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddBooksFXMLController {
    @FXML
    private SplitMenuButton genreMenu;

    @FXML
    private TextField title;

    @FXML
    private TextField author;

    @FXML
    private TextField year;

    @FXML
    private TextArea summary;

    public void setGenre(ActionEvent mo) {
        MenuItem mi = (MenuItem) mo.getSource();

        genreMenu.setText(mi.getText());
    }

    public boolean containsOnlyDigits(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!(Character.isDigit(s.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public void submitButton() {
        if (containsOnlyDigits(year.getText()) && !title.getText().equals("")
                && !genreMenu.getText().equals("Select Genre") && !author.getText().equals("")) {

            Book beeb = new Book(title.getText(), author.getText(), Integer.parseInt(year.getText()), summary.getText(),
                    genreMenu.getText());
            if (MKLibrary.getLibrary().isEmpty()){
                MKLibrary.getLibrary().add(beeb);
            }
            else{
                for (Book searchBook: MKLibrary.getLibrary()) {
                    if (beeb.getDewey() < searchBook.getDewey()){
                        MKLibrary.getLibrary().add(MKLibrary.getLibrary().indexOf(searchBook),beeb);
                        break;
                    }
                    else if (MKLibrary.getLibrary().indexOf(searchBook) == MKLibrary.getLibrary().size() -1){
                        MKLibrary.getLibrary().add(beeb);
                        break;
                    }
                }
            }  
            MKLibrary.getAddBookStage().close();
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ErrorsFXML.fxml"));
                Parent root = loader.load();

                MKLibrary.getErrorStage().setScene(new Scene(root));

                ErrorsFXMLController errorBookController = loader.getController();

                MKLibrary.getErrorStage().show();
                errorBookController.printError("One or more fields was not entered correctly.");
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

    }

}
