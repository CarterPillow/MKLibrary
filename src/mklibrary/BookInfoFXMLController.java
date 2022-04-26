package mklibrary;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

// Controller for the BookInfo page
// page that comes up when you click on a book in the library search menu
public class BookInfoFXMLController {

    @FXML
    private Text title; // book title text

    @FXML
    private Text author; // book author text

    @FXML
    private Text genre; // book genre text

    @FXML
    private Text year; // book year published text

    @FXML
    private Text dewey; // book dewey text

    @FXML
    private TextArea summary; // book summary text area

    @FXML
    private Button checkButton; // check out button

    private Book book;

    private SearchBookFXMLController cont; // controller for the search book page

    public void fillInfo(Book b,SearchBookFXMLController cont){ // fills the info for the book on the info page
        this.cont = cont;
        book = b;

        title.setText("Title: " + b.getTitle());
        author.setText("Author: " + b.getAuthor());
        genre.setText("Genre: "  + b.getGenre());
        year.setText("Year Released: " + b.getYear());
        summary.setText(b.getSummary());
        dewey.setText("Dewey Number: " + b.getDewey());

    }

    public void checkOut(){ // checks out the book by setting the checkedOut field to true
        book.setCheckedOut(true);

        cont.refreshSearch(); // refreshes the search page

        MKLibrary.getBookInfoStage().close(); // closes the book info page
    }
}
