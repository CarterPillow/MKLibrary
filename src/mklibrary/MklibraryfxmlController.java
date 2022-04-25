package mklibrary;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class MklibraryfxmlController {
    @FXML
    private Button addBook;

    @FXML
    private Button searchBook;

    public void addBooks() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddBooksFXML.fxml"));
            Parent root = loader.load();

            MKLibrary.getAddBookStage().setScene(new Scene(root));

            AddBooksFXMLController addBookController = loader.getController();

            MKLibrary.getAddBookStage().show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void searchBooks() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("searchfxml.fxml"));
            Parent root = loader.load();

            MKLibrary.getSearchBookStage().setScene(new Scene(root));

            SearchBookFXMLController searchBookController = loader.getController();

            MKLibrary.getSearchBookStage().show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
