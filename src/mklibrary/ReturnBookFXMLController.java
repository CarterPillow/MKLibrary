
package mklibrary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ReturnBookFXMLController{
    
     @FXML
    private TableView bookList;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, String> genreColumn;

    @FXML
    private TableColumn<Book, String> yearColumn;

    @FXML
    private TableColumn<Book, String> deweyColumn;

    private int selectedDewey = -1;
    
    public void createBookList(){
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("genre"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("year"));
        deweyColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("dewey"));
        
        for (Book b: MKLibrary.getLibrary()) {
            if (b.isCheckedOut() == true){
                bookList.getItems().add(b);
            }
        }

        bookList.refresh();
    }
    
    public void checkInBook(MouseEvent e){
        Book book = (Book) bookList.getSelectionModel().getSelectedItem();
        if (book != null && book.getDewey() != selectedDewey){
            System.out.println(book);
            MKLibrary.getLibrary().get(MKLibrary.getLibrary().indexOf(book)).setCheckedOut(false);
            ObservableList<Book> books = bookList.getItems();
            books.clear();
            for (Book b: MKLibrary.getLibrary()) {
                if (b.isCheckedOut() == true){
                    books.add(b);
                }
        }
            bookList.refresh();
            selectedDewey = book.getDewey();
        }
        
    }
}
