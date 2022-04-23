/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mklibrary;

import java.util.ArrayList;
import java.util.HashMap;

public class Book {
    private String title;
    private String author;
    private int year;
    private String summary;
    private String genre;
    private int dewey;
    private static HashMap<String,ArrayList<Integer>> bookCount = new HashMap<>(){{
        put("General Works",new ArrayList<Integer>(){{add(0);add(0);}});
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

    public Book(String title, String author, int year, String summary, String genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.summary = summary;
        this.genre = genre;
        this.dewey = getBookCount().get(genre).get(0) + ((getBookCount().get(genre).get(1)));

        bookCount.get(genre).set(0,bookCount.get(genre).get(0)+1);
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

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", author=" + author + ", year=" + year + ", summary=" + summary + ", genre=" + genre + ", dewey=" + dewey + '}';
    }
}
