package mklibrary;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
public class SearchBookFXMLController {

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
        System.out.print(MKLibrary.getLibrary());
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("genre"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("year"));
        deweyColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("dewey"));
        bookList.getItems().addAll(MKLibrary.getLibrary());
    }

    public void openBookPage(MouseEvent e){
        Book book = (Book) bookList.getSelectionModel().getSelectedItem();
        if (book.getDewey() != selectedDewey){
            System.out.println(book);
        }
        selectedDewey = book.getDewey();

    }
}