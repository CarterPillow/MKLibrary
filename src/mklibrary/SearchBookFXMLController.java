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

    @FXML
    private TextField searchField;

    private int selectedDewey = -1;

    public void createBookList(){
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("genre"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("year"));
        deweyColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("dewey"));
        bookList.getItems().addAll(MKLibrary.getLibrary());
        bookList.refresh();
    }

    public void openBookPage(MouseEvent e){
        Book book = (Book) bookList.getSelectionModel().getSelectedItem();
        if (book.getDewey() != selectedDewey){
            System.out.println(book);
             try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("BookInfoFXML.fxml"));
                Parent root = loader.load();

                MKLibrary.getBookInfoStage().setScene(new Scene(root));

                BookInfoFXMLController bookInfoController = loader.getController();

                MKLibrary.getBookInfoStage().show();
            } 
             catch (IOException ex) {
                System.out.println(ex);
            }
            

            
        }
        selectedDewey = book.getDewey();

    }

    public void enterSearch(KeyEvent ke) {
        if (ke.getCode() == KeyCode.ENTER) {
            search();
        }
    }
    public void search(){
        String search = searchField.getText().toLowerCase();
        ObservableList<Book> books = bookList.getItems();
        books.clear();
        for (Book book : MKLibrary.getLibrary()){
            if (book.getTitle().toLowerCase().contains(search) || book.getAuthor().toLowerCase().contains(search) || book.getGenre().toLowerCase().contains(search) || (book.getYear() + "").equals(search)){
                books.add(book);
            }
        }
        bookList.refresh();
    }
}