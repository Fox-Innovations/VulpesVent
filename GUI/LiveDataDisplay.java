package GUI;

import Information.LiveDataInfo;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LiveDataDisplay {
    
    private GridPane liveDataDisplay;
    @SuppressWarnings("unused")
    private Scene scene;
    private Label tidalVolume;
    private Label psi;
    private Label bpm;
    private Text liveTidalVolume;
    private Text livePSI;
    private Text liveBPM; 

    public LiveDataDisplay() {
        //#TODO implement into primary window


        liveDataDisplay = new GridPane();
        scene = new Scene(liveDataDisplay);
        tidalVolume = new Label("Tidal Volume: ");
        psi = new Label("PSI: ");
        bpm = new Label("BPM: ");
        liveTidalVolume = new Text(setLiveTidalVolume());
        livePSI = new Text(setLivePSI());
        liveBPM = new Text(setLiveBPM());

        liveDataDisplay.add(tidalVolume, 0, 0);
        liveDataDisplay.add(psi, 0, 1);
        liveDataDisplay.add(bpm, 0, 2);
        liveDataDisplay.add(liveTidalVolume, 1, 0);
        liveDataDisplay.add(livePSI, 1, 1);
        liveDataDisplay.add(liveBPM, 1, 2);

    }

    private String setLiveTidalVolume(){
        String toSet;

        try {
            toSet = LiveDataInfo.getCurrentTidalVolume() + "";
        } catch (NullPointerException e) {
            toSet = "Unable to Fetch Data";
        }
        

        return toSet;
    }

    private String setLivePSI(){
        String toSet;

        try {
            toSet = LiveDataInfo.getCurrentPSI() + "";
        } catch (NullPointerException e) {
            toSet = "Unable to Fetch Data";
        }

        return toSet;
    }

    private String setLiveBPM(){
        String toSet = "";

        try {
            toSet = LiveDataInfo.getCurrentBPM() + "";
        } catch (Exception e) {
            toSet = "Unable to Fetch Data";
        }

        return toSet;
    }
}