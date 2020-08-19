package GUI;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class InformationTabBar {

    private VBox controlToolBarBox;
    private TabPane informationTabPane;
    // private Button systemInformation;
    // private Button operatingInformation;
    // private Button patientInformation;
    // private Button patientAdmissionInformation;
    Tab systemInformationTab;
    Tab operatingInformationTab;
    Tab patientInformationTab;
    Tab patientAdmissionInformationTab;
    TextArea systemInformationText;
    TextArea operatingInformationText;
    TextArea patientInformationText;
    TextArea patientAdmissionInformationText;

    public InformationTabBar() {

        //#TODO get this shitty fucking node to do what you want where you want it when you want it. More or less nothing is done
        // controlToolBar = new ToolBar();
        // controlToolBarBox = new VBox(controlToolBar);

        // systemInformation = new Button("System Information");
        // operatingInformation = new Button("Operating Information");
        // patientInformation = new Button("Patient Information");
        // patientAdmissionInformation = new Button("Patient Information");
        // setButtonActions();

        // controlToolBar.getItems().add(systemInformation);
        // controlToolBar.getItems().add(operatingInformation);
        // controlToolBar.getItems().add(patientInformation);
        // controlToolBar.getItems().add(patientAdmissionInformation);

        // controlToolBar.relocate(200, 200);

        

        // controlToolBarBox = new VBox(controlToolBar);

        informationTabPane = new TabPane();

        systemInformationText = new TextArea("");
        operatingInformationText = new TextArea("");
        patientInformationText = new TextArea("");
        patientAdmissionInformationText = new TextArea("");

        systemInformationTab = new Tab("System Information", systemInformationText);
        operatingInformationTab = new Tab("Operating Information", operatingInformationText);
        patientInformationTab = new Tab("Patient Information Tab", patientInformationText);
        patientAdmissionInformationTab = new Tab("Patient Admission Information", patientAdmissionInformationText);

        informationTabPane.getTabs().add(systemInformationTab);
        informationTabPane.getTabs().add(operatingInformationTab);
        informationTabPane.getTabs().add(patientInformationTab);
        informationTabPane.getTabs().add(patientAdmissionInformationTab);


    }

    public VBox getInformationToolBar() {
        return controlToolBarBox;
    }

    public TabPane getInformationTabBar() {
        return informationTabPane;
    }

    // private void setButtonActions() {

    //     //#TODO create information page class that displays the relevant information from the .JSON storage file
    //     systemInformation.setOnAction(ActionEvent -> {

    //     });

    //     operatingInformation.setOnAction(ActionEvent -> {

    //     });

    //     patientInformation.setOnAction(ActionEvent -> {

    //     });

    //     patientAdmissionInformation.setOnAction(ActionEvent -> {

    //     });

    // }

}