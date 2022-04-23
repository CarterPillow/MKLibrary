/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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

}
