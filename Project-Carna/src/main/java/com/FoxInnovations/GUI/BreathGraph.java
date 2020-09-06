package com.FoxInnovations.GUI;

import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.chart.LineChart;
import javafx.application.Platform;
import javafx.geometry.Insets;

public class BreathGraph {

    private long startTime;
    private final NumberAxis xAxis;
    private final NumberAxis yAxis;
    private final LineChart<Number, Number> breathGraph;
    private XYChart.Series<Number, Number> series;

    public BreathGraph(int w, int h, int x, int y) {

        xAxis = new NumberAxis();
        yAxis = new NumberAxis();
        breathGraph = new LineChart<>(xAxis, yAxis);
        // breathGraph.setMinSize(x, y);
        // breathGraph.setMaxSize(x, y);
        breathGraph.setPrefSize(w, h);
        breathGraph.relocate(x, y);
        
        series = new XYChart.Series<>();

        // Sets label for the x Axis
        xAxis.setLabel("t(sec) since breath cycle started");
        xAxis.setTickLabelFill(Paint.valueOf("FFFFFF"));
        // removes xaxis animations
        xAxis.setAnimated(false);
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(0);
        xAxis.setUpperBound(20);
        // Sets label for the y Axis
        yAxis.setLabel("PSI");
        yAxis.setTickLabelFill(Paint.valueOf("FFFFFF"));
        // removes yaxis animations
        yAxis.setAnimated(false);
        // Sets label for breath greaph
        breathGraph.setTitle("Breath Graph");
        // disables animations
        breathGraph.setAnimated(false);
        // sets name for the data series
        series.setName("Breath Data");

        // adds all data to linechart from series
        breathGraph.getData().add(series);
        breathGraph.setBackground(
                        new Background(new BackgroundFill(Paint.valueOf("3E3E3E"), new CornerRadii(5), new Insets(0))));
        breathGraph.getStylesheets().add(getClass().getResource("breathGraph.css").toExternalForm());
        breathGraph.setCreateSymbols(false);
        //series.getNode().getStyleClass().add("");
        
        setBasicData();
        startTime = System.currentTimeMillis();

    }

    // returns the line chart to be used on the primary window
    public LineChart<Number, Number> getBreathGraph() {
        return breathGraph;
    }

    public void addCurrentPSI(double TidalVolume) {
        // determine the change in time since the breath cycle data was reset
        double deltaT = (System.currentTimeMillis() - startTime) / 1000;
        /*
         * the lambda function is utilised to insure the real time functionality of the
         * graph
         */
        Platform.runLater(() -> {
            series.getData().add(new XYChart.Data<>(deltaT, TidalVolume));
        });
    }

    public void setBasicData() {

        series.getData().add(new XYChart.Data<>(0, 5));
        series.getData().add(new XYChart.Data<>(2, 6));
        series.getData().add(new XYChart.Data<>(4, 8));
        series.getData().add(new XYChart.Data<>(6, 12));
        series.getData().add(new XYChart.Data<>(8, 18));
        series.getData().add(new XYChart.Data<>(10, 26));
        series.getData().add(new XYChart.Data<>(12, 18));
        series.getData().add(new XYChart.Data<>(14, 12));
        series.getData().add(new XYChart.Data<>(16, 8));
        series.getData().add(new XYChart.Data<>(18, 6));
        series.getData().add(new XYChart.Data<>(20, 5));
    }

    // on the start of a new breath cycle, excecute method
    public void newCycle() {

        
        series.getData().clear();
        startTime = System.currentTimeMillis();
    }
}