package mklibrary;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class MKLibrary extends Application {
    
    private static Stage addBookStage = null;
    private static Stage errorStage = null;
    private static ArrayList<Book> library = new ArrayList<>();
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("mklibraryfxml.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        createErrorStage();
        createAddBookStage();
    }
    
     public void createAddBookStage(){
        addBookStage = new Stage();
        addBookStage.setTitle("Add a Book!");
        addBookStage.setAlwaysOnTop(true);
        addBookStage.setResizable(false);
        addBookStage.initModality(Modality.APPLICATION_MODAL);
    }
     
    public void createErrorStage(){
        errorStage = new Stage();
        errorStage.setTitle("ERROR");
        errorStage.setAlwaysOnTop(true);
        errorStage.setResizable(false);
        errorStage.initModality(Modality.APPLICATION_MODAL);
    }
    
    public static Stage getErrorStage(){
        return errorStage;
    }
    public static Stage getAddBookStage(){
        return addBookStage;
    }
    
    public static ArrayList<Book> getLibrary(){
        return library;
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
}