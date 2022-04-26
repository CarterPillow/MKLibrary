package mklibrary;

import java.util.ArrayList;
import java.util.HashMap;

public class Book {
    private String title; // title of the book
    private String author; // author of the book
    private int year; // year of publication
    private String summary; // summary of the book
    private String genre; // genre of the book
    private int dewey; // dewey number of the book
    private boolean checkedOut; // whether the book is checked out


    // The number of book per genre in the library is limited to 100
    private static HashMap<String,ArrayList<Integer>> bookCount = new HashMap<>(){{ // Hashmap storing ArrayList of bookCount and the start of the dewey number for each genre
        put("General Works",new ArrayList<Integer>(){{add(0);add(0);}}); // first number is the count of books in the library, second number is the start of the dewey number
        put("Philosophy/Psychology", new ArrayList<Integer>(){{add(0);add(100);}});
        put("Religion",new ArrayList<Integer>(){{add(0);add(200);}});
        put("Social Sciences",new ArrayList<Integer>(){{add(0);add(300);}});
        put("Language",new ArrayList<Integer>(){{add(0);add(400);}});
        put("Natural Sciences/Mathematics",new ArrayList<Integer>(){{add(0);add(500);}});
        put("Technology",new ArrayList<Integer>(){{add(0);add(600);}});
        put("The Arts",new ArrayList<Integer>(){{add(0);add(700);}});
        put("Literature/Rhetoric",new ArrayList<Integer>(){{add(0);add(800);}});
        put("History/Biography/Geography",new ArrayList<Integer>(){{add(0);add(900);}});
    }};

    public Book(String title, String author, int year, String summary, String genre) { // constructor for the book class with all the parameters
        this.title = title;
        this.author = author;
        this.year = year;
        this.summary = summary;
        this.genre = genre;
        this.dewey = getBookCount().get(genre).get(0) + ((getBookCount().get(genre).get(1)));
        this.checkedOut = false;
        bookCount.get(genre).set(0,bookCount.get(genre).get(0)+1);
    }
     // getters / setters
    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean isCheckedOut) {
        this.checkedOut = isCheckedOut;
    }

    public int getDewey() {
        return dewey;
    }

    public void setDewey(int dewey) {
        this.dewey = dewey;
    }

    public static HashMap<String, ArrayList<Integer>> getBookCount() {
        return bookCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
     // toString method used for debugging
    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", author=" + author + ", year=" + year + ", summary=" + summary + ", genre=" + genre + ", dewey=" + dewey + '}';
    }
}
