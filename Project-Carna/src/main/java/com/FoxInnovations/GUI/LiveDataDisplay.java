package com.FoxInnovations.GUI;

import com.FoxInnovations.Information.LiveDataInfo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LiveDataDisplay {

    private GridPane liveDataDisplay;
    private Scene scene;
    private Label tidalVolume;
    private Label psi;
    private Label bpm;
    private Text liveTidalVolume;
    private Text livePSI;
    private Text liveBPM;

    public LiveDataDisplay(int w, int h, int x, int y) {

        Paint sceneFill = Paint.valueOf("3E3E3E");

        // intitialise live data display grid pane
        liveDataDisplay = new GridPane();

        //set grid pane layout
        liveDataDisplay.setPrefSize(w, h);
        liveDataDisplay.relocate(x, y);
        liveDataDisplay.setHgap(20);
        liveDataDisplay.setVgap(20);
        
        //set styling for live data display grid pane
        liveDataDisplay.setAlignment(Pos.CENTER);
        liveDataDisplay.setBorder(new Border(
                new BorderStroke(sceneFill, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(5))));
        liveDataDisplay.setBackground(new Background(new BackgroundFill(sceneFill, new CornerRadii(5), new Insets(0))));


        scene = new Scene(liveDataDisplay);
        scene.setFill(Paint.valueOf("808B96"));

        tidalVolume = new Label("Tidal Volume: ");
        tidalVolume.setFont(new Font(24));
        tidalVolume.setTextFill(Paint.valueOf("289ECD"));

        psi = new Label("PSI: ");
        psi.setFont(new Font(24));
        psi.setTextFill(Paint.valueOf("289ECD"));

        bpm = new Label("BPM: ");
        bpm.setFont(new Font(24));
        bpm.setTextFill(Paint.valueOf("289ECD"));

        liveTidalVolume = new Text(setLiveTidalVolume());
        liveTidalVolume.setFont(new Font(32));
        liveTidalVolume.setFill(Paint.valueOf("FFFFFF"));

        livePSI = new Text(setLivePSI());
        livePSI.setFont(new Font(32));
        livePSI.setFill(Paint.valueOf("FFFFFF"));

        liveBPM = new Text(setLiveBPM());
        liveBPM.setFont(new Font(32));
        liveBPM.setFill(Paint.valueOf("FFFFFF"));

        liveDataDisplay.add(tidalVolume, 0, 0);
        liveDataDisplay.add(psi, 0, 1);
        liveDataDisplay.add(bpm, 0, 2);
        liveDataDisplay.add(liveTidalVolume, 1, 0);
        liveDataDisplay.add(livePSI, 1, 1);
        liveDataDisplay.add(liveBPM, 1, 2);

    }

    public GridPane getLiveDataDisplay() {

        return liveDataDisplay;
    }

    private String setLiveTidalVolume() {

        String toSet;

        try {
            toSet = LiveDataInfo.getCurrentTidalVolume() + "";
        } catch (NullPointerException e) {
            toSet = "Unable to Fetch Data";
        }

        return toSet;
    }

    private String setLivePSI() {
        String toSet;

        try {
            toSet = LiveDataInfo.getCurrentPSI() + "";
        } catch (NullPointerException e) {
            toSet = "Unable to Fetch Data";
        }

        return toSet;
    }

    private String setLiveBPM() {


        String toSet = "";

        try {
            toSet = LiveDataInfo.getCurrentBPM() + "";
        } catch (Exception e) {
            toSet = "Unable to Fetch Data";
        }

        return toSet;
    }

}