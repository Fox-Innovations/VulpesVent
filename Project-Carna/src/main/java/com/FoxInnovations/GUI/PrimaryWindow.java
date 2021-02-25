package com.FoxInnovations.GUI;

//The commented imports are necessary for the breathGraphDataRTTestMethod method
/*
import javafx.event.ActionEvent;  
import javafx.event.EventHandler;  
import java.util.concurrent.Executors;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;
import javafx.scene.control.Button;
*/
import javafx.application.Application;
import javafx.geometry.Insets; 
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage; 


@SuppressWarnings("ClassCastException")
public class PrimaryWindow extends Application {

    //private Pane root;
    private GridPane root;
    private BreathGraph breathGraph;
    private InformationTabBar informationTabBar;
    private LiveDataDisplay liveDataDisplay; 

    
    @Override
    public void start(Stage primaryStage) throws Exception {

        informationTabBar = new InformationTabBar(385, 460, 10, 10); 
        breathGraph = new BreathGraph(385, 270, 405, 10);
        liveDataDisplay = new LiveDataDisplay(385, 180, 405, 270);

        // int backR = 40;
        // int backG = 40;
        // int backB = 40; 
        Paint backgroundColor = Paint.valueOf("5D5D5D");

        primaryStage.setTitle("Vulpes Vent");

        //root = new Pane();
        root = new GridPane();
        root.setBackground(new Background(new BackgroundFill(backgroundColor, new CornerRadii(5), new Insets(0))));
        primaryStage.setScene(new Scene(root, 800, 480, backgroundColor));
        root.add(breathGraph.getBreathGraph(), 1, 0); 
        root.add(informationTabBar.getInformationTabBar(), 0, 0, 1, 2);
        root.add(liveDataDisplay.getLiveDataDisplay(), 1, 1);
        root.relocate(10, 10);
        root.setHgap(10); 
        root.setVgap(10);
        //root.getChildren().addAll(breathGraph.getBreathGraph());
        // root.getChildren().addAll(informationTabBar.getInformationTabBar());
        // root.getChildren().addAll(liveDataDisplay.getLiveDataDisplay());

        Image applicationIcon = new Image(getClass().getResourceAsStream("Fox_Innovations_Logo.png")); 
        primaryStage.getIcons().add(applicationIcon); 

        primaryStage.show();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    /*
     * This method can be implemented and used to test the functionality of the
     * breath graph in the sense that it can take live data, however due to the
     * necessary method of determining the change in time it will appear as though
     * ~5 data points are being output simultaniously
     */
    /*
     * public void breathGraphDataRTTestMethod(){ Random r = new Random();
     * ScheduledExecutorService scheduledExecutorService; scheduledExecutorService =
     * Executors.newScheduledThreadPool(1);
     * 
     * scheduledExecutorService.scheduleAtFixedRate(() -> {
     * 
     * int value = r.nextInt(10)+10; breathGraph.addCurrentPSI(value);
     * 
     * }, 0, 100, TimeUnit.MILLISECONDS);
     * 
     * Button btn = new Button("cycle values"); btn.setOnAction(new
     * EventHandler<ActionEvent>() {
     * 
     * @Override public void handle(ActionEvent arg0) { breathGraph.newCycle(); }
     * });
     * 
     * root.getChildren().add(btn);
     * 
     * }
     */
}