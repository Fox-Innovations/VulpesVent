package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PrimaryWindow extends Application {

    public void start(Stage primaryStage) {
        
        int backR = 40;
        int backG = 40;
        int backB = 40;
        Color backgroundColor = Color.rgb(backR, backG, backB);
        
        
        primaryStage.setTitle("Primary Window"); 
        
        

        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root, 1920, 1080, backgroundColor));

        primaryStage.show();
    }
}