package mklibrary;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

// Controller for the search book page
public class SearchBookFXMLController {

    @FXML
    private TableView bookList; // table view for the library search results

    @FXML
    private TableColumn<Book, String> titleColumn; // table column for the book title

    @FXML
    private TableColumn<Book, String> authorColumn; // table column for the book author

    @FXML
    private TableColumn<Book, String> genreColumn; // table column for the book genre

    @FXML
    private TableColumn<Book, String> yearColumn; // table column for the book year

    @FXML
    private TableColumn<Book, String> deweyColumn; // table column for the book dewey number

    @FXML
    private TextField searchField; // text field for the search bar

    private int selectedDewey = -1; // dewey number of the selected book

    private SearchBookFXMLController cont; // controller for the search book page

    public void createBookList(SearchBookFXMLController con){ // creates the table view for the library search results
        cont = con; // sets the controller for the search book page
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title")); // This makes the column "title" in the table view display the title of the book
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author")); // This makes the column "author" in the table view display the author of the book
        genreColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("genre")); // This makes the column "genre" in the table view display the genre of the book
        yearColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("year")); // This makes the column "year released" in the table view display the year of the book
        deweyColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("dewey")); // This makes the column "dewey number" in the table view display the dewey number of the book

        for (Book b: MKLibrary.getLibrary()) { // adds all the books in the library to the table view if they are not checked out
            if (b.isCheckedOut() == false){
                bookList.getItems().add(b);
            }
        }

        bookList.refresh();
    }

    public void refreshSearch(){ // refreshes the search results
        ObservableList<Book> books = bookList.getItems(); // gets the list of books in the table view
            books.clear(); // clears the list of books in the table view
            for (Book b: MKLibrary.getLibrary()) { // adds all the books in the library to the table view if they are not checked out
                if (b.isCheckedOut() == false){
                    books.add(b);
                }
        }
            bookList.refresh();
    }

    public void openBookPage(MouseEvent e){ // opens the book page for the selected book
        Book book = (Book) bookList.getSelectionModel().getSelectedItem(); // gets the selected book
        if (book != null && book.getDewey() != selectedDewey){ // if the selected book is not null and the dewey number of the selected book is not the same as the dewey number of the previously selected book

             try { // tries to open the book page
                FXMLLoader loader = new FXMLLoader(getClass().getResource("BookInfoFXML.fxml")); 
                Parent root = loader.load(); // loads the book page

                MKLibrary.getBookInfoStage().setScene(new Scene(root)); // sets the scene of the book page to the book page

                BookInfoFXMLController bookInfoController = loader.getController(); // gets the controller for the book page
                bookInfoController.fillInfo(book,cont); // fills the book page with the information of the selected book
                MKLibrary.getBookInfoStage().show(); // shows the book page
            }
             catch (IOException ex) { // if the book page cannot be opened an error message is displayed
                System.out.println(ex);
            }

            selectedDewey = book.getDewey();
        }

    }

    public void enterSearch(KeyEvent ke) { // searches for the book when the enter key is pressed
        if (ke.getCode() == KeyCode.ENTER) { // if the enter key is pressed
            search(); // searches for the book
        }
    }
    public void search(){
        String search = searchField.getText().toLowerCase(); // gets the search term
        ObservableList<Book> books = bookList.getItems(); // gets the list of books in the table view
        books.clear(); // clears the list of books in the table view
        for (Book book : MKLibrary.getLibrary()){ // adds all the books in the library to the table view if they contain the search term
            if (book.getTitle().toLowerCase().contains(search) || book.getAuthor().toLowerCase().contains(search) || book.getGenre().toLowerCase().contains(search) || (book.getYear() + "").equals(search)){
                books.add(book);
            }
        }
        bookList.refresh();
    }
}