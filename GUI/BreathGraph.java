package GUI;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.LineChart;
import javafx.scene.Scene;

public class BreathGraph extends Application {


    private long startTime;
    private Stage stage;
    private Scene scene;
    private final NumberAxis xAxis;
    private final NumberAxis yAxis;
    private final LineChart<Number, Number> breathGraph;
    private XYChart.Series<Number, Number> series;

    public BreathGraph(Stage toPlace, int x, int y) {
        
        xAxis = new NumberAxis();
        yAxis = new NumberAxis();
        breathGraph = new LineChart<>(xAxis, yAxis);
        scene = new Scene(breathGraph, 640, 540);
        series = new XYChart.Series<>();

        //sets stage to the parameter toPlace, which is the stage 
        //that the BreathGraph is beign implemented in
        stage = toPlace;
        //Sets label for the x Axis
        xAxis.setLabel("t(sec) since breath cycle started");
        //removes xaxis animations
        xAxis.setAnimated(false);
        //Sets label for the y Axis
        yAxis.setLabel("PSI");
        //removes yaxis animations
        yAxis.setAnimated(false);
        //Sets label for breath greaph
        breathGraph.setTitle("Breath Graph");
        //disables animations
        breathGraph.setAnimated(false);
        //sets name for the data series
        series.setName("Breath Data");
    }

    @Override
    public void start(Stage stage) {
        breathGraph.getData().add(series);
        startTime = System.currentTimeMillis();

    }

    public void addCurrentPSI(double PSI){
        double x = (System.currentTimeMillis() - startTime)/1000;
        series.getData().add(new XYChart.Data<>(x, PSI));

    }

    public void newCycle(){
        series.getData().clear();
    }
}