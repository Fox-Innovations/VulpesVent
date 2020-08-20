package GUI;

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
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PrimaryWindow extends Application {

    private Pane root;
    private BreathGraph breathGraph;
    private InformationTabBar informationTabBar;

    @Override 
    public void start(Stage primaryStage) throws Exception {

        breathGraph = new BreathGraph(385, 230);
        informationTabBar = new InformationTabBar(385, 460);

        int backR = 40;
        int backG = 40;
        int backB = 40;
        Color backgroundColor = Color.rgb(backR, backG, backB);

        primaryStage.setTitle("Primary Window");

        root = new Pane();
        root.setStyle("-fx-background-color: backgroundColor");
        primaryStage.setScene(new Scene(root, 800, 480, backgroundColor));
        root.getChildren().addAll(breathGraph.getBreathGraph());
        root.getChildren().addAll(informationTabBar.getInformationTabBar());

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