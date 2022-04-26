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

// Controller for the add books page
public class AddBooksFXMLController {
    @FXML
    private SplitMenuButton genreMenu; // Reference to the genre menu button

    @FXML
    private TextField title; // Reference to the title text field

    @FXML
    private TextField author; // Reference to the author text field

    @FXML
    private TextField year; // Reference to the year text field

    @FXML
    private TextArea summary; // Reference to the summary text area

    public void setGenre(ActionEvent mo) { // Method to set the genre
        MenuItem mi = (MenuItem) mo.getSource(); // Get the menu item that was clicked

        genreMenu.setText(mi.getText()); // Set the text of the menu button to the text of the menu item
    }

    public boolean containsOnlyDigits(String s) { // Method to check if a string contains only digits
        for (int i = 0; i < s.length(); i++) { // Loop through the string
            if (!(Character.isDigit(s.charAt(i)))) { // If the character is not a digit return false
                return false;
            }
        }
        return true;
    }

    public void submitButton() { // Method to submit the book
        if (containsOnlyDigits(year.getText()) && !title.getText().equals("")                               // If the year is a number and the title is not empty
                && !genreMenu.getText().equals("Select Genre") && !author.getText().equals("")) {  // and the genre is not empty and the author is not empty

            Book book = new Book(title.getText(), author.getText(), Integer.parseInt(year.getText()), summary.getText(),
                    genreMenu.getText()); // Create a new book
            if (MKLibrary.getLibrary().isEmpty()){ // check if the library is empty add the book to the library
                MKLibrary.getLibrary().add(book);
            }
            else{
                for (Book searchBook: MKLibrary.getLibrary()) { // Loop through the library
                    if (book.getDewey() < searchBook.getDewey()){ // If the book's dewey number is less than the current book's dewey number add the book to the library
                        MKLibrary.getLibrary().add(MKLibrary.getLibrary().indexOf(searchBook),book);
                        break;
                    }
                    else if (MKLibrary.getLibrary().indexOf(searchBook) == MKLibrary.getLibrary().size() -1){ // If the index of the current book is the last book in the library add the book to the library at the end
                        MKLibrary.getLibrary().add(book);
                        break;
                    }
                }
            }
            MKLibrary.getAddBookStage().close(); // Close the add book stage
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ErrorsFXML.fxml"));
                Parent root = loader.load(); // Load the errors FXML

                MKLibrary.getErrorStage().setScene(new Scene(root)); // Set the scene of the error stage to the errors FXML

                ErrorsFXMLController errorBookController = loader.getController(); // Get the controller of the errors FXML

                MKLibrary.getErrorStage().show(); // Show the error stage
                errorBookController.printError("One or more fields was not entered correctly.");
            } catch (IOException ex) { // Catch the IOException
                System.out.println(ex);
            }
        }

    }

}
