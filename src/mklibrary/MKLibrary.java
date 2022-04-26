//Names: Ryan Vassalotti and Carter Hanson
//Date: 4/26/22
//Emails: vassryan@aol.com, cahanson18@gmail.com
//Course: CSC2290 001
//Assignment Desc: Program 5 - MK Library
//Honor code: “I will practice academic and personal integrity and
//excellence of character and expect the same from others.” 

package mklibrary;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MKLibrary extends Application { // Main class

    private static Stage addBookStage = null; // Reference to the stage for the add book window
    private static Stage errorStage = null; // Reference to the stage for the error window
    private static Stage searchStage = null; // Reference to the stage for the search window
    private static Stage bookInfoStage = null; // Reference to the stage for the book info window
    private static Stage returnBookStage = null; // Reference to the stage for the return book window
    private static ArrayList<Book> library = new ArrayList<>(); // ArrayList of books in the library

    @Override
    public void start(Stage primaryStage) throws Exception { // Override the start method
        Parent root = FXMLLoader.load(getClass().getResource("mklibraryfxml.fxml")); // Load the fxml file
        primaryStage.setResizable(false); // Set the stage to not be resizable
        primaryStage.setTitle("MK Library"); // Set the title of the stage
        primaryStage.setScene(new Scene(root)); // Set the scene of the stage
        primaryStage.show(); // Show the stage
        createErrorStage(); // Create the error stage
        createAddBookStage(); // Create the add book stage
        createSearchBookStage(); // Create the search book stage
        createBookInfoWindow(); // Create the book info window
        createReturnBookStage(); // Create the return book stage
    }

    public void createReturnBookStage(){ // Create the return book stage
        returnBookStage = new Stage(); // Create a new stage
        returnBookStage.setTitle("Book Return"); // Set the title of the stage
        returnBookStage.setAlwaysOnTop(true); // Set the stage to always be on top
        returnBookStage.setResizable(false); // Set the stage to not be resizable
        returnBookStage.initModality(Modality.APPLICATION_MODAL); // Set the stage to be modal
    }

    public void createAddBookStage() { // Create the add book stage
        addBookStage = new Stage(); // Create a new stage
        addBookStage.setTitle("Add a Book!"); // Set the title of the stage
        addBookStage.setAlwaysOnTop(true); // Set the stage to always be on top
        addBookStage.setResizable(false); // Set the stage to not be resizable
        addBookStage.initModality(Modality.APPLICATION_MODAL); // Set the stage to be modal
    }

    public void createSearchBookStage() { // Create the search book stage
        searchStage = new Stage(); // Create a new stage
        searchStage.setTitle("Search a Book!"); // Set the title of the stage
        searchStage.setAlwaysOnTop(true); // Set the stage to always be on top
        searchStage.setResizable(false); // Set the stage to not be resizable
        searchStage.initModality(Modality.APPLICATION_MODAL);   // Set the stage to be modal
    }

    public void createErrorStage() { // Create the error stage
        errorStage = new Stage(); // Create a new stage
        errorStage.setTitle("ERROR"); // Set the title of the stage
        errorStage.setAlwaysOnTop(true); // Set the stage to always be on top
        errorStage.setResizable(false); // Set the stage to not be resizable
        errorStage.initModality(Modality.APPLICATION_MODAL); // Set the stage to be modal
    }

    public void createBookInfoWindow(){ // Create the book info window
        bookInfoStage = new Stage(); // Create a new stage
        bookInfoStage.setTitle("Book Information"); // Set the title of the stage
        bookInfoStage.setAlwaysOnTop(true); // Set the stage to always be on top
        bookInfoStage.setResizable(false); // Set the stage to not be resizable
        bookInfoStage.initModality(Modality.APPLICATION_MODAL); // Set the stage to be modal
    }

    public static Stage getReturnBookStage(){ // Get the returnBook stage
        return returnBookStage;
    }

    public static Stage getBookInfoStage(){ // Get the bookInfo stage
        return bookInfoStage;
    }

    public static Stage getErrorStage() { // Get the error stage
        return errorStage;
    }

    public static Stage getAddBookStage() { // Get the addBook stage
        return addBookStage;
    }

    public static Stage getSearchBookStage() { // Get the searchBook stage
        return searchStage;
    }

    public static ArrayList<Book> getLibrary() { // Get the library
        return library;
    }

    public static void main(String[] args) {
        launch(args); // Launch the application
    }

}