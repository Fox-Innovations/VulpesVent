package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PrimaryWindow extends Application {

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Primary Window"); 
 
        

        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root, 300, 250));

        primaryStage.show();
    }
}