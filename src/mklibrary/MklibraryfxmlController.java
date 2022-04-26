package mklibrary;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
// Controller for the home page
public class MklibraryfxmlController {
    @FXML
    private Button addBook; // Reference to the add book button

    @FXML
    private Button searchBook; // Reference to the search book button

    @FXML
    private Button returnBookButton; // Reference to the return book button

    public void returnBooks(){ // Method to open return books window
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ReturnBookFXML.fxml"));
            Parent root = loader.load(); // Load the fxml file

            MKLibrary.getReturnBookStage().setScene(new Scene(root)); // Set the scene of the stage

            ReturnBookFXMLController returnBookController = loader.getController(); // Get the controller of the fxml file
            returnBookController.createBookList(); // Create the book list

            MKLibrary.getReturnBookStage().show(); // Show the stage
        } catch (IOException ex) { // Catch the IOException
            System.out.println(ex);
        }
    }

    public void addBooks() { // Method to open add books window
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddBooksFXML.fxml"));
            Parent root = loader.load(); // Load the fxml file

            MKLibrary.getAddBookStage().setScene(new Scene(root)); // Set the scene of the stage

            MKLibrary.getAddBookStage().show(); // Show the stage
        } catch (IOException ex) { // Catch the IOException
            System.out.println(ex);
        }
    }

    public void searchBooks() { // Method to open search books window
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("searchfxml.fxml")); // Load the fxml file
            Parent root = loader.load();

            MKLibrary.getSearchBookStage().setScene(new Scene(root)); // Set the scene of the stage

            SearchBookFXMLController searchBookController = loader.getController(); // Get the controller of the fxml file

            searchBookController.createBookList(searchBookController); // Create the book list

            MKLibrary.getSearchBookStage().show(); // Show the stage
        } catch (IOException ex) { // Catch the IOException
            System.out.println(ex);
        }
    }

}
