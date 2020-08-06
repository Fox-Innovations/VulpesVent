package GUI;

import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.LineChart;
import javafx.application.Platform;
import javafx.scene.Scene;

public class BreathGraph {


    private long startTime;
    private Scene scene;
    private final NumberAxis xAxis;
    private final NumberAxis yAxis;
    private final LineChart<Number, Number> breathGraph;
    private XYChart.Series<Number, Number> series;

    public BreathGraph(int x, int y) {
        xAxis = new NumberAxis();
        yAxis = new NumberAxis();
        breathGraph = new LineChart<>(xAxis, yAxis);
        // breathGraph.setMinSize(x, y);
        // breathGraph.setMaxSize(x, y);
        breathGraph.setPrefSize(x, y);
        breathGraph.relocate(950, 20);
        
        scene = new Scene(breathGraph, x, y);
        series = new XYChart.Series<>();

        //Sets label for the x Axis
        xAxis.setLabel("t(sec) since breath cycle started");
        //removes xaxis animations
        xAxis.setAnimated(false);
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(0);
        xAxis.setUpperBound(20);
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
        // adds all data to linechart from series
        breathGraph.getData().add(series);

        startTime = System.currentTimeMillis();

    }

    public Scene getScene(){
        return scene;
    }

    public LineChart<Number, Number> getLineChart(){
        return breathGraph;
    }

    public void addCurrentPSI(double PSI){
        // determine the change in time since the breath cycle data was reset
        double deltaT = (System.currentTimeMillis() - startTime)/1000;
        /* the lambda function is utilised to insure the real time functionality of
        the graph */
        Platform.runLater(() -> {
            series.getData().add(new XYChart.Data<>(deltaT, PSI));
        });
        
    }

    public void newCycle(){
        series.getData().clear();
        startTime = System.currentTimeMillis();
    }
}