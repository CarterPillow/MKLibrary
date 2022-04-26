package mklibrary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;


public class BookInfoFXMLController {
    
    @FXML
    private Text title;
    
    @FXML
    private Text author;
    
    @FXML
    private Text genre;
    
    @FXML
    private Text year;
    
    @FXML
    private Text dewey;
    
    @FXML 
    private TextArea summary;
    
    @FXML
    private Button checkButton;
    
    private Book book;
    
    private SearchBookFXMLController cont;
    
    public void fillInfo(Book b,SearchBookFXMLController cont){
        this.cont = cont;
        book = b;
        title.setText("Title: " + b.getTitle());
        author.setText("Author: " + b.getAuthor());
        genre.setText("Genre: "  + b.getGenre());
        year.setText("Year Released: " + b.getYear());
        summary.setText(b.getSummary());
        dewey.setText("Dewey Number: " + b.getDewey());
        
    }
    
    public void checkOut(){
        book.setCheckedOut(true);

        cont.refreshSearch();

        MKLibrary.getBookInfoStage().close();
    }
}
