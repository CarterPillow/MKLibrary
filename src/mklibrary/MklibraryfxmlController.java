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
        MKLibrary.getLibrary().add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Grapes of Wrath", "John Steinbeck", 1939, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Scarlet Letter", "Nathaniel Hawthorne", 1850, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Grapes of Wrath", "John Steinbeck", 1939, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Scarlet Letter", "Nathaniel Hawthorne", 1850, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Grapes of Wrath", "John Steinbeck", 1939, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Scarlet Letter", "Nathaniel Hawthorne", 1850, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Grapes of Wrath", "John Steinbeck", 1939, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Scarlet Letter", "Nathaniel Hawthorne", 1850, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, "A children's General Works novel", "General Works"));
        MKLibrary.getLibrary().add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, "A children's General Works novel", "General Works"));
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("searchfxml.fxml"));
            Parent root = loader.load();

            MKLibrary.getSearchBookStage().setScene(new Scene(root));

            SearchBookFXMLController searchBookController = loader.getController();

            searchBookController.createBookList();

            MKLibrary.getSearchBookStage().show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
