package GUI;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;

public class ControlToolBar {
    
    VBox controlToolBarBox;
    private ToolBar controlToolBar;
    private Button systemInformation;
    private Button patientInformation;

    public ControlToolBar(){

        controlToolBar = new ToolBar();
        controlToolBarBox = new VBox(controlToolBar);

    }

}