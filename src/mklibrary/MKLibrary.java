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

public class MKLibrary extends Application {

    private static Stage addBookStage = null;
    private static Stage errorStage = null;
    private static Stage searchStage = null;
    private static Stage bookInfoStage = null;
    private static Stage returnBookStage = null;
    private static ArrayList<Book> library = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("mklibraryfxml.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("MK Library");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        createErrorStage();
        createAddBookStage();
        createSearchBookStage();
        createBookInfoWindow();
        createReturnBookStage();
    }

    public void createReturnBookStage(){
        returnBookStage = new Stage();
        returnBookStage.setTitle("Book Return");
        returnBookStage.setAlwaysOnTop(true);
        returnBookStage.setResizable(false);
        returnBookStage.initModality(Modality.APPLICATION_MODAL);
    }
    
    public void createAddBookStage() {
        addBookStage = new Stage();
        addBookStage.setTitle("Add a Book!");
        addBookStage.setAlwaysOnTop(true);
        addBookStage.setResizable(false);
        addBookStage.initModality(Modality.APPLICATION_MODAL);
    }

    public void createSearchBookStage() {
        searchStage = new Stage();
        searchStage.setTitle("Search a Book!");
        searchStage.setAlwaysOnTop(true);
        searchStage.setResizable(false);
        searchStage.initModality(Modality.APPLICATION_MODAL);
    }

    public void createErrorStage() {
        errorStage = new Stage();
        errorStage.setTitle("ERROR");
        errorStage.setAlwaysOnTop(true);
        errorStage.setResizable(false);
        errorStage.initModality(Modality.APPLICATION_MODAL);
    }

    public void createBookInfoWindow(){
        bookInfoStage = new Stage();
        bookInfoStage.setTitle("Book Information");
        bookInfoStage.setAlwaysOnTop(true);
        bookInfoStage.setResizable(false);
        bookInfoStage.initModality(Modality.APPLICATION_MODAL);
    }
    
    public static Stage getReturnBookStage(){
        return returnBookStage;
    }
    
    public static Stage getBookInfoStage(){
        return bookInfoStage;
    }
    
    public static Stage getErrorStage() {
        return errorStage;
    }

    public static Stage getAddBookStage() {
        return addBookStage;
    }

    public static Stage getSearchBookStage() {
        return searchStage;
    }

    public static ArrayList<Book> getLibrary() {
        return library;
    }

    public static void main(String[] args) {
        launch(args);
    }

}