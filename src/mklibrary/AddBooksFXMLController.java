/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mklibrary;

import com.sun.source.doctree.SummaryTree;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class AddBooksFXMLController  {
    @FXML
    private SplitMenuButton genreMenu;
    
    @FXML
    private TextField title;
    
    @FXML
    private TextField author;
    
    @FXML
    private TextField year;
    
    @FXML
    private TextArea summary;
    
    public void setGenre(ActionEvent mo){
        MenuItem mi = (MenuItem) mo.getSource();
        
        genreMenu.setText(mi.getText());
    }
    
    public boolean containsOnlyDigits(String s){
        for (int i = 0; i < s.length(); i++) {
            if (!(Character.isDigit(s.charAt(i)))){
                return false;
            }
        }
        return true;
    }
    
    public void submitButton(){
        if (containsOnlyDigits(year.getText())){
        
        
        Book beeb = new Book(title.getText(),author.getText(),Integer.parseInt(year.getText()),summary.getText(),genreMenu.getText());
  
        MKLibrary.getLibrary().add(beeb);
        }
        else{
            
        }
    }
    
}
