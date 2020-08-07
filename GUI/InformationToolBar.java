package GUI;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class InformationToolBar {

    private VBox controlToolBarBox;
    private ToolBar controlToolBar;
    private Button systemInformation;
    private Button operatingInformation;
    private Button patientInformation;
    private Button patientAdmissionInformation;

    public InformationToolBar() {

        //#TODO get this shitty fucking node to do what you want where you want it when you want it. More or less nothing is done
        controlToolBar = new ToolBar();
        controlToolBarBox = new VBox(controlToolBar);

        systemInformation = new Button("System Information");
        operatingInformation = new Button("Operating Information");
        patientInformation = new Button("Patient Information");
        patientAdmissionInformation = new Button("Patient Information");
        setButtonActions();

        controlToolBar.getItems().add(systemInformation);
        controlToolBar.getItems().add(operatingInformation);
        controlToolBar.getItems().add(patientInformation);
        controlToolBar.getItems().add(patientAdmissionInformation);

        controlToolBar.relocate(10, 10);

        

        controlToolBarBox = new VBox(controlToolBar);

    }

    public VBox getInformationToolBar() {
        return controlToolBarBox;
    }

    private void setButtonActions() {

        //#TODO create information page class that displays the relevant information from the .JSON storage file
        systemInformation.setOnAction(ActionEvent -> {

        });

        operatingInformation.setOnAction(ActionEvent -> {

        });

        patientInformation.setOnAction(ActionEvent -> {

        });

        patientAdmissionInformation.setOnAction(ActionEvent -> {

        });

    }

}