
package mklibrary;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ReturnBookFXMLController{
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

    private int selectedDewey = -1; // dewey number of the selected book

    public void createBookList(){ // creates the table view for the library search results
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title")); // This makes the column "title" in the table view display the title of the book
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author")); // This makes the column "author" in the table view display the author of the book
        genreColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("genre")); // This makes the column "genre" in the table view display the genre of the book
        yearColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("year")); // This makes the column "year released" in the table view display the year of the book
        deweyColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("dewey")); // This makes the column "dewey number" in the table view display the dewey number of the book

        for (Book b: MKLibrary.getLibrary()) { // adds all the books in the library to the table view if they are checked out
            if (b.isCheckedOut() == true){
                bookList.getItems().add(b);
            }
        }

        bookList.refresh();
    }

    public void checkInBook(MouseEvent e){ // checks in the selected book
        Book book = (Book) bookList.getSelectionModel().getSelectedItem(); // gets the selected book
        if (book != null && book.getDewey() != selectedDewey){ // if the selected book is not null and the dewey number is different from the previous selected book
            MKLibrary.getLibrary().get(MKLibrary.getLibrary().indexOf(book)).setCheckedOut(false); // sets the book's variable checkedout to false
            ObservableList<Book> books = bookList.getItems(); // gets the list of books
            books.clear(); // clears the list of books
            for (Book b: MKLibrary.getLibrary()) { // adds all the books in the library to the table view if they are checked out
                if (b.isCheckedOut() == true){
                    books.add(b);
                }
        }
            bookList.refresh();
            selectedDewey = book.getDewey(); // sets the selected dewey number to the dewey number of the selected book
        }

    }
}
